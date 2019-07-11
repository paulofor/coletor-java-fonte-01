package coletorboadica.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorboadica.dao.*;
import coletorboadica.modelo.*;
import coletorboadica.regracolecao.filtro.*;


public abstract class CategoriaRegraColecao {
	
	public CategoriaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CategoriaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CategoriaFiltro _filtro;

	public CategoriaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CategoriaFiltro();
		return _filtro;
	}

	public void setFiltro(CategoriaFiltro dado) {
		_filtro = dado;
	}

	private CategoriaFiltro[] _listaEntrada;
	@Deprecated
	protected CategoriaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CategoriaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Categoria> _listaItem;
	protected List<Categoria> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Categoria> dado) {
		_listaItem = dado;
	}

	public final List<Categoria> ListaParaPesquisa() throws DaoException {
		List<Categoria> saida;
		CategoriaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaParaPesquisa(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Categoria> ListaParaPesquisa(final DaoConexao conexao)
			throws DaoException;
	public final Categoria ExecutaDia() throws DaoException {
		Categoria saida;
		CategoriaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ExecutaDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Categoria ExecutaDia(final DaoConexao conexao)
			throws DaoException;




	public static final CategoriaDao getDao() {
		return DBB.getInstancia().getCategoriaDao();
	}
	protected final CategoriaDao getDao(final DaoConexao conexao) {
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final CategoriaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CategoriaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CategoriaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Categoria PreInsercao(Categoria item) {
		return item;
	}

	public Categoria PreAlteracao(Categoria item) {
		return item;
	}

	public Categoria obtemPorChave(long chave) throws DaoException {
		CategoriaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Categoria saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Categoria obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		Categoria saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CategoriaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CategoriaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CategoriaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Categoria excluiItem(Categoria item) throws DaoException {
		CategoriaDao dao = getDao();
		DaoConexao conexao = null;
		Categoria saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Categoria excluiItem(Categoria item, DaoConexao conexao) throws DaoException {
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public Categoria alteraItem(Categoria item) throws DaoException {
		CategoriaDao dao = getDao();
		DaoConexao conexao = null;
		Categoria saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Categoria alteraItem(Categoria item, DaoConexao conexao) throws DaoException {
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Categoria insereItemLoad(Categoria item) throws DaoException {
		CategoriaDao dao = getDao();
		DaoConexao conexao = null;
		Categoria saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Categoria insereItemLoad(Categoria item, DaoConexao conexao) throws DaoException {
		CategoriaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
