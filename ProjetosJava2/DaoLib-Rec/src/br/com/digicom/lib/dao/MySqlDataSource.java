 package br.com.digicom.lib.dao;
 
 import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 
 public class MySqlDataSource
   implements DataFonte
 {
   private String urlConexao = null;
   private final String DRIVER = "com.mysql.jdbc.Driver";
   private String usuario = null;
   private String senha = null;
 
   public MySqlDataSource(String url, String usuario, String senha) {
     this.urlConexao = url;
     this.usuario = usuario;
     this.senha = senha;
   }
 
   public void setUrlConexao(String url) {
     this.urlConexao = url;
   }
 
   public DaoConexao criaConexao() throws DaoException {
     DaoConexao daoConexao = new DaoConexao();
     daoConexao.setConexao(MySqlConnectionPool.criaConexao(this.urlConexao, this.usuario, this.senha, "com.mysql.jdbc.Driver"));
     return daoConexao;
   }
   public void liberaConexao(DaoConexao conexao) throws DaoException {
     MySqlConnectionPool.liberaConexao(conexao.getConexao());
     conexao = null;
   }
 
   public ResultSet getListaSql(String sql, DaoConexao conexao) throws DaoException {
     return getListaSql(sql, conexao.getConexao());
   }
   public void executaSql(String sql, DaoConexao conexao) throws DaoException {
     executaSql(sql, conexao.getConexao());
   }
 
   public ResultSet getListaSql(String sql, Connection conexao) throws DaoException
   {
     Statement stmt = null;
     try
     {
       stmt = conexao.createStatement();
       stmt.execute(sql);
       ResultSet rs = stmt.getResultSet();
       return rs;
     } catch (NullPointerException e) {
       e.printStackTrace();
       if (conexao == null) throw new DaoException(e, "sem conexão aberta");
       		throw new DaoException(e, sql); 
       } catch (Exception e) {
    	   e.printStackTrace();
      	   throw new DaoException(e, sql);
       }
   }
 
   public void executaSql(String sql, Connection conexao) throws DaoException {
     Statement stmt = null;
     try {
       stmt = conexao.createStatement();
       stmt.executeUpdate(sql);
       stmt.close();
     } catch (SQLException e) {
       throw new DaoException(e, sql);
     }
   }
 
   public int getValorInt(String sql, DaoConexao conexao) throws DaoException
   {
     Statement stmt = null;
     try
     {
       stmt = conexao.getConexao().createStatement();
       stmt.execute(sql);
       ResultSet rs = stmt.getResultSet();
       rs.next();
       return rs.getInt(1);
     }
     catch (NullPointerException e) {
       if (conexao.getConexao() == null) throw new DaoException(e, "sem conexão aberta");
       throw new DaoException(e, sql); 
       } catch (Exception e) {
       	   throw new DaoException(e, sql);
       }
   }
   
   public String getValorString(String sql, DaoConexao conexao) throws DaoException {
     Statement stmt = null;
     try
     {
      stmt = conexao.getConexao().createStatement();
       stmt.execute(sql);
       ResultSet rs = stmt.getResultSet();
       rs.next();
       return rs.getString(1);
     } catch (NullPointerException e) {
       if (conexao.getConexao() == null) throw new DaoException(e, "sem conexão aberta");
       throw new DaoException(e, sql); 
       } catch (Exception e) {
    	   throw new DaoException(e, sql);
       }
   }
 
   public long getValorLong(String sql, DaoConexao conexao) throws DaoException {
     Statement stmt = null;
     try
     {
       stmt = conexao.getConexao().createStatement();
       stmt.execute(sql);
       ResultSet rs = stmt.getResultSet();
       rs.next();
       return rs.getLong(1);
     } catch (NullPointerException e) {
       if (conexao.getConexao() == null) throw new DaoException(e, "sem conexão aberta");
       throw new DaoException(e, sql); 
       } catch (Exception e) {
    	   throw new DaoException(e, sql);
       }
   }
 
   public void executaSqlForcado(String sql, DaoConexao conexao)
     throws DaoException
   {
     try
     {
       executaSql(sql, conexao.getConexao());
     } catch (Exception e) {
       try {
         if (conexao.getConexao().isClosed()) {
           conexao.setConexao(MySqlConnectionPool.criaConexao(this.urlConexao, this.usuario, this.senha, "com.mysql.jdbc.Driver"));
           executaSql(sql, conexao.getConexao()); } else {
           throw new DaoException(e);
         }
       } catch (Exception e2) {
         throw new DaoException(e);
       }
     }
   }
 }

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.dao.MySqlDataSource
 * JD-Core Version:    0.6.0
 */