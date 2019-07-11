package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class UsuarioMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		Usuario objeto;
		objeto = new Usuario();
		objeto.setIdUsuario(resultadoLista.getInt(1));
		return (ObjetoDominioI) objeto;
	}
}
