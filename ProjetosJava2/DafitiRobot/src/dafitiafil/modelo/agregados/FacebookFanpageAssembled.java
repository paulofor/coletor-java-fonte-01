package dafitiafil.modelo.agregados;


import dafitiafil.modelo.agregados.*;
import dafitiafil.modelo.*;


public  class FacebookFanpageAssembled   implements FacebookFanpageAssembledI { 
  private FacebookPerfil _FacebookPerfilEstaEm;
	public FacebookPerfil getFacebookPerfilEstaEm() {
		return _FacebookPerfilEstaEm;
	}
	public void setFacebookPerfilEstaEm( FacebookPerfil dado ) {
		_FacebookPerfilEstaEm = dado;
	}
  private CategoriaProduto _CategoriaProdutoReferenteA;
	public CategoriaProduto getCategoriaProdutoReferenteA() {
		return _CategoriaProdutoReferenteA;
	}
	public void setCategoriaProdutoReferenteA( CategoriaProduto dado ) {
		_CategoriaProdutoReferenteA = dado;
	}
}
