package visitadorprodutos.regracolecao.base;


import java.util.Collection;
import br.com.digicom.lib.*;


import visitadorprodutos.dao.*;
import visitadorprodutos.dao.extendida.*;
import visitadorprodutos.modelo.*;
import visitadorprodutos.regracolecao.filtro.*;


public abstract class LojaSiteRegraColecao   { 
	private LojaSiteFiltro _filtro;
	public LojaSiteFiltro getFiltro() {
		if (_filtro==null) _filtro = new LojaSiteFiltro();
		return _filtro;
	}
	public abstract Collection ListaPorPlanejamentoVisita();
	protected LojaSiteExtDaoI getDao() {
		return DBB.getInstancia().getLojaSiteDao();
	}
}
