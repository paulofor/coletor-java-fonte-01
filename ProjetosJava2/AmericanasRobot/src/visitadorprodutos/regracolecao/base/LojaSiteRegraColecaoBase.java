package visitadorprodutos.regracolecao.base;


import java.util.Collection;


import visitadorprodutos.regracolecao.filtro.*;


public abstract class LojaSiteRegraColecaoBase   { 
	private LojaSiteFiltro _filtro;
	public LojaSiteFiltro getFiltro() {
		return _filtro;
	}
}
