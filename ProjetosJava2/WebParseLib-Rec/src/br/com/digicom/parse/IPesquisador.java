package br.com.digicom.parse;

import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;

public abstract interface IPesquisador
{
  public abstract void setCallbackParse(ICallbackParse paramICallbackParse);

  public abstract void setDadosParse(IDadosParse paramIDadosParse);

  public abstract void run();
}

/* Location:           D:\Java-Recuperacao\webparse.jar
 * Qualified Name:     br.com.digicom.parse.IPesquisador
 * JD-Core Version:    0.6.0
 */