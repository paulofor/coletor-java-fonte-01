package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class ProdutoRegraColecao {
	
	public ProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ProdutoFiltro _filtro;

	public ProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(ProdutoFiltro dado) {
		_filtro = dado;
	}

	private ProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected ProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Produto> _listaItem;
	protected List<Produto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Produto> dado) {
		_listaItem = dado;
	}

	public final Produto BaixarImagens() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = BaixarImagens(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto BaixarImagens(final DaoConexao conexao)
			throws DaoException;
	public final List<Produto> OportunidadeDia() throws DaoException {
		List<Produto> saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = OportunidadeDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Produto> OportunidadeDia(final DaoConexao conexao)
			throws DaoException;
	public final Produto ObtemCodigoDafiti() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemCodigoDafiti(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto ObtemCodigoDafiti(final DaoConexao conexao)
			throws DaoException;
	public final Produto CriaCodigoDafitiPorCategoriaOportunidade() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaCodigoDafitiPorCategoriaOportunidade(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto CriaCodigoDafitiPorCategoriaOportunidade(final DaoConexao conexao)
			throws DaoException;




	protected ProdutoDao getDao() {
		return DBB.getInstancia().getProdutoDao();
	}

	protected void preparaDaoParaConexao(final ProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Produto PreInsercao(Produto item) {
		return item;
	}

	public Produto PreAlteracao(Produto item) {
		return item;
	}

	public Produto obtemPorChave(long chave) throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Produto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Produto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		Produto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Produto alteraItem(Produto item) throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = null;
		Produto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Produto alteraItem(Produto item, DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Produto insereItemLoad(Produto item) throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = null;
		Produto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Produto insereItemLoad(Produto item, DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
