package coletorboadica.modelo.agregados;


import coletorboadica.modelo.agregados.*;
import coletorboadica.modelo.*;


public  class CategoriaProdutoAssembled   implements CategoriaProdutoAssembledI { 
  private ProdutoComum _ProdutoComumAssociada;
	public ProdutoComum getProdutoComumAssociada() {
		return _ProdutoComumAssociada;
	}
	public void setProdutoComumAssociada( ProdutoComum dado ) {
		_ProdutoComumAssociada = dado;
	}
  private Categoria _CategoriaAssociada;
	public Categoria getCategoriaAssociada() {
		return _CategoriaAssociada;
	}
	public void setCategoriaAssociada( Categoria dado ) {
		_CategoriaAssociada = dado;
	}
}
