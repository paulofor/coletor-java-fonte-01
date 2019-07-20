package br.com.digicom.lib.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



import br.com.digicom.lib.DCIObjetoDominio;

public abstract class DaoBase implements DaoI {
	public static final String MY_SQL = "MySql";
	private DataFonte _dataSource;
	private String _tipoDataSource;
	private DaoConexao _conexao;
	private MontadorDaoI _montador;

	protected void setMontador(MontadorDaoI montador) {
		this._montador = montador;
	}

	public MontadorDaoI getMontador() {
		if (this._montador == null) {
			this._montador = criaMontadorPadrao();
		}
		return this._montador;
	}

	protected abstract MontadorDaoI criaMontadorPadrao();

	public void setConexao(DaoConexao conexao) {
		this._conexao = conexao;
	}

	protected void setDataSource(DataFonte dataSource) {
		this._dataSource = dataSource;
	}

	public DaoBase(DataFonte dataSource) {
		this._dataSource = dataSource;
	}

	public DaoConexao criaConexao() throws DaoException {
		return this._dataSource.criaConexao();
	}

	public void liberaConexao(DaoConexao conexao) throws DaoException {
		this._dataSource.liberaConexao(conexao);
	}

	protected List getListaSqlListaInterna(String sql) throws DaoException {
		if (this._conexao==null) throw new DaoException("Conexao = null");
		List saida = getListaSqlListaInterna(sql, this._conexao);
		return saida;
	}
	protected DCIObjetoDominio getObjetoSqlInterno(String sql) throws DaoException {
		List listaUnica = getListaSqlListaInterna(sql);
		if(listaUnica.size()>0) 
			return (DCIObjetoDominio) listaUnica.get(0);
		else
			return null;
	}
	
	protected List getListaSql(String sql) throws DaoException {
		List saida = getListaSql(sql, this._conexao);

		return saida;
	}
	
	
	
	
	private List getListaSqlListaInterna(String sql, DaoConexao conexao) throws DaoException{
		List listaSaida = new ArrayList();
		ResultSet resultado = this._dataSource.getListaSql(sql, conexao);
		ResultadoLista resultadoLista = new ResultadoLista();
		resultadoLista.setResultSet(resultado);
		resultadoLista.setSql(sql);
		boolean insere = false;
		DCIObjetoDominio objeto = null;
		DaoItemRetorno retorno = null;
		while (resultadoLista.next()) {
			try {
				retorno = getMontador().extraiRegistroListaInterna(resultadoLista, objeto);
				insere = retorno.getInsere();
				objeto = retorno.getObjeto();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoException(e,sql);
			}
			if (insere) {
				listaSaida.add(objeto);
			}
		}
		return listaSaida;
	}
	

	private List getListaSql(String sql, DaoConexao conexao)
			throws DaoException {
		List listaSaida = new LinkedList();
		ResultSet resultado = this._dataSource.getListaSql(sql, conexao);
		ResultadoLista resultadoLista = new ResultadoLista();
		resultadoLista.setResultSet(resultado);
		resultadoLista.setSql(sql);
		while (resultadoLista.next()) {
			DCIObjetoDominio objeto = getMontador().extraiRegistro(
					resultadoLista);
			listaSaida.add(objeto);
		}
		return listaSaida;
	}

	protected void executaSql(String sql) throws DaoException {
		if (this._conexao==null) throw new DaoException("Conexão nula");
		executaSql(sql, this._conexao);
	}

	protected void executaSqlForcado(String sql) throws DaoException {
		executaSqlForcado(sql, this._conexao);
	}

	private void executaSql(String sql, DaoConexao conexao) throws DaoException {
		this._dataSource.executaSql(sql, conexao);
	}

	private void executaSqlForcado(String sql, DaoConexao conexao)
			throws DaoException {
		this._dataSource.executaSqlForcado(sql, conexao);
	}

	protected DCIObjetoDominio getObjeto(String sql) throws DaoException {
		DCIObjetoDominio saida = getObjeto(sql, this._conexao);
		if (this._montador instanceof MontadorDaoComposite) 
			this._montador = null;
		return saida;
	}

	private DCIObjetoDominio getObjeto(String sql, DaoConexao conexao)
			throws DaoException {
		DCIObjetoDominio objeto = null;
		ResultSet resultado = this._dataSource.getListaSql(sql, conexao);
		ResultadoLista resultadoLista = new ResultadoLista();
		resultadoLista.setResultSet(resultado);
		resultadoLista.setSql(sql);
		if (resultadoLista.next()) {
			objeto = getMontador().extraiRegistro(resultadoLista);
		}
		return objeto;
	}

	private long getValorLong(String sql, DaoConexao conexao)
			throws DaoException {
		return this._dataSource.getValorLong(sql, conexao);
	}

	protected long getValorLong(String sql) throws DaoException {
		long saida = getValorLong(sql, this._conexao);
		return saida;
	}

	private int getValorInt(String sql, DaoConexao conexao) throws DaoException {
		return this._dataSource.getValorInt(sql, conexao);
	}

	protected int getValorInt(String sql) throws DaoException {
		int saida = getValorInt(sql, this._conexao);
		return saida;
	}

	private String getValorString(String sql, DaoConexao conexao)
			throws DaoException {
		return this._dataSource.getValorString(sql, conexao);
	}

	protected String getValorString(String sql) throws DaoException {
		String saida = getValorString(sql, this._conexao);
		return saida;
	}
}

/*
 * Location: D:\Java-Recuperacao\daolib.jar Qualified Name:
 * br.com.digicom.lib.dao.DaoBase JD-Core Version: 0.6.0
 */