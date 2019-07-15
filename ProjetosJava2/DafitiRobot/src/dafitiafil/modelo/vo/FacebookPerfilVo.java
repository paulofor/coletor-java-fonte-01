package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class FacebookPerfilVo implements FacebookPerfil
{
		
	public long getIdObj()
    {
       return idFacebookPerfil;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdFacebookPerfil\" : \"" + idFacebookPerfil + "\" "
		+ ", \"FacebookId\" : \"" + facebookId + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"Sobrenome\" : \"" + sobrenome + "\" "
		+ ", \"EmailUtilizado\" : \"" + emailUtilizado + "\" "
		+ ", \"AplicacaoNome\" : \"" + aplicacaoNome + "\" "
		+ ", \"AplicacaoId\" : \"" + aplicacaoId + "\" "
		+ ", \"AplicacaoChave\" : \"" + aplicacaoChave + "\" "
		+ ", \"TokenAcesso\" : \"" + tokenAcesso + "\" "
		+ ", \"ValorMaximoProduto\" : \"" + valorMaximoProduto + "\" "
		+ ", \"ValorMinimoProduto\" : \"" + valorMinimoProduto + "\" "
		+ ", \"IdCategoriaProdutoRa\" : \"" + idCategoriaProdutoRa + "\" "
		+ ", \"IdProdutoI\" : \"" + idProdutoI + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private FacebookPerfilDerivada derivada = null;
	private FacebookPerfilDerivada getDerivada() {
		if (derivada==null) {
			derivada = new FacebookPerfilDerivada(this);
		}
		return derivada;
	}

	private FacebookPerfilAgregado agregado = null;
	private FacebookPerfilAgregado getAgregado() {
		if (agregado==null) {
			agregado = new FacebookPerfilAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
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
	
	
	// Montador Tradicional
	public Produto getProdutoIcone()
	{
		return getAgregado().getProdutoIcone(); 
	} 
	public void setProdutoIcone(Produto value) 
	{
		getAgregado().setProdutoIcone(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_Icone(Produto value)
	{
		getAgregado().setProdutoIcone(value); 
	} 
	public Produto getCorrenteProduto_Icone()
	{
		return getAgregado().getProdutoIcone(); 
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
	
	// Montador Alternativo
	public boolean existeListaFacebookFanpage_Possui() {
		return getAgregado().existeListaFacebookFanpage_Possui();
	}
	public void criaVaziaListaFacebookFanpage_Possui() {
		getAgregado().criaVaziaListaFacebookFanpage_Possui();
	}
	public List<FacebookFanpage> getListaFacebookFanpage_Possui() 
	{
		return getAgregado().getListaFacebookFanpage_Possui(); 
	} 
	public void setListaFacebookFanpage_Possui(List<FacebookFanpage> value) 
	{
		getAgregado().setListaFacebookFanpage_Possui(value); 
	} 
	public void addListaFacebookFanpage_Possui(FacebookFanpage value) 
	{
		getAgregado().addListaFacebookFanpage_Possui(value); 
	} 
	public FacebookFanpage getCorrenteFacebookFanpage_Possui()
	{
		return getAgregado().getCorrenteFacebookFanpage_Possui(); 
	} 
	

	
	
	
	
	
	private long idFacebookPerfil;
	public long getIdFacebookPerfil()
	{
		return idFacebookPerfil;
	}
	public  void setIdFacebookPerfil(long value)
	{
		idFacebookPerfil = value; 
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
	
	
	
	
	
	private String nome;
	public String getNome()
	{
		return nome;
	}
	public  void setNome(String value)
	{
		nome = value; 
	}
	
	
	
	
	
	private String sobrenome;
	public String getSobrenome()
	{
		return sobrenome;
	}
	public  void setSobrenome(String value)
	{
		sobrenome = value; 
	}
	
	
	
	
	
	private String emailUtilizado;
	public String getEmailUtilizado()
	{
		return emailUtilizado;
	}
	public  void setEmailUtilizado(String value)
	{
		emailUtilizado = value; 
	}
	
	
	
	
	
	private String aplicacaoNome;
	public String getAplicacaoNome()
	{
		return aplicacaoNome;
	}
	public  void setAplicacaoNome(String value)
	{
		aplicacaoNome = value; 
	}
	
	
	
	
	
	private String aplicacaoId;
	public String getAplicacaoId()
	{
		return aplicacaoId;
	}
	public  void setAplicacaoId(String value)
	{
		aplicacaoId = value; 
	}
	
	
	
	
	
	private String aplicacaoChave;
	public String getAplicacaoChave()
	{
		return aplicacaoChave;
	}
	public  void setAplicacaoChave(String value)
	{
		aplicacaoChave = value; 
	}
	
	
	
	
	
	private String tokenAcesso;
	public String getTokenAcesso()
	{
		return tokenAcesso;
	}
	public  void setTokenAcesso(String value)
	{
		tokenAcesso = value; 
	}
	
	
	
	public String getValorMaximoProdutoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorMaximoProduto);
	}
	
	
	
	private float valorMaximoProduto;
	public float getValorMaximoProduto()
	{
		return valorMaximoProduto;
	}
	public  void setValorMaximoProduto(float value)
	{
		valorMaximoProduto = value; 
	}
	
	
	
	public String getValorMinimoProdutoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorMinimoProduto);
	}
	
	
	
	private float valorMinimoProduto;
	public float getValorMinimoProduto()
	{
		return valorMinimoProduto;
	}
	public  void setValorMinimoProduto(float value)
	{
		valorMinimoProduto = value; 
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
	
	
	
	
		
	private long idProdutoI;
	public long getIdProdutoI() {
		// relacionamento
		if (idProdutoI==0 && this.getProdutoIcone()!=null) 
			return getProdutoIcone().getIdObj();
		else
			return idProdutoI;
	}
	public void setIdProdutoI(long _valor) {
		idProdutoI = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
