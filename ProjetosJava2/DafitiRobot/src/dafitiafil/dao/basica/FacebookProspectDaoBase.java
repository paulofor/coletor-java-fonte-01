package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.FacebookProspect;
import dafitiafil.regracolecao.filtro.FacebookProspectFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class FacebookProspectDaoBase extends DaoAplicacao implements FacebookProspectDaoBaseI {
	
	
	public FacebookProspectDaoBase() {
		super();
	}
	public FacebookProspectDaoBase(DataFonte dataSource) {
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
		return new FacebookProspectMontador();
	}
	public static String tabelaSelect() {
		return " facebook_prospect" ;
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
		return " order by " + tabelaSelect() + ".facebook_id " ;
	}
	
	
	public static String camposOrdenados() {
		return " facebook_prospect.id_facebook_prospect " 
		+ " ,facebook_prospect.facebook_id " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_facebook_prospect " 
		+ " , " + nomeTabela + ".facebook_id " 
		;
	}
	
	
	@Override
	public void insereItem(FacebookProspect item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(FacebookProspect item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(FacebookProspect item) throws DaoException {
		FacebookProspect teste = this.obtemPorChave(item.getIdFacebookProspect());
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
	public void insereItemLoad(FacebookProspect item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_facebook_prospect) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdFacebookProspect(id);	
	}
	@Override
	public void alteraItem(FacebookProspect item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_facebook_prospect = " + item.getIdFacebookProspect();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(FacebookProspect item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_facebook_prospect = " + item.getIdFacebookProspect();
		executaSql(query);
	}
	@Override
	public FacebookProspect obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_facebook_prospect = " + id;
        return (FacebookProspect) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(FacebookProspectFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( FacebookProspectFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(FacebookProspectFiltro filtro)
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
	
	
	protected String valoresInsert(FacebookProspect item) {
		return " ( '" + item.getIdFacebookProspect() + "'  " 
		+ " ,'" + item.getFacebookId() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_facebook_prospect " 
		+ " ,facebook_id " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(FacebookProspect item) {
		return " id_facebook_prospect = '" + item.getIdFacebookProspect() + "'  " 
		+ " , facebook_id = '" + item.getFacebookId() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(FacebookProspect item) {
		return " id_facebook_prospect = '" + item.getIdFacebookProspect() + "'  " 
		+ " , facebook_id = '" + item.getFacebookId() + "'  " 
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
        montador.adicionaMontador(new FacebookProspectMontador(), null);
         return montador;
    }
	
	
}
