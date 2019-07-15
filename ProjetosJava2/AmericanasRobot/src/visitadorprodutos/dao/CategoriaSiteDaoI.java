package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface CategoriaSiteDaoI extends DaoI { 
	public void cria( CategoriaSite item )  throws  DaoException;
}
