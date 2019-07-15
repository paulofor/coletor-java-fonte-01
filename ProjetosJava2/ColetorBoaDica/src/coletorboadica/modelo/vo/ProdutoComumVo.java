package coletorboadica.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorboadica.modelo.*;
import coletorboadica.modelo.agregado.*;
import coletorboadica.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ProdutoComumVo implements ProdutoComum
{
		
	public long getIdObj()
    {
       return idProdutoComum;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdProdutoComum\" : \"" + idProdutoComum + "\" "
		+ ", \"NomeProduto\" : \"" + nomeProduto + "\" "
		+ ", \"Marca\" : \"" + marca + "\" "
		+ ", \"Descricao\" : \"" + descricao + "\" "
		+ ", \"Url\" : \"" + url + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ProdutoComumDerivada derivada = null;
	private ProdutoComumDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ProdutoComumDerivada(this);
		}
		return derivada;
	}

	private ProdutoComumAgregado agregado = null;
	private ProdutoComumAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ProdutoComumAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaPrecoLoja_Possui() {
		return getAgregado().existeListaPrecoLoja_Possui();
	}
	public void criaVaziaListaPrecoLoja_Possui() {
		getAgregado().criaVaziaListaPrecoLoja_Possui();
	}
	public List<PrecoLoja> getListaPrecoLoja_Possui() 
	{
		return getAgregado().getListaPrecoLoja_Possui(); 
	} 
	public void setListaPrecoLoja_Possui(List<PrecoLoja> value) 
	{
		getAgregado().setListaPrecoLoja_Possui(value); 
	} 
	public void addListaPrecoLoja_Possui(PrecoLoja value) 
	{
		getAgregado().addListaPrecoLoja_Possui(value); 
	} 
	public PrecoLoja getCorrentePrecoLoja_Possui()
	{
		return getAgregado().getCorrentePrecoLoja_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaCategoriaProduto_Associada() {
		return getAgregado().existeListaCategoriaProduto_Associada();
	}
	public void criaVaziaListaCategoriaProduto_Associada() {
		getAgregado().criaVaziaListaCategoriaProduto_Associada();
	}
	public List<CategoriaProduto> getListaCategoriaProduto_Associada() 
	{
		return getAgregado().getListaCategoriaProduto_Associada(); 
	} 
	public void setListaCategoriaProduto_Associada(List<CategoriaProduto> value) 
	{
		getAgregado().setListaCategoriaProduto_Associada(value); 
	} 
	public void addListaCategoriaProduto_Associada(CategoriaProduto value) 
	{
		getAgregado().addListaCategoriaProduto_Associada(value); 
	} 
	public CategoriaProduto getCorrenteCategoriaProduto_Associada()
	{
		return getAgregado().getCorrenteCategoriaProduto_Associada(); 
	} 
	

	
	
	
	
	
	private long idProdutoComum;
	public long getIdProdutoComum()
	{
		return idProdutoComum;
	}
	public  void setIdProdutoComum(long value)
	{
		idProdutoComum = value; 
	}
	
	
	
	
	
	private String nomeProduto;
	public String getNomeProduto()
	{
		return nomeProduto;
	}
	public  void setNomeProduto(String value)
	{
		nomeProduto = value; 
	}
	
	
	
	
	
	private String marca;
	public String getMarca()
	{
		return marca;
	}
	public  void setMarca(String value)
	{
		marca = value; 
	}
	
	
	
	
	
	private String descricao;
	public String getDescricao()
	{
		return descricao;
	}
	public  void setDescricao(String value)
	{
		descricao = value; 
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
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
