package dafitiafil.modelo.agregados;


import dafitiafil.modelo.agregados.*;
import dafitiafil.modelo.*;


public  class FacebookFotoPostAssembled   implements FacebookFotoPostAssembledI { 
  private FacebookFanpage _FacebookFanpageEnviadoPara;
	public FacebookFanpage getFacebookFanpageEnviadoPara() {
		return _FacebookFanpageEnviadoPara;
	}
	public void setFacebookFanpageEnviadoPara( FacebookFanpage dado ) {
		_FacebookFanpageEnviadoPara = dado;
	}
  private FacebookPerfil _FacebookPerfilEnviadoPara;
	public FacebookPerfil getFacebookPerfilEnviadoPara() {
		return _FacebookPerfilEnviadoPara;
	}
	public void setFacebookPerfilEnviadoPara( FacebookPerfil dado ) {
		_FacebookPerfilEnviadoPara = dado;
	}
  private Produto _ProdutoReferenteA;
	public Produto getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( Produto dado ) {
		_ProdutoReferenteA = dado;
	}
}
