package coletorboadica.dao;

import  coletorboadica.dao.*;

// versao templates

public  class DBB   {


	private static DBB _instancia =  null;
	public static DBB getInstancia() {
		if (_instancia==null) _instancia = new DBB();
		return _instancia;
	}
	public DBB() {
	
		_ProdutoComumDao = null;
	
		_CategoriaProdutoDao = null;
	
		_PrecoLojaDao = null;
	
		_CategoriaDao = null;
	
	}


	private  ProdutoComumDao _ProdutoComumDao;
	public  ProdutoComumDao getProdutoComumDao() {
		if (_ProdutoComumDao==null) _ProdutoComumDao = new ProdutoComumDaoExtendida();
		return _ProdutoComumDao;
	}

	private  CategoriaProdutoDao _CategoriaProdutoDao;
	public  CategoriaProdutoDao getCategoriaProdutoDao() {
		if (_CategoriaProdutoDao==null) _CategoriaProdutoDao = new CategoriaProdutoDaoExtendida();
		return _CategoriaProdutoDao;
	}

	private  PrecoLojaDao _PrecoLojaDao;
	public  PrecoLojaDao getPrecoLojaDao() {
		if (_PrecoLojaDao==null) _PrecoLojaDao = new PrecoLojaDaoExtendida();
		return _PrecoLojaDao;
	}

	private  CategoriaDao _CategoriaDao;
	public  CategoriaDao getCategoriaDao() {
		if (_CategoriaDao==null) _CategoriaDao = new CategoriaDaoExtendida();
		return _CategoriaDao;
	}

}