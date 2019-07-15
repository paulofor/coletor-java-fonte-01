package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class FacebookProspectRegraColecao {
	
	public FacebookProspectRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		FacebookProspectDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		FacebookProspectDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		FacebookProspectFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private FacebookProspectFiltro _filtro;

	public FacebookProspectFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new FacebookProspectFiltro();
		return _filtro;
	}

	public void setFiltro(FacebookProspectFiltro dado) {
		_filtro = dado;
	}

	private FacebookProspectFiltro[] _listaEntrada;
	@Deprecated
	protected FacebookProspectFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final FacebookProspectFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<FacebookProspect> _listaItem;
	protected List<FacebookProspect> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<FacebookProspect> dado) {
		_listaItem = dado;
	}





	protected FacebookProspectDao getDao() {
		return DBB.getInstancia().getFacebookProspectDao();
	}

	protected void preparaDaoParaConexao(final FacebookProspectDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		FacebookProspectDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		FacebookProspectDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		FacebookProspectDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public FacebookProspect PreInsercao(FacebookProspect item) {
		return item;
	}

	public FacebookProspect PreAlteracao(FacebookProspect item) {
		return item;
	}

	public FacebookProspect obtemPorChave(long chave) throws DaoException {
		FacebookProspectDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		FacebookProspect saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public FacebookProspect obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		FacebookProspectDao dao = getDao();
		dao.setConexao(conexao);
		FacebookProspect saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		FacebookProspectDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		FacebookProspectDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		FacebookProspectDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public FacebookProspect alteraItem(FacebookProspect item) throws DaoException {
		FacebookProspectDao dao = getDao();
		DaoConexao conexao = null;
		FacebookProspect saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookProspect alteraItem(FacebookProspect item, DaoConexao conexao) throws DaoException {
		FacebookProspectDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public FacebookProspect insereItemLoad(FacebookProspect item) throws DaoException {
		FacebookProspectDao dao = getDao();
		DaoConexao conexao = null;
		FacebookProspect saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookProspect insereItemLoad(FacebookProspect item, DaoConexao conexao) throws DaoException {
		FacebookProspectDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
