package br.com.digicom.lib.dao;

public class DaoException extends Exception {
	private Exception _original;
	private String _mensagemAdicional;

	public DaoException(String texto) {
		this._mensagemAdicional = texto;
	}

	public DaoException(Exception original) {
		this._mensagemAdicional = null;
		this._original = original;
	}
	public DaoException(Exception original, String mensagem) {
		this._mensagemAdicional = mensagem;
		this._original = original;
	}

	@Override
	public String toString() {
		
		return super.toString() + " " + getMessage();
	}

	public String getMessage() {
		return (this._mensagemAdicional == null ? "" : this._mensagemAdicional)
				+ (this._original==null? " [sem exceção origem] " : this._original.getMessage());
	}

	public Exception getOriginal() {
		return this._original;
	}

	public void printStackTrace() {
		if (this._original!=null) {
			this._original.printStackTrace();
		} else {
			super.printStackTrace();
		}
	}
}

/*
 * Location: D:\Java-Recuperacao\daolib.jar Qualified Name:
 * br.com.digicom.lib.dao.DaoException JD-Core Version: 0.6.0
 */