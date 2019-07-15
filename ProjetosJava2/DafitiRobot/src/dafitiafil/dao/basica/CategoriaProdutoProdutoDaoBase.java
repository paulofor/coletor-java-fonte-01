package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.CategoriaProdutoProduto;
import dafitiafil.regracolecao.filtro.CategoriaProdutoProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CategoriaProdutoProdutoDaoBase extends DaoAplicacao implements CategoriaProdutoProdutoDaoBaseI {
	
	
	public CategoriaProdutoProdutoDaoBase() {
		super();
	}
	public CategoriaProdutoProdutoDaoBase(DataFonte dataSource) {
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
		return new CategoriaProdutoProdutoMontador();
	}
	public static String tabelaSelect() {
		return " categoria_produto_produto" ;
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
		return " order by " + tabelaSelect() + ".id_categoria_produto_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " categoria_produto_produto.id_categoria_produto_produto " 
		+ " , DATE_FORMAT(categoria_produto_produto.data_inclusao,'%d-%m-%Y') " 
		+ " ,categoria_produto_produto.id_categoria_produto_ra " 
		+ " ,categoria_produto_produto.id_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_categoria_produto_produto " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inclusao,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".id_categoria_produto_ra " 
		+ " , " + nomeTabela + ".id_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(CategoriaProdutoProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(CategoriaProdutoProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(CategoriaProdutoProduto item) throws DaoException {
		CategoriaProdutoProduto teste = this.obtemPorChave(item.getIdCategoriaProdutoProduto());
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
	public void insereItemLoad(CategoriaProdutoProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_categoria_produto_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCategoriaProdutoProduto(id);	
	}
	@Override
	public void alteraItem(CategoriaProdutoProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_categoria_produto_produto = " + item.getIdCategoriaProdutoProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(CategoriaProdutoProduto item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_categoria_produto_produto = " + item.getIdCategoriaProdutoProduto();
		executaSql(query);
	}
	@Override
	public CategoriaProdutoProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_categoria_produto_produto = " + id;
        return (CategoriaProdutoProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CategoriaProdutoProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CategoriaProdutoProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoCategoriaProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_categoria_produto_ra = " + filtro.getCodigoCategoriaProdutoReferenteA();
      	}
      	
		if (filtro.getCodigoProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_ra = " + filtro.getCodigoProdutoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CategoriaProdutoProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(CategoriaProdutoProduto item) {
		return " ( '" + item.getIdCategoriaProdutoProduto() + "'  " 
		+ " ," + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  "
		+ " ," + item.getIdCategoriaProdutoRa() + "  "
		+ " ," + item.getIdProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_categoria_produto_produto " 
		+ " ,data_inclusao " 
		+ " ,id_categoria_produto_ra " 
		+ " ,id_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CategoriaProdutoProduto item) {
		return " id_categoria_produto_produto = '" + item.getIdCategoriaProdutoProduto() + "'  " 
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  "
		+ " , id_categoria_produto_ra = " + item.getIdCategoriaProdutoRa() + "  "
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(CategoriaProdutoProduto item) {
		return " id_categoria_produto_produto = '" + item.getIdCategoriaProdutoProduto() + "'  " 
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  " 
		+ " , id_categoria_produto_ra = " + item.getIdCategoriaProdutoRa() + "  " 
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  " 
		;
	}
	
	
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorReferenteACategoriaProduto(long id) throws DaoException{ // Padrao
	public List ListaPorCategoriaProdutoReferenteA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	ProdutoDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + ProdutoDaoBase.tabelaSelect() +
            " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " +
            tabelaSelect() + ".id_produto_ra" +
            " where id_categoria_produto_ra = " + id + " " +
            criterioExclusaoCategoriaProdutoReferenteA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaProdutoProdutoMontador(),null);
        montador.adicionaMontador(new ProdutoMontador(), "ProdutoReferenteA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorReferenteACategoriaProduto(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_categoria_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoCategoriaProdutoReferenteA() {
		return "";
	}
	
	//public List getPorReferenteAProduto(long id) throws DaoException{ // Padrao
	public List ListaPorProdutoReferenteA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	CategoriaProdutoDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + CategoriaProdutoDaoBase.tabelaSelect() +
            " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_produto = " +
            tabelaSelect() + ".id_categoria_produto_ra" +
            " where id_produto_ra = " + id + " " +
            criterioExclusaoProdutoReferenteA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaProdutoProdutoMontador(),null);
        montador.adicionaMontador(new CategoriaProdutoMontador(), "CategoriaProdutoReferenteA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorReferenteAProduto(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoProdutoReferenteA() {
		return "";
	}
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemCategoriaProduto_ReferenteA = false;
	public void setObtemCategoriaProduto_ReferenteA() {
		_obtemCategoriaProduto_ReferenteA = true;
	}
	protected String outterJoinCategoriaProduto_ReferenteA() {
		return " left outer join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_produto = " + tabelaSelect() + ".id_categoria_produto_ra ";  
	}
	public boolean atualizaReferenteACategoriaProduto(long idCategoriaProdutoProduto, long idCategoriaProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_categoria_produto_ra  = " + idCategoriaProdutoRa +
        " where id_categoria_produto_produto = " +  idCategoriaProdutoProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinCategoriaProduto_ReferenteA() {
		return " inner join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_produto = " + tabelaSelect() + ".id_categoria_produto_ra ";  
	}
	
 	
	private boolean _obtemProduto_ReferenteA = false;
	public void setObtemProduto_ReferenteA() {
		_obtemProduto_ReferenteA = true;
	}
	protected String outterJoinProduto_ReferenteA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	public boolean atualizaReferenteAProduto(long idCategoriaProdutoProduto, long idProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_ra  = " + idProdutoRa +
        " where id_categoria_produto_produto = " +  idCategoriaProdutoProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProduto_ReferenteA() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemCategoriaProduto_ReferenteA?" , " +CategoriaProdutoDaoBase.camposOrdenados():"");
		saida += (this._obtemProduto_ReferenteA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemCategoriaProduto_ReferenteA = false;
		_obtemProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemCategoriaProduto_ReferenteA? outterJoinCategoriaProduto_ReferenteA() + " ":"");
		saida += (this._obtemProduto_ReferenteA? outterJoinProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaProdutoProdutoMontador(), null);
		if (this._obtemCategoriaProduto_ReferenteA)
            montador.adicionaMontador(new CategoriaProdutoMontador(), "CategoriaProduto_ReferenteA");
		if (this._obtemProduto_ReferenteA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_ReferenteA");
         return montador;
    }
	
	
}
