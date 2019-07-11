package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class FacebookFanpageVo implements FacebookFanpage
{
		
	public long getIdObj()
    {
       return idFacebookFanpage;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdFacebookFanpage\" : \"" + idFacebookFanpage + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"FacebookId\" : \"" + facebookId + "\" "
		+ ", \"IdFacebookPerfilEe\" : \"" + idFacebookPerfilEe + "\" "
		+ ", \"IdCategoriaProdutoRa\" : \"" + idCategoriaProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private FacebookFanpageDerivada derivada = null;
	private FacebookFanpageDerivada getDerivada() {
		if (derivada==null) {
			derivada = new FacebookFanpageDerivada(this);
		}
		return derivada;
	}

	private FacebookFanpageAgregado agregado = null;
	private FacebookFanpageAgregado getAgregado() {
		if (agregado==null) {
			agregado = new FacebookFanpageAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public FacebookPerfil getFacebookPerfilEstaEm()
	{
		return getAgregado().getFacebookPerfilEstaEm(); 
	} 
	public void setFacebookPerfilEstaEm(FacebookPerfil value) 
	{
		getAgregado().setFacebookPerfilEstaEm(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaFacebookPerfil_EstaEm(FacebookPerfil value)
	{
		getAgregado().setFacebookPerfilEstaEm(value); 
	} 
	public FacebookPerfil getCorrenteFacebookPerfil_EstaEm()
	{
		return getAgregado().getFacebookPerfilEstaEm(); 
	} 
	
	
	// Montador Tradicional
	public CategoriaProduto getCategoriaProdutoReferenteA()
	{
		return getAgregado().getCategoriaProdutoReferenteA(); 
	} 
	public void setCategoriaProdutoReferenteA(CategoriaProduto value) 
	{
		getAgregado().setCategoriaProdutoReferenteA(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaCategoriaProduto_ReferenteA(CategoriaProduto value)
	{
		getAgregado().setCategoriaProdutoReferenteA(value); 
	} 
	public CategoriaProduto getCorrenteCategoriaProduto_ReferenteA()
	{
		return getAgregado().getCategoriaProdutoReferenteA(); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaFacebookFotoPost_Recebe() {
		return getAgregado().existeListaFacebookFotoPost_Recebe();
	}
	public void criaVaziaListaFacebookFotoPost_Recebe() {
		getAgregado().criaVaziaListaFacebookFotoPost_Recebe();
	}
	public List<FacebookFotoPost> getListaFacebookFotoPost_Recebe() 
	{
		return getAgregado().getListaFacebookFotoPost_Recebe(); 
	} 
	public void setListaFacebookFotoPost_Recebe(List<FacebookFotoPost> value) 
	{
		getAgregado().setListaFacebookFotoPost_Recebe(value); 
	} 
	public void addListaFacebookFotoPost_Recebe(FacebookFotoPost value) 
	{
		getAgregado().addListaFacebookFotoPost_Recebe(value); 
	} 
	public FacebookFotoPost getCorrenteFacebookFotoPost_Recebe()
	{
		return getAgregado().getCorrenteFacebookFotoPost_Recebe(); 
	} 
	

	
	
	
	
	
	private long idFacebookFanpage;
	public long getIdFacebookFanpage()
	{
		return idFacebookFanpage;
	}
	public  void setIdFacebookFanpage(long value)
	{
		idFacebookFanpage = value; 
	}
	
	
	
	
	
	private String nome;
	public String getNome()
	{
		return nome;
	}
	public  void setNome(String value)
	{
		nome = value; 
	}
	
	
	
	
	
	private String facebookId;
	public String getFacebookId()
	{
		return facebookId;
	}
	public  void setFacebookId(String value)
	{
		facebookId = value; 
	}
	
	
	
	
		
	private long idFacebookPerfilEe;
	public long getIdFacebookPerfilEe() {
		// relacionamento
		if (idFacebookPerfilEe==0 && this.getFacebookPerfilEstaEm()!=null) 
			return getFacebookPerfilEstaEm().getIdObj();
		else
			return idFacebookPerfilEe;
	}
	public void setIdFacebookPerfilEe(long _valor) {
		idFacebookPerfilEe = _valor;
	}
	
	
	
	
		
	private long idCategoriaProdutoRa;
	public long getIdCategoriaProdutoRa() {
		// relacionamento
		if (idCategoriaProdutoRa==0 && this.getCategoriaProdutoReferenteA()!=null) 
			return getCategoriaProdutoReferenteA().getIdObj();
		else
			return idCategoriaProdutoRa;
	}
	public void setIdCategoriaProdutoRa(long _valor) {
		idCategoriaProdutoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
