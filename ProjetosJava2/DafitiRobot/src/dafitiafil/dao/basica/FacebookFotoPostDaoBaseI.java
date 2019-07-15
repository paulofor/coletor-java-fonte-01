package dafitiafil.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import dafitiafil.modelo.*;
import dafitiafil.dao.*;
import dafitiafil.regracolecao.filtro.*;

public interface FacebookFotoPostDaoBaseI
 extends DaoI { 
	public void insereItem( FacebookFotoPost item )  throws  DaoException;
	public void insereItemCompleto( FacebookFotoPost item )  throws  DaoException;
	public boolean insereSeNaoExiste( FacebookFotoPost item )  throws  DaoException;
	public void insereItemLoad( FacebookFotoPost item )  throws  DaoException;
	public void alteraItem( FacebookFotoPost item )  throws  DaoException;
	public void excluiItem( FacebookFotoPost item )  throws  DaoException;
	public FacebookFotoPost obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( FacebookFotoPostFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( FacebookFotoPostFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorFacebookFanpageEnviadoPara( long idItem )  throws  DaoException;
	public List ListaPorFacebookPerfilEnviadoPara( long idItem )  throws  DaoException;
	public List ListaPorProdutoReferenteA( long idItem )  throws  DaoException;



}
