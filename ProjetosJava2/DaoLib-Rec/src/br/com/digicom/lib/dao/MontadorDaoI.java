package br.com.digicom.lib.dao;

import java.lang.reflect.InvocationTargetException;

import br.com.digicom.lib.DCIObjetoDominio;

public abstract interface MontadorDaoI
{
  public abstract DCIObjetoDominio extraiRegistro(ResultadoLista paramResultadoLista, DCIObjetoDominio paramDCIObjetoDominio, int paramInt)
    throws DaoException;

  public abstract DCIObjetoDominio extraiRegistro(ResultadoLista paramResultadoLista)
    throws DaoException;

  public abstract DCIObjetoDominio extraiRegistro(ResultadoLista paramResultadoLista, int paramInt)
    throws DaoException;

  public abstract DaoItemRetorno extraiRegistroListaInterna(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
		    throws DaoException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
  public abstract DaoItemRetorno extraiRegistroInterno(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
		    throws DaoException;
  
  public abstract int quantidadeCampos();
}

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.dao.MontadorDaoI
 * JD-Core Version:    0.6.0
 */