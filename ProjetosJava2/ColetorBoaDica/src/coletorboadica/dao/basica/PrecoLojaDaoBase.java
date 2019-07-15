package coletorboadica.dao.basica;

import java.util.List;

import coletorboadica.dao.montador.*;
import coletorboadica.modelo.PrecoLoja;
import coletorboadica.regracolecao.filtro.PrecoLojaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PrecoLojaDaoBase extends DaoAplicacao implements PrecoLojaDaoBaseI {
	
	
	public PrecoLojaDaoBase() {
		super();
	}
	public PrecoLojaDaoBase(DataFonte dataSource) {
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
		return new PrecoLojaMontador();
	}
	public static String tabelaSelect() {
		return " preco_loja" ;
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
		return " order by " + tabelaSelect() + ".valor " ;
	}
	
	
	public static String camposOrdenados() {
		return " preco_loja.id_preco_loja " 
		+ " , DATE_FORMAT(preco_loja.data,'%d-%m-%Y %H:%i:%s') " 
		+ " ,preco_loja.nome_loja " 
		+ " ,preco_loja.codigo_loja " 
		+ " ,preco_loja.valor " 
		+ " ,preco_loja.bairro_loja " 
		+ " ,preco_loja.municipio_loja " 
		+ " ,preco_loja.id_produto_comum_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_preco_loja " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".nome_loja " 
		+ " , " + nomeTabela + ".codigo_loja " 
		+ " , " + nomeTabela + ".valor " 
		+ " , " + nomeTabela + ".bairro_loja " 
		+ " , " + nomeTabela + ".municipio_loja " 
		+ " , " + nomeTabela + ".id_produto_comum_ra " 
		;
	}
	
	
	@Override
	public void insereItem(PrecoLoja item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(PrecoLoja item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(PrecoLoja item) throws DaoException {
		PrecoLoja teste = this.obtemPorChave(item.getIdPrecoLoja());
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
	public void insereItemLoad(PrecoLoja item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_preco_loja) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPrecoLoja(id);	
	}
	@Override
	public void alteraItem(PrecoLoja item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_preco_loja = " + item.getIdPrecoLoja();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(PrecoLoja item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_preco_loja = " + item.getIdPrecoLoja();
		executaSql(query);
	}
	@Override
	public PrecoLoja obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_preco_loja = " + id;
        return (PrecoLoja) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PrecoLojaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PrecoLojaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProdutoComumReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_comum_ra = " + filtro.getCodigoProdutoComumReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(PrecoLojaFiltro filtro)
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
	
	
	protected String valoresInsert(PrecoLoja item) {
		return " ( '" + item.getIdPrecoLoja() + "'  " 
		+ " ," + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  "
		+ " ,'" + item.getNomeLoja() + "'  "
		+ " ,'" + item.getCodigoLoja() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValor()) + "'  "
		+ " ,'" + item.getBairroLoja() + "'  "
		+ " ,'" + item.getMunicipioLoja() + "'  "
		+ " ," + item.getIdProdutoComumRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_preco_loja " 
		+ " ,data " 
		+ " ,nome_loja " 
		+ " ,codigo_loja " 
		+ " ,valor " 
		+ " ,bairro_loja " 
		+ " ,municipio_loja " 
		+ " ,id_produto_comum_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(PrecoLoja item) {
		return " id_preco_loja = '" + item.getIdPrecoLoja() + "'  " 
		+ " , data = " + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  "
		+ " , nome_loja = '" + item.getNomeLoja() + "'  "
		+ " , codigo_loja = '" + item.getCodigoLoja() + "'  "
		+ " , valor = '" +  DCConvert.ToDataBase(item.getValor()) + "'  "
		+ " , bairro_loja = '" + item.getBairroLoja() + "'  "
		+ " , municipio_loja = '" + item.getMunicipioLoja() + "'  "
		+ " , id_produto_comum_ra = " + item.getIdProdutoComumRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(PrecoLoja item) {
		return " id_preco_loja = '" + item.getIdPrecoLoja() + "'  " 
		+ " , data = " + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  " 
		+ " , nome_loja = '" + item.getNomeLoja() + "'  " 
		+ " , codigo_loja = '" + item.getCodigoLoja() + "'  " 
		+ " , valor = '" +  DCConvert.ToDataBase(item.getValor()) + "'  " 
		+ " , bairro_loja = '" + item.getBairroLoja() + "'  " 
		+ " , municipio_loja = '" + item.getMunicipioLoja() + "'  " 
		+ " , id_produto_comum_ra = " + item.getIdProdutoComumRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAProdutoComum(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_comum_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProdutoComumReferenteA(long id) throws DaoException {
		return getPorReferenteAProdutoComum(id);
	}
	public boolean excluiPorReferenteAProdutoComum(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_comum_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProdutoComum_ReferenteA() {
	//	return " inner join " + ProdutoComumDaoBase.tabelaSelect() + " on " + ProdutoComumDaoBase.tabelaSelect() + ".id_preco_loja_p = " + tabelaSelect() + ".id_preco_loja ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProdutoComum_ReferenteA = false;
	public void setObtemProdutoComum_ReferenteA() {
		_obtemProdutoComum_ReferenteA = true;
	}
	protected String outterJoinProdutoComum_ReferenteA() {
		return " left outer join " + ProdutoComumDaoBase.tabelaSelect() + " on " + ProdutoComumDaoBase.tabelaSelect() + ".id_produto_comum = " + tabelaSelect() + ".id_produto_comum_ra ";  
	}
	public boolean atualizaReferenteAProdutoComum(long idPrecoLoja, long idProdutoComumRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_comum_ra  = " + idProdutoComumRa +
        " where id_preco_loja = " +  idPrecoLoja;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProdutoComum_ReferenteA() {
		return " inner join " + ProdutoComumDaoBase.tabelaSelect() + " on " + ProdutoComumDaoBase.tabelaSelect() + ".id_produto_comum = " + tabelaSelect() + ".id_produto_comum_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProdutoComum_ReferenteA?" , " +ProdutoComumDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProdutoComum_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProdutoComum_ReferenteA? outterJoinProdutoComum_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PrecoLojaMontador(), null);
		if (this._obtemProdutoComum_ReferenteA)
            montador.adicionaMontador(new ProdutoComumMontador(), "ProdutoComum_ReferenteA");
         return montador;
    }
	
	
}
