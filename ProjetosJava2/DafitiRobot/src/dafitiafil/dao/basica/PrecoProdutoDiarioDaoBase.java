package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.PrecoProdutoDiario;
import dafitiafil.regracolecao.filtro.PrecoProdutoDiarioFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PrecoProdutoDiarioDaoBase extends DaoAplicacao implements PrecoProdutoDiarioDaoBaseI {
	
	
	public PrecoProdutoDiarioDaoBase() {
		super();
	}
	public PrecoProdutoDiarioDaoBase(DataFonte dataSource) {
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
		return new PrecoProdutoDiarioMontador();
	}
	public static String tabelaSelect() {
		return " preco_produto_diario" ;
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
		return " order by " + tabelaSelect() + ".valor_consumidor " ;
	}
	
	
	public static String camposOrdenados() {
		return " preco_produto_diario.id_preco_produto_diario " 
		+ " ,preco_produto_diario.valor_preco_avista " 
		+ " ,preco_produto_diario.quantidade_parcela " 
		+ " , DATE_FORMAT(preco_produto_diario.data_visita,'%d-%m-%Y') " 
		+ " ,preco_produto_diario.valor_parcela " 
		+ " ,preco_produto_diario.preco_promocional " 
		+ " ,preco_produto_diario.valor_consumidor " 
		+ " ,preco_produto_diario.id_produto_pa " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_preco_produto_diario " 
		+ " , " + nomeTabela + ".valor_preco_avista " 
		+ " , " + nomeTabela + ".quantidade_parcela " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_visita,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".valor_parcela " 
		+ " , " + nomeTabela + ".preco_promocional " 
		+ " , " + nomeTabela + ".valor_consumidor " 
		+ " , " + nomeTabela + ".id_produto_pa " 
		;
	}
	
	
	@Override
	public void insereItem(PrecoProdutoDiario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(PrecoProdutoDiario item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(PrecoProdutoDiario item) throws DaoException {
		PrecoProdutoDiario teste = this.obtemPorChave(item.getIdPrecoProdutoDiario());
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
	public void insereItemLoad(PrecoProdutoDiario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_preco_produto_diario) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPrecoProdutoDiario(id);	
	}
	@Override
	public void alteraItem(PrecoProdutoDiario item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_preco_produto_diario = " + item.getIdPrecoProdutoDiario();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(PrecoProdutoDiario item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_preco_produto_diario = " + item.getIdPrecoProdutoDiario();
		executaSql(query);
	}
	@Override
	public PrecoProdutoDiario obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_preco_produto_diario = " + id;
        return (PrecoProdutoDiario) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PrecoProdutoDiarioFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PrecoProdutoDiarioFiltro filtro ) {
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
	public List ListaFiltroSimples(PrecoProdutoDiarioFiltro filtro)
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
	
	
	protected String valoresInsert(PrecoProdutoDiario item) {
		return " ( '" + item.getIdPrecoProdutoDiario() + "'  " 
		+ " ,'" +  DCConvert.ToDataBase(item.getValorPrecoAvista()) + "'  "
		+ " ,'" + item.getQuantidadeParcela() + "'  "
		+ " ," + (item.getDataVisita()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataVisita()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorParcela()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoPromocional()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorConsumidor()) + "'  "
		+ " ," + item.getIdProdutoPa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_preco_produto_diario " 
		+ " ,valor_preco_avista " 
		+ " ,quantidade_parcela " 
		+ " ,data_visita " 
		+ " ,valor_parcela " 
		+ " ,preco_promocional " 
		+ " ,valor_consumidor " 
		+ " ,id_produto_pa " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(PrecoProdutoDiario item) {
		return " id_preco_produto_diario = '" + item.getIdPrecoProdutoDiario() + "'  " 
		+ " , valor_preco_avista = '" +  DCConvert.ToDataBase(item.getValorPrecoAvista()) + "'  "
		+ " , quantidade_parcela = '" + item.getQuantidadeParcela() + "'  "
		+ " , data_visita = " + (item.getDataVisita()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataVisita()) ) + "  "
		+ " , valor_parcela = '" +  DCConvert.ToDataBase(item.getValorParcela()) + "'  "
		+ " , preco_promocional = '" +  DCConvert.ToDataBase(item.getPrecoPromocional()) + "'  "
		+ " , valor_consumidor = '" +  DCConvert.ToDataBase(item.getValorConsumidor()) + "'  "
		+ " , id_produto_pa = " + item.getIdProdutoPa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(PrecoProdutoDiario item) {
		return " id_preco_produto_diario = '" + item.getIdPrecoProdutoDiario() + "'  " 
		+ " , valor_preco_avista = '" +  DCConvert.ToDataBase(item.getValorPrecoAvista()) + "'  " 
		+ " , quantidade_parcela = '" + item.getQuantidadeParcela() + "'  " 
		+ " , data_visita = " + (item.getDataVisita()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataVisita()) ) + "  " 
		+ " , valor_parcela = '" +  DCConvert.ToDataBase(item.getValorParcela()) + "'  " 
		+ " , preco_promocional = '" +  DCConvert.ToDataBase(item.getPrecoPromocional()) + "'  " 
		+ " , valor_consumidor = '" +  DCConvert.ToDataBase(item.getValorConsumidor()) + "'  " 
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
	public boolean atualizaPertenceAProduto(long idPrecoProdutoDiario, long idProdutoPa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_pa  = " + idProdutoPa +
        " where id_preco_produto_diario = " +  idPrecoProdutoDiario;
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
        montador.adicionaMontador(new PrecoProdutoDiarioMontador(), null);
		if (this._obtemProduto_PertenceA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_PertenceA");
         return montador;
    }
	
	
}
