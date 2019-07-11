package coletorboadica.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorboadica.modelo.*;
import coletorboadica.dao.*;
import coletorboadica.regracolecao.filtro.*;

public interface CategoriaProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( CategoriaProduto item )  throws  DaoException;
	public void insereItemCompleto( CategoriaProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( CategoriaProduto item )  throws  DaoException;
	public void insereItemLoad( CategoriaProduto item )  throws  DaoException;
	public void alteraItem( CategoriaProduto item )  throws  DaoException;
	public void excluiItem( CategoriaProduto item )  throws  DaoException;
	public CategoriaProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CategoriaProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CategoriaProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorProdutoComumAssociada( long idItem )  throws  DaoException;
	public List ListaPorCategoriaAssociada( long idItem )  throws  DaoException;
	CategoriaProduto obtemPorRel(long idProdutoComumA, long idCategoriaA) throws DaoException;



}
