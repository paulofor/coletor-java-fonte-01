package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class ExecucaoVisitaDao  extends DaoAplicacao implements ExecucaoVisitaDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new ExecucaoVisitaMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " execucao_visita.id_execucao_visita";
		camposSaida += "  , execucao_visita.data";
		camposSaida += "  , execucao_visita.mais_recente";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " execucao_visita" ;
	}
	public void cria( ExecucaoVisita item )  throws  DaoException{
		String query = null;
		query = " insert into execucao_visita (data , mais_recente) values ('" + item.getData() + "' , '" + item.getMaisRecente() + "')";
		getDataSource().executaSql(query);
	}
}
