package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class CategoriaSiteMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		CategoriaSite objeto;
		objeto = new CategoriaSite();
		objeto.setIdCategoriaSite(resultadoLista.getInt(1));
		objeto.setNome(resultadoLista.getString(2));
		objeto.setUrl(resultadoLista.getString(3));
		return (ObjetoDominioI) objeto;
	}
}
