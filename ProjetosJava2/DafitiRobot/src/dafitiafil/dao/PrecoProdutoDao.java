package dafitiafil.dao;


import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.basica.PrecoProdutoDaoBaseI;
import dafitiafil.modelo.PrecoProduto;

public interface PrecoProdutoDao
 extends PrecoProdutoDaoBaseI { 
	PrecoProduto obtemMaisRecente(long idProduto) throws DaoException;
}
