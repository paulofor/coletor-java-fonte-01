/*     */ package br.com.digicom.parse.log;
/*     */ 
/*     */ import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
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
/*     */  
/*     */ 
/*     */   public static String retornaProximoDiaUtil(String dataAAAAMMDD) {
/*  70 */     int ano = Integer.parseInt(dataAAAAMMDD.substring(0, 4));
/*  71 */     int mes = Integer.parseInt(dataAAAAMMDD.substring(4, 6));
/*  72 */     int dia = Integer.parseInt(dataAAAAMMDD.substring(6, 8));
/*  73 */     Calendar data = Calendar.getInstance();
/*  74 */     data.set(ano, mes - 1, dia);
/*  75 */     data.add(5, 1);
/*  76 */     while ((data.get(7) == 7) || 
/*  77 */       (data.get(7) == 1))
/*     */     {
/*  79 */       data.add(5, 1);
/*     */     }
/*  81 */     String saida = data.get(1) + colocaZero(data.get(2) + 1) + 
/*  82 */       colocaZero(data.get(5));
/*  83 */     return saida;
/*     */   }
/*     */ 
/*     */   public static String colocaZero(int valor) {
/*  87 */     if (valor < 10) return "0" + valor;
/*  88 */     return "" + valor;
/*     */   }
/*     */ 
/*     */   public static String getDataAAAA_MM_DD() {
/*  92 */     Calendar now = Calendar.getInstance();
/*  93 */     String data = colocaZeroEsquerda(now.get(1)) + "-" + 
/*  94 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/*  95 */       now.get(5);
/*  96 */     return data;
/*     */   }
/*     */   public static String getDataDD_MM_AAAA() {
/*  99 */     Calendar now = Calendar.getInstance();
/* 100 */     String data = colocaZeroEsquerda(now.get(5)) + "-" + 
/* 101 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/* 102 */       now.get(1);
/* 103 */     return data;
/*     */   }
/*     */ 

			public static String getDataHoraVO() {
				return getDataDD_MM_AAAA() + " " + getHora();
			}

/*     */   private static String colocaZeroEsquerda(int num) {
/* 107 */     if (num > 9) return "" + num;
/* 108 */     return "0" + num;
/*     */   }
/*     */   public static String getData() {
/* 111 */     Calendar now = Calendar.getInstance();
/* 112 */     String data = now.get(1) + "-" + (
/* 113 */       now.get(2) + 1) + "-" + 
/* 114 */       now.get(5);
/* 115 */     return data;
/*     */   }
/*     */   public static String getHora() {
/* 118 */     Calendar cal = Calendar.getInstance();
/* 119 */     Date hoje = cal.getTime();
/*     */ 
/* 121 */     DateFormat df = DateFormat.getTimeInstance();
/* 122 */     return df.format(hoje);
/*     */   }
/*     */ 
/*     */   public static String converteAAAAMMDD2DD_MM_AAAA(String dataAAAAMMDD) {
/* 126 */     String ano = dataAAAAMMDD.substring(0, 4);
/* 127 */     String mes = dataAAAAMMDD.substring(4, 6);
/* 128 */     String dia = dataAAAAMMDD.substring(6);
/* 129 */     return dia + "-" + mes + "-" + ano;
/*     */   }

			public static String converteAAAA_MM_DD2DD_MM_AAAA(String data) {
				// AAAA-MM-DD
				// 01234567890
				String ano = data.substring(0,4);
				String mes = data.substring(5, 7);
				String dia = data.substring(8);
				return dia + "-" + mes + "-" + ano;
			}
			public static String converteDD_MM_AAAA2AAAA_MM_DD(String data) {
				// DD-MM-AAAA
				// 01234567890
				String ano = data.substring(6);
				String mes = data.substring(3, 5);
				String dia = data.substring(0,2);
				return ano + "-" + mes + "-" + dia;
			}
			public static long converteDD_MM_AAAA2Inteiro(String data) {
				String ano = data.substring(6);
				String mes = data.substring(3, 5);
				String dia = data.substring(0,2);
				long saida = Integer.parseInt(ano + mes + dia);
				return saida;
			}

			// Retorna data em formato MySQL somada x dias da data atual
			public static String getDataAAAA_MM_DD_Add(int diasDiferenca) {
				Calendar now = Calendar.getInstance();
				now.add(Calendar.DAY_OF_YEAR, diasDiferenca);
				String data = colocaZeroEsquerda(now.get(1)) + "-" + 
						colocaZeroEsquerda(now.get(2) + 1) + "-" + 
						colocaZeroEsquerda(now.get(5));
				return data;
			}

			
}

/* Location:           C:\Fontes\ProjetosJava2\Recuperacao-CotacaoJava15\Cotacao15\
 * Qualified Name:     sisacaoweb2.util.DatasUtils
 * JD-Core Version:    0.6.0
 */