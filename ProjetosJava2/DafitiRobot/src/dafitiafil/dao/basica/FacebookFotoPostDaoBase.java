package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.FacebookFotoPost;
import dafitiafil.regracolecao.filtro.FacebookFotoPostFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class FacebookFotoPostDaoBase extends DaoAplicacao implements FacebookFotoPostDaoBaseI {
	
	
	public FacebookFotoPostDaoBase() {
		super();
	}
	public FacebookFotoPostDaoBase(DataFonte dataSource) {
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
		return new FacebookFotoPostMontador();
	}
	public static String tabelaSelect() {
		return " facebook_foto_post" ;
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
		return " order by " + tabelaSelect() + ".facebook_id " ;
	}
	
	
	public static String camposOrdenados() {
		return " facebook_foto_post.id_facebook_foto_post " 
		+ " , DATE_FORMAT(facebook_foto_post.data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " ,facebook_foto_post.facebook_id " 
		+ " ,facebook_foto_post.qtde_click " 
		+ " ,facebook_foto_post.mensagem " 
		+ " ,facebook_foto_post.preco_consumidor " 
		+ " ,facebook_foto_post.id_facebook_fanpage_ep " 
		+ " ,facebook_foto_post.id_facebook_perfil_ep " 
		+ " ,facebook_foto_post.id_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_facebook_foto_post " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".facebook_id " 
		+ " , " + nomeTabela + ".qtde_click " 
		+ " , " + nomeTabela + ".mensagem " 
		+ " , " + nomeTabela + ".preco_consumidor " 
		+ " , " + nomeTabela + ".id_facebook_fanpage_ep " 
		+ " , " + nomeTabela + ".id_facebook_perfil_ep " 
		+ " , " + nomeTabela + ".id_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(FacebookFotoPost item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(FacebookFotoPost item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(FacebookFotoPost item) throws DaoException {
		FacebookFotoPost teste = this.obtemPorChave(item.getIdFacebookFotoPost());
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
	public void insereItemLoad(FacebookFotoPost item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_facebook_foto_post) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdFacebookFotoPost(id);	
	}
	@Override
	public void alteraItem(FacebookFotoPost item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_facebook_foto_post = " + item.getIdFacebookFotoPost();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(FacebookFotoPost item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_facebook_foto_post = " + item.getIdFacebookFotoPost();
		executaSql(query);
	}
	@Override
	public FacebookFotoPost obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_facebook_foto_post = " + id;
        return (FacebookFotoPost) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(FacebookFotoPostFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( FacebookFotoPostFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoFacebookFanpageEnviadoPara() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_facebook_fanpage_ep = " + filtro.getCodigoFacebookFanpageEnviadoPara();
      	}
      	
		if (filtro.getCodigoFacebookPerfilEnviadoPara() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_facebook_perfil_ep = " + filtro.getCodigoFacebookPerfilEnviadoPara();
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
	public List ListaFiltroSimples(FacebookFotoPostFiltro filtro)
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
	
	
	protected String valoresInsert(FacebookFotoPost item) {
		return " ( '" + item.getIdFacebookFotoPost() + "'  " 
		+ " ," + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " ,'" + item.getFacebookId() + "'  "
		+ " ,'" + item.getQtdeClick() + "'  "
		+ " ,'" + item.getMensagem() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoConsumidor()) + "'  "
		+ " ," + item.getIdFacebookFanpageEp() + "  "
		+ " ," + item.getIdFacebookPerfilEp() + "  "
		+ " ," + item.getIdProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_facebook_foto_post " 
		+ " ,data_hora " 
		+ " ,facebook_id " 
		+ " ,qtde_click " 
		+ " ,mensagem " 
		+ " ,preco_consumidor " 
		+ " ,id_facebook_fanpage_ep " 
		+ " ,id_facebook_perfil_ep " 
		+ " ,id_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(FacebookFotoPost item) {
		return " id_facebook_foto_post = '" + item.getIdFacebookFotoPost() + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " , facebook_id = '" + item.getFacebookId() + "'  "
		+ " , qtde_click = '" + item.getQtdeClick() + "'  "
		+ " , mensagem = '" + item.getMensagem() + "'  "
		+ " , preco_consumidor = '" +  DCConvert.ToDataBase(item.getPrecoConsumidor()) + "'  "
		+ " , id_facebook_fanpage_ep = " + item.getIdFacebookFanpageEp() + "  "
		+ " , id_facebook_perfil_ep = " + item.getIdFacebookPerfilEp() + "  "
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(FacebookFotoPost item) {
		return " id_facebook_foto_post = '" + item.getIdFacebookFotoPost() + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  " 
		+ " , facebook_id = '" + item.getFacebookId() + "'  " 
		+ " , qtde_click = '" + item.getQtdeClick() + "'  " 
		+ " , mensagem = '" + item.getMensagem() + "'  " 
		+ " , preco_consumidor = '" +  DCConvert.ToDataBase(item.getPrecoConsumidor()) + "'  " 
		+ " , id_facebook_fanpage_ep = " + item.getIdFacebookFanpageEp() + "  " 
		+ " , id_facebook_perfil_ep = " + item.getIdFacebookPerfilEp() + "  " 
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  " 
		;
	}
	
	
	
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorEnviadoParaFacebookFanpage(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_facebook_fanpage_ep = " + id + orderByLista();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	public boolean excluiPorEnviadoParaFacebookFanpage(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_facebook_fanpage_ep = " + id;
       	this.executaSql(sql);
       	return true;
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorEnviadoParaFacebookPerfil(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_facebook_perfil_ep = " + id + orderByLista();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	public boolean excluiPorEnviadoParaFacebookPerfil(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_facebook_perfil_ep = " + id;
       	this.executaSql(sql);
       	return true;
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
	
	private boolean _obtemFacebookFanpage_EnviadoPara = false;
	public void setObtemFacebookFanpage_EnviadoPara() {
		_obtemFacebookFanpage_EnviadoPara = true;
	}
	protected String outterJoinFacebookFanpage_EnviadoPara() {
		return " left outer join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_fanpage = " + tabelaSelect() + ".id_facebook_fanpage_ep ";  
	}
	public boolean atualizaEnviadoParaFacebookFanpage(long idFacebookFotoPost, long idFacebookFanpageEp) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_facebook_fanpage_ep  = " + idFacebookFanpageEp +
        " where id_facebook_foto_post = " +  idFacebookFotoPost;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinFacebookFanpage_EnviadoPara() {
		return " inner join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_fanpage = " + tabelaSelect() + ".id_facebook_fanpage_ep ";  
	}
	
 	
	private boolean _obtemFacebookPerfil_EnviadoPara = false;
	public void setObtemFacebookPerfil_EnviadoPara() {
		_obtemFacebookPerfil_EnviadoPara = true;
	}
	protected String outterJoinFacebookPerfil_EnviadoPara() {
		return " left outer join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_facebook_perfil = " + tabelaSelect() + ".id_facebook_perfil_ep ";  
	}
	public boolean atualizaEnviadoParaFacebookPerfil(long idFacebookFotoPost, long idFacebookPerfilEp) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_facebook_perfil_ep  = " + idFacebookPerfilEp +
        " where id_facebook_foto_post = " +  idFacebookFotoPost;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinFacebookPerfil_EnviadoPara() {
		return " inner join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_facebook_perfil = " + tabelaSelect() + ".id_facebook_perfil_ep ";  
	}
	
 	
	private boolean _obtemProduto_ReferenteA = false;
	public void setObtemProduto_ReferenteA() {
		_obtemProduto_ReferenteA = true;
	}
	protected String outterJoinProduto_ReferenteA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	public boolean atualizaReferenteAProduto(long idFacebookFotoPost, long idProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_ra  = " + idProdutoRa +
        " where id_facebook_foto_post = " +  idFacebookFotoPost;
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
		saida += (this._obtemFacebookFanpage_EnviadoPara?" , " +FacebookFanpageDaoBase.camposOrdenados():"");
		saida += (this._obtemFacebookPerfil_EnviadoPara?" , " +FacebookPerfilDaoBase.camposOrdenados():"");
		saida += (this._obtemProduto_ReferenteA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemFacebookFanpage_EnviadoPara = false;
		_obtemFacebookPerfil_EnviadoPara = false;
		_obtemProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemFacebookFanpage_EnviadoPara? outterJoinFacebookFanpage_EnviadoPara() + " ":"");
		saida += (this._obtemFacebookPerfil_EnviadoPara? outterJoinFacebookPerfil_EnviadoPara() + " ":"");
		saida += (this._obtemProduto_ReferenteA? outterJoinProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new FacebookFotoPostMontador(), null);
		if (this._obtemFacebookFanpage_EnviadoPara)
            montador.adicionaMontador(new FacebookFanpageMontador(), "FacebookFanpage_EnviadoPara");
		if (this._obtemFacebookPerfil_EnviadoPara)
            montador.adicionaMontador(new FacebookPerfilMontador(), "FacebookPerfil_EnviadoPara");
		if (this._obtemProduto_ReferenteA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_ReferenteA");
         return montador;
    }
	
	
}
