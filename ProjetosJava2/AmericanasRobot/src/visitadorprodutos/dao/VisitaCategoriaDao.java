package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class VisitaCategoriaDao  extends DaoAplicacao implements VisitaCategoriaDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new VisitaCategoriaMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " visita_categoria.id_visita_categoria";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " visita_categoria" ;
	}
	public void cria( VisitaCategoria item )  throws  DaoException{
		String query = null;
		query = " insert into visita_categoria () values ()";
		getDataSource().executaSql(query);
	}
}
