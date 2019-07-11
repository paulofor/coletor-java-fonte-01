package coletorboadica.modelo.ws;


import coletorboadica.modelo.vo.*;
import coletorboadica.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ProdutoComumObjetoWs   { 
      long _idProdutoComum;
	public long getIdProdutoComum() {
		return _idProdutoComum;
	}
	public void setIdProdutoComum( long dado ) {
		_idProdutoComum = dado;
	}
      String _nomeProduto;
	public String getNomeProduto() {
		return _nomeProduto;
	}
	public void setNomeProduto( String dado ) {
		_nomeProduto = dado;
	}
      String _marca;
	public String getMarca() {
		return _marca;
	}
	public void setMarca( String dado ) {
		_marca = dado;
	}
      String _descricao;
	public String getDescricao() {
		return _descricao;
	}
	public void setDescricao( String dado ) {
		_descricao = dado;
	}
      String _url;
	public String getUrl() {
		return _url;
	}
	public void setUrl( String dado ) {
		_url = dado;
	}
}
