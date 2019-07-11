package coletorboadica.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorboadica.dao.*;
import coletorboadica.modelo.*;
import coletorboadica.regracolecao.filtro.*;


public abstract class PrecoLojaRegraColecao {
	
	public PrecoLojaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PrecoLojaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PrecoLojaFiltro _filtro;

	public PrecoLojaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PrecoLojaFiltro();
		return _filtro;
	}

	public void setFiltro(PrecoLojaFiltro dado) {
		_filtro = dado;
	}

	private PrecoLojaFiltro[] _listaEntrada;
	@Deprecated
	protected PrecoLojaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PrecoLojaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PrecoLoja> _listaItem;
	protected List<PrecoLoja> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PrecoLoja> dado) {
		_listaItem = dado;
	}





	public static final PrecoLojaDao getDao() {
		return DBB.getInstancia().getPrecoLojaDao();
	}
	protected final PrecoLojaDao getDao(final DaoConexao conexao) {
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final PrecoLojaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PrecoLojaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PrecoLojaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PrecoLoja PreInsercao(PrecoLoja item) {
		return item;
	}

	public PrecoLoja PreAlteracao(PrecoLoja item) {
		return item;
	}

	public PrecoLoja obtemPorChave(long chave) throws DaoException {
		PrecoLojaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PrecoLoja saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PrecoLoja obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		PrecoLoja saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PrecoLojaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PrecoLojaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PrecoLojaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PrecoLoja excluiItem(PrecoLoja item) throws DaoException {
		PrecoLojaDao dao = getDao();
		DaoConexao conexao = null;
		PrecoLoja saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoLoja excluiItem(PrecoLoja item, DaoConexao conexao) throws DaoException {
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public PrecoLoja alteraItem(PrecoLoja item) throws DaoException {
		PrecoLojaDao dao = getDao();
		DaoConexao conexao = null;
		PrecoLoja saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoLoja alteraItem(PrecoLoja item, DaoConexao conexao) throws DaoException {
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PrecoLoja insereItemLoad(PrecoLoja item) throws DaoException {
		PrecoLojaDao dao = getDao();
		DaoConexao conexao = null;
		PrecoLoja saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoLoja insereItemLoad(PrecoLoja item, DaoConexao conexao) throws DaoException {
		PrecoLojaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAProdutoComum(long id) throws DaoException {
		// Existe no DAO
		PrecoLojaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoComumReferenteA(id);
	}
	public boolean excluiPorReferenteAProdutoComum(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAProdutoComum(long id, DaoConexao conn) throws DaoException {
		PrecoLojaDao dao = getDao(conn);
		return dao.ListaPorProdutoComumReferenteA(id);
	}
	
	
}
