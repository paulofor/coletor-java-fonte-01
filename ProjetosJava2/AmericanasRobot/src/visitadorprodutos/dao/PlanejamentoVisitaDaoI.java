package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface PlanejamentoVisitaDaoI extends DaoI { 
	public void cria( PlanejamentoVisita item )  throws  DaoException;
}
