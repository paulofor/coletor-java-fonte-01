package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface ProdutoDaoI extends DaoI { 
	public void cria( Produto item )  throws  DaoException;
}
