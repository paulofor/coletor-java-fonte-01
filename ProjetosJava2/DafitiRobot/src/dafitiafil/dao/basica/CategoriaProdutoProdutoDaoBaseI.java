package dafitiafil.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import dafitiafil.modelo.*;
import dafitiafil.dao.*;
import dafitiafil.regracolecao.filtro.*;

public interface CategoriaProdutoProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( CategoriaProdutoProduto item )  throws  DaoException;
	public void insereItemCompleto( CategoriaProdutoProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( CategoriaProdutoProduto item )  throws  DaoException;
	public void insereItemLoad( CategoriaProdutoProduto item )  throws  DaoException;
	public void alteraItem( CategoriaProdutoProduto item )  throws  DaoException;
	public void excluiItem( CategoriaProdutoProduto item )  throws  DaoException;
	public CategoriaProdutoProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CategoriaProdutoProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CategoriaProdutoProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorCategoriaProdutoReferenteA( long idItem )  throws  DaoException;
	public List ListaPorProdutoReferenteA( long idItem )  throws  DaoException;



}
