package dafitiafil.modelo.ws;


import dafitiafil.modelo.vo.*;
import dafitiafil.modelo.*;


public  class FacebookFanpageObjetoWs   { 
      long _idFacebookFanpage;
	public long getIdFacebookFanpage() {
		return _idFacebookFanpage;
	}
	public void setIdFacebookFanpage( long dado ) {
		_idFacebookFanpage = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _facebookId;
	public String getFacebookId() {
		return _facebookId;
	}
	public void setFacebookId( String dado ) {
		_facebookId = dado;
	}
      long _idFacebookPerfilEe;
	public long getIdFacebookPerfilEe() {
		return _idFacebookPerfilEe;
	}
	public void setIdFacebookPerfilEe( long dado ) {
		_idFacebookPerfilEe = dado;
	}
      long _idCategoriaProdutoRa;
	public long getIdCategoriaProdutoRa() {
		return _idCategoriaProdutoRa;
	}
	public void setIdCategoriaProdutoRa( long dado ) {
		_idCategoriaProdutoRa = dado;
	}
  private FacebookPerfilObjetoWs _FacebookPerfilEstaEm;
	public FacebookPerfilObjetoWs getFacebookPerfilEstaEm() {
		return _FacebookPerfilEstaEm;
	}
	public void setFacebookPerfilEstaEm( FacebookPerfilObjetoWs dado ) {
		_FacebookPerfilEstaEm = dado;
	}
  private CategoriaProdutoObjetoWs _CategoriaProdutoReferenteA;
	public CategoriaProdutoObjetoWs getCategoriaProdutoReferenteA() {
		return _CategoriaProdutoReferenteA;
	}
	public void setCategoriaProdutoReferenteA( CategoriaProdutoObjetoWs dado ) {
		_CategoriaProdutoReferenteA = dado;
	}
}
