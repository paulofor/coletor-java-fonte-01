package coletorboadica.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorboadica.modelo.*;


public  class CategoriaDerivada   implements CategoriaDerivadaI { 
  private Categoria principal;
      public CategoriaDerivada( Categoria itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
