package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class LojaSiteMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		LojaSite objeto;
		objeto = new LojaSite();
		objeto.setIdLojaSite(resultadoLista.getInt(1));
		objeto.setNomeClasseParse(resultadoLista.getString(2));
		objeto.setNome(resultadoLista.getString(3));
		objeto.setUrl(resultadoLista.getString(4));
		return (ObjetoDominioI) objeto;
	}
}
