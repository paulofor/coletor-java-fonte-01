package dafitiafil.dao.basica;

import java.util.List;

import dafitiafil.dao.montador.*;
import dafitiafil.modelo.FacebookFanpage;
import dafitiafil.regracolecao.filtro.FacebookFanpageFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class FacebookFanpageDaoBase extends DaoAplicacao implements FacebookFanpageDaoBaseI {
	
	
	public FacebookFanpageDaoBase() {
		super();
	}
	public FacebookFanpageDaoBase(DataFonte dataSource) {
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
		return new FacebookFanpageMontador();
	}
	public static String tabelaSelect() {
		return " facebook_fanpage" ;
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
		return " facebook_fanpage.id_facebook_fanpage " 
		+ " ,facebook_fanpage.nome " 
		+ " ,facebook_fanpage.facebook_id " 
		+ " ,facebook_fanpage.id_facebook_perfil_ee " 
		+ " ,facebook_fanpage.id_categoria_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_facebook_fanpage " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".facebook_id " 
		+ " , " + nomeTabela + ".id_facebook_perfil_ee " 
		+ " , " + nomeTabela + ".id_categoria_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(FacebookFanpage item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(FacebookFanpage item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(FacebookFanpage item) throws DaoException {
		FacebookFanpage teste = this.obtemPorChave(item.getIdFacebookFanpage());
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
	public void insereItemLoad(FacebookFanpage item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_facebook_fanpage) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdFacebookFanpage(id);	
	}
	@Override
	public void alteraItem(FacebookFanpage item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_facebook_fanpage = " + item.getIdFacebookFanpage();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(FacebookFanpage item) throws DaoException {
		String query = null;
		query = " delete from filme  where id_facebook_fanpage = " + item.getIdFacebookFanpage();
		executaSql(query);
	}
	@Override
	public FacebookFanpage obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_facebook_fanpage = " + id;
        return (FacebookFanpage) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(FacebookFanpageFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( FacebookFanpageFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoFacebookPerfilEstaEm() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_facebook_perfil_ee = " + filtro.getCodigoFacebookPerfilEstaEm();
      	}
      	
		if (filtro.getCodigoCategoriaProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_categoria_produto_ra = " + filtro.getCodigoCategoriaProdutoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(FacebookFanpageFiltro filtro)
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
	
	
	protected String valoresInsert(FacebookFanpage item) {
		return " ( '" + item.getIdFacebookFanpage() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getFacebookId() + "'  "
		+ " ," + item.getIdFacebookPerfilEe() + "  "
		+ " ," + item.getIdCategoriaProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_facebook_fanpage " 
		+ " ,nome " 
		+ " ,facebook_id " 
		+ " ,id_facebook_perfil_ee " 
		+ " ,id_categoria_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(FacebookFanpage item) {
		return " id_facebook_fanpage = '" + item.getIdFacebookFanpage() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , facebook_id = '" + item.getFacebookId() + "'  "
		+ " , id_facebook_perfil_ee = " + item.getIdFacebookPerfilEe() + "  "
		+ " , id_categoria_produto_ra = " + item.getIdCategoriaProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(FacebookFanpage item) {
		return " id_facebook_fanpage = '" + item.getIdFacebookFanpage() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , facebook_id = '" + item.getFacebookId() + "'  " 
		+ " , id_facebook_perfil_ee = " + item.getIdFacebookPerfilEe() + "  " 
		+ " , id_categoria_produto_ra = " + item.getIdCategoriaProdutoRa() + "  " 
		;
	}
	
	
	
	/*
	public FacebookFanpage obtemPorFacebookFotoPostRecebe(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookFotoPost_Recebe() + 
			" where id_facebook_foto_post = " + id;
		return (FacebookFanpage) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookFotoPost_Recebe() {
		return " inner join " + FacebookFotoPostDaoBase.tabelaSelect() + " on " + FacebookFotoPostDaoBase.tabelaSelect() + ".id_facebook_fanpage_ep = " + tabelaSelect() + ".id_facebook_fanpage ";  
	}
	public static String outerJoinFacebookFotoPost_Recebe() {
		return " left outer join " + FacebookFotoPostDaoBase.tabelaSelect() + " on " + FacebookFotoPostDaoBase.tabelaSelect() + ".id_facebook_fanpage_ep = " + tabelaSelect() + ".id_facebook_fanpage ";  
	}
 	
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorEstaEmFacebookPerfil(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_facebook_perfil_ee = " + id + orderByLista();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	public boolean excluiPorEstaEmFacebookPerfil(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_facebook_perfil_ee = " + id;
       	this.executaSql(sql);
       	return true;
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
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemFacebookPerfil_EstaEm = false;
	public void setObtemFacebookPerfil_EstaEm() {
		_obtemFacebookPerfil_EstaEm = true;
	}
	protected String outterJoinFacebookPerfil_EstaEm() {
		return " left outer join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_facebook_perfil = " + tabelaSelect() + ".id_facebook_perfil_ee ";  
	}
	public boolean atualizaEstaEmFacebookPerfil(long idFacebookFanpage, long idFacebookPerfilEe) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_facebook_perfil_ee  = " + idFacebookPerfilEe +
        " where id_facebook_fanpage = " +  idFacebookFanpage;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinFacebookPerfil_EstaEm() {
		return " inner join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_facebook_perfil = " + tabelaSelect() + ".id_facebook_perfil_ee ";  
	}
	
 	
	private boolean _obtemCategoriaProduto_ReferenteA = false;
	public void setObtemCategoriaProduto_ReferenteA() {
		_obtemCategoriaProduto_ReferenteA = true;
	}
	protected String outterJoinCategoriaProduto_ReferenteA() {
		return " left outer join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_produto = " + tabelaSelect() + ".id_categoria_produto_ra ";  
	}
	public boolean atualizaReferenteACategoriaProduto(long idFacebookFanpage, long idCategoriaProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_categoria_produto_ra  = " + idCategoriaProdutoRa +
        " where id_facebook_fanpage = " +  idFacebookFanpage;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinCategoriaProduto_ReferenteA() {
		return " inner join " + CategoriaProdutoDaoBase.tabelaSelect() + " on " + CategoriaProdutoDaoBase.tabelaSelect() + ".id_categoria_produto = " + tabelaSelect() + ".id_categoria_produto_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemFacebookPerfil_EstaEm?" , " +FacebookPerfilDaoBase.camposOrdenados():"");
		saida += (this._obtemCategoriaProduto_ReferenteA?" , " +CategoriaProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemFacebookPerfil_EstaEm = false;
		_obtemCategoriaProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemFacebookPerfil_EstaEm? outterJoinFacebookPerfil_EstaEm() + " ":"");
		saida += (this._obtemCategoriaProduto_ReferenteA? outterJoinCategoriaProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new FacebookFanpageMontador(), null);
		if (this._obtemFacebookPerfil_EstaEm)
            montador.adicionaMontador(new FacebookPerfilMontador(), "FacebookPerfil_EstaEm");
		if (this._obtemCategoriaProduto_ReferenteA)
            montador.adicionaMontador(new CategoriaProdutoMontador(), "CategoriaProduto_ReferenteA");
         return montador;
    }
	
	
}
