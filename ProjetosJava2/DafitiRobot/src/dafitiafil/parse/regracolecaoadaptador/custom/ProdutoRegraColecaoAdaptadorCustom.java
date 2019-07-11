package dafitiafil.parse.regracolecaoadaptador.custom;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import dafitiafil.modelo.Produto;
import dafitiafil.parse.callback.ProdutoListaCallbackHtml;
import dafitiafil.parse.callback.custom.ProdutoDetalheUrlCallbackHtml;
import dafitiafil.parse.dados.custom.ProdutoDadosParseCustom;
import dafitiafil.parse.regracolecaoadaptador.ProdutoRegraColecaoAdaptador;


public class ProdutoRegraColecaoAdaptadorCustom extends ProdutoRegraColecaoAdaptador {

	private Produto item = null;
	
	public ProdutoRegraColecaoAdaptadorCustom() {
		exec = new ExecutadorParse();
		callbackLista = new ProdutoListaCallbackHtml();
		callbackDetalhe = new ProdutoDetalheUrlCallbackHtml();
		dadosParse = new ProdutoDadosParseCustom();
	}
	
	public void setItemAtualiza(Produto entrada) {
		item = entrada;
	}
	
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		atualizaDetalhe(item,conexao);
		return;
	}

}