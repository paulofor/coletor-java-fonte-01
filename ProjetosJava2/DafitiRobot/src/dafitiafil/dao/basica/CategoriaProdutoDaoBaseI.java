package dafitiafil.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import dafitiafil.modelo.*;
import dafitiafil.dao.*;
import dafitiafil.regracolecao.filtro.*;

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



	public List ListaNaoRelacionadaEmCategoriaProdutoProdutoListaPossui( long idProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmFacebookPerfilListaGera( long idFacebookPerfil )  throws  DaoException;
	public List ListaNaoRelacionadaEmFacebookFanpageListaPossui( long idFacebookFanpage )  throws  DaoException;

}
