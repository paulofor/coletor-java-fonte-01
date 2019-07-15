package dafitiafil.modelo.derivadas;


import br.com.digicom.lib.*;


import dafitiafil.modelo.*;


public  class CategoriaProdutoDerivada   implements CategoriaProdutoDerivadaI { 
  private CategoriaProduto principal;
      public CategoriaProdutoDerivada( CategoriaProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
