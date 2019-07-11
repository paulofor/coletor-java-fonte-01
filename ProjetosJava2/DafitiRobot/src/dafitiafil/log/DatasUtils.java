/*     */ package dafitiafil.log;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class DatasUtils
/*     */ {
/*     */   public static String exibe(Date data)
/*     */   {
/*  16 */     DateFormat df = DateFormat.getTimeInstance();
/*  17 */     return df.format(data);
/*     */   }
/*     */ 
/*     */   public static Date converteHH_MM_SS(String horario) {
/*  21 */     int hora = Integer.parseInt(horario.substring(0, 2));
/*  22 */     int minuto = Integer.parseInt(horario.substring(3, 5));
/*     */ 
/*  24 */     return converteHoraMinuto(hora, minuto);
/*     */   }
/*     */ 
/*     */   public static Date diaAtual() {
/*  28 */     Calendar cal = Calendar.getInstance();
/*  29 */     cal.set(11, 0);
/*  30 */     cal.set(12, 0);
/*  31 */     cal.set(13, 0);
/*  32 */     cal.set(14, 0);
/*  33 */     return cal.getTime();
/*     */   }
/*     */ 
/*     */   private static Date horaAtual() {
/*  37 */     Calendar cal = Calendar.getInstance();
/*  38 */     return cal.getTime();
/*     */   }
/*     */ 
/*     */   public static boolean fimSemana() {
/*  42 */     Calendar cal = Calendar.getInstance();
/*     */ 
/*  44 */     return (cal.get(7) == 1) || 
/*  44 */       (cal.get(7) == 7);
/*     */   }
/*     */ 
/*     */   public static Date converteHoraMinuto(int hora, int minuto) {
/*  48 */     Calendar calendar = Calendar.getInstance();
/*  49 */     calendar.set(11, hora);
/*  50 */     calendar.set(12, minuto);
/*  51 */     calendar.set(13, 0);
/*  52 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   public static String retornaProximoDiaUtil(String dataAAAAMMDD)
/*     */   {
/*  58 */     int ano = Integer.parseInt(dataAAAAMMDD.substring(0, 4));
/*  59 */     int mes = Integer.parseInt(dataAAAAMMDD.substring(4, 6));
/*  60 */     int dia = Integer.parseInt(dataAAAAMMDD.substring(6, 8));
/*  61 */     Calendar data = Calendar.getInstance();
/*  62 */     data.set(ano, mes - 1, dia);
/*  63 */     data.add(5, 1);
/*  64 */     while ((data.get(7) == 7) || 
/*  65 */       (data.get(7) == 1))
/*     */     {
/*  67 */       data.add(5, 1);
/*     */     }
/*  69 */     String saida = data.get(1) + colocaZero(data.get(2) + 1) + 
/*  70 */       colocaZero(data.get(5));
/*  71 */     return saida;
/*     */   }
/*     */ 
/*     */   public static String colocaZero(int valor) {
/*  75 */     if (valor < 10) return "0" + valor;
/*  76 */     return "" + valor;
/*     */   }
/*     */ 
/*     */   public static String getDataAAAA_MM_DD() {
/*  80 */     Calendar now = Calendar.getInstance();
/*  81 */     String data = colocaZeroEsquerda(now.get(1)) + "-" + 
/*  82 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/*  83 */       now.get(5);
/*  84 */     return data;
/*     */   }
/*     */   public static String getDataDD_MM_AAAA() {
/*  87 */     Calendar now = Calendar.getInstance();
/*  88 */     String data = colocaZeroEsquerda(now.get(5)) + "-" + 
/*  89 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/*  90 */       now.get(1);
/*  91 */     return data;
/*     */   }
/*     */ 
/*     */   private static String colocaZeroEsquerda(int num) {
/*  95 */     if (num > 9) return "" + num;
/*  96 */     return "0" + num;
/*     */   }
/*     */   public static String getData() {
/*  99 */     Calendar now = Calendar.getInstance();
/* 100 */     String data = now.get(1) + "-" + (
/* 101 */       now.get(2) + 1) + "-" + 
/* 102 */       now.get(5);
/* 103 */     return data;
/*     */   }
/*     */   public static String getHora() {
/* 106 */     Calendar cal = Calendar.getInstance();
/* 107 */     Date hoje = cal.getTime();
/*     */ 
/* 109 */     DateFormat df = DateFormat.getTimeInstance();
/* 110 */     return df.format(hoje);
/*     */   }
/*     */ 
/*     */   public static String converteAAAAMMDD2DD_MM_AAAA(String dataAAAAMMDD) {
/* 114 */     String ano = dataAAAAMMDD.substring(0, 4);
/* 115 */     String mes = dataAAAAMMDD.substring(4, 6);
/* 116 */     String dia = dataAAAAMMDD.substring(6);
/* 117 */     return dia + "-" + mes + "-" + ano;
/*     */   }
/*     */ }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.util.DatasUtils
 * JD-Core Version:    0.6.0
 */