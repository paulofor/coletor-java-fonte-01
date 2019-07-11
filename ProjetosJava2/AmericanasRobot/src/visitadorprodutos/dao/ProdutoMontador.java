package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class ProdutoMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		Produto objeto;
		objeto = new Produto();
		objeto.setIdProduto(resultadoLista.getInt(1));
		objeto.setNome(resultadoLista.getString(2));
		return (ObjetoDominioI) objeto;
	}
}
