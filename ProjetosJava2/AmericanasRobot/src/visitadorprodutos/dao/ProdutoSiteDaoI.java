package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface ProdutoSiteDaoI extends DaoI { 
	public void cria( ProdutoSite item )  throws  DaoException;
}
