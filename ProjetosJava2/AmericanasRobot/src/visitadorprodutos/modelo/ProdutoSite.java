package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class ProdutoSite   implements ObjetoDominioI { 
	private int _idProdutoSite;
	public int getIdProdutoSite() {
		return _idProdutoSite;
	}
	public void setIdProdutoSite( int dado ) {
		_idProdutoSite = dado;
	}
	private String _rotuloSite;
	public String getRotuloSite() {
		return _rotuloSite;
	}
	public void setRotuloSite( String dado ) {
		_rotuloSite = dado;
	}
}
