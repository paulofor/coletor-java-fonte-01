 package br.com.digicom.parse;
 
 import br.com.digicom.parse.callback.ICallbackParse;
 import br.com.digicom.parse.callback.IDadosParse;
 import java.util.TimerTask;
 
 public abstract class PesquisadorTimer extends TimerTask
   implements IPesquisador
 {
   private RestricaoTempo restricaoTempo;
   private ExecutadorParse executadorParse;
 
   public PesquisadorTimer()
   {
/* 14 */     this.executadorParse = new ExecutadorParse();
   }
 
   public PesquisadorTimer(RestricaoTempo restricaoTempo) {
/* 18 */     this.restricaoTempo = restricaoTempo;
/* 19 */     this.executadorParse = new ExecutadorParse();
   }
 
   public void setRestricaoTempo(RestricaoTempo restricaoTempo) {
/* 23 */     this.restricaoTempo = restricaoTempo;
   }
 
   public void setCallbackParse(ICallbackParse callback) {
/* 27 */     this.executadorParse.setCallbackParse(callback);
   }
   public void setDadosParse(IDadosParse dadosParse) {
/* 30 */     this.executadorParse.setDadosParse(dadosParse);
   }
 
   public void run() {
/* 34 */     if (this.restricaoTempo.podeAcessar())
/* 35 */       this.executadorParse.executa();
   }
 }

/* Location:           D:\Java-Recuperacao\webparse.jar
 * Qualified Name:     br.com.digicom.parse.PesquisadorTimer
 * JD-Core Version:    0.6.0
 */