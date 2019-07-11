package dafitiafil.dao;


import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.basica.CategoriaProdutoProdutoDaoBaseI;
import dafitiafil.modelo.CategoriaProdutoProduto;

public interface CategoriaProdutoProdutoDao
 extends CategoriaProdutoProdutoDaoBaseI { 
	
	public  CategoriaProdutoProduto obtemPorChavesAssociativas( CategoriaProdutoProduto item )  throws  DaoException;
	public boolean insereSeNaoExisteAssociativa(CategoriaProdutoProduto item) throws DaoException ;

}
