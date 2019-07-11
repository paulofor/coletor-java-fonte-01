package visitadorprodutos.dao;


import visitadorprodutos.dao.extendida.*;


public  class DBB   { 
	private static DBB _instancia =  null;
	public static DBB getInstancia() {
		if (_instancia==null) _instancia = new DBB();
		return _instancia;
	}
	private CategoriaProdutoExtDaoI _CategoriaProdutoDao;
	public CategoriaProdutoExtDaoI getCategoriaProdutoDao() {
		if (_CategoriaProdutoDao==null) _CategoriaProdutoDao = new CategoriaProdutoExtDao();
		return _CategoriaProdutoDao;
	}
	private CategoriaSiteExtDaoI _CategoriaSiteDao;
	public CategoriaSiteExtDaoI getCategoriaSiteDao() {
		if (_CategoriaSiteDao==null) _CategoriaSiteDao = new CategoriaSiteExtDao();
		return _CategoriaSiteDao;
	}
	private ExecucaoVisitaExtDaoI _ExecucaoVisitaDao;
	public ExecucaoVisitaExtDaoI getExecucaoVisitaDao() {
		if (_ExecucaoVisitaDao==null) _ExecucaoVisitaDao = new ExecucaoVisitaExtDao();
		return _ExecucaoVisitaDao;
	}
	private LojaSiteExtDaoI _LojaSiteDao;
	public LojaSiteExtDaoI getLojaSiteDao() {
		if (_LojaSiteDao==null) _LojaSiteDao = new LojaSiteExtDao();
		return _LojaSiteDao;
	}
	private ObservacaoVisitaExtDaoI _ObservacaoVisitaDao;
	public ObservacaoVisitaExtDaoI getObservacaoVisitaDao() {
		if (_ObservacaoVisitaDao==null) _ObservacaoVisitaDao = new ObservacaoVisitaExtDao();
		return _ObservacaoVisitaDao;
	}
	private PlanejamentoVisitaExtDaoI _PlanejamentoVisitaDao;
	public PlanejamentoVisitaExtDaoI getPlanejamentoVisitaDao() {
		if (_PlanejamentoVisitaDao==null) _PlanejamentoVisitaDao = new PlanejamentoVisitaExtDao();
		return _PlanejamentoVisitaDao;
	}
	private ProdutoExtDaoI _ProdutoDao;
	public ProdutoExtDaoI getProdutoDao() {
		if (_ProdutoDao==null) _ProdutoDao = new ProdutoExtDao();
		return _ProdutoDao;
	}
	private ProdutoSiteExtDaoI _ProdutoSiteDao;
	public ProdutoSiteExtDaoI getProdutoSiteDao() {
		if (_ProdutoSiteDao==null) _ProdutoSiteDao = new ProdutoSiteExtDao();
		return _ProdutoSiteDao;
	}
	private UsuarioExtDaoI _UsuarioDao;
	public UsuarioExtDaoI getUsuarioDao() {
		if (_UsuarioDao==null) _UsuarioDao = new UsuarioExtDao();
		return _UsuarioDao;
	}
	private VisitaCategoriaExtDaoI _VisitaCategoriaDao;
	public VisitaCategoriaExtDaoI getVisitaCategoriaDao() {
		if (_VisitaCategoriaDao==null) _VisitaCategoriaDao = new VisitaCategoriaExtDao();
		return _VisitaCategoriaDao;
	}
}
