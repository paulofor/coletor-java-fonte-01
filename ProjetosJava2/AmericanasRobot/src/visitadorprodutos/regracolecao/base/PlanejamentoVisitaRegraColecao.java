package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class PlanejamentoVisitaRegraColecao   { 
	private PlanejamentoVisitaFiltro _filtro;
	public PlanejamentoVisitaFiltro getFiltro() {
		if (_filtro==null) _filtro = new PlanejamentoVisitaFiltro();
		return _filtro;
	}
	public abstract Collection Pendentes();
	protected PlanejamentoVisitaExtDaoI getDao() {
		return DBB.getInstancia().getPlanejamentoVisitaDao();
	}
}
