package visitadorprodutos.regracolecao.base;


import java.util.Collection;


import visitadorprodutos.regracolecao.filtro.*;


public abstract class PlanejamentoVisitaRegraColecaoBase   { 
	private PlanejamentoVisitaFiltro _filtro;
	public PlanejamentoVisitaFiltro getFiltro() {
		return _filtro;
	}
}
