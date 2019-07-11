package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class ExecucaoVisitaRegraColecao   { 
	private ExecucaoVisitaFiltro _filtro;
	public ExecucaoVisitaFiltro getFiltro() {
		if (_filtro==null) _filtro = new ExecucaoVisitaFiltro();
		return _filtro;
	}
	public abstract Collection PendentesPorData();
	protected ExecucaoVisitaExtDaoI getDao() {
		return DBB.getInstancia().getExecucaoVisitaDao();
	}
}
