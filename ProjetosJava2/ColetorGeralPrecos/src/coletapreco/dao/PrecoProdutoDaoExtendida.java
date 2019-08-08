package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
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



	@Override
	public void insereItemComIds(PrecoProduto item) throws DaoException {
		// TODO Auto-generated method stub
		String sql;
        sql = "insert into " + tabelaSelect() +
        		camposInsertComIds() + " values " + valoresInsertComIds(item);
        this.executaSql(sql);
	}
	
	protected String camposInsertComIds() 
	{
		return " ( id_preco_produto " 
		+ " ,preco_boleto " 
		+ " ,data_visita_inicial " 
		+ " ,quantidade_parcela " 
		+ " ,preco_parcela " 
		+ " ,preco_venda " 
		+ " ,preco_regular " 
		+ " ,data_ultima_visita " 
		+ " ,percentual_ajuste " 
		+ " ,media_2meses " 
		+ " ,minimo_3meses " 
		+ " ,id_produto_pa " 
		+ " ,id_loja_virtual " 
		+ " ,id_natureza_produto "
		+ " ,id_categoria_loja "
		+ " ) ";
	}
	
	protected String valoresInsertComIds(PrecoProduto item) {
		return " ( '" + item.getIdPrecoProduto() + "'  " 
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoBoleto()) + "'  "
		+ " ," + (item.getDataVisitaInicial()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataVisitaInicial()) ) + "  "
		+ " ,'" + item.getQuantidadeParcela() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoParcela()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoRegular()) + "'  "
		+ " ," + (item.getDataUltimaVisita()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVisita()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPercentualAjuste()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getMedia2meses()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getMinimo3meses()) + "'  "
		+ " ," + item.getIdProdutoPa() + "  "
		+ " ," + item.getIdLojaVirtual() + "  "
		+ " ," + item.getIdNaturezaProduto() + "  "
		+ " ," + item.getIdCategoraLoja() + "  "
		+ " ) ";
	}



	@Override
	public void atualizaDiferencaPosicao7Dias() throws DaoException {
		
		String sql2 = "update preco_produto " + 
				"set diferenca_posicao7 = (posicao7 - posicao0) " +
				"where preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql2);
		
		String sql = "update preco_produto " + 
				"set posicao7 = posicao6, " + 
				"posicao6 = posicao5, " + 
				"posicao5 = posicao4, " + 
				"posicao4 = posicao3, " + 
				"posicao3 = posicao2, " + 
				"posicao2 = posicao1, " + 
				"posicao1 = posicao0  " + 
				"where preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
		
		
	}
	
}
