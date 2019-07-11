package visitadorprodutos.modelo;


import br.com.digicom.lib.*;


public  class PlanejamentoVisita   implements ObjetoDominioI { 
	private int _idPlanejamentoVisita;
	public int getIdPlanejamentoVisita() {
		return _idPlanejamentoVisita;
	}
	public void setIdPlanejamentoVisita( int dado ) {
		_idPlanejamentoVisita = dado;
	}
	private String _proximaData;
	public String getProximaData() {
		return _proximaData;
	}
	public void setProximaData( String dado ) {
		_proximaData = dado;
	}
	private String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
	private String _periodicidade;
	public String getPeriodicidade() {
		return _periodicidade;
	}
	public void setPeriodicidade( String dado ) {
		_periodicidade = dado;
	}
}
