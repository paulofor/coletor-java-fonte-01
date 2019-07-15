package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class PrecoProdutoDerivada   implements PrecoProdutoDerivadaI { 
  private PrecoProduto principal;
      public PrecoProdutoDerivada( PrecoProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
