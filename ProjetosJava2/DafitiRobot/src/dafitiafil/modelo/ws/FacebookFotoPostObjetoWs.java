package dafitiafil.modelo.ws;


import dafitiafil.modelo.vo.*;
import dafitiafil.modelo.*;


public  class FacebookFotoPostObjetoWs   { 
      long _idFacebookFotoPost;
	public long getIdFacebookFotoPost() {
		return _idFacebookFotoPost;
	}
	public void setIdFacebookFotoPost( long dado ) {
		_idFacebookFotoPost = dado;
	}
      String _dataHora;
	public String getDataHora() {
		return _dataHora;
	}
	public void setDataHora( String dado ) {
		_dataHora = dado;
	}
      String _facebookId;
	public String getFacebookId() {
		return _facebookId;
	}
	public void setFacebookId( String dado ) {
		_facebookId = dado;
	}
      long _qtdeClick;
	public long getQtdeClick() {
		return _qtdeClick;
	}
	public void setQtdeClick( long dado ) {
		_qtdeClick = dado;
	}
      String _mensagem;
	public String getMensagem() {
		return _mensagem;
	}
	public void setMensagem( String dado ) {
		_mensagem = dado;
	}
      float _precoConsumidor;
	public float getPrecoConsumidor() {
		return _precoConsumidor;
	}
	public void setPrecoConsumidor( float dado ) {
		_precoConsumidor = dado;
	}
      long _idFacebookFanpageEp;
	public long getIdFacebookFanpageEp() {
		return _idFacebookFanpageEp;
	}
	public void setIdFacebookFanpageEp( long dado ) {
		_idFacebookFanpageEp = dado;
	}
      long _idFacebookPerfilEp;
	public long getIdFacebookPerfilEp() {
		return _idFacebookPerfilEp;
	}
	public void setIdFacebookPerfilEp( long dado ) {
		_idFacebookPerfilEp = dado;
	}
      long _idProdutoRa;
	public long getIdProdutoRa() {
		return _idProdutoRa;
	}
	public void setIdProdutoRa( long dado ) {
		_idProdutoRa = dado;
	}
  private FacebookFanpageObjetoWs _FacebookFanpageEnviadoPara;
	public FacebookFanpageObjetoWs getFacebookFanpageEnviadoPara() {
		return _FacebookFanpageEnviadoPara;
	}
	public void setFacebookFanpageEnviadoPara( FacebookFanpageObjetoWs dado ) {
		_FacebookFanpageEnviadoPara = dado;
	}
  private FacebookPerfilObjetoWs _FacebookPerfilEnviadoPara;
	public FacebookPerfilObjetoWs getFacebookPerfilEnviadoPara() {
		return _FacebookPerfilEnviadoPara;
	}
	public void setFacebookPerfilEnviadoPara( FacebookPerfilObjetoWs dado ) {
		_FacebookPerfilEnviadoPara = dado;
	}
  private ProdutoObjetoWs _ProdutoReferenteA;
	public ProdutoObjetoWs getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( ProdutoObjetoWs dado ) {
		_ProdutoReferenteA = dado;
	}
}
