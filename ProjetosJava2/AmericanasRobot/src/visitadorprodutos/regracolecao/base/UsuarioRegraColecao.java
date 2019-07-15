package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class UsuarioRegraColecao   { 
	private UsuarioFiltro _filtro;
	public UsuarioFiltro getFiltro() {
		if (_filtro==null) _filtro = new UsuarioFiltro();
		return _filtro;
	}
	protected UsuarioExtDaoI getDao() {
		return DBB.getInstancia().getUsuarioDao();
	}
}
