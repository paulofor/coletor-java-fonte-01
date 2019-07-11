package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface ExecucaoVisitaDaoI extends DaoI { 
	public void cria( ExecucaoVisita item )  throws  DaoException;
}
