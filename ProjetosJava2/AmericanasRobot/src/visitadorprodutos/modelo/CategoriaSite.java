package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class CategoriaSite   implements ObjetoDominioI { 
	private int _idCategoriaSite;
	public int getIdCategoriaSite() {
		return _idCategoriaSite;
	}
	public void setIdCategoriaSite( int dado ) {
		_idCategoriaSite = dado;
	}
	private String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
	private String _url;
	public String getUrl() {
		return _url;
	}
	public void setUrl( String dado ) {
		_url = dado;
	}
}
