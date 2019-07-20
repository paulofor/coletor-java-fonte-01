package br.com.digicom.lib.dao;

import br.com.digicom.lib.DCIObjetoDominio;

public abstract class MontadorDao
{
	
	public boolean extraiRegistroListaInterna(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
			throws DaoException {
		objeto = ((MontadorDaoI)this).extraiRegistro(paramResultadoLista);
		return true;
	}


	public boolean extraiRegistroInterno(ResultadoLista paramResultadoLista,DCIObjetoDominio objeto) 
			throws DaoException {
		objeto = ((MontadorDaoI)this).extraiRegistro(paramResultadoLista);
		return true;
	}
}

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.dao.MontadorDao
 * JD-Core Version:    0.6.0
 */