package coletorboadica.dao.basica;

import java.util.List;

import coletorboadica.dao.montador.*;
import coletorboadica.modelo.CategoriaProduto;
import coletorboadica.regracolecao.filtro.CategoriaProdutoFiltro;
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
		return " order by " + tabelaSelect() + ".id_categoria_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " categoria_produto.id_categoria_produto " 
		+ " ,categoria_produto.id_produto_comum_a " 
		+ " ,categoria_produto.id_categoria_a " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_categoria_produto " 
		+ " , " + nomeTabela + ".id_produto_comum_a " 
		+ " , " + nomeTabela + ".id_categoria_a " 
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
		query = " delete from " + tabelaSelect() + " where id_categoria_produto = " + item.getIdCategoriaProduto();
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
      	
		if (filtro.getCodigoProdutoComumAssociada() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_comum_a = " + filtro.getCodigoProdutoComumAssociada();
      	}
      	
		if (filtro.getCodigoCategoriaAssociada() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_categoria_a = " + filtro.getCodigoCategoriaAssociada();
      	}
      	
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
		+ " ," + item.getIdProdutoComumA() + "  "
		+ " ," + item.getIdCategoriaA() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_categoria_produto " 
		+ " ,id_produto_comum_a " 
		+ " ,id_categoria_a " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CategoriaProduto item) {
		return " id_categoria_produto = '" + item.getIdCategoriaProduto() + "'  " 
		+ " , id_produto_comum_a = " + item.getIdProdutoComumA() + "  "
		+ " , id_categoria_a = " + item.getIdCategoriaA() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(CategoriaProduto item) {
		return " id_categoria_produto = '" + item.getIdCategoriaProduto() + "'  " 
		+ " , id_produto_comum_a = " + item.getIdProdutoComumA() + "  " 
		+ " , id_categoria_a = " + item.getIdCategoriaA() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	@Override
	public CategoriaProduto obtemPorRel(long idProdutoComumA, long idCategoriaA) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_produto_comum_a = " + idProdutoComumA + 
				" and id_categoria_a = " + idCategoriaA;
		return (CategoriaProduto) this.getObjeto(sql);
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorAssociadaProdutoComum(long id) throws DaoException{ // Padrao
	public List ListaPorProdutoComumAssociada(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	CategoriaDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + CategoriaDaoBase.tabelaSelect() +
            " on " + CategoriaDaoBase.tabelaSelect() + ".id_categoria = " +
            tabelaSelect() + ".id_categoria_a" +
            " where id_produto_comum_a = " + id + " " +
            criterioExclusaoProdutoComumAssociada() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaProdutoMontador(),null);
        montador.adicionaMontador(new CategoriaMontador(), "CategoriaAssociada");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorAssociadaProdutoComum(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_produto_comum_a = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoProdutoComumAssociada() {
		return "";
	}
	
	//public List getPorAssociadaCategoria(long id) throws DaoException{ // Padrao
	public List ListaPorCategoriaAssociada(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	ProdutoComumDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + ProdutoComumDaoBase.tabelaSelect() +
            " on " + ProdutoComumDaoBase.tabelaSelect() + ".id_produto_comum = " +
            tabelaSelect() + ".id_produto_comum_a" +
            " where id_categoria_a = " + id + " " +
            criterioExclusaoCategoriaAssociada() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaProdutoMontador(),null);
        montador.adicionaMontador(new ProdutoComumMontador(), "ProdutoComumAssociada");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorAssociadaCategoria(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_categoria_a = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoCategoriaAssociada() {
		return "";
	}
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProdutoComum_Associada = false;
	public void setObtemProdutoComum_Associada() {
		_obtemProdutoComum_Associada = true;
	}
	protected String outterJoinProdutoComum_Associada() {
		return " left outer join " + ProdutoComumDaoBase.tabelaSelect() + " on " + ProdutoComumDaoBase.tabelaSelect() + ".id_produto_comum = " + tabelaSelect() + ".id_produto_comum_a ";  
	}
	public boolean atualizaAssociadaProdutoComum(long idCategoriaProduto, long idProdutoComumA) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_comum_a  = " + idProdutoComumA +
        " where id_categoria_produto = " +  idCategoriaProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProdutoComum_Associada() {
		return " inner join " + ProdutoComumDaoBase.tabelaSelect() + " on " + ProdutoComumDaoBase.tabelaSelect() + ".id_produto_comum = " + tabelaSelect() + ".id_produto_comum_a ";  
	}
	
 	
	private boolean _obtemCategoria_Associada = false;
	public void setObtemCategoria_Associada() {
		_obtemCategoria_Associada = true;
	}
	protected String outterJoinCategoria_Associada() {
		return " left outer join " + CategoriaDaoBase.tabelaSelect() + " on " + CategoriaDaoBase.tabelaSelect() + ".id_categoria = " + tabelaSelect() + ".id_categoria_a ";  
	}
	public boolean atualizaAssociadaCategoria(long idCategoriaProduto, long idCategoriaA) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_categoria_a  = " + idCategoriaA +
        " where id_categoria_produto = " +  idCategoriaProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinCategoria_Associada() {
		return " inner join " + CategoriaDaoBase.tabelaSelect() + " on " + CategoriaDaoBase.tabelaSelect() + ".id_categoria = " + tabelaSelect() + ".id_categoria_a ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProdutoComum_Associada?" , " +ProdutoComumDaoBase.camposOrdenados():"");
		saida += (this._obtemCategoria_Associada?" , " +CategoriaDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProdutoComum_Associada = false;
		_obtemCategoria_Associada = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProdutoComum_Associada? outterJoinProdutoComum_Associada() + " ":"");
		saida += (this._obtemCategoria_Associada? outterJoinCategoria_Associada() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaProdutoMontador(), null);
		if (this._obtemProdutoComum_Associada)
            montador.adicionaMontador(new ProdutoComumMontador(), "ProdutoComum_Associada");
		if (this._obtemCategoria_Associada)
            montador.adicionaMontador(new CategoriaMontador(), "Categoria_Associada");
         return montador;
    }
	
	
}
