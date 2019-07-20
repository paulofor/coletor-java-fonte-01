 package br.com.digicom.lib.dao;
 
 import java.sql.Connection;
 import java.sql.DriverManager;
 
 public class MySqlConnectionPool
 {
   private static Object _driver = null;
 
   public static Connection criaConexao(String url, String usuario, String senha, String driver) throws DaoException {
     try {
       Connection conexao = null;
       if (_driver == null)
        _driver = Class.forName(driver).newInstance();
       	conexao = DriverManager.getConnection(url, usuario, senha);
       	return conexao; 
       } catch (Exception e) {
    	throw new DaoException(e);
       }
   }
 
   public static void liberaConexao(Connection conexao) throws DaoException {
     try {
       conexao.close();
     } catch (Exception e) {
       throw new DaoException(e);
     }
   }
 }

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.dao.MySqlConnectionPool
 * JD-Core Version:    0.6.0
 */