package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface CategoriaProdutoDaoI extends DaoI { 
	public void cria( CategoriaProduto item )  throws  DaoException;
}
