package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CategoriaProdutoVo implements CategoriaProduto
{
		
	public long getIdObj()
    {
       return idCategoriaProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCategoriaProduto\" : \"" + idCategoriaProduto + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"Url\" : \"" + url + "\" "
		+ ", \"DataInclusao\" : \"" + dataInclusao + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CategoriaProdutoDerivada derivada = null;
	private CategoriaProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CategoriaProdutoDerivada(this);
		}
		return derivada;
	}

	private CategoriaProdutoAgregado agregado = null;
	private CategoriaProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CategoriaProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaCategoriaProdutoProduto_Possui() {
		return getAgregado().existeListaCategoriaProdutoProduto_Possui();
	}
	public void criaVaziaListaCategoriaProdutoProduto_Possui() {
		getAgregado().criaVaziaListaCategoriaProdutoProduto_Possui();
	}
	public List<CategoriaProdutoProduto> getListaCategoriaProdutoProduto_Possui() 
	{
		return getAgregado().getListaCategoriaProdutoProduto_Possui(); 
	} 
	public void setListaCategoriaProdutoProduto_Possui(List<CategoriaProdutoProduto> value) 
	{
		getAgregado().setListaCategoriaProdutoProduto_Possui(value); 
	} 
	public void addListaCategoriaProdutoProduto_Possui(CategoriaProdutoProduto value) 
	{
		getAgregado().addListaCategoriaProdutoProduto_Possui(value); 
	} 
	public CategoriaProdutoProduto getCorrenteCategoriaProdutoProduto_Possui()
	{
		return getAgregado().getCorrenteCategoriaProdutoProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaFacebookPerfil_Gera() {
		return getAgregado().existeListaFacebookPerfil_Gera();
	}
	public void criaVaziaListaFacebookPerfil_Gera() {
		getAgregado().criaVaziaListaFacebookPerfil_Gera();
	}
	public List<FacebookPerfil> getListaFacebookPerfil_Gera() 
	{
		return getAgregado().getListaFacebookPerfil_Gera(); 
	} 
	public void setListaFacebookPerfil_Gera(List<FacebookPerfil> value) 
	{
		getAgregado().setListaFacebookPerfil_Gera(value); 
	} 
	public void addListaFacebookPerfil_Gera(FacebookPerfil value) 
	{
		getAgregado().addListaFacebookPerfil_Gera(value); 
	} 
	public FacebookPerfil getCorrenteFacebookPerfil_Gera()
	{
		return getAgregado().getCorrenteFacebookPerfil_Gera(); 
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
	

	
	
	
	
	
	private long idCategoriaProduto;
	public long getIdCategoriaProduto()
	{
		return idCategoriaProduto;
	}
	public  void setIdCategoriaProduto(long value)
	{
		idCategoriaProduto = value; 
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
	
	
	
	
	
	private String url;
	public String getUrl()
	{
		return url;
	}
	public  void setUrl(String value)
	{
		url = value; 
	}
	
	
	
	
	
	private String dataInclusao;
	public String getDataInclusao()
	{
		return dataInclusao;
	}
	public  void setDataInclusao(String value)
	{
		dataInclusao = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
