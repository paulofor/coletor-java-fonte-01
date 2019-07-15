package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface LojaSiteDaoI extends DaoI { 
	public void cria( LojaSite item )  throws  DaoException;
}
