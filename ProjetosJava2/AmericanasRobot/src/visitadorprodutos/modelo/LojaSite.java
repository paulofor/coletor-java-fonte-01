package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class LojaSite   implements ObjetoDominioI { 
	private int _idLojaSite;
	public int getIdLojaSite() {
		return _idLojaSite;
	}
	public void setIdLojaSite( int dado ) {
		_idLojaSite = dado;
	}
	private String _nomeClasseParse;
	public String getNomeClasseParse() {
		return _nomeClasseParse;
	}
	public void setNomeClasseParse( String dado ) {
		_nomeClasseParse = dado;
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
