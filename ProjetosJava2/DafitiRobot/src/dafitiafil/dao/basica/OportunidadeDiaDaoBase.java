package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.OportunidadeDia;
import dafitiafil.regracolecao.filtro.OportunidadeDiaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class OportunidadeDiaDaoBase extends DaoAplicacao implements OportunidadeDiaDaoBaseI {
	
	
	public OportunidadeDiaDaoBase() {
		super();
	}
	public OportunidadeDiaDaoBase(DataFonte dataSource) {
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
		return new OportunidadeDiaMontador();
	}
	public static String tabelaSelect() {
		return " oportunidade_dia" ;
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
		return " order by " + tabelaSelect() + ".nome_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " oportunidade_dia.id_oportunidade_dia " 
		+ " , DATE_FORMAT(oportunidade_dia.data_inicio_preco_atual,'%d-%m-%Y') " 
		+ " ,oportunidade_dia.nome_produto " 
		+ " ,oportunidade_dia.url_produto " 
		+ " ,oportunidade_dia.valor_parcela_atual " 
		+ " ,oportunidade_dia.valor_parcela_anterior " 
		+ " ,oportunidade_dia.quantidade_parcela_anterior " 
		+ " ,oportunidade_dia.quantidade_parcela_atual " 
		+ " ,oportunidade_dia.valor_consumidor_atual " 
		+ " ,oportunidade_dia.valor_consumidor_anterior " 
		+ " ,oportunidade_dia.percentual_ajuste_atual " 
		+ " ,oportunidade_dia.url_imagem " 
		+ " ,oportunidade_dia.imagem_local " 
		+ " ,oportunidade_dia.quantidade_exibicao " 
		+ " ,oportunidade_dia.codigo_facebook " 
		+ " , DATE_FORMAT(oportunidade_dia.data_ultima_preco_anterior,'%d-%m-%Y') " 
		+ " ,oportunidade_dia.url_afiliado " 
		+ " ,oportunidade_dia.nome_marca " 
		+ " ,oportunidade_dia.posicao_produto " 
		+ " ,oportunidade_dia.id_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_oportunidade_dia " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inicio_preco_atual,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".nome_produto " 
		+ " , " + nomeTabela + ".url_produto " 
		+ " , " + nomeTabela + ".valor_parcela_atual " 
		+ " , " + nomeTabela + ".valor_parcela_anterior " 
		+ " , " + nomeTabela + ".quantidade_parcela_anterior " 
		+ " , " + nomeTabela + ".quantidade_parcela_atual " 
		+ " , " + nomeTabela + ".valor_consumidor_atual " 
		+ " , " + nomeTabela + ".valor_consumidor_anterior " 
		+ " , " + nomeTabela + ".percentual_ajuste_atual " 
		+ " , " + nomeTabela + ".url_imagem " 
		+ " , " + nomeTabela + ".imagem_local " 
		+ " , " + nomeTabela + ".quantidade_exibicao " 
		+ " , " + nomeTabela + ".codigo_facebook " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_preco_anterior,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".url_afiliado " 
		+ " , " + nomeTabela + ".nome_marca " 
		+ " , " + nomeTabela + ".posicao_produto " 
		+ " , " + nomeTabela + ".id_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(OportunidadeDia item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(OportunidadeDia item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(OportunidadeDia item) throws DaoException {
		OportunidadeDia teste = this.obtemPorChave(item.getIdOportunidadeDia());
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
	public void insereItemLoad(OportunidadeDia item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_oportunidade_dia) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdOportunidadeDia(id);	
	}
	@Override
	public void alteraItem(OportunidadeDia item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_oportunidade_dia = " + item.getIdOportunidadeDia();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(OportunidadeDia item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_oportunidade_dia = " + item.getIdOportunidadeDia();
		executaSql(query);
	}
	@Override
	public OportunidadeDia obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_oportunidade_dia = " + id;
        return (OportunidadeDia) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(OportunidadeDiaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( OportunidadeDiaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_ra = " + filtro.getCodigoProdutoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(OportunidadeDiaFiltro filtro)
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
	
	
	protected String valoresInsert(OportunidadeDia item) {
		return " ( '" + item.getIdOportunidadeDia() + "'  " 
		+ " ," + (item.getDataInicioPrecoAtual()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPrecoAtual()) ) + "  "
		+ " ,'" + item.getNomeProduto() + "'  "
		+ " ,'" + item.getUrlProduto() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorParcelaAtual()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorParcelaAnterior()) + "'  "
		+ " ,'" + item.getQuantidadeParcelaAnterior() + "'  "
		+ " ,'" + item.getQuantidadeParcelaAtual() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorConsumidorAtual()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorConsumidorAnterior()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPercentualAjusteAtual()) + "'  "
		+ " ,'" + item.getUrlImagem() + "'  "
		+ " ,'" + item.getImagemLocal() + "'  "
		+ " ,'" + item.getQuantidadeExibicao() + "'  "
		+ " ,'" + item.getCodigoFacebook() + "'  "
		+ " ," + (item.getDataUltimaPrecoAnterior()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaPrecoAnterior()) ) + "  "
		+ " ,'" + item.getUrlAfiliado() + "'  "
		+ " ,'" + item.getNomeMarca() + "'  "
		+ " ,'" + item.getPosicaoProduto() + "'  "
		+ " ," + item.getIdProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_oportunidade_dia " 
		+ " ,data_inicio_preco_atual " 
		+ " ,nome_produto " 
		+ " ,url_produto " 
		+ " ,valor_parcela_atual " 
		+ " ,valor_parcela_anterior " 
		+ " ,quantidade_parcela_anterior " 
		+ " ,quantidade_parcela_atual " 
		+ " ,valor_consumidor_atual " 
		+ " ,valor_consumidor_anterior " 
		+ " ,percentual_ajuste_atual " 
		+ " ,url_imagem " 
		+ " ,imagem_local " 
		+ " ,quantidade_exibicao " 
		+ " ,codigo_facebook " 
		+ " ,data_ultima_preco_anterior " 
		+ " ,url_afiliado " 
		+ " ,nome_marca " 
		+ " ,posicao_produto " 
		+ " ,id_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(OportunidadeDia item) {
		return " id_oportunidade_dia = '" + item.getIdOportunidadeDia() + "'  " 
		+ " , data_inicio_preco_atual = " + (item.getDataInicioPrecoAtual()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPrecoAtual()) ) + "  "
		+ " , nome_produto = '" + item.getNomeProduto() + "'  "
		+ " , url_produto = '" + item.getUrlProduto() + "'  "
		+ " , valor_parcela_atual = '" +  DCConvert.ToDataBase(item.getValorParcelaAtual()) + "'  "
		+ " , valor_parcela_anterior = '" +  DCConvert.ToDataBase(item.getValorParcelaAnterior()) + "'  "
		+ " , quantidade_parcela_anterior = '" + item.getQuantidadeParcelaAnterior() + "'  "
		+ " , quantidade_parcela_atual = '" + item.getQuantidadeParcelaAtual() + "'  "
		+ " , valor_consumidor_atual = '" +  DCConvert.ToDataBase(item.getValorConsumidorAtual()) + "'  "
		+ " , valor_consumidor_anterior = '" +  DCConvert.ToDataBase(item.getValorConsumidorAnterior()) + "'  "
		+ " , percentual_ajuste_atual = '" +  DCConvert.ToDataBase(item.getPercentualAjusteAtual()) + "'  "
		+ " , url_imagem = '" + item.getUrlImagem() + "'  "
		+ " , imagem_local = '" + item.getImagemLocal() + "'  "
		+ " , quantidade_exibicao = '" + item.getQuantidadeExibicao() + "'  "
		+ " , codigo_facebook = '" + item.getCodigoFacebook() + "'  "
		+ " , data_ultima_preco_anterior = " + (item.getDataUltimaPrecoAnterior()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaPrecoAnterior()) ) + "  "
		+ " , url_afiliado = '" + item.getUrlAfiliado() + "'  "
		+ " , nome_marca = '" + item.getNomeMarca() + "'  "
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  "
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(OportunidadeDia item) {
		return " id_oportunidade_dia = '" + item.getIdOportunidadeDia() + "'  " 
		+ " , data_inicio_preco_atual = " + (item.getDataInicioPrecoAtual()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPrecoAtual()) ) + "  " 
		+ " , nome_produto = '" + item.getNomeProduto() + "'  " 
		+ " , url_produto = '" + item.getUrlProduto() + "'  " 
		+ " , valor_parcela_atual = '" +  DCConvert.ToDataBase(item.getValorParcelaAtual()) + "'  " 
		+ " , valor_parcela_anterior = '" +  DCConvert.ToDataBase(item.getValorParcelaAnterior()) + "'  " 
		+ " , quantidade_parcela_anterior = '" + item.getQuantidadeParcelaAnterior() + "'  " 
		+ " , quantidade_parcela_atual = '" + item.getQuantidadeParcelaAtual() + "'  " 
		+ " , valor_consumidor_atual = '" +  DCConvert.ToDataBase(item.getValorConsumidorAtual()) + "'  " 
		+ " , valor_consumidor_anterior = '" +  DCConvert.ToDataBase(item.getValorConsumidorAnterior()) + "'  " 
		+ " , percentual_ajuste_atual = '" +  DCConvert.ToDataBase(item.getPercentualAjusteAtual()) + "'  " 
		+ " , url_imagem = '" + item.getUrlImagem() + "'  " 
		+ " , imagem_local = '" + item.getImagemLocal() + "'  " 
		+ " , quantidade_exibicao = '" + item.getQuantidadeExibicao() + "'  " 
		+ " , codigo_facebook = '" + item.getCodigoFacebook() + "'  " 
		+ " , data_ultima_preco_anterior = " + (item.getDataUltimaPrecoAnterior()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaPrecoAnterior()) ) + "  " 
		+ " , url_afiliado = '" + item.getUrlAfiliado() + "'  " 
		+ " , nome_marca = '" + item.getNomeMarca() + "'  " 
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  " 
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  " 
		;
	}
	
	
	
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_ra = " + id + orderByLista();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	public boolean excluiPorReferenteAProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProduto_ReferenteA = false;
	public void setObtemProduto_ReferenteA() {
		_obtemProduto_ReferenteA = true;
	}
	protected String outterJoinProduto_ReferenteA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	public boolean atualizaReferenteAProduto(long idOportunidadeDia, long idProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_ra  = " + idProdutoRa +
        " where id_oportunidade_dia = " +  idOportunidadeDia;
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
		saida += (this._obtemProduto_ReferenteA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProduto_ReferenteA? outterJoinProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new OportunidadeDiaMontador(), null);
		if (this._obtemProduto_ReferenteA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_ReferenteA");
         return montador;
    }
	
	
}
