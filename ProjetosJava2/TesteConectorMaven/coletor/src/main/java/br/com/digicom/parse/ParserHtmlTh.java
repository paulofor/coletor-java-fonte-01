package br.com.digicom.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import javax.xml.parsers.SAXParser;

import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.log.ArquivoLog;

public class ParserHtmlTh extends ParserThread {
	SAXParser parseDelegator = null;
	ConectorApache conector = null;
	ICallbackParse callback = null;
	

	public void setCallback(ICallbackParse callback) {
		this.callback = callback;
	}

	

	public void setParser(SAXParser parser) {
		this.parseDelegator = parser;
	}

	private String getCharSet() {
		//if (this.conector.getCharSet()!=null) return this.conector.getCharSet();
		if (this.callback.getCharSet()!=null) return this.callback.getCharSet();
		return CallbackParseHtml.HTML5_CHARSET;
	}
	
	public void run() {
		try {
			this.callback.inicializacao();
			//this.conector.setCookies(this.callback.getCookies());
			//BufferedReader read = new BufferedReader(new InputStreamReader(this.conector.getInputStream(), "UTF-8"));
			//BufferedReader read = new BufferedReader(new InputStreamReader(this.conector.getInputStream(), this.conector.getCharSet()));
			//BufferedReader read = new BufferedReader(new InputStreamReader(this.conector.getInputStream(), getCharSet()));
			
			// Reader read = new
			// InputStr eamReader(this.conector.getInputStream());
			// System.out.println("TESTE ************************");
			//this.callback.setCookies(this.conector.getCookies());
			
			String line = null;
			//while ((line = read.readLine()) != null) {
			//	System.out.println(line);
		    //}
			new ParserDelegator().parse(this.conector.getReader(), (HTMLEditorKit.ParserCallback) this.callback, true);
			this.callback.finalizacaoOk();
		} catch (IOException e) {
			e.printStackTrace();
			ArquivoLog.getInstancia().salvaErro(e);
			this.callback.finalizacaoErro();
		} catch (Exception e) {
			e.printStackTrace();
			ArquivoLog.getInstancia().salvaErro(e);
			this.callback.finalizacaoErro();
		} finally {
			this.conector.closeBuffer();
			this.conector = null;
		}
	}



	@Override
	public void setConector(ConectorApache paramConector) {
		// TODO Auto-generated method stub
		conector = paramConector;
	}
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.ParserHtmlTh JD-Core Version: 0.6.0
 */