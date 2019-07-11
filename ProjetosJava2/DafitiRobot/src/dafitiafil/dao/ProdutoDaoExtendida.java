package dafitiafil.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import dafitiafil.dao.basica.MarcaDaoBase;
import dafitiafil.dao.basica.PrecoProdutoDaoBase;
import dafitiafil.dao.basica.ProdutoDaoBase;
import dafitiafil.dao.montador.MarcaMontador;
import dafitiafil.dao.montador.PrecoProdutoMontador;
import dafitiafil.dao.montador.ProdutoMontador;
import dafitiafil.modelo.Produto;


public  class ProdutoDaoExtendida  extends ProdutoDaoBase implements ProdutoDao { 
	public Produto obtemPorReferencia(Produto item) throws DaoException {
		return obtemPorUrl(item);
	}

	public Produto obtemPorUrl(Produto item) throws DaoException {
		if (item.getUrl()==null) return null;
		String query = null;
		query = " select " + CamposSelectJoin() + " from " + ConsultaJoin()
				+ "  where produto.url = '" + item.getUrl().trim() + "'";
		return (Produto) getObjeto(query);
	}
	
	public List<Produto> listaSemImagem() throws DaoException {
		String sql = "select " + camposOrdenados() + " from " +
				tabelaSelect() + " where imagem is not null and imagem_local = 'null'";
		return this.getListaSql(sql);
	}

	/*
	 * 	select produto.*, preco_produto.* from produto
		inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto
		where preco_produto.data_visita_inicial > '2013-04-05'
		and preco_produto.data_ultima_visita = current_date()
		and preco_produto.percentual_ajuste > 1.8
	 */
	
	@Override
	public List<Produto> oportunidadesDia(String dataInicialMySql,
			String percentualMinimo) throws DaoException {
		/*
		String sql = "select " + camposOrdenados() + " , " +
				PrecoProdutoDaoBase.camposOrdenados() + 
				" from " + tabelaSelect() + 
				" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  +
				" where preco_produto.data_visita_inicial > '" + dataInicialMySql + "' " +
				" and preco_produto.data_ultima_visita = current_date() " +
				" and preco_produto.percentual_ajuste > " + percentualMinimo +
				" order by produto.id_produto, preco_produto.data_ultima_visita desc";
		*/
		String sql1 = " select id_produto " +
				" from " + tabelaSelect() + 
				" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + 
				" where preco_produto.data_visita_inicial > '" + dataInicialMySql + "' " +
				" and preco_produto.data_ultima_visita = current_date() " +
				//" where preco_produto.data_visita_inicial > '2015-01-22' " +
				//" and preco_produto.data_ultima_visita = '2015-01-29' " +
				" and preco_produto.percentual_ajuste > " + percentualMinimo;
				
		String sql = "select " + camposOrdenados() + " , " +
				PrecoProdutoDaoBase.camposOrdenados() + " , " +
				MarcaDaoBase.camposOrdenados() +
				" from " + tabelaSelect() + 
				" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + // PrecoProduto
				" inner join marca on marca.id_marca = produto.id_marca_pa " + // Marca
				" where id_produto in ("  + sql1 + " ) " +
				" order by produto.id_produto, preco_produto.data_ultima_visita desc";
		MontadorDaoComposite composto = new MontadorDaoComposite();
		composto.adicionaMontador(new ProdutoMontador(), null);
		// Inserir Categoria e marca.
		composto.adicionaMontador(new PrecoProdutoMontador(), "ListaPrecoProduto_Possui");
		composto.adicionaMontador(new MarcaMontador(), "MarcaPertenceA");
		setMontador(composto);
		return this.getListaSqlListaInterna(sql);
	}

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaPorMarcaPertenceA(long idItem) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaNaoRelacionadaEmCategoriaProdutoProdutoListaPossui(
			long idCategoriaProduto) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaNaoRelacionadaEmPrecoProdutoListaPossui(long idPrecoProduto)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaNaoRelacionadaEmOportunidadeDiaListaPodePossuir(
			long idOportunidadeDia) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaNaoRelacionadaEmPrecoProdutoDiarioListaPossui(
			long idPrecoProdutoDiario) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaNaoRelacionadaEmFacebookFotoPostListaGerou(
			long idFacebookFotoPost) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaNaoRelacionadaEmFacebookPerfilListaAparece(
			long idFacebookPerfil) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
