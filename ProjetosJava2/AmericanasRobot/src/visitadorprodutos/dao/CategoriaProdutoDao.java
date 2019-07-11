package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class CategoriaProdutoDao  extends DaoAplicacao implements CategoriaProdutoDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new CategoriaProdutoMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " categoria_produto.id_categoria_produto";
		camposSaida += "  , categoria_produto.nome";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " categoria_produto" ;
	}
	public void cria( CategoriaProduto item )  throws  DaoException{
		String query = null;
		query = " insert into categoria_produto (nome) values ('" + item.getNome() + "')";
		getDataSource().executaSql(query);
	}
}
