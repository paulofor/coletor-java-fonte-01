package dafitiafil.app;

import java.util.Iterator;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import dafitiafil.modelo.PrecoProduto;
import dafitiafil.modelo.Produto;
import dafitiafil.obj.AcessaSitePrecoProdutoDafitiObj;
import dafitiafil.regracolecao.FabricaRegra;
import dafitiafil.regracolecao.OportunidadeDiaRegraColecao;
import dafitiafil.regracolecao.ProdutoRegraColecao;
import dafitiafil.regracolecao.impl.FacebookFotoPostRegraColecaoImpl;
import digicom.facebook.obj.FbEnviador;
import digicom.facebook.obj.FbEnviadorObj;

public class TestaMetodo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//criaOportunidades();
		//
		//atualizaCategoria();
		//apagaFotosFace();
		
		//baixarImagens();
		//criaOportunidades();
		//criaCodigoAfiliadoPorCategoria(1);
		
		//baixarImagens();
		//
		
		FbEnviadorObj enviador = new FbEnviadorObj();
		enviador.enviaOportunidade();
		//obtemCodigoDafiti(889);
		
		//enviaOportunidade();
		//postSemLink();
		
	}

	private static void enviaOportunidade() {
		FbEnviadorObj obj = new FbEnviadorObj();
		obj.enviaOportunidade();
	}
	
	private static void postSemLink() {
		FacebookFotoPostRegraColecaoImpl servico = (FacebookFotoPostRegraColecaoImpl) FabricaRegra.getInstancia().getFacebookFotoPostRegraColecao();
		FbEnviadorObj obj = new FbEnviadorObj();
		try {
			servico.getFiltro().setAlvoPostPerfil(obj.getPerfil());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		servico.EnviaPostSemLink();
	}
	
	private static void obtemCodigoDafiti(long id) {
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		try {
			Produto produto = produtoSrv.obtemPorChave(id);
			produtoSrv.getFiltro().setItem(produto);
			produto = produtoSrv.ObtemCodigoDafiti();
			System.out.println(produto.getUrlAfiliado());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void criaCodigoAfiliadoPorCategoria(long codigoCategoria) {
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		produtoSrv.getFiltro().setCodigoCategoriaProduto(codigoCategoria);
		try {
			produtoSrv.CriaCodigoDafitiPorCategoriaOportunidade();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private static void apagaFotosFace() {
		OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		try {
			oportunidadeSrv.ExcluiImagensDia();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void atualizaCategoria() {
		AcessaSitePrecoProdutoDafitiObj obj = new AcessaSitePrecoProdutoDafitiObj();
		try {
			obj.atualizaCategoria();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void criaOportunidades() {
		AcessaSitePrecoProdutoDafitiObj obj = new AcessaSitePrecoProdutoDafitiObj();
		try {
			obj.encontrarOportunidades();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void baixarImagens() {
		AcessaSitePrecoProdutoDafitiObj obj = new AcessaSitePrecoProdutoDafitiObj();
		try {
			obj.baixarImagens();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void buscaProdutosParaOportunidade() {
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		produtoSrv.getFiltro().setDataInicioOportunidade("2013-04-01");
		produtoSrv.getFiltro().setPercentualMinimoOportunidade(5);
		try {
			List lista = produtoSrv.OportunidadeDia();
			Iterator it = lista.iterator();
			while (it.hasNext()) {
				Produto produto = (Produto) it.next();
				List<PrecoProduto> precos = produto.getListaPrecoProduto_Possui();
				PrecoProduto preco = precos.get(0);
				PrecoProduto preco1 = precos.get(1);
				System.out.println(produto.getNome() + " ->"  + preco.getValorConsumidor() + " ( " + preco1.getValorConsumidor() + " )");
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

}
