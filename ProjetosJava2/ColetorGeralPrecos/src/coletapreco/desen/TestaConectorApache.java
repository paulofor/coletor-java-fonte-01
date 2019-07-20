package coletapreco.desen;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache;
import br.com.digicom.parse.callback.ICallbackParse;
import coletapreco.dao.DBB;
import coletapreco.dao.LojaVirtualDao;
import coletapreco.dao.ProdutoDao;
import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.FabricaVo;
import coletapreco.parse.callback.custom.CategoriaLojaRevendaCosmeticosDetalheCallback;
import coletapreco.parse.dados.CategoriaLojaDadosParse;

public class TestaConectorApache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://www.extra.com.br/Informatica/Notebook/?Filtro=C56_C57";
		url = "https://www.revendadecosmeticos.com.br/marcas/macrilan.html?limit=48&p=10";
		ProdutoDao daoProduto = DBB.getInstancia().getProdutoDao();
		DaoConexao conexao;
		CategoriaLoja categoria = FabricaVo.criaCategoriaLoja();
		categoria.setUrl(url);
		categoria.setIdCategoriaLoja(999);
		categoria.setNome("Teste");
		categoria.setDataInclusao("2019-07-19");
		
		try {
			conexao = getDao().criaConexao();
			daoProduto.setConexao(conexao);
			ICallbackParse callback = new CategoriaLojaRevendaCosmeticosDetalheCallback();
			ExecutadorParseApache exec = new ExecutadorParseApache();
			CategoriaLojaDadosParse dadosParse = new CategoriaLojaDadosParse();
			dadosParse.setItemDetalhe(categoria);
			exec.setCallbackParse(callback); // Callback recebe dados parse -> manter ordem.
			exec.setDadosParse(dadosParse);
			exec.executa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}
	
	public static final LojaVirtualDao getDao() {
		return DBB.getInstancia().getLojaVirtualDao();
	}

}
