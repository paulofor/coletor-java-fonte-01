package coletorboadica.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorboadica.modelo.*;
import coletorboadica.dao.*;
import coletorboadica.regracolecao.filtro.*;

public interface PrecoLojaDaoBaseI
 extends DaoI { 
	public void insereItem( PrecoLoja item )  throws  DaoException;
	public void insereItemCompleto( PrecoLoja item )  throws  DaoException;
	public boolean insereSeNaoExiste( PrecoLoja item )  throws  DaoException;
	public void insereItemLoad( PrecoLoja item )  throws  DaoException;
	public void alteraItem( PrecoLoja item )  throws  DaoException;
	public void excluiItem( PrecoLoja item )  throws  DaoException;
	public PrecoLoja obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PrecoLojaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PrecoLojaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorProdutoComumReferenteA( long idItem )  throws  DaoException;



}
