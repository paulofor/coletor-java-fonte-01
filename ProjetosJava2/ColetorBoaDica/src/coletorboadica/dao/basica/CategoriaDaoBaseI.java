package coletorboadica.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorboadica.modelo.*;
import coletorboadica.dao.*;
import coletorboadica.regracolecao.filtro.*;

public interface CategoriaDaoBaseI
 extends DaoI { 
	public void insereItem( Categoria item )  throws  DaoException;
	public void insereItemCompleto( Categoria item )  throws  DaoException;
	public boolean insereSeNaoExiste( Categoria item )  throws  DaoException;
	public void insereItemLoad( Categoria item )  throws  DaoException;
	public void alteraItem( Categoria item )  throws  DaoException;
	public void excluiItem( Categoria item )  throws  DaoException;
	public Categoria obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CategoriaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CategoriaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmCategoriaProdutoListaAssociada( long idProdutoComum )  throws  DaoException;

}
