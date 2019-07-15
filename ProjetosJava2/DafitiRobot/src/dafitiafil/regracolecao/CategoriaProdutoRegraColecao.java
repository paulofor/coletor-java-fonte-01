package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class CategoriaProdutoRegraColecao {
	
	public CategoriaProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CategoriaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CategoriaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CategoriaProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CategoriaProdutoFiltro _filtro;

	public CategoriaProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CategoriaProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(CategoriaProdutoFiltro dado) {
		_filtro = dado;
	}

	private CategoriaProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected CategoriaProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CategoriaProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<CategoriaProduto> _listaItem;
	protected List<CategoriaProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<CategoriaProduto> dado) {
		_listaItem = dado;
	}

	public final CategoriaProduto AtualizaDetalhe() throws DaoException {
		CategoriaProduto saida;
		CategoriaProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaDetalhe(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CategoriaProduto AtualizaDetalhe(final DaoConexao conexao)
			throws DaoException;




	protected CategoriaProdutoDao getDao() {
		return DBB.getInstancia().getCategoriaProdutoDao();
	}

	protected void preparaDaoParaConexao(final CategoriaProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CategoriaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CategoriaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CategoriaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public CategoriaProduto PreInsercao(CategoriaProduto item) {
		return item;
	}

	public CategoriaProduto PreAlteracao(CategoriaProduto item) {
		return item;
	}

	public CategoriaProduto obtemPorChave(long chave) throws DaoException {
		CategoriaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		CategoriaProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public CategoriaProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CategoriaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		CategoriaProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CategoriaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CategoriaProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CategoriaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public CategoriaProduto alteraItem(CategoriaProduto item) throws DaoException {
		CategoriaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaProduto alteraItem(CategoriaProduto item, DaoConexao conexao) throws DaoException {
		CategoriaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public CategoriaProduto insereItemLoad(CategoriaProduto item) throws DaoException {
		CategoriaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaProduto insereItemLoad(CategoriaProduto item, DaoConexao conexao) throws DaoException {
		CategoriaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
