 package br.com.digicom.lib.dao;
 
 public class ValorNaoEncontradoException extends DaoException
 {
   public ValorNaoEncontradoException(Exception original)
   {
/*  6 */     super(original);
   }
 
   public ValorNaoEncontradoException(Exception original, String mensagem) {
/* 10 */     super(original, mensagem);
   }
 }

/* Location:           D:\Java-Recuperacao\daolib.jar
 * Qualified Name:     br.com.digicom.lib.dao.ValorNaoEncontradoException
 * JD-Core Version:    0.6.0
 */