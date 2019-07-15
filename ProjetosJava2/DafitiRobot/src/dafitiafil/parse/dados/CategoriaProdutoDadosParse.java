package dafitiafil.parse.dados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import dafitiafil.dao.CategoriaProdutoProdutoDao;
import dafitiafil.dao.DBB;
import dafitiafil.dao.MarcaDao;
import dafitiafil.dao.PrecoProdutoDao;
import dafitiafil.dao.PrecoProdutoDiarioDao;
import dafitiafil.dao.ProdutoDao;
import dafitiafil.log.ArquivoLog;
import dafitiafil.modelo.CategoriaProduto;
import dafitiafil.modelo.CategoriaProdutoProduto;
import dafitiafil.modelo.FabricaVo;
import dafitiafil.modelo.Marca;
import dafitiafil.modelo.PrecoProduto;
import dafitiafil.modelo.PrecoProdutoDiario;
import dafitiafil.modelo.Produto;
import dafitiafil.parse.dados.basico.CategoriaProdutoDadosParseBase;
import dafitiafil.regracolecao.filtro.CategoriaProdutoProdutoFiltro;

public class CategoriaProdutoDadosParse extends CategoriaProdutoDadosParseBase{

	ProdutoDao daoProduto = null;
	PrecoProdutoDao daoPreco = null;
	CategoriaProdutoProdutoDao daoCatProduto = null;
	MarcaDao daoMarca = null;
	PrecoProdutoDiarioDao daoPrecoDiario = null;
	
	
	public CategoriaProdutoDadosParse() {
		daoProduto = DBB.getInstancia().getProdutoDao();
		daoPreco = DBB.getInstancia().getPrecoProdutoDao();
		daoCatProduto = DBB.getInstancia().getCategoriaProdutoProdutoDao();
		daoMarca = DBB.getInstancia().getMarcaDao();
		
	}
	
	public String getUrlDetalhe() {
 		return this.itemDetalhe.getUrl();
 	}
	
	protected boolean iguais(CategoriaProduto item1, CategoriaProduto item2) {
		return (item1.getUrl().compareTo(item2.getUrl())==0);
	}
	
	public void finalizacaoOkDetalhe() {
		trataProduto();
	}

	
	private void salvaPrecoDiario(PrecoProduto novo) throws DaoException{
		return;
		/*
		PrecoProdutoDiario precoDiario = FabricaVo.criaPrecoProdutoDiario();
		precoDiario.setIdProdutoPa(novo.getIdProdutoPa());
		precoDiario.setDataVisita(DCConvert.getDataDD_MM_AAAA());
		precoDiario.setQuantidadeParcela(novo.getQuantidadeParcela());
		precoDiario.setPrecoPromocional(novo.getPrecoPromocional());
		precoDiario.setValorConsumidor(novo.getValorConsumidor());
		precoDiario.setValorParcela(novo.getValorParcela());
		precoDiario.setValorPrecoAvista(novo.getValorPrecoAvista());
		this.daoPrecoDiario.insereItem(precoDiario);
		*/
	}
	
	// Para uma melhor organizacao deveria ficar no RegraColecao
	private void insereProduto(Produto produto) throws DaoException {
		//produto.setImagemLocal("");
		String mensagemArquivo = produto.getNome() + "(" + produto.getUrl() + ")";
		ArquivoLog.getInstancia().salvaResultadoDao(mensagemArquivo);
		Produto produtoDb = daoProduto.obtemPorReferencia(produto);
		
		if (produtoDb==null) {
			// Nao existe, necessario criar
			ArquivoLog.getInstancia().salvaResultadoDao("não encontrado.");
			produto.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
			daoProduto.insereItemLoad(produto);
			List<PrecoProduto> precos = produto.getListaPrecoProduto_Possui();
			PrecoProduto preco = precos.get(0);
			preco.setIdProdutoPa(produto.getIdProduto());
			preco.setDataVisitaInicial(DCConvert.getDataDD_MM_AAAA());
			preco.setDataUltimaVisita(DCConvert.getDataDD_MM_AAAA());
			preco.setPercentualAjuste(0);
			daoPreco.insereItem(preco);
			salvaPrecoDiario(preco);
		}  else {
			// Se existe verificar se tem nome
			ArquivoLog.getInstancia().salvaResultadoDao("encontrado. (id:" + produtoDb.getIdProduto() + ")");
			produto.setIdProduto(produtoDb.getIdProduto());
			if ("null".equals(produtoDb.getNome())) {
				produtoDb.setNome(produto.getNome());
				daoProduto.alteraItem(produto);
			}
			List<PrecoProduto> lista = produto.getListaPrecoProduto_Possui();
			if (lista!=null) {
				PrecoProduto preco = lista.get(0);
				preco.setIdProdutoPa(produto.getIdProduto());
				trataPrecoProduto(preco);
				salvaPrecoDiario(preco);
				//daoPreco.insereItem(preco);
				//System.out.println("Produto com preço: " + produto.getMarca() + " - " + produto.getNome());
			} else {
				System.out.println("Produto sem preço: " + produto.getMarcaPertenceA().getNomeMarca() + " - " + produto.getNome());
			}
				
		}
		
	}
	
	
	// Para melhor organizacao deveria ficar no RegraColecao (02-05-2013)
	private void trataPrecoProduto(PrecoProduto preco) throws DaoException{
		PrecoProduto anterior = daoPreco.obtemMaisRecente(preco.getIdProdutoPa());
		ArquivoLog.getInstancia().salvaResultadoDao("Preço Hoje: " + preco.getValorConsumidorFormatada() + " ( " +
				preco.getQuantidadeParcela() + " x " + preco.getValorParcelaFormatada() + " )");
		if (anterior.getPrecoPromocional()!=preco.getPrecoPromocional() ||
			anterior.getValorConsumidor()!=preco.getValorConsumidor() ||
			anterior.getValorPrecoAvista()!=preco.getValorPrecoAvista()) {
			float percentual = (anterior.getValorConsumidor()-preco.getValorConsumidor()) / anterior.getValorConsumidor();
			percentual = percentual * 100;
			preco.setPercentualAjuste(percentual);
			preco.setDataUltimaVisita(DCConvert.getDataDD_MM_AAAA());
			preco.setDataVisitaInicial(DCConvert.getDataDD_MM_AAAA());
			ArquivoLog.getInstancia().salvaResultadoDao("Novo preço");
			daoPreco.insereItem(preco);
		} else {
			ArquivoLog.getInstancia().salvaResultadoDao("Mesmo Preço");
			anterior.setDataUltimaVisita(DCConvert.getDataDD_MM_AAAA());
			daoPreco.alteraItem(anterior);
		}
	}
	
	private void trataProduto() {
		daoProduto.setConexao(getConexao());
		daoCatProduto.setConexao(getConexao());
		daoPreco.setConexao(getConexao());
		daoMarca.setConexao(getConexao());
		
		//ProdutoDadosParse dadoParse = new ProdutoDadosParse();
		CategoriaProdutoProduto catProd = null;
		PrecoProduto preco = null;
		
		List<CategoriaProdutoProduto> listaCatProd = new ArrayList<CategoriaProdutoProduto>();
		Iterator<CategoriaProdutoProduto> it = this.itemDetalhe.getListaCategoriaProdutoProduto_Possui().iterator();
		while (it.hasNext()) {
			CategoriaProdutoProduto item = it.next();
			Produto produto = item.getProdutoReferenteA();
			Marca marca = produto.getMarcaPertenceA();
			try {
				// Trata marca
				Marca marcaBd = daoMarca.obtemPorNome(marca.getNomeMarca());
				if (marcaBd==null) {
					daoMarca.insereItemLoad(marca);
					produto.setIdMarcaPa(marca.getIdMarca());
				} else {
					produto.setIdMarcaPa(marcaBd.getIdMarca());
				}
				insereProduto(produto);
				catProd = FabricaVo.criaCategoriaProdutoProduto();
				catProd.setIdCategoriaProdutoRa(itemDetalhe.getIdCategoriaProduto());
				catProd.setIdProdutoRa(produto.getIdProduto());
				listaCatProd.add(catProd);
			} catch (DaoException daoe) {
				//String mensagem = "Produto: " + produto.getNome() + " Marca: " + produto.getMarcaPertenceA().getNomeMarca();
				ArquivoLog.getInstancia().salvaErroDao(daoe);
			} catch (Exception e) {
				String mensagem = "Produto: " + produto.getNome() + " Marca: " + produto.getMarcaPertenceA().getNomeMarca();
				ArquivoLog.getInstancia().salvaErro(e, mensagem);
			} 
			//daoCatProduto.insereSeNaoExisteAssociativa(catProd);
		}
		CategoriaProdutoProdutoDadosParse catProdDados = new CategoriaProdutoProdutoDadosParse();
		CategoriaProdutoProdutoFiltro catProdFiltro = new CategoriaProdutoProdutoFiltro();
		catProdFiltro.setCodigoCategoriaProdutoReferenteA(itemDetalhe.getIdCategoriaProduto());

		try {
			List<CategoriaProdutoProduto> listaBanco = daoCatProduto.ListaFiltroSimples(catProdFiltro);
			List<CategoriaProdutoProduto> listaInclusao = catProdDados.subtraiListaPorNome(listaCatProd,listaBanco);
			List<CategoriaProdutoProduto> listaExclusao = catProdDados.subtraiListaPorNome(listaBanco,listaCatProd);
		
			Iterator<CategoriaProdutoProduto> itCatProd = listaInclusao.iterator();
			while (itCatProd.hasNext()) {
				CategoriaProdutoProduto item = itCatProd.next();
				//System.out.println("CategoriaProdutoProduto Nova: ");
				item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
				daoCatProduto.insereSeNaoExisteAssociativa(item);
			}
		} catch (DaoException e) {
			ArquivoLog.getInstancia().salvaErro(e);
			e.printStackTrace();
		}
		//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
		//dao.liberaConexao(getConexao());
	}
	

}