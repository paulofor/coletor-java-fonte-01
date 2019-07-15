package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class ObservacaoVisitaMontador   implements MontadorDaoI { 
	public ObjetoDominioI extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		ObservacaoVisita objeto;
		objeto = new ObservacaoVisita();
		objeto.setIdObservacaoVisita(resultadoLista.getInt(1));
		objeto.setMaisRecente(resultadoLista.getLogicoConvertido(2));
		objeto.setPreco(resultadoLista.getFloat(3));
		return (ObjetoDominioI) objeto;
	}
}
