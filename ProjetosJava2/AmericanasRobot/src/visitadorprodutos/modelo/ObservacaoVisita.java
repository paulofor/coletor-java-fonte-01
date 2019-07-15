package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class ObservacaoVisita   implements ObjetoDominioI { 
	private int _idObservacaoVisita;
	public int getIdObservacaoVisita() {
		return _idObservacaoVisita;
	}
	public void setIdObservacaoVisita( int dado ) {
		_idObservacaoVisita = dado;
	}
	private boolean _maisRecente;
	public boolean getMaisRecente() {
		return _maisRecente;
	}
	public void setMaisRecente( boolean dado ) {
		_maisRecente = dado;
	}
	private float _preco;
	public float getPreco() {
		return _preco;
	}
	public void setPreco( float dado ) {
		_preco = dado;
	}
}
