package dafitiafil.modelo.derivadas;


import br.com.digicom.lib.*;


import dafitiafil.modelo.*;


public  class CategoriaProdutoProdutoDerivada   implements CategoriaProdutoProdutoDerivadaI { 
  private CategoriaProdutoProduto principal;
      public CategoriaProdutoProdutoDerivada( CategoriaProdutoProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
