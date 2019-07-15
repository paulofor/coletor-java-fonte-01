package dafitiafil.regracolecao.impl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.ProdutoDao;
import dafitiafil.log.ArquivoLog;
import dafitiafil.modelo.OportunidadeDia;
import dafitiafil.modelo.PrecoProduto;
import dafitiafil.modelo.Produto;
import dafitiafil.parse.regracolecaoadaptador.custom.ProdutoRegraColecaoAdaptadorCustom;
import dafitiafil.regracolecao.FabricaRegra;
import dafitiafil.regracolecao.OportunidadeDiaRegraColecao;
import dafitiafil.regracolecao.ProdutoRegraColecao;


public  class ProdutoRegraColecaoImpl  extends ProdutoRegraColecao { 
	
	public static String diretorioDownload = "D:\\RobotWeb\\Dafiti\\Imagens";
	
	@Override
	public Produto BaixarImagens(DaoConexao conexao) throws DaoException {
		OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List<OportunidadeDia> listaOportunidade = oportunidadeSrv.ListaSemImagem(conexao);
		Iterator<OportunidadeDia> itOportunidade = listaOportunidade.iterator();
		int posicao = 1;
		while (itOportunidade.hasNext()) {
			OportunidadeDia oportunidade = itOportunidade.next();
			Produto produto = null;
			try {
				produto = dao.obtemPorChave(oportunidade.getIdProdutoRa());
				produto.setImagemLocal( "img-" + String.format("%09d",produto.getIdProduto()) + ".jpg");
				obtemImagemProduto(dao, produto);
				System.out.println("Imagem... " + (posicao++) + " de " + listaOportunidade.size());
			} catch (Exception e) {
				ArquivoLog.getInstancia().salvaErro(e, "oportunidade Id:" + oportunidade.getIdOportunidadeDia());
				ArquivoLog.getInstancia().salvaErro(e, "produto Id:" + oportunidade.getIdProdutoRa());
				ArquivoLog.getInstancia().salvaErro(e, "Produto:" + produto);
			}
		}
		return null;
	}
	
	private void obtemImagemProduto(ProdutoDao dao, Produto produto) {
		try {
			String nomeImagem = produto.getImagem();
			//obtemImagem( URLDecoder.decode(nomeImagem), produto.getImagemLocal());
			obtemImagem( nomeImagem, produto.getImagemLocal());
			dao.alteraItem(produto);
		} catch (Exception e) {
			System.out.println("Erro Imagem:" + e.getMessage());
			ArquivoLog.getInstancia().salvaErro(e, produto.getImagem());
		}
	}
	
	private void obtemImagem(String url, String local) throws MalformedURLException, 
			IOException, FileNotFoundException{
		
		File localFile = new File(diretorioDownload + File.separator + local);
		URL urlAcesso = new URL(url);
		InputStream in = urlAcesso.openStream();
		FileOutputStream out = new FileOutputStream(localFile);
		copyStream(in, out);
	}
	
	private void copyStream(InputStream in, OutputStream out)
			throws IOException {
		int BUFFER_SIZE = 4096;
		try {
			byte[] buf = new byte[BUFFER_SIZE];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}
	}

	@Override
	public List OportunidadeDia(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List<Produto> lista = dao.oportunidadesDia(getFiltro().getDataInicioOportunidade(), "" + getFiltro().getPercentualMinimoOportunidade());
		return lista;
	}

	@Override
	public Produto ObtemCodigoDafiti(DaoConexao conexao) throws DaoException {
		ProdutoRegraColecaoAdaptadorCustom adaptador = new ProdutoRegraColecaoAdaptadorCustom();
		Produto itemFiltro = getFiltro().getItem();
		List<PrecoProduto> listaPreco = itemFiltro.getListaPrecoProduto_Possui();
		adaptador.setItemAtualiza(itemFiltro);
		adaptador.atualizaDetalhe(conexao);
		itemFiltro.setListaPrecoProduto_Possui(listaPreco);
		return itemFiltro;
	}

	@Override
	public Produto CriaCodigoDafitiPorCategoriaOportunidade(DaoConexao conexao)
			throws DaoException {
		
		OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		long codigoCategoria = getFiltro().getCodigoCategoriaProduto();
		oportunidadeSrv.getFiltro().setCodigoCategoriaProduto(codigoCategoria);
		List<OportunidadeDia> oportunidades = oportunidadeSrv.ListaPorCategoria(conexao);
		Iterator<OportunidadeDia> itOp = oportunidades.iterator();
		int cont = 1;
		
		while (itOp.hasNext()) {
			System.out.println((cont++) + " de " + oportunidades.size());
			OportunidadeDia op = itOp.next();
			if (op.getProdutoReferenteA()==null) {
				op.setProdutoReferenteA(this.obtemPorChave(op.getIdProdutoRa(), conexao));
			}
			System.out.println(op.getProdutoReferenteA().getUrlAfiliado());
			if (op.getProdutoReferenteA().getUrlAfiliado() == null || 
					"null".equals(op.getProdutoReferenteA().getUrlAfiliado()) ||
					"Copiar e colar este código para montar o seu link !".equals(op.getProdutoReferenteA().getUrlAfiliado())) {
				this.getFiltro().setItem(op.getProdutoReferenteA());
				Produto produto = this.ObtemCodigoDafiti(conexao);
				System.out.println(produto.getUrlAfiliado());
				//this.alteraItem(produto, conexao);
				op.setUrlAfiliado(produto.getUrlAfiliado());
				oportunidadeSrv.alteraItem(op, conexao);
			}
		}
		return null;
	}
}
