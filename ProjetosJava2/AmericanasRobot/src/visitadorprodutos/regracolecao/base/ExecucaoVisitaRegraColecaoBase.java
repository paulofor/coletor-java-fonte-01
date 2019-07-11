package visitadorprodutos.regracolecao.base;


import java.util.Collection;


import visitadorprodutos.regracolecao.filtro.*;


public abstract class ExecucaoVisitaRegraColecaoBase   { 
	private ExecucaoVisitaFiltro _filtro;
	public ExecucaoVisitaFiltro getFiltro() {
		return _filtro;
	}
	public abstract Collection PendentesPorData();
}
