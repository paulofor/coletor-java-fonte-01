package coletorboadica.modelo.agregados;


import coletorboadica.modelo.agregados.*;
import coletorboadica.modelo.*;


public  class PrecoLojaAssembled   implements PrecoLojaAssembledI { 
  private ProdutoComum _ProdutoComumReferenteA;
	public ProdutoComum getProdutoComumReferenteA() {
		return _ProdutoComumReferenteA;
	}
	public void setProdutoComumReferenteA( ProdutoComum dado ) {
		_ProdutoComumReferenteA = dado;
	}
}
