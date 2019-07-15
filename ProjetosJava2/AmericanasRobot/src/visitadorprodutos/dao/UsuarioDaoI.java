package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface UsuarioDaoI extends DaoI { 
	public void cria( Usuario item )  throws  DaoException;
}
