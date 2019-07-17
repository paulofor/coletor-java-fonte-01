package br.com.digicom.parse.log;
 
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;


 
public class ArquivoLog
{
   private static ArquivoLog _arquivoLog;
   private String _nomeArquivo = "WebParse-Erro.log";

   public static ArquivoLog getInstancia()
   {
	   if (_arquivoLog == null) _arquivoLog = new ArquivoLog();
	   	return _arquivoLog;
   }

   public void setArquivo(String nomeArquivo) {
	   this._nomeArquivo = nomeArquivo;
   }
 
   public void salvaLog(String input) {
	   try {
		   FileWriter arq = new FileWriter(this._nomeArquivo, true);
		   arq.write(input + "(" + DatasUtils.getData() + " " + DatasUtils.getHora() + ") \r\n");
		   arq.close();
	   } catch (IOException e) {
		   System.out.println("*** Erro arquivo Logs ***" + e);
	   }
   }
   
	public void salvaErro(Exception erro) {
		try {
			FileOutputStream arq = new FileOutputStream(this._nomeArquivo, true);
			PrintStream ps = new PrintStream(arq, true);
			ps.print("(" + DatasUtils.getData() + " " + DatasUtils.getHora() + ") - ");
			erro.printStackTrace(ps);
			arq.close();

		} catch (IOException e) {
			System.out.println("*** Erro arquivo Logs ***" + e);
		}
	}
}

