package coletorboadica.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorboadica.dao.*;
import coletorboadica.dao.basica.*;
import coletorboadica.modelo.ProdutoComum;


public  class ProdutoComumDaoExtendida  extends ProdutoComumDaoBase implements ProdutoComumDao {

	

	@Override
	public List ListaNaoRelacionadaEmPrecoLojaListaPossui(long idPrecoLoja) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmCategoriaProdutoListaAssociada(long idCategoria) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ProdutoComum ObtemPorNomeModelo(String nomeModelo) throws DaoException {
		String sql = "select " + this.camposOrdenados() + " from " + tabelaSelect() + 
				" where nome_produto = '" + nomeModelo.toUpperCase().trim() + "'";
		return (ProdutoComum) this.getObjeto(sql);
	} 
}
