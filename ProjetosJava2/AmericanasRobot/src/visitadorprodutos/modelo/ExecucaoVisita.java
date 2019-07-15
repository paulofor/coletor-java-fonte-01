package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class ExecucaoVisita   implements ObjetoDominioI { 
	private int _idExecucaoVisita;
	public int getIdExecucaoVisita() {
		return _idExecucaoVisita;
	}
	public void setIdExecucaoVisita( int dado ) {
		_idExecucaoVisita = dado;
	}
	private String _data;
	public String getData() {
		return _data;
	}
	public void setData( String dado ) {
		_data = dado;
	}
	private boolean _maisRecente;
	public boolean getMaisRecente() {
		return _maisRecente;
	}
	public void setMaisRecente( boolean dado ) {
		_maisRecente = dado;
	}
}
