package br.com.digicom.lib.dao;

import java.sql.ResultSet;

public abstract interface DataFonte
{
  public abstract void executaSql(String paramString, DaoConexao paramDaoConexao)
    throws DaoException;

  public abstract void executaSqlForcado(String paramString, DaoConexao paramDaoConexao)
    throws DaoException;

  public abstract ResultSet getListaSql(String paramString, DaoConexao paramDaoConexao)
    throws DaoException;

  public abstract String getValorString(String paramString, DaoConexao paramDaoConexao)
    throws DaoException;

  public abstract int getValorInt(String paramString, DaoConexao paramDaoConexao)
    throws DaoException;

  public abstract long getValorLong(String paramString, DaoConexao paramDaoConexao)
    throws DaoException;

  public abstract DaoConexao criaConexao()
    throws DaoException;

  public abstract void liberaConexao(DaoConexao paramDaoConexao)
    throws DaoException;
}

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.dao.DataFonte
 * JD-Core Version:    0.6.0
 */