package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class ExecucaoVisitaMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		ExecucaoVisita objeto;
		objeto = new ExecucaoVisita();
		objeto.setIdExecucaoVisita(resultadoLista.getInt(1));
		objeto.setData(resultadoLista.getString(2));
		objeto.setMaisRecente(resultadoLista.getLogicoConvertido(3));
		return (ObjetoDominioI) objeto;
	}
}
