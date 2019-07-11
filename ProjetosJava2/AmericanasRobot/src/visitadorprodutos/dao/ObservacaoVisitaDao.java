package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class ObservacaoVisitaDao  extends DaoAplicacao implements ObservacaoVisitaDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new ObservacaoVisitaMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " observacao_visita.id_observacao_visita";
		camposSaida += "  , observacao_visita.mais_recente";
		camposSaida += "  , observacao_visita.preco";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " observacao_visita" ;
	}
	public void cria( ObservacaoVisita item )  throws  DaoException{
		String query = null;
		query = " insert into observacao_visita (mais_recente , preco) values ('" + item.getMaisRecente() + "' , '" + item.getPreco() + "')";
		getDataSource().executaSql(query);
	}
}
