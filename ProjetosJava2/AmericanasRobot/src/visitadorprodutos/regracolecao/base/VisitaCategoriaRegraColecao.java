package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class VisitaCategoriaRegraColecao   { 
	private VisitaCategoriaFiltro _filtro;
	public VisitaCategoriaFiltro getFiltro() {
		if (_filtro==null) _filtro = new VisitaCategoriaFiltro();
		return _filtro;
	}
	protected VisitaCategoriaExtDaoI getDao() {
		return DBB.getInstancia().getVisitaCategoriaDao();
	}
}
