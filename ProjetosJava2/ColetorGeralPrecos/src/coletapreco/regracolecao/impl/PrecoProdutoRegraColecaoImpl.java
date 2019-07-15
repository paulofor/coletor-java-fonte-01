package coletapreco.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletapreco.dao.PrecoProdutoDao;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.InteresseProduto;
import coletapreco.modelo.PrecoDiario;
import coletapreco.modelo.PrecoProduto;
import coletapreco.modelo.Produto;
import coletapreco.regracolecao.PrecoProdutoRegraColecao;
import coletapreco.util.UtilData;


public  class PrecoProdutoRegraColecaoImpl  extends PrecoProdutoRegraColecao {
	
	
	private String descricaoPreco(PrecoProduto preco) {
		return "Venda: " + preco.getPrecoVendaFormatada() + " ( " + preco.getQuantidadeParcela() + " x " + 
				preco.getPrecoParcelaFormatada() + " ) Id PrecoProduto: " + preco.getIdPrecoProduto();
		
	}
	
	@Override
	public PrecoProduto AtualizaPorPrecoAtual(DaoConexao conexao) throws DaoException {
		PrecoDiario precoDiario = this.getFiltro().validaPrecoAtual();
		Produto produto = FabricaVo.criaProduto();
		PrecoProduto precoProduto = FabricaVo.criaPrecoProduto();
		produto.setIdProduto(precoDiario.getIdProdutoPa());
		precoProduto.setPrecoVenda(precoDiario.getPrecoVenda());
		getFiltro().setItem(precoProduto);
		getFiltro().setProduto(produto);
		return AtualizaPreco(conexao);
	} 
	
	@Override
	public synchronized  PrecoProduto AtualizaPreco(DaoConexao conexao) throws DaoException {
		Produto pesquisa = getFiltro().getProduto();
		PrecoProduto precoNovo = getFiltro().getItem();
		ArquivoLog.getInstancia().salvaLog("Pre�o Produto: " + descricaoPreco(precoNovo));
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		
		PrecoProduto precoRecente = MaisRecentePorProduto(conexao);
		
		if (precoRecente==null) {
			ArquivoLog.getInstancia().salvaLog("N�o existe pre�o");
			precoNovo.setProdutoPertenceA(pesquisa);
			precoNovo.setDataUltimaVisita(UtilData.getDataHora());
			precoNovo.setDataVisitaInicial(UtilData.getDataHora());
			precoNovo.setPercentualAjuste(0);
			dao.insereItem(precoNovo);
			
		} else {
			ArquivoLog.getInstancia().salvaLog("Pre�co mais recente: " + descricaoPreco(precoRecente));
			if (precoRecente.getPrecoVenda()==precoNovo.getPrecoVenda()) {
				ArquivoLog.getInstancia().salvaLog("Mesmo pre�o");
				precoRecente.setDataUltimaVisita(UtilData.getDataHora());
				dao.alteraItem(precoRecente);
			} else {
				ArquivoLog.getInstancia().salvaLog("Mudan�a de pre�o");
				float percentual = 0;
				if (precoRecente.getPrecoVenda()>0) {
					percentual = (precoRecente.getPrecoVenda()-precoNovo.getPrecoVenda()) / precoRecente.getPrecoVenda();
					percentual = percentual * 100;
				} else {
					percentual = 0;
				}
				ArquivoLog.getInstancia().salvaLog("Mudan�a de pre�o (Ajuste:" + percentual + ")");
				precoNovo.setPercentualAjuste(percentual);

				precoNovo.setProdutoPertenceA(pesquisa);
				precoNovo.setDataUltimaVisita(UtilData.getDataHora());
				precoNovo.setDataVisitaInicial(UtilData.getDataHora());
				dao.insereItem(precoNovo);
			}
		}
		precoRecente = null;
		return null;
	}


	

	@Override
	public PrecoProduto MaisRecentePorProduto(DaoConexao conexao) throws DaoException {
		Produto pesquisa = getFiltro().getProduto();
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		PrecoProduto preco = dao.MaisRecentePorProduto(pesquisa.getIdProduto());
		return preco;
	}

	@Override
	public PrecoProduto MinimoPorProduto(DaoConexao conexao) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public PrecoProduto CalculaMinimo(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao(conexao);
		dao.atualizaMinimoProduto(getFiltro().getItem().getIdProdutoPa());
		return getFiltro().getItem();
	}

	@Override
	public PrecoProduto CalculaPrecoMedio(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao(conexao);
		dao.atualizaMediaProduto(getFiltro().getItem().getIdProdutoPa());
		return getFiltro().getItem();
	}

	@Override
	public PrecoProduto CalculaMedioMinimoAjustePositivo(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao(conexao);
		dao.atualizaMediaProduto();
		dao.atualizaMinimoProduto();
		return null;
	}

	@Override
	public PrecoProduto AtualizaMediaMinimoPorListaInteresse(DaoConexao conexao) throws DaoException {
		StringBuffer listaIdProduto = new StringBuffer("( 0 ");
		List<InteresseProduto> listaInteresse = this.getFiltro().getListaIneresse();
		for (InteresseProduto interesse : listaInteresse) {
			if (interesse.getMonitora()) {
				listaIdProduto.append(" , " + interesse.getIdProdutoClienteRa());
			}
		}
		listaIdProduto.append(" ) ");
		PrecoProdutoDao dao = getDao(conexao);
		dao.atualizaMediaProduto(listaIdProduto.toString());
		dao.atualizaMinimoProduto(listaIdProduto.toString());
		// TODO Auto-generated method stub
		return null;
	}

	
}
