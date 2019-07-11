package coletorboadica.modelo.ws;


import coletorboadica.modelo.vo.*;
import coletorboadica.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class CategoriaObjetoWs   { 
      String _url;
	public String getUrl() {
		return _url;
	}
	public void setUrl( String dado ) {
		_url = dado;
	}
      long _idCategoria;
	public long getIdCategoria() {
		return _idCategoria;
	}
	public void setIdCategoria( long dado ) {
		_idCategoria = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
}
