package dafitiafil.modelo.ws;


import dafitiafil.modelo.vo.*;
import dafitiafil.modelo.*;


public  class CategoriaProdutoProdutoObjetoWs   { 
      long _idCategoriaProdutoProduto;
	public long getIdCategoriaProdutoProduto() {
		return _idCategoriaProdutoProduto;
	}
	public void setIdCategoriaProdutoProduto( long dado ) {
		_idCategoriaProdutoProduto = dado;
	}
      String _dataInclusao;
	public String getDataInclusao() {
		return _dataInclusao;
	}
	public void setDataInclusao( String dado ) {
		_dataInclusao = dado;
	}
      long _idCategoriaProdutoRa;
	public long getIdCategoriaProdutoRa() {
		return _idCategoriaProdutoRa;
	}
	public void setIdCategoriaProdutoRa( long dado ) {
		_idCategoriaProdutoRa = dado;
	}
      long _idProdutoRa;
	public long getIdProdutoRa() {
		return _idProdutoRa;
	}
	public void setIdProdutoRa( long dado ) {
		_idProdutoRa = dado;
	}
  private CategoriaProdutoObjetoWs _CategoriaProdutoReferenteA;
	public CategoriaProdutoObjetoWs getCategoriaProdutoReferenteA() {
		return _CategoriaProdutoReferenteA;
	}
	public void setCategoriaProdutoReferenteA( CategoriaProdutoObjetoWs dado ) {
		_CategoriaProdutoReferenteA = dado;
	}
  private ProdutoObjetoWs _ProdutoReferenteA;
	public ProdutoObjetoWs getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( ProdutoObjetoWs dado ) {
		_ProdutoReferenteA = dado;
	}
}
