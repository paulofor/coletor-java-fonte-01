package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class PrecoProdutoDiarioRegraColecao {
	
	public PrecoProdutoDiarioRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PrecoProdutoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PrecoProdutoDiarioFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PrecoProdutoDiarioFiltro _filtro;

	public PrecoProdutoDiarioFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PrecoProdutoDiarioFiltro();
		return _filtro;
	}

	public void setFiltro(PrecoProdutoDiarioFiltro dado) {
		_filtro = dado;
	}

	private PrecoProdutoDiarioFiltro[] _listaEntrada;
	@Deprecated
	protected PrecoProdutoDiarioFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PrecoProdutoDiarioFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PrecoProdutoDiario> _listaItem;
	protected List<PrecoProdutoDiario> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PrecoProdutoDiario> dado) {
		_listaItem = dado;
	}





	protected PrecoProdutoDiarioDao getDao() {
		return DBB.getInstancia().getPrecoProdutoDiarioDao();
	}

	protected void preparaDaoParaConexao(final PrecoProdutoDiarioDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PrecoProdutoDiario PreInsercao(PrecoProdutoDiario item) {
		return item;
	}

	public PrecoProdutoDiario PreAlteracao(PrecoProdutoDiario item) {
		return item;
	}

	public PrecoProdutoDiario obtemPorChave(long chave) throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PrecoProdutoDiario saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PrecoProdutoDiario obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		PrecoProdutoDiario saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PrecoProdutoDiario alteraItem(PrecoProdutoDiario item) throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		PrecoProdutoDiario saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoProdutoDiario alteraItem(PrecoProdutoDiario item, DaoConexao conexao) throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PrecoProdutoDiario insereItemLoad(PrecoProdutoDiario item) throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		PrecoProdutoDiario saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoProdutoDiario insereItemLoad(PrecoProdutoDiario item, DaoConexao conexao) throws DaoException {
		PrecoProdutoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
