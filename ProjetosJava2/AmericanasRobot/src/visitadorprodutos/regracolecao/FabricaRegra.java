package visitadorprodutos.regracolecao;


import visitadorprodutos.regracolecao.base.*;


public  class FabricaRegra   { 
	private static FabricaRegra _instancia =  null;
	public static FabricaRegra getInstancia() {
		if (_instancia==null) _instancia = new FabricaRegra();
		return _instancia;
	}
	private CategoriaProdutoRegraColecao _CategoriaProdutoRegraColecao;
	public CategoriaProdutoRegraColecao getCategoriaProdutoRegraColecao() {
		if (_CategoriaProdutoRegraColecao==null) _CategoriaProdutoRegraColecao = new CategoriaProdutoRegraColecaoImpl();
		return _CategoriaProdutoRegraColecao;
	}
	private CategoriaSiteRegraColecao _CategoriaSiteRegraColecao;
	public CategoriaSiteRegraColecao getCategoriaSiteRegraColecao() {
		if (_CategoriaSiteRegraColecao==null) _CategoriaSiteRegraColecao = new CategoriaSiteRegraColecaoImpl();
		return _CategoriaSiteRegraColecao;
	}
	private ExecucaoVisitaRegraColecao _ExecucaoVisitaRegraColecao;
	public ExecucaoVisitaRegraColecao getExecucaoVisitaRegraColecao() {
		if (_ExecucaoVisitaRegraColecao==null) _ExecucaoVisitaRegraColecao = new ExecucaoVisitaRegraColecaoImpl();
		return _ExecucaoVisitaRegraColecao;
	}
	private LojaSiteRegraColecao _LojaSiteRegraColecao;
	public LojaSiteRegraColecao getLojaSiteRegraColecao() {
		if (_LojaSiteRegraColecao==null) _LojaSiteRegraColecao = new LojaSiteRegraColecaoImpl();
		return _LojaSiteRegraColecao;
	}
	private ObservacaoVisitaRegraColecao _ObservacaoVisitaRegraColecao;
	public ObservacaoVisitaRegraColecao getObservacaoVisitaRegraColecao() {
		if (_ObservacaoVisitaRegraColecao==null) _ObservacaoVisitaRegraColecao = new ObservacaoVisitaRegraColecaoImpl();
		return _ObservacaoVisitaRegraColecao;
	}
	private PlanejamentoVisitaRegraColecao _PlanejamentoVisitaRegraColecao;
	public PlanejamentoVisitaRegraColecao getPlanejamentoVisitaRegraColecao() {
		if (_PlanejamentoVisitaRegraColecao==null) _PlanejamentoVisitaRegraColecao = new PlanejamentoVisitaRegraColecaoImpl();
		return _PlanejamentoVisitaRegraColecao;
	}
	private ProdutoRegraColecao _ProdutoRegraColecao;
	public ProdutoRegraColecao getProdutoRegraColecao() {
		if (_ProdutoRegraColecao==null) _ProdutoRegraColecao = new ProdutoRegraColecaoImpl();
		return _ProdutoRegraColecao;
	}
	private ProdutoSiteRegraColecao _ProdutoSiteRegraColecao;
	public ProdutoSiteRegraColecao getProdutoSiteRegraColecao() {
		if (_ProdutoSiteRegraColecao==null) _ProdutoSiteRegraColecao = new ProdutoSiteRegraColecaoImpl();
		return _ProdutoSiteRegraColecao;
	}
	private UsuarioRegraColecao _UsuarioRegraColecao;
	public UsuarioRegraColecao getUsuarioRegraColecao() {
		if (_UsuarioRegraColecao==null) _UsuarioRegraColecao = new UsuarioRegraColecaoImpl();
		return _UsuarioRegraColecao;
	}
	private VisitaCategoriaRegraColecao _VisitaCategoriaRegraColecao;
	public VisitaCategoriaRegraColecao getVisitaCategoriaRegraColecao() {
		if (_VisitaCategoriaRegraColecao==null) _VisitaCategoriaRegraColecao = new VisitaCategoriaRegraColecaoImpl();
		return _VisitaCategoriaRegraColecao;
	}
}
