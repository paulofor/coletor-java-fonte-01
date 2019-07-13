package br.com.digicom.parse.callback;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ParserThread;

public abstract interface ICallbackParse {
	
	
	
	public abstract ParserThread criaParse();

	public abstract URL getUrl() throws MalformedURLException;

	public abstract void setDados(IDadosParse paramIDadosParse);

	public abstract void finalizacaoErro();

	public abstract void finalizacaoOk() throws DaoException;

	public abstract void inicializacao();

	public abstract boolean getLoop();

	public boolean isPost();

	public List camposPost();

	public abstract void setCookies(CookieManager cookies);

	public abstract CookieManager getCookies();
	
	public String getCharSet();

	

	public abstract URL getJsonUrl() throws MalformedURLException;
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.callback.ICallbackParse JD-Core Version: 0.6.0
 */