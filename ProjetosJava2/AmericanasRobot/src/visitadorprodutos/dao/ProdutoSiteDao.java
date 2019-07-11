package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class ProdutoSiteDao  extends DaoAplicacao implements ProdutoSiteDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new ProdutoSiteMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " produto_site.id_produto_site";
		camposSaida += "  , produto_site.rotulo_site";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " produto_site" ;
	}
	public void cria( ProdutoSite item )  throws  DaoException{
		String query = null;
		query = " insert into produto_site (rotulo_site) values ('" + item.getRotuloSite() + "')";
		getDataSource().executaSql(query);
	}
}
