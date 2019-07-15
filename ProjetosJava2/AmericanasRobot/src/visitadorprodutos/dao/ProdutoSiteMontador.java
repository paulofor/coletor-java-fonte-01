package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class ProdutoSiteMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		ProdutoSite objeto;
		objeto = new ProdutoSite();
		objeto.setIdProdutoSite(resultadoLista.getInt(1));
		objeto.setRotuloSite(resultadoLista.getString(2));
		return (ObjetoDominioI) objeto;
	}
}
