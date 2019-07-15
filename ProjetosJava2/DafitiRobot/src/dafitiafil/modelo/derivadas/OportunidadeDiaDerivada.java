package dafitiafil.modelo.derivadas;


import br.com.digicom.lib.*;


import dafitiafil.modelo.*;


public  class OportunidadeDiaDerivada   implements OportunidadeDiaDerivadaI { 
  private OportunidadeDia principal;
      public OportunidadeDiaDerivada( OportunidadeDia itemPrincipal )
      {
      principal = itemPrincipal;
	}
	@Override
	public String getCodigoImagemLocal() {
		return "img-" + String.format("%09d",principal.getIdProdutoRa()) + ".jpg";
	}
	@Override
	public void setCodigoImagemLocal(String dado) {
		// TODO Auto-generated method stub
		
	}
   
}
