package coletorboadica.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorboadica.dao.CategoriaDao;
import coletorboadica.modelo.Categoria;
import coletorboadica.parse.regracolecaoadaptador.CategoriaRegraColecaoAdaptador;
import coletorboadica.regracolecao.CategoriaRegraColecao;


public  class CategoriaRegraColecaoImpl  extends CategoriaRegraColecao {

	@Override
	public List<Categoria> ListaParaPesquisa(DaoConexao conexao) throws DaoException {
		CategoriaDao dao = getDao(conexao);
		return dao.ListaParaPesquisa();
	}

	@Override
	public Categoria ExecutaDia(DaoConexao conexao) throws DaoException {
		CategoriaRegraColecaoAdaptador adaptador = new CategoriaRegraColecaoAdaptador();
		List<Categoria> listaPesquisa = this.ListaParaPesquisa(conexao);
		for (Categoria categoria : listaPesquisa) {
			System.out.println("Parser de " + categoria.getNome());
			//adaptador.setItem(categoria);
			adaptador.atualizaDetalhe(categoria, conexao);
		}
		return null;
	} 
}
