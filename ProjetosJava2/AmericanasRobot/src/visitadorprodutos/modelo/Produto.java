package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class Produto   implements ObjetoDominioI { 
	private int _idProduto;
	public int getIdProduto() {
		return _idProduto;
	}
	public void setIdProduto( int dado ) {
		_idProduto = dado;
	}
	private String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
}
