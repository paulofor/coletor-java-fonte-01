package coletorboadica.dao.basica;

import java.util.List;

import coletorboadica.dao.montador.*;
import coletorboadica.modelo.ProdutoComum;
import coletorboadica.regracolecao.filtro.ProdutoComumFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ProdutoComumDaoBase extends DaoAplicacao implements ProdutoComumDaoBaseI {
	
	
	public ProdutoComumDaoBase() {
		super();
	}
	public ProdutoComumDaoBase(DataFonte dataSource) {
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
		return new ProdutoComumMontador();
	}
	public static String tabelaSelect() {
		return " produto_comum" ;
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
		return " order by " + tabelaSelect() + ".nome_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " produto_comum.id_produto_comum " 
		+ " ,produto_comum.nome_produto " 
		+ " ,produto_comum.marca " 
		+ " ,produto_comum.descricao " 
		+ " ,produto_comum.url " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_produto_comum " 
		+ " , " + nomeTabela + ".nome_produto " 
		+ " , " + nomeTabela + ".marca " 
		+ " , " + nomeTabela + ".descricao " 
		+ " , " + nomeTabela + ".url " 
		;
	}
	
	
	@Override
	public void insereItem(ProdutoComum item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ProdutoComum item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ProdutoComum item) throws DaoException {
		ProdutoComum teste = this.obtemPorChave(item.getIdProdutoComum());
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
	public void insereItemLoad(ProdutoComum item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_produto_comum) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdProdutoComum(id);	
	}
	@Override
	public void alteraItem(ProdutoComum item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_produto_comum = " + item.getIdProdutoComum();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ProdutoComum item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_produto_comum = " + item.getIdProdutoComum();
		executaSql(query);
	}
	@Override
	public ProdutoComum obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_produto_comum = " + id;
        return (ProdutoComum) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ProdutoComumFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ProdutoComumFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ProdutoComumFiltro filtro)
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
	
	
	protected String valoresInsert(ProdutoComum item) {
		return " ( '" + item.getIdProdutoComum() + "'  " 
		+ " ,'" + item.getNomeProduto() + "'  "
		+ " ,'" + item.getMarca() + "'  "
		+ " ,'" + item.getDescricao() + "'  "
		+ " ,'" + item.getUrl() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_produto_comum " 
		+ " ,nome_produto " 
		+ " ,marca " 
		+ " ,descricao " 
		+ " ,url " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ProdutoComum item) {
		return " id_produto_comum = '" + item.getIdProdutoComum() + "'  " 
		+ " , nome_produto = '" + item.getNomeProduto() + "'  "
		+ " , marca = '" + item.getMarca() + "'  "
		+ " , descricao = '" + item.getDescricao() + "'  "
		+ " , url = '" + item.getUrl() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(ProdutoComum item) {
		return " id_produto_comum = '" + item.getIdProdutoComum() + "'  " 
		+ " , nome_produto = '" + item.getNomeProduto() + "'  " 
		+ " , marca = '" + item.getMarca() + "'  " 
		+ " , descricao = '" + item.getDescricao() + "'  " 
		+ " , url = '" + item.getUrl() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public ProdutoComum obtemPorPrecoLojaPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPrecoLoja_Possui() + 
			" where id_preco_loja = " + id;
		return (ProdutoComum) getObjeto(sql);
	}
	*/
	public static String innerJoinPrecoLoja_Possui() {
		return " inner join " + PrecoLojaDaoBase.tabelaSelect() + " on " + PrecoLojaDaoBase.tabelaSelect() + ".id_produto_comum_ra = " + tabelaSelect() + ".id_produto_comum ";  
	}
	public static String outerJoinPrecoLoja_Possui() {
		return " left outer join " + PrecoLojaDaoBase.tabelaSelect() + " on " + PrecoLojaDaoBase.tabelaSelect() + ".id_produto_comum_ra = " + tabelaSelect() + ".id_produto_comum ";  
	}
 	
	/*
	public ProdutoComum obtemPorCategoriaProdutoAssociada(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaProduto_Associada() + 
			" where id_categoria_produto = " + id;
		return (ProdutoComum) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaProduto_Associada() {
		return " inner join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_produto_comum_a = " + tabelaSelect() + ".id_produto_comum ";  
	}
	public static String outerJoinCategoriaProduto_Associada() {
		return " left outer join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_produto_comum_a = " + tabelaSelect() + ".id_produto_comum ";  
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
        montador.adicionaMontador(new ProdutoComumMontador(), null);
         return montador;
    }
	
	
}
