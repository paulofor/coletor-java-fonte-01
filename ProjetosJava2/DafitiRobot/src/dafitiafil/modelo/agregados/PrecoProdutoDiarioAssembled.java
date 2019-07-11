package dafitiafil.modelo.agregados;


import dafitiafil.modelo.agregados.*;
import dafitiafil.modelo.*;


public  class PrecoProdutoDiarioAssembled   implements PrecoProdutoDiarioAssembledI { 
  private Produto _ProdutoPertenceA;
	public Produto getProdutoPertenceA() {
		return _ProdutoPertenceA;
	}
	public void setProdutoPertenceA( Produto dado ) {
		_ProdutoPertenceA = dado;
	}
}
