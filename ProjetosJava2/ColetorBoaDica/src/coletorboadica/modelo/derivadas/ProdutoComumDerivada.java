package coletorboadica.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorboadica.modelo.*;


public  class ProdutoComumDerivada   implements ProdutoComumDerivadaI { 
  private ProdutoComum principal;
      public ProdutoComumDerivada( ProdutoComum itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
