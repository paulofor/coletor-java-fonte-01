package visitadorprodutos.regracolecao.base;


import java.util.Collection;


import visitadorprodutos.regracolecao.filtro.*;


public abstract class CategoriaSiteRegraColecaoBase   { 
	private CategoriaSiteFiltro _filtro;
	public CategoriaSiteFiltro getFiltro() {
		return _filtro;
	}
	public abstract Collection ColecaoPorPlanejamentoVisita();
	public abstract Collection Pendentes();
}
