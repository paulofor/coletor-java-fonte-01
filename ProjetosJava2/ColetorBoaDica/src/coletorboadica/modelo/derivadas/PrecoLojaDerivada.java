package coletorboadica.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorboadica.modelo.*;


public  class PrecoLojaDerivada   implements PrecoLojaDerivadaI { 
  private PrecoLoja principal;
      public PrecoLojaDerivada( PrecoLoja itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
