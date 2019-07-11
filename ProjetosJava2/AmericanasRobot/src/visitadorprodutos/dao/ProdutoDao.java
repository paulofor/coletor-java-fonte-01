package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class ProdutoDao  extends DaoAplicacao implements ProdutoDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new ProdutoMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " produto.id_produto";
		camposSaida += "  , produto.nome";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " produto" ;
	}
	public void cria( Produto item )  throws  DaoException{
		String query = null;
		query = " insert into produto (nome) values ('" + item.getNome() + "')";
		getDataSource().executaSql(query);
	}
}
