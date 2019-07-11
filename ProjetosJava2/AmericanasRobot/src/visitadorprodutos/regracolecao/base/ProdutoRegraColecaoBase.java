package visitadorprodutos.regracolecao.base;


import java.util.Collection;


import visitadorprodutos.regracolecao.filtro.*;


public abstract class ProdutoRegraColecaoBase   { 
	private ProdutoFiltro _filtro;
	public ProdutoFiltro getFiltro() {
		return _filtro;
	}
}
