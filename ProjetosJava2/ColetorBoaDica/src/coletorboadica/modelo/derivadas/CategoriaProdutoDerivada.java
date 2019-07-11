package coletorboadica.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorboadica.modelo.*;


public  class CategoriaProdutoDerivada   implements CategoriaProdutoDerivadaI { 
  private CategoriaProduto principal;
      public CategoriaProdutoDerivada( CategoriaProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
