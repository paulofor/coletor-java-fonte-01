package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.FacebookPerfil;
import dafitiafil.regracolecao.filtro.FacebookPerfilFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class FacebookPerfilDaoBase extends DaoAplicacao implements FacebookPerfilDaoBaseI {
	
	
	public FacebookPerfilDaoBase() {
		super();
	}
	public FacebookPerfilDaoBase(DataFonte dataSource) {
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
		return new FacebookPerfilMontador();
	}
	public static String tabelaSelect() {
		return " facebook_perfil" ;
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
		return " facebook_perfil.id_facebook_perfil " 
		+ " ,facebook_perfil.facebook_id " 
		+ " ,facebook_perfil.nome " 
		+ " ,facebook_perfil.sobrenome " 
		+ " ,facebook_perfil.email_utilizado " 
		+ " ,facebook_perfil.aplicacao_nome " 
		+ " ,facebook_perfil.aplicacao_id " 
		+ " ,facebook_perfil.aplicacao_chave " 
		+ " ,facebook_perfil.token_acesso " 
		+ " ,facebook_perfil.valor_maximo_produto " 
		+ " ,facebook_perfil.valor_minimo_produto " 
		+ " ,facebook_perfil.id_categoria_produto_ra " 
		+ " ,facebook_perfil.id_produto_i " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_facebook_perfil " 
		+ " , " + nomeTabela + ".facebook_id " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".sobrenome " 
		+ " , " + nomeTabela + ".email_utilizado " 
		+ " , " + nomeTabela + ".aplicacao_nome " 
		+ " , " + nomeTabela + ".aplicacao_id " 
		+ " , " + nomeTabela + ".aplicacao_chave " 
		+ " , " + nomeTabela + ".token_acesso " 
		+ " , " + nomeTabela + ".valor_maximo_produto " 
		+ " , " + nomeTabela + ".valor_minimo_produto " 
		+ " , " + nomeTabela + ".id_categoria_produto_ra " 
		+ " , " + nomeTabela + ".id_produto_i " 
		;
	}
	
	
	@Override
	public void insereItem(FacebookPerfil item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(FacebookPerfil item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(FacebookPerfil item) throws DaoException {
		FacebookPerfil teste = this.obtemPorChave(item.getIdFacebookPerfil());
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
	public void insereItemLoad(FacebookPerfil item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_facebook_perfil) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdFacebookPerfil(id);	
	}
	@Override
	public void alteraItem(FacebookPerfil item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_facebook_perfil = " + item.getIdFacebookPerfil();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(FacebookPerfil item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_facebook_perfil = " + item.getIdFacebookPerfil();
		executaSql(query);
	}
	@Override
	public FacebookPerfil obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_facebook_perfil = " + id;
        return (FacebookPerfil) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(FacebookPerfilFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( FacebookPerfilFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoCategoriaProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_categoria_produto_ra = " + filtro.getCodigoCategoriaProdutoReferenteA();
      	}
      	
		if (filtro.getCodigoProdutoIcone() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_i = " + filtro.getCodigoProdutoIcone();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(FacebookPerfilFiltro filtro)
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
	
	
	protected String valoresInsert(FacebookPerfil item) {
		return " ( '" + item.getIdFacebookPerfil() + "'  " 
		+ " ,'" + item.getFacebookId() + "'  "
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getSobrenome() + "'  "
		+ " ,'" + item.getEmailUtilizado() + "'  "
		+ " ,'" + item.getAplicacaoNome() + "'  "
		+ " ,'" + item.getAplicacaoId() + "'  "
		+ " ,'" + item.getAplicacaoChave() + "'  "
		+ " ,'" + item.getTokenAcesso() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorMaximoProduto()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorMinimoProduto()) + "'  "
		+ " ," + item.getIdCategoriaProdutoRa() + "  "
		+ " ," + item.getIdProdutoI() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_facebook_perfil " 
		+ " ,facebook_id " 
		+ " ,nome " 
		+ " ,sobrenome " 
		+ " ,email_utilizado " 
		+ " ,aplicacao_nome " 
		+ " ,aplicacao_id " 
		+ " ,aplicacao_chave " 
		+ " ,token_acesso " 
		+ " ,valor_maximo_produto " 
		+ " ,valor_minimo_produto " 
		+ " ,id_categoria_produto_ra " 
		+ " ,id_produto_i " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(FacebookPerfil item) {
		return " id_facebook_perfil = '" + item.getIdFacebookPerfil() + "'  " 
		+ " , facebook_id = '" + item.getFacebookId() + "'  "
		+ " , nome = '" + item.getNome() + "'  "
		+ " , sobrenome = '" + item.getSobrenome() + "'  "
		+ " , email_utilizado = '" + item.getEmailUtilizado() + "'  "
		+ " , aplicacao_nome = '" + item.getAplicacaoNome() + "'  "
		+ " , aplicacao_id = '" + item.getAplicacaoId() + "'  "
		+ " , aplicacao_chave = '" + item.getAplicacaoChave() + "'  "
		+ " , token_acesso = '" + item.getTokenAcesso() + "'  "
		+ " , valor_maximo_produto = '" +  DCConvert.ToDataBase(item.getValorMaximoProduto()) + "'  "
		+ " , valor_minimo_produto = '" +  DCConvert.ToDataBase(item.getValorMinimoProduto()) + "'  "
		+ " , id_categoria_produto_ra = " + item.getIdCategoriaProdutoRa() + "  "
		+ " , id_produto_i = " + item.getIdProdutoI() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(FacebookPerfil item) {
		return " id_facebook_perfil = '" + item.getIdFacebookPerfil() + "'  " 
		+ " , facebook_id = '" + item.getFacebookId() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , sobrenome = '" + item.getSobrenome() + "'  " 
		+ " , email_utilizado = '" + item.getEmailUtilizado() + "'  " 
		+ " , aplicacao_nome = '" + item.getAplicacaoNome() + "'  " 
		+ " , aplicacao_id = '" + item.getAplicacaoId() + "'  " 
		+ " , aplicacao_chave = '" + item.getAplicacaoChave() + "'  " 
		+ " , token_acesso = '" + item.getTokenAcesso() + "'  " 
		+ " , valor_maximo_produto = '" +  DCConvert.ToDataBase(item.getValorMaximoProduto()) + "'  " 
		+ " , valor_minimo_produto = '" +  DCConvert.ToDataBase(item.getValorMinimoProduto()) + "'  " 
		+ " , id_categoria_produto_ra = " + item.getIdCategoriaProdutoRa() + "  " 
		+ " , id_produto_i = " + item.getIdProdutoI() + "  " 
		;
	}
	
	
	
	/*
	public FacebookPerfil obtemPorFacebookFotoPostRecebe(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookFotoPost_Recebe() + 
			" where id_facebook_foto_post = " + id;
		return (FacebookPerfil) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookFotoPost_Recebe() {
		return " inner join " + FacebookFotoPostDaoBase.tabelaSelect() + " on " + FacebookFotoPostDaoBase.tabelaSelect() + ".id_facebook_perfil_ep = " + tabelaSelect() + ".id_facebook_perfil ";  
	}
	public static String outerJoinFacebookFotoPost_Recebe() {
		return " left outer join " + FacebookFotoPostDaoBase.tabelaSelect() + " on " + FacebookFotoPostDaoBase.tabelaSelect() + ".id_facebook_perfil_ep = " + tabelaSelect() + ".id_facebook_perfil ";  
	}
 	
	/*
	public FacebookPerfil obtemPorFacebookFanpagePossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookFanpage_Possui() + 
			" where id_facebook_fanpage = " + id;
		return (FacebookPerfil) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookFanpage_Possui() {
		return " inner join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_perfil_ee = " + tabelaSelect() + ".id_facebook_perfil ";  
	}
	public static String outerJoinFacebookFanpage_Possui() {
		return " left outer join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_perfil_ee = " + tabelaSelect() + ".id_facebook_perfil ";  
	}
 	
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteACategoriaProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_categoria_produto_ra = " + id + orderByLista();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	public boolean excluiPorReferenteACategoriaProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_categoria_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorIconeProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_i = " + id + orderByLista();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	public boolean excluiPorIconeProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_i = " + id;
       	this.executaSql(sql);
       	return true;
	}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemCategoriaProduto_ReferenteA = false;
	public void setObtemCategoriaProduto_ReferenteA() {
		_obtemCategoriaProduto_ReferenteA = true;
	}
	protected String outterJoinCategoriaProduto_ReferenteA() {
		return " left outer join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_produto = " + tabelaSelect() + ".id_categoria_produto_ra ";  
	}
	public boolean atualizaReferenteACategoriaProduto(long idFacebookPerfil, long idCategoriaProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_categoria_produto_ra  = " + idCategoriaProdutoRa +
        " where id_facebook_perfil = " +  idFacebookPerfil;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinCategoriaProduto_ReferenteA() {
		return " inner join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_produto = " + tabelaSelect() + ".id_categoria_produto_ra ";  
	}
	
 	
	private boolean _obtemProduto_Icone = false;
	public void setObtemProduto_Icone() {
		_obtemProduto_Icone = true;
	}
	protected String outterJoinProduto_Icone() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_i ";  
	}
	public boolean atualizaIconeProduto(long idFacebookPerfil, long idProdutoI) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_i  = " + idProdutoI +
        " where id_facebook_perfil = " +  idFacebookPerfil;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProduto_Icone() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_i ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemCategoriaProduto_ReferenteA?" , " +CategoriaProdutoDaoBase.camposOrdenados():"");
		saida += (this._obtemProduto_Icone?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemCategoriaProduto_ReferenteA = false;
		_obtemProduto_Icone = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemCategoriaProduto_ReferenteA? outterJoinCategoriaProduto_ReferenteA() + " ":"");
		saida += (this._obtemProduto_Icone? outterJoinProduto_Icone() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new FacebookPerfilMontador(), null);
		if (this._obtemCategoriaProduto_ReferenteA)
            montador.adicionaMontador(new CategoriaProdutoMontador(), "CategoriaProduto_ReferenteA");
		if (this._obtemProduto_Icone)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_Icone");
         return montador;
    }
	
	
}
