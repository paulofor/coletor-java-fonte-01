package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.CategoriaProduto;
import dafitiafil.regracolecao.filtro.CategoriaProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CategoriaProdutoDaoBase extends DaoAplicacao implements CategoriaProdutoDaoBaseI {
	
	
	public CategoriaProdutoDaoBase() {
		super();
	}
	public CategoriaProdutoDaoBase(DataFonte dataSource) {
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
		return new CategoriaProdutoMontador();
	}
	public static String tabelaSelect() {
		return " categoria_produto" ;
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
		return " order by " + tabelaSelect() + ".nome " ;
	}
	
	
	public static String camposOrdenados() {
		return " categoria_produto.id_categoria_produto " 
		+ " ,categoria_produto.nome " 
		+ " ,categoria_produto.url " 
		+ " , DATE_FORMAT(categoria_produto.data_inclusao,'%d-%m-%Y') " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_categoria_produto " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".url " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inclusao,'%d-%m-%Y') " 
		;
	}
	
	
	@Override
	public void insereItem(CategoriaProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(CategoriaProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(CategoriaProduto item) throws DaoException {
		CategoriaProduto teste = this.obtemPorChave(item.getIdCategoriaProduto());
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
	public void insereItemLoad(CategoriaProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_categoria_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCategoriaProduto(id);	
	}
	@Override
	public void alteraItem(CategoriaProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_categoria_produto = " + item.getIdCategoriaProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(CategoriaProduto item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_categoria_produto = " + item.getIdCategoriaProduto();
		executaSql(query);
	}
	@Override
	public CategoriaProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_categoria_produto = " + id;
        return (CategoriaProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CategoriaProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CategoriaProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CategoriaProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(CategoriaProduto item) {
		return " ( '" + item.getIdCategoriaProduto() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getUrl() + "'  "
		+ " ," + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_categoria_produto " 
		+ " ,nome " 
		+ " ,url " 
		+ " ,data_inclusao " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CategoriaProduto item) {
		return " id_categoria_produto = '" + item.getIdCategoriaProduto() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , url = '" + item.getUrl() + "'  "
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  "
		;
	}
	protected String camposValoresUpdateEdicao(CategoriaProduto item) {
		return " id_categoria_produto = '" + item.getIdCategoriaProduto() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , url = '" + item.getUrl() + "'  " 
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  " 
		;
	}
	
	
	
	/*
	public CategoriaProduto obtemPorCategoriaProdutoProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaProdutoProduto_Possui() + 
			" where id_categoria_produto_produto = " + id;
		return (CategoriaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaProdutoProduto_Possui() {
		return " inner join " + CategoriaProdutoProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoProdutoDaoBase.tabelaSelect() + ".id_categoria_produto_ra = " + tabelaSelect() + ".id_categoria_produto ";  
	}
	public static String outerJoinCategoriaProdutoProduto_Possui() {
		return " left outer join " + CategoriaProdutoProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoProdutoDaoBase.tabelaSelect() + ".id_categoria_produto_ra = " + tabelaSelect() + ".id_categoria_produto ";  
	}
 	
	/*
	public CategoriaProduto obtemPorFacebookPerfilGera(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookPerfil_Gera() + 
			" where id_facebook_perfil = " + id;
		return (CategoriaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookPerfil_Gera() {
		return " inner join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_categoria_produto_ra = " + tabelaSelect() + ".id_categoria_produto ";  
	}
	public static String outerJoinFacebookPerfil_Gera() {
		return " left outer join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_categoria_produto_ra = " + tabelaSelect() + ".id_categoria_produto ";  
	}
 	
	/*
	public CategoriaProduto obtemPorFacebookFanpagePossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookFanpage_Possui() + 
			" where id_facebook_fanpage = " + id;
		return (CategoriaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookFanpage_Possui() {
		return " inner join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_categoria_produto_ra = " + tabelaSelect() + ".id_categoria_produto ";  
	}
	public static String outerJoinFacebookFanpage_Possui() {
		return " left outer join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_categoria_produto_ra = " + tabelaSelect() + ".id_categoria_produto ";  
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
        montador.adicionaMontador(new CategoriaProdutoMontador(), null);
         return montador;
    }
	
	
}
