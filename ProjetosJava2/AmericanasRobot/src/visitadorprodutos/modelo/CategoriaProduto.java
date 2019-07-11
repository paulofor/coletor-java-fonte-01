package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class CategoriaProduto   implements ObjetoDominioI { 
	private int _idCategoriaProduto;
	public int getIdCategoriaProduto() {
		return _idCategoriaProduto;
	}
	public void setIdCategoriaProduto( int dado ) {
		_idCategoriaProduto = dado;
	}
	private String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
}
