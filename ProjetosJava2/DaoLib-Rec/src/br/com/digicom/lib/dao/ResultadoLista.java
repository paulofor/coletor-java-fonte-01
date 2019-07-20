package br.com.digicom.lib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ResultadoLista {
	private ResultSet _lista;
	private String _sql = null;

	public void setSql(String sql) {
		this._sql = sql;
	}

	public void setResultSet(ResultSet resultado) {
		this._lista = resultado;
	}

	public boolean next() throws DaoException {
		try {
			return this._lista.next();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	public String getHoraMinuto(int indice) throws DaoException {
		try {
			return _lista.getString(indice);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
	public String getString(int indice) throws DaoException {
		try {
			return _lista.getString(indice);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	public int getInt(int indice) throws DaoException {
		try {
			return this._lista.getInt(indice);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	public Date getDate(int indice) throws DaoException {
		try {
			return this._lista.getDate(indice);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	public boolean getLogicoConvertido(int indice) throws DaoException {
		try {
			return this._lista.getString(indice).equals("S");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	public float getFloat(int indice) throws DaoException {
		try {
			return this._lista.getFloat(indice);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
}

/*
 * Location: D:\Java-Recuperacao\daolib.jar Qualified Name:
 * br.com.digicom.lib.dao.ResultadoLista JD-Core Version: 0.6.0
 */