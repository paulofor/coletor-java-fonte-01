 package br.com.digicom.lib.util;

import java.util.Calendar;
 
 public class DCConvert
 {
   public static String ToDataAAAA_MM_DD(String data_dd_mm_aaaaa)
   {
	   // DD-MM-AAAA
	   // 0123456789
     if (data_dd_mm_aaaaa.length() < 10) return "";
     return data_dd_mm_aaaaa.substring(6, 10) + "-" + 
     		data_dd_mm_aaaaa.substring(3, 5) + "-" + 
     		data_dd_mm_aaaaa.substring(0, 2);
   }
   public static String ToDataAAAA_MM_DD_HHMMSS(String data_dd_mm_aaaaa_hh_mm_ss)
	{
		if (data_dd_mm_aaaaa_hh_mm_ss.length() < 10)
		{
			return "";
		}
		return (data_dd_mm_aaaaa_hh_mm_ss.substring(6, 10) + "-" + data_dd_mm_aaaaa_hh_mm_ss.substring(3, 5) + "-" + data_dd_mm_aaaaa_hh_mm_ss.substring(0, 2) + data_dd_mm_aaaaa_hh_mm_ss.substring(10));
	}
   public static String ToDataBase(float valor)
   {
     return String.valueOf(valor);
   }
   
   public static String ToDataSqlAAAA_MM_DD(String data_dd_mm_aaaaa)
	{
		if (data_dd_mm_aaaaa == null)
		{
			return "null";
		}
		return ("'" + ToDataAAAA_MM_DD(data_dd_mm_aaaaa) + "'");
	}




	public static String ToDataSqlAAAA_MM_DD_HHMMSS(String data_dd_mm_aaaaa)
	{
		if (data_dd_mm_aaaaa == null)
		{
			return "null";
		}
		return ("'" + ToDataAAAA_MM_DD_HHMMSS(data_dd_mm_aaaaa) + "'");
	}
	
	public static String getDataDD_MM_AAAA() {
		Calendar now = Calendar.getInstance();
		String data = colocaZeroEsquerda(now.get(5)) + "-" + 
				colocaZeroEsquerda(now.get(2) + 1) + "-" + 
				now.get(1);
		return data;
	}
	
	public static String getDataAAAA_MM_DD() {
		Calendar now = Calendar.getInstance();
		String data =  now.get(1) + "-" + 
				colocaZeroEsquerda(now.get(2) + 1) + "-" + 
				colocaZeroEsquerda(now.get(5));
		return data;
	}
	 
	private static String colocaZeroEsquerda(int num) {
		if (num > 9) return "" + num;
		return "0" + num;
	}
 }

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.util.DCConvert
 * JD-Core Version:    0.6.0
 */