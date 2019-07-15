package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;

public interface ObservacaoVisitaDaoI extends DaoI { 
	public void cria( ObservacaoVisita item )  throws  DaoException;
}
