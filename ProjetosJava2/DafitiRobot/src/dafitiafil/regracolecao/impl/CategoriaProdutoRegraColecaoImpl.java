package dafitiafil.regracolecao.impl;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import dafitiafil.modelo.CategoriaProduto;
import dafitiafil.parse.regracolecaoadaptador.CategoriaProdutoRegraColecaoAdaptador;
import dafitiafil.regracolecao.CategoriaProdutoRegraColecao;


public  class CategoriaProdutoRegraColecaoImpl  extends CategoriaProdutoRegraColecao {

	@Override
	public CategoriaProduto AtualizaDetalhe(DaoConexao conexao)
			throws DaoException {
		CategoriaProdutoRegraColecaoAdaptador adaptador = new CategoriaProdutoRegraColecaoAdaptador();
		adaptador.atualizaDetalhe(conexao);
		return null;

	} 
}
