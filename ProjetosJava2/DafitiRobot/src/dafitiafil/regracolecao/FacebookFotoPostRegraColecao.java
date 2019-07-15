package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class FacebookFotoPostRegraColecao {
	
	public FacebookFotoPostRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		FacebookFotoPostDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		FacebookFotoPostDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		FacebookFotoPostFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private FacebookFotoPostFiltro _filtro;

	public FacebookFotoPostFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new FacebookFotoPostFiltro();
		return _filtro;
	}

	public void setFiltro(FacebookFotoPostFiltro dado) {
		_filtro = dado;
	}

	private FacebookFotoPostFiltro[] _listaEntrada;
	@Deprecated
	protected FacebookFotoPostFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final FacebookFotoPostFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<FacebookFotoPost> _listaItem;
	protected List<FacebookFotoPost> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<FacebookFotoPost> dado) {
		_listaItem = dado;
	}

	public final FacebookFotoPost EnviaFotoPost() throws DaoException {
		FacebookFotoPost saida;
		FacebookFotoPostDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EnviaFotoPost(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract FacebookFotoPost EnviaFotoPost(final DaoConexao conexao)
			throws DaoException;
	public final FacebookFotoPost ApagarTodos() throws DaoException {
		FacebookFotoPost saida;
		FacebookFotoPostDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ApagarTodos(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract FacebookFotoPost ApagarTodos(final DaoConexao conexao)
			throws DaoException;




	protected FacebookFotoPostDao getDao() {
		return DBB.getInstancia().getFacebookFotoPostDao();
	}

	protected void preparaDaoParaConexao(final FacebookFotoPostDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		FacebookFotoPostDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		FacebookFotoPostDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		FacebookFotoPostDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public FacebookFotoPost PreInsercao(FacebookFotoPost item) {
		return item;
	}

	public FacebookFotoPost PreAlteracao(FacebookFotoPost item) {
		return item;
	}

	public FacebookFotoPost obtemPorChave(long chave) throws DaoException {
		FacebookFotoPostDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		FacebookFotoPost saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public FacebookFotoPost obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		FacebookFotoPostDao dao = getDao();
		dao.setConexao(conexao);
		FacebookFotoPost saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		FacebookFotoPostDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		FacebookFotoPostDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		FacebookFotoPostDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public FacebookFotoPost alteraItem(FacebookFotoPost item) throws DaoException {
		FacebookFotoPostDao dao = getDao();
		DaoConexao conexao = null;
		FacebookFotoPost saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookFotoPost alteraItem(FacebookFotoPost item, DaoConexao conexao) throws DaoException {
		FacebookFotoPostDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public FacebookFotoPost insereItemLoad(FacebookFotoPost item) throws DaoException {
		FacebookFotoPostDao dao = getDao();
		DaoConexao conexao = null;
		FacebookFotoPost saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookFotoPost insereItemLoad(FacebookFotoPost item, DaoConexao conexao) throws DaoException {
		FacebookFotoPostDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
