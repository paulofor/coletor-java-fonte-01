package br.com.digicom.parse.dao;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.parse.callback.IDadosParse;

public abstract class DadosParseDao implements IDadosParse{

	//private String servidor;
	private DaoConexao conexao;
	
	//public void setServidor(String valor) {
	//	servidor = valor;
	//}
	
	public DaoConexao getConexao() {
		return conexao;
	}
	public void setConexao(DaoConexao valor) {
		conexao = valor;
	}
}
