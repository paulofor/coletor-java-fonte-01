package dafitiafil.modelo.derivadas;


import br.com.digicom.lib.*;


import dafitiafil.modelo.*;


public  class UsuarioDerivada   implements UsuarioDerivadaI { 
  private Usuario principal;
      public UsuarioDerivada( Usuario itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
