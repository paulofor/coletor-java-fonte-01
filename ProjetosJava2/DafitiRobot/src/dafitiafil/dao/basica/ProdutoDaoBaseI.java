package dafitiafil.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import dafitiafil.modelo.*;
import dafitiafil.dao.*;
import dafitiafil.regracolecao.filtro.*;

public interface ProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( Produto item )  throws  DaoException;
	public void insereItemCompleto( Produto item )  throws  DaoException;
	public boolean insereSeNaoExiste( Produto item )  throws  DaoException;
	public void insereItemLoad( Produto item )  throws  DaoException;
	public void alteraItem( Produto item )  throws  DaoException;
	public void excluiItem( Produto item )  throws  DaoException;
	public Produto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorMarcaPertenceA( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmCategoriaProdutoProdutoListaPossui( long idCategoriaProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmPrecoProdutoListaPossui( long idPrecoProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmOportunidadeDiaListaPodePossuir( long idOportunidadeDia )  throws  DaoException;
	public List ListaNaoRelacionadaEmPrecoProdutoDiarioListaPossui( long idPrecoProdutoDiario )  throws  DaoException;
	public List ListaNaoRelacionadaEmFacebookFotoPostListaGerou( long idFacebookFotoPost )  throws  DaoException;
	public List ListaNaoRelacionadaEmFacebookPerfilListaAparece( long idFacebookPerfil )  throws  DaoException;

}
