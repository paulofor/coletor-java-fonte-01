package coletorboadica.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorboadica.modelo.*;
import coletorboadica.modelo.agregado.*;
import coletorboadica.modelo.derivadas.*;

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
		+ ", \"IdProdutoComumA\" : \"" + idProdutoComumA + "\" "
		+ ", \"IdCategoriaA\" : \"" + idCategoriaA + "\" "
	
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
	
	// Montador Tradicional
	public ProdutoComum getProdutoComumAssociada(boolean lazyLoader)
	{
		return getAgregado().getProdutoComumAssociada(lazyLoader); 
	} 
	public void setProdutoComumAssociada(ProdutoComum value) 
	{
		getAgregado().setProdutoComumAssociada(value); 
	} 
	/*
	public void setProdutoComumAssociadaComReversao(ProdutoComum value) 
	{
		getAgregado().setProdutoComumAssociadaComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProdutoComum_Associada(ProdutoComum value)
	{
		getAgregado().setProdutoComumAssociada(value); 
	} 
	public ProdutoComum getCorrenteProdutoComum_Associada()
	{
		return getAgregado().getProdutoComumAssociada(false); 
	} 
	
	
	// Montador Tradicional
	public Categoria getCategoriaAssociada(boolean lazyLoader)
	{
		return getAgregado().getCategoriaAssociada(lazyLoader); 
	} 
	public void setCategoriaAssociada(Categoria value) 
	{
		getAgregado().setCategoriaAssociada(value); 
	} 
	/*
	public void setCategoriaAssociadaComReversao(Categoria value) 
	{
		getAgregado().setCategoriaAssociadaComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaCategoria_Associada(Categoria value)
	{
		getAgregado().setCategoriaAssociada(value); 
	} 
	public Categoria getCorrenteCategoria_Associada()
	{
		return getAgregado().getCategoriaAssociada(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idCategoriaProduto;
	public long getIdCategoriaProduto()
	{
		return idCategoriaProduto;
	}
	public  void setIdCategoriaProduto(long value)
	{
		idCategoriaProduto = value; 
	}
	
	
	
	
		
	private long idProdutoComumA;
	public long getIdProdutoComumA() {
		// relacionamento
		if (idProdutoComumA==0 && this.getProdutoComumAssociada(false)!=null) 
			return getProdutoComumAssociada(false).getIdObj();
		else
			return idProdutoComumA;
	}
	public void setIdProdutoComumA(long _valor) {
		idProdutoComumA = _valor;
	}
	
	
	
	
		
	private long idCategoriaA;
	public long getIdCategoriaA() {
		// relacionamento
		if (idCategoriaA==0 && this.getCategoriaAssociada(false)!=null) 
			return getCategoriaAssociada(false).getIdObj();
		else
			return idCategoriaA;
	}
	public void setIdCategoriaA(long _valor) {
		idCategoriaA = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
