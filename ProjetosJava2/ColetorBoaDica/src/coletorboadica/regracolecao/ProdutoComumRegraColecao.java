package coletorboadica.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorboadica.dao.*;
import coletorboadica.modelo.*;
import coletorboadica.regracolecao.filtro.*;


public abstract class ProdutoComumRegraColecao {
	
	public ProdutoComumRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ProdutoComumFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ProdutoComumFiltro _filtro;

	public ProdutoComumFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ProdutoComumFiltro();
		return _filtro;
	}

	public void setFiltro(ProdutoComumFiltro dado) {
		_filtro = dado;
	}

	private ProdutoComumFiltro[] _listaEntrada;
	@Deprecated
	protected ProdutoComumFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ProdutoComumFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ProdutoComum> _listaItem;
	protected List<ProdutoComum> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ProdutoComum> dado) {
		_listaItem = dado;
	}

	public final ProdutoComum ProcessaProdutoPreco() throws DaoException {
		ProdutoComum saida;
		ProdutoComumDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ProcessaProdutoPreco(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ProdutoComum ProcessaProdutoPreco(final DaoConexao conexao)
			throws DaoException;
	public final ProdutoComum ObtemPorNomeModelo() throws DaoException {
		ProdutoComum saida;
		ProdutoComumDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorNomeModelo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ProdutoComum ObtemPorNomeModelo(final DaoConexao conexao)
			throws DaoException;




	public static final ProdutoComumDao getDao() {
		return DBB.getInstancia().getProdutoComumDao();
	}
	protected final ProdutoComumDao getDao(final DaoConexao conexao) {
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ProdutoComumDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ProdutoComumDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ProdutoComumDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ProdutoComum PreInsercao(ProdutoComum item) {
		return item;
	}

	public ProdutoComum PreAlteracao(ProdutoComum item) {
		return item;
	}

	public ProdutoComum obtemPorChave(long chave) throws DaoException {
		ProdutoComumDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ProdutoComum saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ProdutoComum obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		ProdutoComum saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ProdutoComumDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ProdutoComumDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ProdutoComumDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ProdutoComum excluiItem(ProdutoComum item) throws DaoException {
		ProdutoComumDao dao = getDao();
		DaoConexao conexao = null;
		ProdutoComum saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProdutoComum excluiItem(ProdutoComum item, DaoConexao conexao) throws DaoException {
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ProdutoComum alteraItem(ProdutoComum item) throws DaoException {
		ProdutoComumDao dao = getDao();
		DaoConexao conexao = null;
		ProdutoComum saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProdutoComum alteraItem(ProdutoComum item, DaoConexao conexao) throws DaoException {
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ProdutoComum insereItemLoad(ProdutoComum item) throws DaoException {
		ProdutoComumDao dao = getDao();
		DaoConexao conexao = null;
		ProdutoComum saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProdutoComum insereItemLoad(ProdutoComum item, DaoConexao conexao) throws DaoException {
		ProdutoComumDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
