package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class VisitaCategoria   implements ObjetoDominioI { 
	private int _idVisitaCategoria;
	public int getIdVisitaCategoria() {
		return _idVisitaCategoria;
	}
	public void setIdVisitaCategoria( int dado ) {
		_idVisitaCategoria = dado;
	}
}
