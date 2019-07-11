package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class CategoriaProdutoProdutoRegraColecao {
	
	public CategoriaProdutoProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CategoriaProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CategoriaProdutoProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CategoriaProdutoProdutoFiltro _filtro;

	public CategoriaProdutoProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CategoriaProdutoProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(CategoriaProdutoProdutoFiltro dado) {
		_filtro = dado;
	}

	private CategoriaProdutoProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected CategoriaProdutoProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CategoriaProdutoProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<CategoriaProdutoProduto> _listaItem;
	protected List<CategoriaProdutoProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<CategoriaProdutoProduto> dado) {
		_listaItem = dado;
	}





	protected CategoriaProdutoProdutoDao getDao() {
		return DBB.getInstancia().getCategoriaProdutoProdutoDao();
	}

	protected void preparaDaoParaConexao(final CategoriaProdutoProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public CategoriaProdutoProduto PreInsercao(CategoriaProdutoProduto item) {
		return item;
	}

	public CategoriaProdutoProduto PreAlteracao(CategoriaProdutoProduto item) {
		return item;
	}

	public CategoriaProdutoProduto obtemPorChave(long chave) throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		CategoriaProdutoProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public CategoriaProdutoProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		CategoriaProdutoProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public CategoriaProdutoProduto alteraItem(CategoriaProdutoProduto item) throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaProdutoProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaProdutoProduto alteraItem(CategoriaProdutoProduto item, DaoConexao conexao) throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public CategoriaProdutoProduto insereItemLoad(CategoriaProdutoProduto item) throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaProdutoProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaProdutoProduto insereItemLoad(CategoriaProdutoProduto item, DaoConexao conexao) throws DaoException {
		CategoriaProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
