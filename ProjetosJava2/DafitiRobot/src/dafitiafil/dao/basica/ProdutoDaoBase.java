package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.Produto;
import dafitiafil.regracolecao.filtro.ProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ProdutoDaoBase extends DaoAplicacao implements ProdutoDaoBaseI {
	
	
	public ProdutoDaoBase() {
		super();
	}
	public ProdutoDaoBase(DataFonte dataSource) {
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
		return new ProdutoMontador();
	}
	public static String tabelaSelect() {
		return " produto" ;
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
		return " produto.id_produto " 
		+ " ,produto.nome " 
		+ " ,produto.url " 
		+ " ,produto.imagem " 
		+ " ,produto.tamanho_imagem " 
		+ " , DATE_FORMAT(produto.data_inclusao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,produto.imagem_local " 
		+ " ,produto.url_origem " 
		+ " ,produto.url_afiliado " 
		+ " ,produto.posicao_produto " 
		+ " ,produto.id_marca_pa " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_produto " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".url " 
		+ " , " + nomeTabela + ".imagem " 
		+ " , " + nomeTabela + ".tamanho_imagem " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inclusao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".imagem_local " 
		+ " , " + nomeTabela + ".url_origem " 
		+ " , " + nomeTabela + ".url_afiliado " 
		+ " , " + nomeTabela + ".posicao_produto " 
		+ " , " + nomeTabela + ".id_marca_pa " 
		;
	}
	
	
	@Override
	public void insereItem(Produto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Produto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Produto item) throws DaoException {
		Produto teste = this.obtemPorChave(item.getIdProduto());
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
	public void insereItemLoad(Produto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdProduto(id);	
	}
	@Override
	public void alteraItem(Produto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_produto = " + item.getIdProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Produto item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_produto = " + item.getIdProduto();
		executaSql(query);
	}
	@Override
	public Produto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_produto = " + id;
        return (Produto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoMarcaPertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_marca_pa = " + filtro.getCodigoMarcaPertenceA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(Produto item) {
		return " ( '" + item.getIdProduto() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getUrl() + "'  "
		+ " ,'" + item.getImagem() + "'  "
		+ " ,'" + item.getTamanhoImagem() + "'  "
		+ " ," + (item.getDataInclusao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataInclusao()) ) + "  "
		+ " ,'" + item.getImagemLocal() + "'  "
		+ " ,'" + item.getUrlOrigem() + "'  "
		+ " ,'" + item.getUrlAfiliado() + "'  "
		+ " ,'" + item.getPosicaoProduto() + "'  "
		+ " ," + item.getIdMarcaPa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_produto " 
		+ " ,nome " 
		+ " ,url " 
		+ " ,imagem " 
		+ " ,tamanho_imagem " 
		+ " ,data_inclusao " 
		+ " ,imagem_local " 
		+ " ,url_origem " 
		+ " ,url_afiliado " 
		+ " ,posicao_produto " 
		+ " ,id_marca_pa " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Produto item) {
		return " id_produto = '" + item.getIdProduto() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , url = '" + item.getUrl() + "'  "
		+ " , imagem = '" + item.getImagem() + "'  "
		+ " , tamanho_imagem = '" + item.getTamanhoImagem() + "'  "
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataInclusao()) ) + "  "
		+ " , imagem_local = '" + item.getImagemLocal() + "'  "
		+ " , url_origem = '" + item.getUrlOrigem() + "'  "
		+ " , url_afiliado = '" + item.getUrlAfiliado() + "'  "
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  "
		+ " , id_marca_pa = " + item.getIdMarcaPa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(Produto item) {
		return " id_produto = '" + item.getIdProduto() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , url = '" + item.getUrl() + "'  " 
		+ " , imagem = '" + item.getImagem() + "'  " 
		+ " , tamanho_imagem = '" + item.getTamanhoImagem() + "'  " 
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataInclusao()) ) + "  " 
		+ " , imagem_local = '" + item.getImagemLocal() + "'  " 
		+ " , url_origem = '" + item.getUrlOrigem() + "'  " 
		+ " , url_afiliado = '" + item.getUrlAfiliado() + "'  " 
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  " 
		+ " , id_marca_pa = " + item.getIdMarcaPa() + "  " 
		;
	}
	
	
	
	/*
	public Produto obtemPorCategoriaProdutoProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaProdutoProduto_Possui() + 
			" where id_categoria_produto_produto = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaProdutoProduto_Possui() {
		return " inner join " + CategoriaProdutoProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinCategoriaProdutoProduto_Possui() {
		return " left outer join " + CategoriaProdutoProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorPrecoProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPrecoProduto_Possui() + 
			" where id_preco_produto = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinPrecoProduto_Possui() {
		return " inner join " + PrecoProdutoDaoBase.tabelaSelect() + " on " + PrecoProdutoDaoBase.tabelaSelect() + ".id_produto_pa = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinPrecoProduto_Possui() {
		return " left outer join " + PrecoProdutoDaoBase.tabelaSelect() + " on " + PrecoProdutoDaoBase.tabelaSelect() + ".id_produto_pa = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorOportunidadeDiaPodePossuir(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOportunidadeDia_PodePossuir() + 
			" where id_oportunidade_dia = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinOportunidadeDia_PodePossuir() {
		return " inner join " + OportunidadeDiaDaoBase.tabelaSelect() + " on " + OportunidadeDiaDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinOportunidadeDia_PodePossuir() {
		return " left outer join " + OportunidadeDiaDaoBase.tabelaSelect() + " on " + OportunidadeDiaDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorPrecoProdutoDiarioPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPrecoProdutoDiario_Possui() + 
			" where id_preco_produto_diario = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinPrecoProdutoDiario_Possui() {
		return " inner join " + PrecoProdutoDiarioDaoBase.tabelaSelect() + " on " + PrecoProdutoDiarioDaoBase.tabelaSelect() + ".id_produto_pa = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinPrecoProdutoDiario_Possui() {
		return " left outer join " + PrecoProdutoDiarioDaoBase.tabelaSelect() + " on " + PrecoProdutoDiarioDaoBase.tabelaSelect() + ".id_produto_pa = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorFacebookFotoPostGerou(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookFotoPost_Gerou() + 
			" where id_facebook_foto_post = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookFotoPost_Gerou() {
		return " inner join " + FacebookFotoPostDaoBase.tabelaSelect() + " on " + FacebookFotoPostDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinFacebookFotoPost_Gerou() {
		return " left outer join " + FacebookFotoPostDaoBase.tabelaSelect() + " on " + FacebookFotoPostDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorFacebookPerfilAparece(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookPerfil_Aparece() + 
			" where id_facebook_perfil = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookPerfil_Aparece() {
		return " inner join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_produto_i = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinFacebookPerfil_Aparece() {
		return " left outer join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_produto_i = " + tabelaSelect() + ".id_produto ";  
	}
 	
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAMarca(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_marca_pa = " + id + orderByLista();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	public boolean excluiPorPertenceAMarca(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_marca_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemMarca_PertenceA = false;
	public void setObtemMarca_PertenceA() {
		_obtemMarca_PertenceA = true;
	}
	protected String outterJoinMarca_PertenceA() {
		return " left outer join " + MarcaDaoBase.tabelaSelect() + " on " + MarcaDaoBase.tabelaSelect() + ".id_marca = " + tabelaSelect() + ".id_marca_pa ";  
	}
	public boolean atualizaPertenceAMarca(long idProduto, long idMarcaPa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_marca_pa  = " + idMarcaPa +
        " where id_produto = " +  idProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinMarca_PertenceA() {
		return " inner join " + MarcaDaoBase.tabelaSelect() + " on " + MarcaDaoBase.tabelaSelect() + ".id_marca = " + tabelaSelect() + ".id_marca_pa ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemMarca_PertenceA?" , " +MarcaDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemMarca_PertenceA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemMarca_PertenceA? outterJoinMarca_PertenceA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ProdutoMontador(), null);
		if (this._obtemMarca_PertenceA)
            montador.adicionaMontador(new MarcaMontador(), "Marca_PertenceA");
         return montador;
    }
	
	
}
