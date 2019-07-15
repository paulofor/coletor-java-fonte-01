package visitadorprodutos.regracolecao.base;


import java.util.Collection;


import visitadorprodutos.regracolecao.filtro.*;


public abstract class ObservacaoVisitaRegraColecaoBase   { 
	private ObservacaoVisitaFiltro _filtro;
	public ObservacaoVisitaFiltro getFiltro() {
		return _filtro;
	}
}
