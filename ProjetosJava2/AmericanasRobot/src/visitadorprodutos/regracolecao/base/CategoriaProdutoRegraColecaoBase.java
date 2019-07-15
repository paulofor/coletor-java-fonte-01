package visitadorprodutos.regracolecao.base;


import java.util.Collection;


import visitadorprodutos.regracolecao.filtro.*;


public abstract class CategoriaProdutoRegraColecaoBase   { 
	private CategoriaProdutoFiltro _filtro;
	public CategoriaProdutoFiltro getFiltro() {
		return _filtro;
	}
}
