package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CategoriaProdutoProdutoVo implements CategoriaProdutoProduto
{
		
	public long getIdObj()
    {
       return idCategoriaProdutoProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCategoriaProdutoProduto\" : \"" + idCategoriaProdutoProduto + "\" "
		+ ", \"DataInclusao\" : \"" + dataInclusao + "\" "
		+ ", \"IdCategoriaProdutoRa\" : \"" + idCategoriaProdutoRa + "\" "
		+ ", \"IdProdutoRa\" : \"" + idProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CategoriaProdutoProdutoDerivada derivada = null;
	private CategoriaProdutoProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CategoriaProdutoProdutoDerivada(this);
		}
		return derivada;
	}

	private CategoriaProdutoProdutoAgregado agregado = null;
	private CategoriaProdutoProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CategoriaProdutoProdutoAgregado(this);
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
	public Produto getProdutoReferenteA()
	{
		return getAgregado().getProdutoReferenteA(); 
	} 
	public void setProdutoReferenteA(Produto value) 
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_ReferenteA(Produto value)
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	public Produto getCorrenteProduto_ReferenteA()
	{
		return getAgregado().getProdutoReferenteA(); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idCategoriaProdutoProduto;
	public long getIdCategoriaProdutoProduto()
	{
		return idCategoriaProdutoProduto;
	}
	public  void setIdCategoriaProdutoProduto(long value)
	{
		idCategoriaProdutoProduto = value; 
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
	
	
	
	
		
	private long idProdutoRa;
	public long getIdProdutoRa() {
		// relacionamento
		if (idProdutoRa==0 && this.getProdutoReferenteA()!=null) 
			return getProdutoReferenteA().getIdObj();
		else
			return idProdutoRa;
	}
	public void setIdProdutoRa(long _valor) {
		idProdutoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
