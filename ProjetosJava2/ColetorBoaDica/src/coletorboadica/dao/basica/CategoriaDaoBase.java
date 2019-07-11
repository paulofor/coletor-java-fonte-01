package coletorboadica.dao.basica;

import java.util.List;

import coletorboadica.dao.montador.*;
import coletorboadica.modelo.Categoria;
import coletorboadica.regracolecao.filtro.CategoriaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CategoriaDaoBase extends DaoAplicacao implements CategoriaDaoBaseI {
	
	
	public CategoriaDaoBase() {
		super();
	}
	public CategoriaDaoBase(DataFonte dataSource) {
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
		return new CategoriaMontador();
	}
	public static String tabelaSelect() {
		return " categoria" ;
	}
	public  String orderByLista() {
		return orderBy();
	}
	public String getLimite() {
		return "";
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
		return " categoria.id_categoria " 
		+ " ,categoria.nome " 
		+ " ,categoria.url " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_categoria " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".url " 
		;
	}
	
	
	@Override
	public void insereItem(Categoria item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Categoria item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Categoria item) throws DaoException {
		Categoria teste = this.obtemPorChave(item.getIdCategoria());
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
	public void insereItemLoad(Categoria item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_categoria) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCategoria(id);	
	}
	@Override
	public void alteraItem(Categoria item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_categoria = " + item.getIdCategoria();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Categoria item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_categoria = " + item.getIdCategoria();
		executaSql(query);
	}
	@Override
	public Categoria obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_categoria = " + id;
        return (Categoria) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CategoriaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CategoriaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CategoriaFiltro filtro)
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
	
	
	protected String valoresInsert(Categoria item) {
		return " ( '" + item.getIdCategoria() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getUrl() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_categoria " 
		+ " ,nome " 
		+ " ,url " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Categoria item) {
		return " id_categoria = '" + item.getIdCategoria() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , url = '" + item.getUrl() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(Categoria item) {
		return " id_categoria = '" + item.getIdCategoria() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , url = '" + item.getUrl() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public Categoria obtemPorCategoriaProdutoAssociada(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaProduto_Associada() + 
			" where id_categoria_produto = " + id;
		return (Categoria) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaProduto_Associada() {
		return " inner join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_a = " + tabelaSelect() + ".id_categoria ";  
	}
	public static String outerJoinCategoriaProduto_Associada() {
		return " left outer join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_a = " + tabelaSelect() + ".id_categoria ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	
	
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
        montador.adicionaMontador(new CategoriaMontador(), null);
         return montador;
    }
	
	
}
