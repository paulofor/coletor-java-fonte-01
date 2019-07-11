package br.com.digicom.parse.dao;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.parse.callback.IDadosParse;

public abstract class DadosParseDao implements IDadosParse{

	private DaoConexao conexao = null;
	
	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	protected DaoConexao getConexao() {
		return this.conexao;
	}
}
