package dafitiafil.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.regracolecao.filtro.*;


public abstract class OportunidadeDiaRegraColecao {
	
	public OportunidadeDiaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		OportunidadeDiaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private OportunidadeDiaFiltro _filtro;

	public OportunidadeDiaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new OportunidadeDiaFiltro();
		return _filtro;
	}

	public void setFiltro(OportunidadeDiaFiltro dado) {
		_filtro = dado;
	}

	private OportunidadeDiaFiltro[] _listaEntrada;
	@Deprecated
	protected OportunidadeDiaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final OportunidadeDiaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<OportunidadeDia> _listaItem;
	protected List<OportunidadeDia> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<OportunidadeDia> dado) {
		_listaItem = dado;
	}

	public final OportunidadeDia ObtemProximoPost() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemProximoPost(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OportunidadeDia ObtemProximoPost(final DaoConexao conexao)
			throws DaoException;
	public final OportunidadeDia CalculaOportunidadeDiaCorrente() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaOportunidadeDiaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OportunidadeDia CalculaOportunidadeDiaCorrente(final DaoConexao conexao)
			throws DaoException;
	public final List<OportunidadeDia> ListaSemImagem() throws DaoException {
		List<OportunidadeDia> saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaSemImagem(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OportunidadeDia> ListaSemImagem(final DaoConexao conexao)
			throws DaoException;
	public final OportunidadeDia ObtemProximoPorCategoria() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemProximoPorCategoria(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OportunidadeDia ObtemProximoPorCategoria(final DaoConexao conexao)
			throws DaoException;
	public final OportunidadeDia AlteraIdFacebook() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AlteraIdFacebook(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OportunidadeDia AlteraIdFacebook(final DaoConexao conexao)
			throws DaoException;
	public final OportunidadeDia ExcluiImagensDia() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ExcluiImagensDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OportunidadeDia ExcluiImagensDia(final DaoConexao conexao)
			throws DaoException;
	public final List<OportunidadeDia> ListaPorCategoria() throws DaoException {
		List<OportunidadeDia> saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorCategoria(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OportunidadeDia> ListaPorCategoria(final DaoConexao conexao)
			throws DaoException;
	public final OportunidadeDia RegistraPostRealizado() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = RegistraPostRealizado(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OportunidadeDia RegistraPostRealizado(final DaoConexao conexao)
			throws DaoException;




	protected OportunidadeDiaDao getDao() {
		return DBB.getInstancia().getOportunidadeDiaDao();
	}

	protected void preparaDaoParaConexao(final OportunidadeDiaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public OportunidadeDia PreInsercao(OportunidadeDia item) {
		return item;
	}

	public OportunidadeDia PreAlteracao(OportunidadeDia item) {
		return item;
	}

	public OportunidadeDia obtemPorChave(long chave) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		OportunidadeDia saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OportunidadeDia obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		OportunidadeDia saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public OportunidadeDia alteraItem(OportunidadeDia item) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = null;
		OportunidadeDia saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OportunidadeDia alteraItem(OportunidadeDia item, DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public OportunidadeDia insereItemLoad(OportunidadeDia item) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = null;
		OportunidadeDia saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OportunidadeDia insereItemLoad(OportunidadeDia item, DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
}
