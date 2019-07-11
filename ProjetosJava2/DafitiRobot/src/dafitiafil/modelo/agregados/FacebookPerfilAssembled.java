package dafitiafil.modelo.agregados;


import dafitiafil.modelo.agregados.*;
import dafitiafil.modelo.*;


public  class FacebookPerfilAssembled   implements FacebookPerfilAssembledI { 
  private CategoriaProduto _CategoriaProdutoReferenteA;
	public CategoriaProduto getCategoriaProdutoReferenteA() {
		return _CategoriaProdutoReferenteA;
	}
	public void setCategoriaProdutoReferenteA( CategoriaProduto dado ) {
		_CategoriaProdutoReferenteA = dado;
	}
  private Produto _ProdutoIcone;
	public Produto getProdutoIcone() {
		return _ProdutoIcone;
	}
	public void setProdutoIcone( Produto dado ) {
		_ProdutoIcone = dado;
	}
}
