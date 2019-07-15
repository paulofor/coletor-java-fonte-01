package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class ProdutoRegraColecao   { 
	private ProdutoFiltro _filtro;
	public ProdutoFiltro getFiltro() {
		if (_filtro==null) _filtro = new ProdutoFiltro();
		return _filtro;
	}
	protected ProdutoExtDaoI getDao() {
		return DBB.getInstancia().getProdutoDao();
	}
}
