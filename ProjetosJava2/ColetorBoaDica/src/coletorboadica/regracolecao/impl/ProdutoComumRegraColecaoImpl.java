package coletorboadica.regracolecao.impl;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import coletorboadica.dao.ProdutoComumDao;
import coletorboadica.modelo.Categoria;
import coletorboadica.modelo.CategoriaProduto;
import coletorboadica.modelo.FabricaVo;
import coletorboadica.modelo.PrecoLoja;
import coletorboadica.modelo.ProdutoComum;
import coletorboadica.regracolecao.CategoriaProdutoRegraColecao;
import coletorboadica.regracolecao.FabricaRegra;
import coletorboadica.regracolecao.PrecoLojaRegraColecao;
import coletorboadica.regracolecao.ProdutoComumRegraColecao;


public  class ProdutoComumRegraColecaoImpl  extends ProdutoComumRegraColecao {

	
	
	@Override
	public ProdutoComum ProcessaProdutoPreco(DaoConexao conexao) throws DaoException {
		
		CategoriaProdutoRegraColecao categoriaProdutoSrv = FabricaRegra.getInstancia().getCategoriaProdutoRegraColecao();
		CategoriaProduto categoriaProduto = FabricaVo.criaCategoriaProduto();

		
		Categoria categoria = this.getFiltro().getCategoriaItem();
		categoriaProduto.setCategoriaAssociada(categoria);
		
		ProdutoComum produto = this.getFiltro().getItem();
		PrecoLoja precoLoja = produto.getCorrentePrecoLoja_Possui();
		produto.setNomeProduto(produto.getNomeProduto().toUpperCase().trim());
		this.getFiltro().setNomeModelo(produto.getNomeProduto());
		ProdutoComum pesquisa = ObtemPorNomeModelo(conexao);
		if (pesquisa==null) {
			ProdutoComumDao dao = getDao(conexao);
			dao.insereItemLoad(produto);
			precoLoja.setIdProdutoComumRa(produto.getIdObj());
			categoriaProduto.setProdutoComumAssociada(produto);
		} else {
			precoLoja.setIdProdutoComumRa(pesquisa.getIdObj());
			categoriaProduto.setProdutoComumAssociada(pesquisa);
		}
		categoriaProdutoSrv.criaRelSeNaoExiste(categoriaProduto, conexao);
		
		precoLoja.setData(DCConvert.getDataDD_MM_AAAA());
		PrecoLojaRegraColecao precoLojaSrv = FabricaRegra.getInstancia().getPrecoLojaRegraColecao();
		
		precoLoja.setBairroLoja(precoLoja.getBairroLoja().toUpperCase().trim());
		precoLoja.setMunicipioLoja(precoLoja.getMunicipioLoja().toUpperCase().trim());
		precoLojaSrv.insereItemLoad(precoLoja, conexao);
		
		return produto;
	}

	@Override
	public ProdutoComum ObtemPorNomeModelo(DaoConexao conexao) throws DaoException {
		ProdutoComumDao dao = getDao(conexao);
		return dao.ObtemPorNomeModelo(this.getFiltro().getNomeModelo());
	} 
}
