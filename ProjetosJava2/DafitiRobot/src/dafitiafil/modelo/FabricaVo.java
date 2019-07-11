package dafitiafil.modelo;


import dafitiafil.modelo.vo.*;


public  class FabricaVo   { 
	public   static CategoriaProduto criaCategoriaProduto() {
          return new CategoriaProdutoVo();
	}
	public   static CategoriaProdutoProduto criaCategoriaProdutoProduto() {
          return new CategoriaProdutoProdutoVo();
	}
	public   static FacebookFanpage criaFacebookFanpage() {
          return new FacebookFanpageVo();
	}
	public   static FacebookFotoPost criaFacebookFotoPost() {
          return new FacebookFotoPostVo();
	}
	public   static FacebookPerfil criaFacebookPerfil() {
          return new FacebookPerfilVo();
	}
	public   static FacebookProspect criaFacebookProspect() {
          return new FacebookProspectVo();
	}
	public   static Marca criaMarca() {
          return new MarcaVo();
	}
	public   static OportunidadeDia criaOportunidadeDia() {
          return new OportunidadeDiaVo();
	}
	public   static PrecoProduto criaPrecoProduto() {
          return new PrecoProdutoVo();
	}
	public   static PrecoProdutoDiario criaPrecoProdutoDiario() {
          return new PrecoProdutoDiarioVo();
	}
	public   static Produto criaProduto() {
          return new ProdutoVo();
	}
	public   static Usuario criaUsuario() {
          return new UsuarioVo();
	}
}
