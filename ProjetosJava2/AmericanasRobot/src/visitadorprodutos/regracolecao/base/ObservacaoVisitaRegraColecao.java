package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class ObservacaoVisitaRegraColecao   { 
	private ObservacaoVisitaFiltro _filtro;
	public ObservacaoVisitaFiltro getFiltro() {
		if (_filtro==null) _filtro = new ObservacaoVisitaFiltro();
		return _filtro;
	}
	protected ObservacaoVisitaExtDaoI getDao() {
		return DBB.getInstancia().getObservacaoVisitaDao();
	}
}
