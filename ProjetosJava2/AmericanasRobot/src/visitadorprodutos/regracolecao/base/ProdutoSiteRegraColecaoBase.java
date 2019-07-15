package visitadorprodutos.regracolecao.base;


import java.util.Collection;


import visitadorprodutos.regracolecao.filtro.*;


public abstract class ProdutoSiteRegraColecaoBase   { 
	private ProdutoSiteFiltro _filtro;
	public ProdutoSiteFiltro getFiltro() {
		return _filtro;
	}
}
