package dafitiafil.regracolecao.impl;

import java.util.Iterator;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import br.com.digicom.util.DCDatas;
import dafitiafil.dao.OportunidadeDiaDao;
import dafitiafil.modelo.FabricaVo;
import dafitiafil.modelo.OportunidadeDia;
import dafitiafil.modelo.PrecoProduto;
import dafitiafil.modelo.Produto;
import dafitiafil.regracolecao.FabricaRegra;
import dafitiafil.regracolecao.OportunidadeDiaRegraColecao;
import dafitiafil.regracolecao.ProdutoRegraColecao;
import digicom.facebook.obj.FbEnviadorObj;

public class OportunidadeDiaRegraColecaoImpl extends OportunidadeDiaRegraColecao {

	private float PERCENTUAL_OPORTUNIDADE = 10.0F;
	private int QTDE_DIAS_OPORTUNIDADE = 14;

	public OportunidadeDia CalculaOportunidadeDiaCorrente(DaoConexao conexao) throws DaoException {
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		String dataInicio = DatasUtils.getDataAAAA_MM_DD_Add(this.QTDE_DIAS_OPORTUNIDADE * -1);
		produtoSrv.getFiltro().setDataInicioOportunidade(dataInicio);
		produtoSrv.getFiltro().setPercentualMinimoOportunidade(this.PERCENTUAL_OPORTUNIDADE);
		List<Produto> listaProduto = produtoSrv.OportunidadeDia(conexao);

		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		dao.limparTabela();
		OportunidadeDia oportunidade = FabricaVo.criaOportunidadeDia();
		int i = 1;
		for (Produto item : listaProduto) {
			System.out.println((i++) + " de " + listaProduto.size());

			if ("null".equals(item.getUrlAfiliado())) {
				produtoSrv.getFiltro().setItem(item);
				item = produtoSrv.ObtemCodigoDafiti(conexao);
			}
			
			oportunidade.setIdProdutoRa(item.getIdProduto());
			oportunidade.setNomeProduto(item.getNome());
			oportunidade.setUrlProduto(item.getUrl());
			oportunidade.setUrlImagem(item.getImagem());
			oportunidade.setImagemLocal(item.getImagemLocal());
			oportunidade.setQuantidadeExibicao(0L);

			PrecoProduto precoAtual = (PrecoProduto) item.getListaPrecoProduto_Possui().get(0);
			PrecoProduto precoAnterior = (PrecoProduto) item.getListaPrecoProduto_Possui().get(1);

			oportunidade.setDataInicioPrecoAtual(precoAtual.getDataUltimaVisita());
			oportunidade.setValorConsumidorAtual(precoAtual.getValorConsumidor());
			oportunidade.setQuantidadeParcelaAtual(precoAtual.getQuantidadeParcela());
			oportunidade.setValorParcelaAtual(precoAtual.getValorParcela());
			oportunidade.setPercentualAjusteAtual(precoAtual.getPercentualAjuste());

			oportunidade.setDataUltimaPrecoAnterior(precoAnterior.getDataUltimaVisita());
			oportunidade.setValorConsumidorAnterior(precoAnterior.getValorConsumidor());
			oportunidade.setQuantidadeParcelaAnterior(precoAnterior.getQuantidadeParcela());
			oportunidade.setValorParcelaAnterior(precoAnterior.getValorParcela());
			oportunidade.setNomeMarca(item.getMarcaPertenceA().getNomeMarca());
			oportunidade.setUrlAfiliado(item.getUrlAfiliado());
			dao.insereItem(oportunidade);
		}
		return null;
	}

	public OportunidadeDia ObtemProximoPost(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		OportunidadeDia saida = dao.obtemProximoPost();
		// dao.somaExibicao(saida.getIdOportunidadeDia());
		return saida;
	}

	public List ListaSemImagem(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		return dao.listaSemImagem();
	}

	@Override
	public OportunidadeDia ObtemProximoPorCategoria(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		OportunidadeDia saida = dao.obtemProximoPorCategoria(this.getFiltro().getCodigoCategoriaProduto(), "300");
		// saida.setQuantidadeExibicao(saida.getQuantidadeExibicao() + 1);
		// dao.somaExibicao(saida.getIdOportunidadeDia());
		// dao.alteraItem(saida);
		this.getFiltro().setItemComCodigoFb(saida);
		return saida;
	}

	@Override
	public OportunidadeDia AlteraIdFacebook(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(getFiltro().getItemComCodigoFb());
		return getFiltro().getItemComCodigoFb();
	}

	// Esse método tem uma outra arquitetura ele chama o Facebook
	@Override
	public OportunidadeDia ExcluiImagensDia(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		List<OportunidadeDia> oportunidades = dao.listaComIdFacebbok();
		FbEnviadorObj face = new FbEnviadorObj();
		Iterator<OportunidadeDia> it = oportunidades.iterator();
		int i = 1;
		boolean result = false;
		while (it.hasNext()) {
			OportunidadeDia item = it.next();
			try {
				result = face.ExluiItem(item.getCodigoFacebook());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Apagando " + (i++) + " de " + oportunidades.size() + "(" + result + ")");
			if (result) {
				item.setCodigoFacebook("null");
				dao.alteraItem(item);
			}
		}
		return null;
	}

	@Override
	public List ListaPorCategoria(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		long id = getFiltro().getCodigoCategoriaProduto();
		List<OportunidadeDia> oportunidades = dao.listaPorCategoria(id);
		return oportunidades;
	}

	@Override
	public OportunidadeDia RegistraPostRealizado(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		OportunidadeDia oportunidade = getFiltro().getItemComCodigoFb();
		dao.alteraItem(oportunidade);
		return oportunidade;
	}

}
