package br.com.digicom.parse;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;

public class ExecutadorParseApache {

	private ICallbackParse callbackParse;
	private IDadosParse dadosParse;

	public void setCallbackParse(ICallbackParse callbackParse) {
		this.callbackParse = callbackParse;
	}

	public void setDadosParse(IDadosParse dadosParse) {
		this.dadosParse = dadosParse;
	}

	public void executa() throws DaoException {
		this.callbackParse.setDados(this.dadosParse);
		do {
			main();
		} while (this.callbackParse.getLoop());

	}

	public void main() throws DaoException {
		// CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// this.setProxy(httpClientBuilder);
		
		CloseableHttpClient httpclient = null;
		try {
			certificado(httpClientBuilder);
			httpclient = httpClientBuilder.build();
			HttpGet httpget = new HttpGet(this.callbackParse.getUrl().toURI());
			System.out.println("Executing request " + httpget.getRequestLine());
			// Base64.Encoder enc= Base64.getEncoder();
			// byte[] strenc =enc.encode("tr626987:Piquet08".getBytes("UTF-8"));
			// httpget.addHeader("Authorization", "Basic "+ strenc);

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
			Reader reader = new StringReader(responseBody);
			// System.out.println(responseBody);
			this.callbackParse.inicializacao();
			new ParserDelegator().parse(reader, (HTMLEditorKit.ParserCallback) this.callbackParse, true);
			this.callbackParse.finalizacaoOk();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void setProxy(HttpClientBuilder httpClientBuilder) {
		// Tratamento de Proxy
		HttpHost proxy = new HttpHost("10.21.7.10", 82);
		httpClientBuilder.setProxy(proxy);
		CredentialsProvider credProvider = new BasicCredentialsProvider();
		credProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
				new UsernamePasswordCredentials("tr626987", "Piquet08"));
		httpClientBuilder.setDefaultCredentialsProvider(credProvider);
		// ---------------------------------------------------------
	}

	private void certificado(HttpClientBuilder client) throws GeneralSecurityException {
		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
		SSLContext.setDefault(ctx);
		client.setSSLContext(ctx);
	}
	
	 private void setSSL(HttpClientBuilder client) 
	            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

	        // use the TrustSelfSignedStrategy to allow Self Signed Certificates
	        SSLContext sslContext = SSLContextBuilder
	                .create()
	                .loadTrustMaterial(new TrustSelfSignedStrategy())
	                .build();

	        // we can optionally disable hostname verification. 
	        // if you don't want to further weaken the security, you don't have to include this.
	        HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
	        
	        // create an SSL Socket Factory to use the SSLContext with the trust self signed certificate strategy
	        // and allow all hosts verifier.
	        SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);
	        
	        // finally create the HttpClient using HttpClient factory methods and assign the ssl socket factory
	        //client.setSslcontext(sslcontext)  .custom()
	        //        .setSSLSocketFactory(connectionFactory)
	 }
	
	 private static class DefaultTrustManager implements X509TrustManager {

	        @Override
	        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

	        @Override
	        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

	        @Override
	        public X509Certificate[] getAcceptedIssuers() {
	            return null;
	        }
	    }

}
