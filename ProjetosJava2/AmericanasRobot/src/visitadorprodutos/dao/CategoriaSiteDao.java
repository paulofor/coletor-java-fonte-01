package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class CategoriaSiteDao  extends DaoAplicacao implements CategoriaSiteDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new CategoriaSiteMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " categoria_site.id_categoria_site";
		camposSaida += "  , categoria_site.nome";
		camposSaida += "  , categoria_site.url";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " categoria_site" ;
	}
	public void cria( CategoriaSite item )  throws  DaoException{
		String query = null;
		query = " insert into categoria_site (nome , url) values ('" + item.getNome() + "' , '" + item.getUrl() + "')";
		getDataSource().executaSql(query);
	}
}
