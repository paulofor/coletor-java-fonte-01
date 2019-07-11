package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class LojaSiteDao  extends DaoAplicacao implements LojaSiteDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new LojaSiteMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " loja_site.id_loja_site";
		camposSaida += "  , loja_site.nome_classe_parse";
		camposSaida += "  , loja_site.nome";
		camposSaida += "  , loja_site.url";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " loja_site" ;
	}
	public void cria( LojaSite item )  throws  DaoException{
		String query = null;
		query = " insert into loja_site (nome_classe_parse , nome , url) values ('" + item.getNomeClasseParse() + "' , '" + item.getNome() + "' , '" + item.getUrl() + "')";
		getDataSource().executaSql(query);
	}
}
