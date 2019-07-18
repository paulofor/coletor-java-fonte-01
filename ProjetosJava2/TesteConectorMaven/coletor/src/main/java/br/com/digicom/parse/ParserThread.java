package br.com.digicom.parse;

import br.com.digicom.parse.callback.ICallbackParse;
import javax.xml.parsers.SAXParser;

public abstract class ParserThread extends Thread
{
  public abstract void setConector(ConectorApache paramConector);

  public abstract void setParser(SAXParser paramSAXParser);

  public abstract void setCallback(ICallbackParse paramICallbackParse);
}

/* Location:           D:\Java-Recuperacao\webparse.jar
 * Qualified Name:     br.com.digicom.parse.ParserThread
 * JD-Core Version:    0.6.0
 */