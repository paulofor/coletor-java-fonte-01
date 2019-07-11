package dafitiafil.modelo.agregados;


import dafitiafil.modelo.agregados.*;
import dafitiafil.modelo.*;


public  class CategoriaProdutoProdutoAssembled   implements CategoriaProdutoProdutoAssembledI { 
  private CategoriaProduto _CategoriaProdutoReferenteA;
	public CategoriaProduto getCategoriaProdutoReferenteA() {
		return _CategoriaProdutoReferenteA;
	}
	public void setCategoriaProdutoReferenteA( CategoriaProduto dado ) {
		_CategoriaProdutoReferenteA = dado;
	}
  private Produto _ProdutoReferenteA;
	public Produto getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( Produto dado ) {
		_ProdutoReferenteA = dado;
	}
}
