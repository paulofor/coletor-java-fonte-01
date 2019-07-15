package coletorboadica.log;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.parse.log.DatasUtils;

public class ArquivoLog {
	private static ArquivoLog _arquivoLog;
	private String _nomeArquivo = "Parse.log";
	// private String _arquivoErro = "Erros.log";
	// private String _arquivoErroDao = "ErroDao.log";
	// private String _arquivoMonitoracao = "Monitoramento.log";
	private static String _raiz = "D:\\RobotWeb\\ColetorBoaDicaDebug\\Log";

	private static String getNomeArquivo() {
		return _raiz + "\\" + DCConvert.getDataDD_MM_AAAA() + "_Parse.log";
	}

	private static String getNomeArquivoSalvaDao() {
		return _raiz + "\\" + DCConvert.getDataDD_MM_AAAA() + "_SalvaDao.log";
	}

	private static String getNomeArquivoErro() {
		return _raiz + "\\" + DCConvert.getDataDD_MM_AAAA() + "_Erros.log";
	}

	private static String getNomeArquivoErroDao() {
		return _raiz + "\\" + DCConvert.getDataDD_MM_AAAA() + "_ErrosDao.log";
	}

	private static String getNomeArquivoMonitoramento() {
		return _raiz + "\\" + DCConvert.getDataDD_MM_AAAA() + "_Monitoramento.log";
	}
	private static String getNomeArquivoNomeProduto() {
		return _raiz + "\\" + DCConvert.getDataDD_MM_AAAA() + "_NomeProduto.log";
	}
	
	private static String getNomeArquivoEtapa() {
		return _raiz + "\\Etapas.log";
	} 

	public static ArquivoLog getInstancia() {
		if (_arquivoLog == null)
			_arquivoLog = new ArquivoLog();
		return _arquivoLog;
	}

	public void setArquivo(String nomeArquivo) {
		this._nomeArquivo = nomeArquivo;
	}
	
	public void salvaLogEtapa(String input) {
		try {
			FileWriter arq = new FileWriter(getNomeArquivoEtapa(), true);
			arq.write("(" + DCConvert.getDataDD_MM_AAAA() + " " + DatasUtils.getHora() + ") " + input + "\r\n");
			arq.close();
		} catch (IOException e) {
			System.out.println("*** Erro arquivo Logs ***" + e);
		}
	}

	public void salvaLog(String input) {
		try {
			FileWriter arq = new FileWriter(getNomeArquivo(), true);
			arq.write("(" + DatasUtils.getHora() + ") " + input + "\r\n");
			arq.close();
		} catch (IOException e) {
			System.out.println("*** Erro arquivo Logs ***" + e);
		}
	}
	public void salvaLogNomeProduto(String input) {
		try {
			FileWriter arq = new FileWriter(getNomeArquivoNomeProduto(), true);
			arq.write("(" + DatasUtils.getHora() + ") " + input + "\r\n");
			arq.close();
		} catch (IOException e) {
			System.out.println("*** Erro arquivo Logs ***" + e);
		}
	}

	public void salvaMonitoramento(String input) {
		try {
			FileWriter arq = new FileWriter(getNomeArquivoMonitoramento(), true);
			arq.write("(" + DatasUtils.getHora() + ") " + input + "\r\n");
			arq.close();
		} catch (IOException e) {
			System.out.println("*** Erro arquivo Monitoramento ***" + e);
		}
	}
	
	public void salvaResultadoDao(String input) {
		try {
			FileWriter arq = new FileWriter(getNomeArquivoSalvaDao(), true);
			arq.write("(" + DatasUtils.getHora() + ") " + input + "\r\n");
			arq.close();
		} catch (IOException e) {
			System.out.println("*** Erro arquivo Salva Dao ***" + e);
		}
	}

	public void salvaErro(Exception e) {
		try {
			FileOutputStream arq = new FileOutputStream(getNomeArquivoErro(), true);
			PrintStream ps = new PrintStream(arq, true);
			ps.print("(" + DatasUtils.getHora() + ") - ");
			e.printStackTrace(ps);
			arq.close();
		} catch (IOException e2) {
			System.out.println("*** Erro arquivo Erros ***" + e2);
		}
	}

	public void salvaErroDao(Exception e) {
		try {
			FileOutputStream arq = new FileOutputStream(getNomeArquivoErroDao(), true);
			PrintStream ps = new PrintStream(arq, true);
			ps.print("(" + DatasUtils.getHora() + ") - ");
			e.printStackTrace(ps);
			arq.close();
		} catch (IOException e2) {
			System.out.println("*** ErroDao arquivo Logs ***" + e2);
		}
	}

	public void salvaErro(Exception e, String mensagem) {
		try {
			FileOutputStream arq = new FileOutputStream(getNomeArquivoErro(), true);
			PrintStream ps = new PrintStream(arq, true);
			ps.print("(" + DatasUtils.getData() + " " + DatasUtils.getHora() + ") - ");
			ps.println(mensagem);
			ps.print("(" + DatasUtils.getData() + " " + DatasUtils.getHora() + ") - ");
			e.printStackTrace(ps);
			arq.close();
		} catch (IOException e2) {
			System.out.println("*** Erro arquivo Logs ***" + e2);
		}
	}
}
