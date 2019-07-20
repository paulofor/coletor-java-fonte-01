package br.com.digicom.parse;

import java.io.IOException;

import javax.xml.parsers.SAXParser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.log.ArquivoLog;

public class ParserXmlTh extends ParserThread {
	SAXParser parseDelegator = null;
	ConectorApache conector = null;
	ICallbackParse callback = null;

	public void setCallback(ICallbackParse callback) {
		this.callback = callback;
	}

	public void setConector(ConectorApache conector) {
		this.conector = conector;
	}

	public void setParser(SAXParser parser) {
		this.parseDelegator = parser;
	}

	public void run() {
		try {
			this.callback.inicializacao();
			this.parseDelegator.parse(this.conector.getInputStream(), (DefaultHandler) this.callback);
			this.callback.finalizacaoOk();
		} catch (IOException e) {
			System.out.println("Erro IO Parser.");
			ArquivoLog.getInstancia().salvaErro(e);
			System.out.println("Finalizacao de ParserThread Erro");
			this.callback.finalizacaoErro();
		} catch (SAXException e) {
			System.out.println("Erro SAX Parser.");
			System.out.println("Finalizacao de ParserThread Erro");
			this.callback.finalizacaoErro();
		} catch (Exception e) {
			System.out.println("Erro Parser *** : " + e);
			this.callback.finalizacaoErro();
		} finally {
			this.conector.closeBuffer();
			this.conector = null;
		}
	}
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.ParserXmlTh JD-Core Version: 0.6.0
 */