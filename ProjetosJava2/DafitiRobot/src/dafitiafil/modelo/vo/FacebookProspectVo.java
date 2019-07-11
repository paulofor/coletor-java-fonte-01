package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class FacebookProspectVo implements FacebookProspect
{
		
	public long getIdObj()
    {
       return idFacebookProspect;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdFacebookProspect\" : \"" + idFacebookProspect + "\" "
		+ ", \"FacebookId\" : \"" + facebookId + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private FacebookProspectDerivada derivada = null;
	private FacebookProspectDerivada getDerivada() {
		if (derivada==null) {
			derivada = new FacebookProspectDerivada(this);
		}
		return derivada;
	}

	private FacebookProspectAgregado agregado = null;
	private FacebookProspectAgregado getAgregado() {
		if (agregado==null) {
			agregado = new FacebookProspectAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idFacebookProspect;
	public long getIdFacebookProspect()
	{
		return idFacebookProspect;
	}
	public  void setIdFacebookProspect(long value)
	{
		idFacebookProspect = value; 
	}
	
	
	
	
	
	private long facebookId;
	public long getFacebookId()
	{
		return facebookId;
	}
	public  void setFacebookId(long value)
	{
		facebookId = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
