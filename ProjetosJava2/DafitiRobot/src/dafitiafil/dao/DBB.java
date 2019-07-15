package dafitiafil.dao;


import dafitiafil.dao.*;


public  class DBB   { 
      public DBB()
      {
		_categoriaProdutoDao = null;
		_categoriaProdutoProdutoDao = null;
		_facebookFanpageDao = null;
		_facebookFotoPostDao = null;
		_facebookPerfilDao = null;
		_facebookProspectDao = null;
		_marcaDao = null;
		_oportunidadeDiaDao = null;
		_precoProdutoDao = null;
		_precoProdutoDiarioDao = null;
		_produtoDao = null;
		_usuarioDao = null;
	}
	private static DBB _instancia =  null;
	public static DBB getInstancia() {
		if (_instancia==null) _instancia = new DBB();
		return _instancia;
	}
	private  CategoriaProdutoDao _categoriaProdutoDao;
	public  CategoriaProdutoDao getCategoriaProdutoDao() {
		if (_categoriaProdutoDao==null) _categoriaProdutoDao = new CategoriaProdutoDaoExtendida();
		return _categoriaProdutoDao;
	}
	private  CategoriaProdutoProdutoDao _categoriaProdutoProdutoDao;
	public  CategoriaProdutoProdutoDao getCategoriaProdutoProdutoDao() {
		if (_categoriaProdutoProdutoDao==null) _categoriaProdutoProdutoDao = new CategoriaProdutoProdutoDaoExtendida();
		return _categoriaProdutoProdutoDao;
	}
	private  FacebookFanpageDao _facebookFanpageDao;
	public  FacebookFanpageDao getFacebookFanpageDao() {
		if (_facebookFanpageDao==null) _facebookFanpageDao = new FacebookFanpageDaoExtendida();
		return _facebookFanpageDao;
	}
	private  FacebookFotoPostDao _facebookFotoPostDao;
	public  FacebookFotoPostDao getFacebookFotoPostDao() {
		if (_facebookFotoPostDao==null) _facebookFotoPostDao = new FacebookFotoPostDaoExtendida();
		return _facebookFotoPostDao;
	}
	private  FacebookPerfilDao _facebookPerfilDao;
	public  FacebookPerfilDao getFacebookPerfilDao() {
		if (_facebookPerfilDao==null) _facebookPerfilDao = new FacebookPerfilDaoExtendida();
		return _facebookPerfilDao;
	}
	private  FacebookProspectDao _facebookProspectDao;
	public  FacebookProspectDao getFacebookProspectDao() {
		if (_facebookProspectDao==null) _facebookProspectDao = new FacebookProspectDaoExtendida();
		return _facebookProspectDao;
	}
	private  MarcaDao _marcaDao;
	public  MarcaDao getMarcaDao() {
		if (_marcaDao==null) _marcaDao = new MarcaDaoExtendida();
		return _marcaDao;
	}
	private  OportunidadeDiaDao _oportunidadeDiaDao;
	public  OportunidadeDiaDao getOportunidadeDiaDao() {
		if (_oportunidadeDiaDao==null) _oportunidadeDiaDao = new OportunidadeDiaDaoExtendida();
		return _oportunidadeDiaDao;
	}
	private  PrecoProdutoDao _precoProdutoDao;
	public  PrecoProdutoDao getPrecoProdutoDao() {
		if (_precoProdutoDao==null) _precoProdutoDao = new PrecoProdutoDaoExtendida();
		return _precoProdutoDao;
	}
	private  PrecoProdutoDiarioDao _precoProdutoDiarioDao;
	public  PrecoProdutoDiarioDao getPrecoProdutoDiarioDao() {
		if (_precoProdutoDiarioDao==null) _precoProdutoDiarioDao = new PrecoProdutoDiarioDaoExtendida();
		return _precoProdutoDiarioDao;
	}
	private  ProdutoDao _produtoDao;
	public  ProdutoDao getProdutoDao() {
		if (_produtoDao==null) _produtoDao = new ProdutoDaoExtendida();
		return _produtoDao;
	}
	private  UsuarioDao _usuarioDao;
	public  UsuarioDao getUsuarioDao() {
		if (_usuarioDao==null) _usuarioDao = new UsuarioDaoExtendida();
		return _usuarioDao;
	}
}
