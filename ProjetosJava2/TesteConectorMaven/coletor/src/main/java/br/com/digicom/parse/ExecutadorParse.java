package br.com.digicom.parse;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.json.JSONObject;
import org.xml.sax.SAXException;

import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.log.ArquivoLog;

public class ExecutadorParse {
	
	int TIMEOUT_VALUE = 60000;
	
	private ICallbackParse callbackParse;
	private IDadosParse dadosParse;

	public void executa() {
		try {
			this.callbackParse.setDados(this.dadosParse);
			do {
				ArquivoLog.getInstancia().salvaLog("inicio do loop");
				ConectorApache conector = new ConectorApache();
				URL url = this.callbackParse.getUrl();
				//ArquivoLog.getInstancia().salvaLog("URL:");
				if ("https".equals(url.getProtocol())) {
					SSLContext ctx = SSLContext.getInstance("TLS");
					ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
					SSLContext.setDefault(ctx);
				}
				
				ArquivoLog.getInstancia().salvaLog("Antes openConnection");
				//URLConnection urlconn = (URLConnection) url.openConnection();
				//urlconn.setConnectTimeout(TIMEOUT_VALUE);
				//urlconn.setReadTimeout(TIMEOUT_VALUE);
				ArquivoLog.getInstancia().salvaLog("Depois openConnection");
				/*
				 * urlconn.setDefaultUseCaches(false);
				 * urlconn.setDefaultAllowUserInteraction(false);
				 * urlconn.setDoInput(true); urlconn.setDoOutput(true);
				 * 
				 * if (this.callbackParse.isPost()) {
				 * urlconn.setDefaultUseCaches(false);
				 * urlconn.setDefaultAllowUserInteraction(false);
				 * urlconn.setDoInput(true); urlconn.setDoOutput(true);
				 * urlconn.setRequestMethod("POST"); Iterator it =
				 * this.callbackParse.camposPost().iterator(); while
				 * (it.hasNext()) { CampoPost post = (CampoPost) it.next();
				 * urlconn.setRequestProperty(post.getChave(), post.getValor());
				 * } }
				 */
				if (this.callbackParse.isPost()) {
					conector.setCamposPost(this.callbackParse.camposPost());
					//urlconn = montaPost(urlconn, this.callbackParse.camposPost());
				} else {
					conector.setCamposPost(null);
				}
				
				//System.out.println("Encoder:" + urlconn.getContentEncoding());
				//if (urlconn==null) {
				//	throw new ExecutadorParseException("url e null " + url.toString());
				//}
				conector.setUri(url.toURI());
				//ArquivoLog.getInstancia().salvaLog("conector.setConexaoUrl(urlconn);");
				conector.start();
				ArquivoLog.getInstancia().salvaLog("conector.start();");
				conector.join(360000L);
				ArquivoLog.getInstancia().salvaLog("conector.join(180000L);");
				if (conector.conectou()) {
					ArquivoLog.getInstancia().salvaLog("if (conector.conectou())");
					executaParse(conector);
					//ArquivoLog.getInstancia().salvaLog("final parse");
				} else {
					/*ArquivoLog.getInstancia().salvaLog("Vai executar sleep");
					if (conector.isUnknownHostException()) {
						ArquivoLog.getInstancia().salvaLog("Executando sleep");
						Thread.sleep(3 * 60 * 1000); // 3 minutos
					}*/
				}
			} while (this.callbackParse.getLoop());
			//ArquivoLog.getInstancia().salvaLog("final do loop");
			
			URL urlJson = callbackParse.getJsonUrl();
			ArquivoLog.getInstancia().salvaLog("urlJson: " + urlJson);
			if (urlJson!=null) {
				//URLConnection urlJsonconn = (URLConnection) urlJson.openConnection();
				ConectorJson conectorJson = new ConectorJson();
				conectorJson.setUri(urlJson.toURI());
				ArquivoLog.getInstancia().salvaLog("conector.start();");
				conectorJson.start();
				ArquivoLog.getInstancia().salvaLog("conector.join(180000L);");
				conectorJson.join(180000L);
				ArquivoLog.getInstancia().salvaLog("conectorJson.getJsonObject();");
				JSONObject json = conectorJson.getJsonObject();
				dadosParse.setJson(json);
			}
		
		} catch (MalformedURLException eURI)  {
			System.out.println(eURI.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			ArquivoLog.getInstancia().salvaLog("Vai executar sleep");
			try {
				Thread.sleep(3 * 60 * 1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} // 3 minutos
			
			
			System.out.println("Erro em executador parse: " + e.getMessage());
			e.printStackTrace();
			this.callbackParse.finalizacaoErro();
		}
		ArquivoLog.getInstancia().salvaLog("Final executador");
	}

	private void executaParse(ConectorApache conector) throws SAXException, ParserConfigurationException, InterruptedException, ExecutadorParseException {
		if (this.callbackParse == null)
			throw new ExecutadorParseException("ExecutadorParse sem callbackParse");
		if (this.dadosParse == null)
			throw new ExecutadorParseException("ExecutadorParse sem dadosParse");
		ParserThread parserThread = this.callbackParse.criaParse();
		SAXParser parseDelegator = SAXParserFactory.newInstance().newSAXParser();

		parserThread.setConector(conector);
		parserThread.setParser(parseDelegator);

		parserThread.setCallback(this.callbackParse);
		ArquivoLog.getInstancia().salvaLog("parserThread.start();");
		parserThread.start();
		ArquivoLog.getInstancia().salvaLog("parserThread.join(180000L)");
		parserThread.join(180000L); // 3 minutos
		ArquivoLog.getInstancia().salvaLog("}");
	}

	public void setCallbackParse(ICallbackParse callback) {
		this.callbackParse = callback;
	}

	public void setDadosParse(IDadosParse dadosParse) {
		this.dadosParse = dadosParse;
	}

	
	private static class DefaultTrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}
	
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.ExecutadorParse JD-Core Version: 0.6.0
 */