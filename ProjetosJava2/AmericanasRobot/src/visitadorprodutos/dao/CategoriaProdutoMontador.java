package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class CategoriaProdutoMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		CategoriaProduto objeto;
		objeto = new CategoriaProduto();
		objeto.setIdCategoriaProduto(resultadoLista.getInt(1));
		objeto.setNome(resultadoLista.getString(2));
		return (ObjetoDominioI) objeto;
	}
}
