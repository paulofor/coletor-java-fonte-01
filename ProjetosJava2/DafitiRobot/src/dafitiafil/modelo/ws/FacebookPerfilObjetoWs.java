package dafitiafil.modelo.ws;


import dafitiafil.modelo.vo.*;
import dafitiafil.modelo.*;


public  class FacebookPerfilObjetoWs   { 
      long _idFacebookPerfil;
	public long getIdFacebookPerfil() {
		return _idFacebookPerfil;
	}
	public void setIdFacebookPerfil( long dado ) {
		_idFacebookPerfil = dado;
	}
      String _facebookId;
	public String getFacebookId() {
		return _facebookId;
	}
	public void setFacebookId( String dado ) {
		_facebookId = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _sobrenome;
	public String getSobrenome() {
		return _sobrenome;
	}
	public void setSobrenome( String dado ) {
		_sobrenome = dado;
	}
      String _emailUtilizado;
	public String getEmailUtilizado() {
		return _emailUtilizado;
	}
	public void setEmailUtilizado( String dado ) {
		_emailUtilizado = dado;
	}
      String _aplicacaoNome;
	public String getAplicacaoNome() {
		return _aplicacaoNome;
	}
	public void setAplicacaoNome( String dado ) {
		_aplicacaoNome = dado;
	}
      String _aplicacaoId;
	public String getAplicacaoId() {
		return _aplicacaoId;
	}
	public void setAplicacaoId( String dado ) {
		_aplicacaoId = dado;
	}
      String _aplicacaoChave;
	public String getAplicacaoChave() {
		return _aplicacaoChave;
	}
	public void setAplicacaoChave( String dado ) {
		_aplicacaoChave = dado;
	}
      String _tokenAcesso;
	public String getTokenAcesso() {
		return _tokenAcesso;
	}
	public void setTokenAcesso( String dado ) {
		_tokenAcesso = dado;
	}
      float _valorMaximoProduto;
	public float getValorMaximoProduto() {
		return _valorMaximoProduto;
	}
	public void setValorMaximoProduto( float dado ) {
		_valorMaximoProduto = dado;
	}
      float _valorMinimoProduto;
	public float getValorMinimoProduto() {
		return _valorMinimoProduto;
	}
	public void setValorMinimoProduto( float dado ) {
		_valorMinimoProduto = dado;
	}
      long _idCategoriaProdutoRa;
	public long getIdCategoriaProdutoRa() {
		return _idCategoriaProdutoRa;
	}
	public void setIdCategoriaProdutoRa( long dado ) {
		_idCategoriaProdutoRa = dado;
	}
      long _idProdutoI;
	public long getIdProdutoI() {
		return _idProdutoI;
	}
	public void setIdProdutoI( long dado ) {
		_idProdutoI = dado;
	}
  private CategoriaProdutoObjetoWs _CategoriaProdutoReferenteA;
	public CategoriaProdutoObjetoWs getCategoriaProdutoReferenteA() {
		return _CategoriaProdutoReferenteA;
	}
	public void setCategoriaProdutoReferenteA( CategoriaProdutoObjetoWs dado ) {
		_CategoriaProdutoReferenteA = dado;
	}
  private ProdutoObjetoWs _ProdutoIcone;
	public ProdutoObjetoWs getProdutoIcone() {
		return _ProdutoIcone;
	}
	public void setProdutoIcone( ProdutoObjetoWs dado ) {
		_ProdutoIcone = dado;
	}
}
