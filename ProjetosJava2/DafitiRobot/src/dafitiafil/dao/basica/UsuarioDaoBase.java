package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.Usuario;
import dafitiafil.regracolecao.filtro.UsuarioFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class UsuarioDaoBase extends DaoAplicacao implements UsuarioDaoBaseI {
	
	
	public UsuarioDaoBase() {
		super();
	}
	public UsuarioDaoBase(DataFonte dataSource) {
		super(dataSource);
	}
	protected String ConsultaJoin() {
		String tabelas;
		tabelas = tabelaSelect();
		return tabelas;
	}
	protected String CamposSelectJoin() {
		String select;
		select = camposOrdenados();
		return select;
	}
	protected  MontadorDaoI criaMontadorPadrao() {
		return new UsuarioMontador();
	}
	public static String tabelaSelect() {
		return " usuario" ;
	}
	public  String orderByLista() {
		return orderBy();
	}
	public  String whereLista() {
		return "";
	}
	public  String whereListaConcatenado() {
		return "";
	}
	public   static String orderBy() {
		return " order by " + tabelaSelect() + ".id_usuario " ;
	}
	
	
	public static String camposOrdenados() {
		return " usuario.id_usuario " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_usuario " 
		;
	}
	
	
	@Override
	public void insereItem(Usuario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Usuario item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Usuario item) throws DaoException {
		Usuario teste = this.obtemPorChave(item.getIdUsuario());
      	if (teste == null)
      	{
        	insereItemCompleto(item);
          	return true;
      	}
      	else
      	{
          	return false;
      	}
	}
	@Override
	public void insereItemLoad(Usuario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_usuario) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdUsuario(id);	
	}
	@Override
	public void alteraItem(Usuario item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_usuario = " + item.getIdUsuario();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Usuario item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_usuario = " + item.getIdUsuario();
		executaSql(query);
	}
	@Override
	public Usuario obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_usuario = " + id;
        return (Usuario) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(UsuarioFiltro filtro) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      	String where;
      	where = WhereFiltro(filtro) + whereListaConcatenado();
      	if (where.length() > 0)
        	sql += " where " + where;
      	sql += orderByLista();
      	return getListaSql(sql);
	}
	
	protected  String WhereFiltro( UsuarioFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(UsuarioFiltro filtro)
			throws DaoException {
		setMontador(null);
		String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      	String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
		if (where.length() > 0)
			sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	
	@Override
	public List ListaCorrente() throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenados() + " from " + tabelaSelect() + orderByLista();
      	return getListaSql(sql);
	}
	
	
	protected String valoresInsert(Usuario item) {
		return " ( '" + item.getIdUsuario() + "'  " 
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_usuario " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Usuario item) {
		return " id_usuario = '" + item.getIdUsuario() + "'  " 
		;
	}
	protected String camposValoresUpdateEdicao(Usuario item) {
		return " id_usuario = '" + item.getIdUsuario() + "'  " 
		;
	}
	
	
	
	
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
        return saida;
    }
    
    public void limpaObtem()
    {
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new UsuarioMontador(), null);
         return montador;
    }
	
	
}
