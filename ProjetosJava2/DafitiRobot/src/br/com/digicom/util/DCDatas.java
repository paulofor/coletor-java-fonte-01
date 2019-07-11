package br.com.digicom.util;

import java.util.Calendar;

public class DCDatas {

	
	
	// Retorna data em formato MySQL somada x dias da data atual
	public static String getDataAAAA_MM_DD_Add(int diasDiferenca) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_YEAR, diasDiferenca);
		String data = colocaZeroEsquerda(now.get(1)) + "-" + 
				colocaZeroEsquerda(now.get(2) + 1) + "-" + 
				colocaZeroEsquerda(now.get(5));
		return data;
	}

	private static String colocaZeroEsquerda(int num) {
		if (num > 9)
			return "" + num;
		return "0" + num;
	}
}
