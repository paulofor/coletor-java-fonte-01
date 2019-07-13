 package br.com.digicom.parse;
 
 import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.log.ArquivoLog;

 import java.io.IOException;
 import java.io.PrintStream;
 import javax.xml.parsers.SAXParser;
 import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
 public class ParserXmlTh extends ParserThread
 {
/* 16 */   SAXParser parseDelegator = null;
/* 17 */   Conector conector = null;
/* 18 */   ICallbackParse callback = null;
 
   public void setCallback(ICallbackParse callback)
   {
/* 24 */     this.callback = callback;
   }
   public void setConector(Conector conector) {
/* 27 */     this.conector = conector;
   }
   public void setParser(SAXParser parser) {
/* 30 */     this.parseDelegator = parser;
   }
 
   public void run() {
     try {
/* 35 */       this.callback.inicializacao();
/* 36 */       this.parseDelegator.parse(this.conector.getInputStream(), (DefaultHandler)this.callback);
/* 37 */       this.callback.finalizacaoOk();
     } catch (IOException e) {
/* 39 */       System.out.println("Erro IO Parser.");
			   ArquivoLog.getInstancia().salvaErro(e);
/* 40 */       System.out.println("Finalizacao de ParserThread Erro");
/* 41 */       this.callback.finalizacaoErro();
     } catch (SAXException e) {
/* 43 */       System.out.println("Erro SAX Parser.");
/* 44 */       System.out.println("Finalizacao de ParserThread Erro");
/* 45 */       this.callback.finalizacaoErro();
     } catch (Exception e) {
/* 47 */       System.out.println("Erro Parser *** : " + e);
/* 48 */       this.callback.finalizacaoErro();
     } finally {
/* 50 */       this.conector.closeBuffer();
/* 51 */       this.conector = null;
     }
   }
 }

/* Location:           D:\Java-Recuperacao\webparse.jar
 * Qualified Name:     br.com.digicom.parse.ParserXmlTh
 * JD-Core Version:    0.6.0
 */