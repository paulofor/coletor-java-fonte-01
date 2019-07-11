package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class VisitaCategoriaMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		VisitaCategoria objeto;
		objeto = new VisitaCategoria();
		objeto.setIdVisitaCategoria(resultadoLista.getInt(1));
		return (ObjetoDominioI) objeto;
	}
}
