package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class PlanejamentoVisitaMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		PlanejamentoVisita objeto;
		objeto = new PlanejamentoVisita();
		objeto.setIdPlanejamentoVisita(resultadoLista.getInt(1));
		objeto.setProximaData(resultadoLista.getString(2));
		objeto.setNome(resultadoLista.getString(3));
		objeto.setPeriodicidade(resultadoLista.getString(4));
		return (ObjetoDominioI) objeto;
	}
}
