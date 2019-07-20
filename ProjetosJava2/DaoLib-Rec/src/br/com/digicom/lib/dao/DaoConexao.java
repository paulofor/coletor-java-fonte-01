 package br.com.digicom.lib.dao;
 
 import java.sql.Connection;
 import java.sql.SQLException;
 
 public class DaoConexao
 {
   private Connection _conexao;
 
   public boolean conexaoInativa()
     throws DaoException
   {
     try
     {
       return this._conexao.isClosed(); 
     } catch (SQLException e) {
    	 throw new DaoException(e);
     }
   }
   public Connection getConexao()
   {
     return this._conexao;
   }
   public void setConexao(Connection conexao) {
    this._conexao = conexao;
   }
 
   public void abreConexao()
   {
   }
 
   public void fechaConexao() throws DaoException
   {
     try
     {
       this._conexao.close();
     } catch (SQLException e) {
       throw new DaoException(e);
     }
   }
 }

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.dao.DaoConexao
 * JD-Core Version:    0.6.0
 */