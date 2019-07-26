package coletor;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestaProxyDesen {

	public static void main(String[] args) {
		try {
			testaProxy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testaProxy() throws IOException {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope("10.21.7.10", 82),  new UsernamePasswordCredentials("tr626987", "Piquet08"));

		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		try {
			
			//HttpHost target = new HttpHost("www.revendadecosmeticos.com.br", 80, "http");
			HttpHost proxy = new HttpHost("10.21.7.10", 82);

			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			HttpGet httpget = new HttpGet("https://www.atacadodemaquiagem.com.br/pagina/5c3a4/labios");
			httpget.setConfig(config);

			//System.out.println("Executing request " + httpget.getRequestLine() + " to " + target + " via " + proxy);

			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				System.out.println(EntityUtils.toString(response.getEntity()));
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

	}

}
