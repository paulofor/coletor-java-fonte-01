package coletorboadica.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorboadica.modelo.*;
import coletorboadica.dao.*;
import coletorboadica.regracolecao.filtro.*;

public interface ProdutoComumDaoBaseI
 extends DaoI { 
	public void insereItem( ProdutoComum item )  throws  DaoException;
	public void insereItemCompleto( ProdutoComum item )  throws  DaoException;
	public boolean insereSeNaoExiste( ProdutoComum item )  throws  DaoException;
	public void insereItemLoad( ProdutoComum item )  throws  DaoException;
	public void alteraItem( ProdutoComum item )  throws  DaoException;
	public void excluiItem( ProdutoComum item )  throws  DaoException;
	public ProdutoComum obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ProdutoComumFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ProdutoComumFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmPrecoLojaListaPossui( long idPrecoLoja )  throws  DaoException;
	public List ListaNaoRelacionadaEmCategoriaProdutoListaAssociada( long idCategoria )  throws  DaoException;

}
