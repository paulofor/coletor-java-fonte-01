package br.com.digicom.parse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;

import br.com.digicom.parse.log.ArquivoLog;

public class Conector extends Thread {
	public final byte SEM_MENSAGEM = -1;
	public final byte MENSAGEM_OK = 0;
	public final byte MENSAGEM_ARQUIVO_NAO_ENCONTRADO = 1;
	public final byte MENSAGEM_SERVIDOR_NAO_RESPONDE = 2;
	public final byte MENSAGEM_ERRO_DESCONHECIDO = 19;
	protected InputStream inputStream;
	private URLConnection urlConexao;
	private HttpsURLConnection urlConexaoSegura;
	private BufferedReader buffer;
	private String servidor;
	private byte mensagem;
	private String charSet = null;
	private static CookieManager msCookieManager = null;
	
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

		((HttpURLConnection)conn).setRequestMethod("POST");
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
			return "ARQUIVO NÃO ENCONTRADO";
		if (codigo == 2)
			return "SERVIDOR NÃO RESPONDE";
		if (codigo == 10)
			return "ERRO DESCONHECIDO";
		return "" + codigo;
	}

	public CookieManager getCookieManager() {
		if (msCookieManager==null) {
			msCookieManager = new CookieManager();
		}
		return msCookieManager;
	}

	public void setCookies(CookieManager cookies) {
		msCookieManager = cookies;
	}

	public void setConexaoUrl(URLConnection urlConexao) {
		this.urlConexao = urlConexao;
	}

	public boolean conectou() {
		return this.mensagem != -1;
	}

	public InputStream getInputStream() {
		return this.inputStream;
	}

	public String getUrl() {
		URL url = this.urlConexao.getURL();
		return url.getProtocol() + "://" + url.getHost() + url.getFile();
	}

	public boolean isUnknownHostException() {
		return (mensagem == 2);
	}
	
	public void run() {
		this.mensagem = -1;
		try {
			//insereCookies(this.urlConexao); // Esta gerando java.lang.IllegalStateException: Already connected
			if (camposPost!=null)
				urlConexao = montaPost(urlConexao);
			String encode = this.urlConexao.getContentEncoding();
			
			if (encode!=null && "gzip".endsWith(encode)) {
				this.inputStream = new GZIPInputStream(this.urlConexao.getInputStream());
			} else {
				this.inputStream = this.urlConexao.getInputStream();
				//this.inputStream = new InputStreamReader(urlConexao.getInputStream(), "UTF-8");
			}
			this.servidor = this.urlConexao.getHeaderField("server");

			this.charSet = getCharSet(urlConexao);
			
			//criaCookies(this.urlConexao);
			this.mensagem = 0;
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
			System.out.println("Mensagem Conector:(" + getUrl() + ")" + mensagemErro(this.mensagem));
		}
	}

	
	private String getCharSet(URLConnection urlConexao2) {
		String contentType = urlConexao2.getContentType();
		if (contentType==null) return null;
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
		try {
			if (this.buffer != null)
				this.buffer.close();
		} catch (Exception e) {
			System.out.println("Errconector: " + e);
		}
	}

	public String getCharSet() {
		return charSet;
	}
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.Conector JD-Core Version: 0.6.0
 */