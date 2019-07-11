package visitadorprodutos.dao.extendida;


import java.util.Collection;

import visitadorprodutos.dao.CategoriaSiteDao;
import br.com.digicom.lib.dao.DaoException;


public  class CategoriaSiteExtDao  extends CategoriaSiteDao implements CategoriaSiteExtDaoI {

	public Collection listaPendente() throws DaoException{
		// TODO Auto-generated method stub
		String sql = "select " + this.camposOrdenados() + " from " + this.tabelaSelect();
		return this.getListaSql(sql);
	} 
}
