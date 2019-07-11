package dafitiafil.regracolecao;


import dafitiafil.regracolecao.impl.*;


public  class FabricaRegra   { 
	private static FabricaRegra _instancia =  null;
	public static FabricaRegra getInstancia() {
		if (_instancia==null) _instancia = new FabricaRegra();
		return _instancia;
	}
	private  CategoriaProdutoRegraColecao _categoriaProdutoRegraColecao;
	public  CategoriaProdutoRegraColecao getCategoriaProdutoRegraColecao() {
		if (_categoriaProdutoRegraColecao==null) _categoriaProdutoRegraColecao = new CategoriaProdutoRegraColecaoImpl();
		return _categoriaProdutoRegraColecao;
	}
	private  CategoriaProdutoProdutoRegraColecao _categoriaProdutoProdutoRegraColecao;
	public  CategoriaProdutoProdutoRegraColecao getCategoriaProdutoProdutoRegraColecao() {
		if (_categoriaProdutoProdutoRegraColecao==null) _categoriaProdutoProdutoRegraColecao = new CategoriaProdutoProdutoRegraColecaoImpl();
		return _categoriaProdutoProdutoRegraColecao;
	}
	private  FacebookFanpageRegraColecao _facebookFanpageRegraColecao;
	public  FacebookFanpageRegraColecao getFacebookFanpageRegraColecao() {
		if (_facebookFanpageRegraColecao==null) _facebookFanpageRegraColecao = new FacebookFanpageRegraColecaoImpl();
		return _facebookFanpageRegraColecao;
	}
	private  FacebookFotoPostRegraColecao _facebookFotoPostRegraColecao;
	public  FacebookFotoPostRegraColecao getFacebookFotoPostRegraColecao() {
		if (_facebookFotoPostRegraColecao==null) _facebookFotoPostRegraColecao = new FacebookFotoPostRegraColecaoImpl();
		return _facebookFotoPostRegraColecao;
	}
	private  FacebookPerfilRegraColecao _facebookPerfilRegraColecao;
	public  FacebookPerfilRegraColecao getFacebookPerfilRegraColecao() {
		if (_facebookPerfilRegraColecao==null) _facebookPerfilRegraColecao = new FacebookPerfilRegraColecaoImpl();
		return _facebookPerfilRegraColecao;
	}
	private  FacebookProspectRegraColecao _facebookProspectRegraColecao;
	public  FacebookProspectRegraColecao getFacebookProspectRegraColecao() {
		if (_facebookProspectRegraColecao==null) _facebookProspectRegraColecao = new FacebookProspectRegraColecaoImpl();
		return _facebookProspectRegraColecao;
	}
	private  MarcaRegraColecao _marcaRegraColecao;
	public  MarcaRegraColecao getMarcaRegraColecao() {
		if (_marcaRegraColecao==null) _marcaRegraColecao = new MarcaRegraColecaoImpl();
		return _marcaRegraColecao;
	}
	private  OportunidadeDiaRegraColecao _oportunidadeDiaRegraColecao;
	public  OportunidadeDiaRegraColecao getOportunidadeDiaRegraColecao() {
		if (_oportunidadeDiaRegraColecao==null) _oportunidadeDiaRegraColecao = new OportunidadeDiaRegraColecaoImpl();
		return _oportunidadeDiaRegraColecao;
	}
	private  PrecoProdutoRegraColecao _precoProdutoRegraColecao;
	public  PrecoProdutoRegraColecao getPrecoProdutoRegraColecao() {
		if (_precoProdutoRegraColecao==null) _precoProdutoRegraColecao = new PrecoProdutoRegraColecaoImpl();
		return _precoProdutoRegraColecao;
	}
	private  PrecoProdutoDiarioRegraColecao _precoProdutoDiarioRegraColecao;
	public  PrecoProdutoDiarioRegraColecao getPrecoProdutoDiarioRegraColecao() {
		if (_precoProdutoDiarioRegraColecao==null) _precoProdutoDiarioRegraColecao = new PrecoProdutoDiarioRegraColecaoImpl();
		return _precoProdutoDiarioRegraColecao;
	}
	private  ProdutoRegraColecao _produtoRegraColecao;
	public  ProdutoRegraColecao getProdutoRegraColecao() {
		if (_produtoRegraColecao==null) _produtoRegraColecao = new ProdutoRegraColecaoImpl();
		return _produtoRegraColecao;
	}
	private  UsuarioRegraColecao _usuarioRegraColecao;
	public  UsuarioRegraColecao getUsuarioRegraColecao() {
		if (_usuarioRegraColecao==null) _usuarioRegraColecao = new UsuarioRegraColecaoImpl();
		return _usuarioRegraColecao;
	}
}
