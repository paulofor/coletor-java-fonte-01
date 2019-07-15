package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class UsuarioRegraColecao {
	
	public UsuarioRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		UsuarioFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private UsuarioFiltro _filtro;

	public UsuarioFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new UsuarioFiltro();
		return _filtro;
	}

	public void setFiltro(UsuarioFiltro dado) {
		_filtro = dado;
	}

	private UsuarioFiltro[] _listaEntrada;
	@Deprecated
	protected UsuarioFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final UsuarioFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Usuario> _listaItem;
	protected List<Usuario> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Usuario> dado) {
		_listaItem = dado;
	}





	protected UsuarioDao getDao() {
		return DBB.getInstancia().getUsuarioDao();
	}

	protected void preparaDaoParaConexao(final UsuarioDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Usuario PreInsercao(Usuario item) {
		return item;
	}

	public Usuario PreAlteracao(Usuario item) {
		return item;
	}

	public Usuario obtemPorChave(long chave) throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Usuario saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Usuario obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		Usuario saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Usuario alteraItem(Usuario item) throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = null;
		Usuario saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Usuario alteraItem(Usuario item, DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Usuario insereItemLoad(Usuario item) throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = null;
		Usuario saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Usuario insereItemLoad(Usuario item, DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
