package br.com.digicom.parse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import br.com.digicom.parse.log.ArquivoLog;

public class ConectorApache extends Thread {
	public final byte SEM_MENSAGEM = -1;
	public final byte MENSAGEM_OK = 0;
	public final byte MENSAGEM_ARQUIVO_NAO_ENCONTRADO = 1;
	public final byte MENSAGEM_SERVIDOR_NAO_RESPONDE = 2;
	public final byte MENSAGEM_ERRO_DESCONHECIDO = 19;
	protected InputStream inputStream;

	private Reader reader;
	private String servidor;
	private byte mensagem;
	private String charSet = null;
	private static CookieManager msCookieManager = null;
	private URI uri = null;

	private List camposPost = null;

	public void setCamposPost(List valor) {
		camposPost = valor;
	}

	private URLConnection montaPost(URLConnection conn) throws IOException {
		StringBuilder postData = new StringBuilder();

		for (Object param : camposPost) {
			CampoPost campo = (CampoPost) param;
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode(campo.getChave(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(campo.getValor(), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");

		((HttpURLConnection) conn).setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.getOutputStream().write(postDataBytes);

		return conn;
	}

	private String mensagemErro(byte codigo) {
		if (codigo == 0)
			return "OK";
		if (codigo == 1)
			return "ARQUIVO NAO ENCONTRADO";
		if (codigo == 2)
			return "SERVIDOR NAO RESPONDE";
		if (codigo == 10)
			return "ERRO DESCONHECIDO";
		return "" + codigo;
	}

	public CookieManager getCookieManager() {
		if (msCookieManager == null) {
			msCookieManager = new CookieManager();
		}
		return msCookieManager;
	}

	public void setCookies(CookieManager cookies) {
		msCookieManager = cookies;
	}

	// substituir por setUrl
	// public void setConexaoUrl(URLConnection urlConexao) {
	// this.urlConexao = urlConexao;
	// }
	public void setUri(URI uri) {
		this.uri = uri;
	}

	public boolean conectou() {
		return this.mensagem != -1;
	}

	public InputStream getInputStream() {
		return this.inputStream;
	}

	public boolean isUnknownHostException() {
		return (mensagem == 2);
	}

	public void run() {
		this.mensagem = -1;
		try {
			// insereCookies(this.urlConexao); // Esta gerando
			// java.lang.IllegalStateException: Already connected
			main();
		} catch (FileNotFoundException e) {
			this.mensagem = 1;
		} catch (UnknownHostException e) {
			ArquivoLog.getInstancia().salvaLog("Vai executar sleep Conector");
			try {
				Thread.sleep(3 * 60 * 1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} // 3 min
			this.mensagem = 2;
			ArquivoLog.getInstancia().salvaErro(e);
		} catch (Exception e) {
			this.mensagem = 19;
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Mensagem Conector:(" + this.uri + ")" + mensagemErro(this.mensagem));
		}
	}

	private String getCharSet(URLConnection urlConexao2) {
		String contentType = urlConexao2.getContentType();
		if (contentType == null)
			return null;
		String[] values = contentType.split(";"); // values.length should be 2
		String charset = null;

		for (String value : values) {
			value = value.trim();

			if (value.toLowerCase().startsWith("charset=")) {
				charset = value.substring("charset=".length());
			}
		}

		return charset;
	}

	private void criaCookies(URLConnection conexao) {
		Map<String, List<String>> headerFields = conexao.getHeaderFields();
		List<String> cookiesHeader = headerFields.get("Set-Cookie");
		if (cookiesHeader != null) {
			for (String cookie : cookiesHeader) {
				List<HttpCookie> listaCookie = HttpCookie.parse(cookie);
				getCookieManager().getCookieStore().add(null, HttpCookie.parse(cookie).get(0));
			}
		}
	}

	private void insereCookies(URLConnection conexao) {
		String texto = "";
		if (getCookieManager().getCookieStore().getCookies().size() > 0) {
			for (HttpCookie cookie : getCookieManager().getCookieStore().getCookies()) {
				texto += ";" + cookie.toString();
			}
			conexao.setRequestProperty("Cookie", texto);
		}
	}

	public void closeBuffer() {
		// try {
		// if (this.buffer != null)
		// this.buffer.close();
		// } catch (Exception e) {
		// System.out.println("Errconector: " + e);
		// }
	}

	public String getCharSet() {
		return charSet;
	}

	public void main() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = criaComProxy();

		System.out.println("Entrou no main");
		try {
			HttpGet httpget = new HttpGet(this.uri);
			httpget= setProxy(httpget);

			System.out.println("Executing request " + httpget.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			reader = new StringReader(responseBody);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally {
			httpclient.close();
		}
	}

	private CloseableHttpClient criaComProxy() {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope("10.21.7.10", 82),  new UsernamePasswordCredentials("tr626987", "Piquet08"));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		return httpclient;
	}

	private CloseableHttpClient criaSemProxy() {
		return HttpClients.createDefault();
	}
	
	private HttpGet setProxy(HttpGet httpget) {
		HttpHost proxy = new HttpHost("10.21.7.10", 82, "http");
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		httpget.setConfig(config);
		return httpget;
	}

	public Reader getReader() {
		return this.reader;
	}
}
