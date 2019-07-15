package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.basica.PrecoProdutoDaoBase;
import coletapreco.modelo.PrecoProduto;


public  class PrecoProdutoDaoExtendida  extends PrecoProdutoDaoBase implements PrecoProdutoDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public PrecoProduto MaisRecentePorProduto(long idProduto) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() + 
					" where data_ultima_visita = (" +
					" select max(data_ultima_visita) " + 
					" from preco_produto " + 
					" where id_produto_pa = " + idProduto +
					" ) and id_produto_pa = " + idProduto;
		return (PrecoProduto) this.getObjeto(sql);
	}

	@Override
	public float ObtemMedia2Meses(long idProduto) throws DaoException {
		String sql = "select (avg(preco_venda)) from preco_diario " + 
				" where id_produto_pa = " + idProduto + " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH )";
		String valor = this.getValorString(sql);
		return Float.parseFloat(valor);
	}

	@Override
	public float ObtemMinimo3Meses(long idProduto) throws DaoException {
		String sql = "select (min(preco_venda)) from preco_diario " + 
				" where id_produto_pa = " + idProduto + " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH )";
		String valor = this.getValorString(sql);
		return Float.parseFloat(valor);
	} 
	
	@Override
	public int ObtemQuantidade2Meses(long idProduto) throws DaoException {
		String sql = "select count(*) from preco_diario " + 
				" where id_produto_pa = " + idProduto + " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH )";
		String valor = this.getValorString(sql);
		return Integer.parseInt(valor);
	} 
	
	@Override
	public void atualizaMediaProduto(long idProduto) throws DaoException {
		String sql = "update preco_produto set media_2meses = ( " +
				" select (avg(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa " + 
				" and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH ) and preco_venda > 0) " +
				" where preco_produto.id_produto_pa in (" + idProduto + ") and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
	}
	@Override
	public void atualizaMinimoProduto(long idProduto) throws DaoException {
		String sql = "update preco_produto set minimo_3meses = ( " +
				" select (min(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa " + 
				" and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH ) and preco_venda > 0) " +
				" where preco_produto.id_produto_pa in (" + idProduto + ") and preco_produto.data_ultima_visita = current_date()";
		
		this.executaSql(sql);
	}
	@Override
	public void atualizaMediaProduto() throws DaoException {
		String sql = "update preco_produto set media_2meses = ( " +
				" select (avg(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa " + 
				" and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH ) and preco_venda > 0) " +
				" where preco_produto.percentual_ajuste > 0 and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
	}
	@Override
	public void atualizaMinimoProduto() throws DaoException {
		String sql = "update preco_produto set minimo_3meses = ( " +
				" select (min(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa " + 
				" and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH )  and preco_venda > 0) " +
				" where preco_produto.percentual_ajuste  > 0 and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
	}



	@Override
	public void atualizaMediaProduto(String lista) throws DaoException {
		String sql = "update preco_produto set media_2meses = ( " +
				" select (avg(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa " + 
				" and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH ) and preco_venda > 0) " +
				" where preco_produto.id_produto_pa in " + lista + " and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
		
	}



	@Override
	public void atualizaMinimoProduto(String lista) throws DaoException {
		String sql = "update preco_produto set minimo_3meses = ( " +
				" select (min(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa " + 
				" and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH )  and preco_venda > 0) " +
				" where preco_produto.id_produto_pa in " + lista + " and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
		
	}
}
