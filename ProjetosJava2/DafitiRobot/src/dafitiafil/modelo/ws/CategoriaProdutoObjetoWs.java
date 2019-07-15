package dafitiafil.modelo.ws;


import dafitiafil.modelo.vo.*;
import dafitiafil.modelo.*;


public  class CategoriaProdutoObjetoWs   { 
      long _idCategoriaProduto;
	public long getIdCategoriaProduto() {
		return _idCategoriaProduto;
	}
	public void setIdCategoriaProduto( long dado ) {
		_idCategoriaProduto = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _url;
	public String getUrl() {
		return _url;
	}
	public void setUrl( String dado ) {
		_url = dado;
	}
      String _dataInclusao;
	public String getDataInclusao() {
		return _dataInclusao;
	}
	public void setDataInclusao( String dado ) {
		_dataInclusao = dado;
	}
}
