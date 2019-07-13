 package br.com.digicom.parse;
 
 import java.io.PrintStream;
 import java.util.Calendar;
 import java.util.Date;
 
 public abstract class RestricaoTempo
 {
/*  8 */   private Date inicioDia = null;
 
/* 10 */   private Date finalDia = null;
 
/* 12 */   private boolean comFinalSemana = false;
 
   protected Date atualizaDia(Date data) {
/* 15 */     data.setDate(horaAtual().getDate());
/* 16 */     data.setMonth(horaAtual().getMonth());
/* 17 */     data.setYear(horaAtual().getYear());
/* 18 */     return data;
   }
 
   public void comFinalSemana()
   {
/* 24 */     this.comFinalSemana = true;
   }
 
   public void setHorarioDia(Date horaInicial, Date horaFinal) {
/* 28 */     this.inicioDia = horaInicial;
/* 29 */     this.finalDia = horaFinal;
   }
 
   public static Date ConverteHoraMinuto(int hora, int minuto) {
/* 33 */     Calendar calendar = Calendar.getInstance();
/* 34 */     calendar.set(11, hora);
/* 35 */     calendar.set(12, minuto);
/* 36 */     calendar.set(13, 0);
/* 37 */     return calendar.getTime();
   }
 
   public boolean podeAcessar() {
/* 41 */     System.out.println("Testou tempo - horaAtual:" + horaAtual() + "(FS:" + fimSemana() + ")");
/* 42 */     Date horaCorrente = horaAtual();
/* 43 */     if ((!this.comFinalSemana) && (fimSemana()))
/* 44 */       return false;
/* 45 */     if ((this.inicioDia != null) && (horaCorrente.before(atualizaDia(this.inicioDia))))
/* 46 */       return false;
/* 47 */     if ((this.finalDia != null) && (horaCorrente.after(atualizaDia(this.finalDia))))
/* 48 */       return false;
/* 49 */     return testaAcesso(horaCorrente);
   }
   protected abstract boolean testaAcesso(Date paramDate);
 
   private Date horaAtual() {
/* 55 */     Calendar cal = Calendar.getInstance();
/* 56 */     return cal.getTime();
   }
 
   private boolean fimSemana() {
/* 60 */     Calendar cal = Calendar.getInstance();
 
/* 62 */     return (cal.get(7) == 1) || 
/* 62 */       (cal.get(7) == 7);
   }
 }

/* Location:           D:\Java-Recuperacao\webparse.jar
 * Qualified Name:     br.com.digicom.parse.RestricaoTempo
 * JD-Core Version:    0.6.0
 */