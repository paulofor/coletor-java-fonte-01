 package br.com.digicom.parse;
 
 import br.com.digicom.parse.callback.ICallbackParse;
 import br.com.digicom.parse.callback.IDadosParse;
 
 public abstract class Pesquisador
   implements IPesquisador
 {
   private ExecutadorParse executadorParse;
 
   public Pesquisador()
   {
/* 11 */     this.executadorParse = new ExecutadorParse();
   }
 
   public void setCallbackParse(ICallbackParse callback) {
/* 15 */     this.executadorParse.setCallbackParse(callback);
   }
   public void setDadosParse(IDadosParse dadosParse) {
/* 18 */     this.executadorParse.setDadosParse(dadosParse);
   }
 
   public void run() {
/* 22 */     this.executadorParse.executa();
   }
 }

/* Location:           D:\Java-Recuperacao\webparse.jar
 * Qualified Name:     br.com.digicom.parse.Pesquisador
 * JD-Core Version:    0.6.0
 */