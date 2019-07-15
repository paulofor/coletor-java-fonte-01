package coletorboadica.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorboadica.dao.basica.*;
import coletorboadica.modelo.CategoriaProduto;

public interface CategoriaProdutoDao
 extends CategoriaProdutoDaoBaseI {

	CategoriaProduto obtemPorRel(long idProdutoComumA, long idCategoriaA)  throws DaoException;
}
