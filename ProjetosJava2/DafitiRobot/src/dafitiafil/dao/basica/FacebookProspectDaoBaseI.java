package dafitiafil.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import dafitiafil.modelo.*;
import dafitiafil.dao.*;
import dafitiafil.regracolecao.filtro.*;

public interface FacebookProspectDaoBaseI
 extends DaoI { 
	public void insereItem( FacebookProspect item )  throws  DaoException;
	public void insereItemCompleto( FacebookProspect item )  throws  DaoException;
	public boolean insereSeNaoExiste( FacebookProspect item )  throws  DaoException;
	public void insereItemLoad( FacebookProspect item )  throws  DaoException;
	public void alteraItem( FacebookProspect item )  throws  DaoException;
	public void excluiItem( FacebookProspect item )  throws  DaoException;
	public FacebookProspect obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( FacebookProspectFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( FacebookProspectFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;




}
