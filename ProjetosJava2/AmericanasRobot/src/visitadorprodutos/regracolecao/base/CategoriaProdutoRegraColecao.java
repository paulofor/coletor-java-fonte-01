package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class CategoriaProdutoRegraColecao   { 
	private CategoriaProdutoFiltro _filtro;
	public CategoriaProdutoFiltro getFiltro() {
		if (_filtro==null) _filtro = new CategoriaProdutoFiltro();
		return _filtro;
	}
	protected CategoriaProdutoExtDaoI getDao() {
		return DBB.getInstancia().getCategoriaProdutoDao();
	}
}
