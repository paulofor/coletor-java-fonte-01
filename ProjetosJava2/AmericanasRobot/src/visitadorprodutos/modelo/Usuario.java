package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class Usuario   implements ObjetoDominioI { 
	private int _idUsuario;
	public int getIdUsuario() {
		return _idUsuario;
	}
	public void setIdUsuario( int dado ) {
		_idUsuario = dado;
	}
}
