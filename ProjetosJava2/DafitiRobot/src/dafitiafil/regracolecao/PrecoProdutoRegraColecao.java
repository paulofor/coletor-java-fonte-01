package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class PrecoProdutoRegraColecao {
	
	public PrecoProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PrecoProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PrecoProdutoFiltro _filtro;

	public PrecoProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PrecoProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(PrecoProdutoFiltro dado) {
		_filtro = dado;
	}

	private PrecoProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected PrecoProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PrecoProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PrecoProduto> _listaItem;
	protected List<PrecoProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PrecoProduto> dado) {
		_listaItem = dado;
	}





	protected PrecoProdutoDao getDao() {
		return DBB.getInstancia().getPrecoProdutoDao();
	}

	protected void preparaDaoParaConexao(final PrecoProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PrecoProduto PreInsercao(PrecoProduto item) {
		return item;
	}

	public PrecoProduto PreAlteracao(PrecoProduto item) {
		return item;
	}

	public PrecoProduto obtemPorChave(long chave) throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PrecoProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PrecoProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		PrecoProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PrecoProduto alteraItem(PrecoProduto item) throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		PrecoProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoProduto alteraItem(PrecoProduto item, DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PrecoProduto insereItemLoad(PrecoProduto item) throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		PrecoProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoProduto insereItemLoad(PrecoProduto item, DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
