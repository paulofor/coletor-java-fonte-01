package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.PrecoProduto;
import dafitiafil.regracolecao.filtro.PrecoProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PrecoProdutoDaoBase extends DaoAplicacao implements PrecoProdutoDaoBaseI {
	
	
	public PrecoProdutoDaoBase() {
		super();
	}
	public PrecoProdutoDaoBase(DataFonte dataSource) {
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
		return new PrecoProdutoMontador();
	}
	public static String tabelaSelect() {
		return " preco_produto" ;
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
		return " order by " + tabelaSelect() + ".valor_preco_avista " ;
	}
	
	
	public static String camposOrdenados() {
		return " preco_produto.id_preco_produto " 
		+ " ,preco_produto.valor_preco_avista " 
		+ " , DATE_FORMAT(preco_produto.data_visita_inicial,'%d-%m-%Y %H:%i:%s') " 
		+ " ,preco_produto.quantidade_parcela " 
		+ " ,preco_produto.valor_parcela " 
		+ " ,preco_produto.preco_promocional " 
		+ " ,preco_produto.valor_consumidor " 
		+ " , DATE_FORMAT(preco_produto.data_ultima_visita,'%d-%m-%Y %H:%i:%s') " 
		+ " ,preco_produto.percentual_ajuste " 
		+ " ,preco_produto.id_produto_pa " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_preco_produto " 
		+ " , " + nomeTabela + ".valor_preco_avista " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_visita_inicial,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".quantidade_parcela " 
		+ " , " + nomeTabela + ".valor_parcela " 
		+ " , " + nomeTabela + ".preco_promocional " 
		+ " , " + nomeTabela + ".valor_consumidor " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_visita,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".percentual_ajuste " 
		+ " , " + nomeTabela + ".id_produto_pa " 
		;
	}
	
	
	@Override
	public void insereItem(PrecoProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(PrecoProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(PrecoProduto item) throws DaoException {
		PrecoProduto teste = this.obtemPorChave(item.getIdPrecoProduto());
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
	public void insereItemLoad(PrecoProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_preco_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPrecoProduto(id);	
	}
	@Override
	public void alteraItem(PrecoProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_preco_produto = " + item.getIdPrecoProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(PrecoProduto item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_preco_produto = " + item.getIdPrecoProduto();
		executaSql(query);
	}
	@Override
	public PrecoProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_preco_produto = " + id;
        return (PrecoProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PrecoProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PrecoProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProdutoPertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_pa = " + filtro.getCodigoProdutoPertenceA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(PrecoProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(PrecoProduto item) {
		return " ( '" + item.getIdPrecoProduto() + "'  " 
		+ " ,'" +  DCConvert.ToDataBase(item.getValorPrecoAvista()) + "'  "
		+ " ," + (item.getDataVisitaInicial()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataVisitaInicial()) ) + "  "
		+ " ,'" + item.getQuantidadeParcela() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorParcela()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoPromocional()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorConsumidor()) + "'  "
		+ " ," + (item.getDataUltimaVisita()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVisita()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPercentualAjuste()) + "'  "
		+ " ," + item.getIdProdutoPa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_preco_produto " 
		+ " ,valor_preco_avista " 
		+ " ,data_visita_inicial " 
		+ " ,quantidade_parcela " 
		+ " ,valor_parcela " 
		+ " ,preco_promocional " 
		+ " ,valor_consumidor " 
		+ " ,data_ultima_visita " 
		+ " ,percentual_ajuste " 
		+ " ,id_produto_pa " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(PrecoProduto item) {
		return " id_preco_produto = '" + item.getIdPrecoProduto() + "'  " 
		+ " , valor_preco_avista = '" +  DCConvert.ToDataBase(item.getValorPrecoAvista()) + "'  "
		+ " , data_visita_inicial = " + (item.getDataVisitaInicial()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataVisitaInicial()) ) + "  "
		+ " , quantidade_parcela = '" + item.getQuantidadeParcela() + "'  "
		+ " , valor_parcela = '" +  DCConvert.ToDataBase(item.getValorParcela()) + "'  "
		+ " , preco_promocional = '" +  DCConvert.ToDataBase(item.getPrecoPromocional()) + "'  "
		+ " , valor_consumidor = '" +  DCConvert.ToDataBase(item.getValorConsumidor()) + "'  "
		+ " , data_ultima_visita = " + (item.getDataUltimaVisita()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVisita()) ) + "  "
		+ " , percentual_ajuste = '" +  DCConvert.ToDataBase(item.getPercentualAjuste()) + "'  "
		+ " , id_produto_pa = " + item.getIdProdutoPa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(PrecoProduto item) {
		return " id_preco_produto = '" + item.getIdPrecoProduto() + "'  " 
		+ " , valor_preco_avista = '" +  DCConvert.ToDataBase(item.getValorPrecoAvista()) + "'  " 
		+ " , data_visita_inicial = " + (item.getDataVisitaInicial()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataVisitaInicial()) ) + "  " 
		+ " , quantidade_parcela = '" + item.getQuantidadeParcela() + "'  " 
		+ " , valor_parcela = '" +  DCConvert.ToDataBase(item.getValorParcela()) + "'  " 
		+ " , preco_promocional = '" +  DCConvert.ToDataBase(item.getPrecoPromocional()) + "'  " 
		+ " , valor_consumidor = '" +  DCConvert.ToDataBase(item.getValorConsumidor()) + "'  " 
		+ " , data_ultima_visita = " + (item.getDataUltimaVisita()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVisita()) ) + "  " 
		+ " , percentual_ajuste = '" +  DCConvert.ToDataBase(item.getPercentualAjuste()) + "'  " 
		+ " , id_produto_pa = " + item.getIdProdutoPa() + "  " 
		;
	}
	
	
	
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_pa = " + id + orderByLista();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	public boolean excluiPorPertenceAProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProduto_PertenceA = false;
	public void setObtemProduto_PertenceA() {
		_obtemProduto_PertenceA = true;
	}
	protected String outterJoinProduto_PertenceA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_pa ";  
	}
	public boolean atualizaPertenceAProduto(long idPrecoProduto, long idProdutoPa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_pa  = " + idProdutoPa +
        " where id_preco_produto = " +  idPrecoProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProduto_PertenceA() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_pa ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProduto_PertenceA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProduto_PertenceA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProduto_PertenceA? outterJoinProduto_PertenceA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PrecoProdutoMontador(), null);
		if (this._obtemProduto_PertenceA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_PertenceA");
         return montador;
    }
	
	
}
