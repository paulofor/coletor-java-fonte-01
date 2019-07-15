package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class PlanejamentoVisitaDao  extends DaoAplicacao implements PlanejamentoVisitaDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new PlanejamentoVisitaMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " planejamento_visita.id_planejamento_visita";
		camposSaida += "  , planejamento_visita.proxima_data";
		camposSaida += "  , planejamento_visita.nome";
		camposSaida += "  , planejamento_visita.periodicidade";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " planejamento_visita" ;
	}
	public void cria( PlanejamentoVisita item )  throws  DaoException{
		String query = null;
		query = " insert into planejamento_visita (proxima_data , nome , periodicidade) values ('" + item.getProximaData() + "' , '" + item.getNome() + "' , '" + item.getPeriodicidade() + "')";
		getDataSource().executaSql(query);
	}
}
