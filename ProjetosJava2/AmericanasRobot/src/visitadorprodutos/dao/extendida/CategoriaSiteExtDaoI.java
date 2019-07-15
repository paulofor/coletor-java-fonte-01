package visitadorprodutos.dao.extendida;



import java.util.Collection;

import visitadorprodutos.dao.CategoriaSiteDaoI;
import br.com.digicom.lib.dao.DaoException;

public interface CategoriaSiteExtDaoI extends CategoriaSiteDaoI { 
	public Collection listaPendente() throws DaoException;
}
