package dafitiafil.modelo.derivadas;


import br.com.digicom.lib.*;


import dafitiafil.modelo.*;


public  class PrecoProdutoDiarioDerivada   implements PrecoProdutoDiarioDerivadaI { 
  private PrecoProdutoDiario principal;
      public PrecoProdutoDiarioDerivada( PrecoProdutoDiario itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
