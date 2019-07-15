package dafitiafil.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import dafitiafil.modelo.*;
import dafitiafil.dao.*;
import dafitiafil.regracolecao.filtro.*;

public interface PrecoProdutoDiarioDaoBaseI
 extends DaoI { 
	public void insereItem( PrecoProdutoDiario item )  throws  DaoException;
	public void insereItemCompleto( PrecoProdutoDiario item )  throws  DaoException;
	public boolean insereSeNaoExiste( PrecoProdutoDiario item )  throws  DaoException;
	public void insereItemLoad( PrecoProdutoDiario item )  throws  DaoException;
	public void alteraItem( PrecoProdutoDiario item )  throws  DaoException;
	public void excluiItem( PrecoProdutoDiario item )  throws  DaoException;
	public PrecoProdutoDiario obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PrecoProdutoDiarioFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PrecoProdutoDiarioFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorProdutoPertenceA( long idItem )  throws  DaoException;



}
