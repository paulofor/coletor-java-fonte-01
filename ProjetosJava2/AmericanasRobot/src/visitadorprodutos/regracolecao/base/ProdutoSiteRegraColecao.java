package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class ProdutoSiteRegraColecao   { 
	private ProdutoSiteFiltro _filtro;
	public ProdutoSiteFiltro getFiltro() {
		if (_filtro==null) _filtro = new ProdutoSiteFiltro();
		return _filtro;
	}
	protected ProdutoSiteExtDaoI getDao() {
		return DBB.getInstancia().getProdutoSiteDao();
	}
}
