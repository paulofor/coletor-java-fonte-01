package coletorboadica.parse.dados;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;

import coletorboadica.log.ArquivoLog;
import coletorboadica.modelo.CategoriaProduto;
import coletorboadica.parse.dados.basico.CategoriaDadosParseBase;
import coletorboadica.regracolecao.FabricaRegra;
import coletorboadica.regracolecao.ProdutoComumRegraColecao;

public class CategoriaDadosParse extends CategoriaDadosParseBase{

	@Override
	public String getUrlDetalhe() {
		return this.itemDetalhe.getUrl();
	}

	@Override
	public void finalizacaoOkDetalhe() {
		ProdutoComumRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoComumRegraColecao();
		List<CategoriaProduto> lista = this.listaCategoriaProduto;
		produtoSrv.getFiltro().setCategoriaItem(itemDetalhe);
		for (CategoriaProduto categoriaProduto : lista){
			produtoSrv.getFiltro().setItem(categoriaProduto.getProdutoComumAssociada(false));
			try {
				produtoSrv.ProcessaProdutoPreco(getConexao());
			} catch (DaoException e) {
				e.printStackTrace();
				ArquivoLog.getInstancia().salvaErroDao(e);
			}
		}
	}

	

}