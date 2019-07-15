package coletorboadica.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorboadica.dao.basica.CategoriaDaoBase;
import coletorboadica.modelo.Categoria;


public  class CategoriaDaoExtendida  extends CategoriaDaoBase implements CategoriaDao {

	@Override
	public List ListaNaoRelacionadaEmCategoriaProdutoListaAssociada(long idProdutoComum) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaParaPesquisa() throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect();
		return this.getListaSql(sql);
	} 
}
