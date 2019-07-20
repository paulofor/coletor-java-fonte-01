package br.com.digicom.lib.dao;

public abstract interface DaoI
{
  public abstract DaoConexao criaConexao()
    throws DaoException;

  public abstract void liberaConexao(DaoConexao paramDaoConexao)
    throws DaoException;

  public abstract void setConexao(DaoConexao paramDaoConexao);
}

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.dao.DaoI
 * JD-Core Version:    0.6.0
 */