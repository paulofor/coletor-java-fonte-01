package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface VisitaCategoriaDaoI extends DaoI { 
	public void cria( VisitaCategoria item )  throws  DaoException;
}
