package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class CategoriaSiteRegraColecao   { 
	private CategoriaSiteFiltro _filtro;
	public CategoriaSiteFiltro getFiltro() {
		if (_filtro==null) _filtro = new CategoriaSiteFiltro();
		return _filtro;
	}
	public abstract Collection ColecaoPorPlanejamentoVisita();
	public abstract Collection Pendentes();
	protected CategoriaSiteExtDaoI getDao() {
		return DBB.getInstancia().getCategoriaSiteDao();
	}
}
