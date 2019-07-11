package dafitiafil.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.basica.OportunidadeDiaDaoBase;
import dafitiafil.modelo.OportunidadeDia;


public  class OportunidadeDiaDaoExtendida  extends OportunidadeDiaDaoBase implements OportunidadeDiaDao {
	
	public void limparTabela() throws DaoException{
		String sql = " delete from " + tabelaSelect();
		this.executaSql(sql);
	}
	
	public OportunidadeDia obtemProximoPost() throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" order by quantidade_exibicao asc limit 1";
		return (OportunidadeDia) this.getObjeto(sql);
	}
	public OportunidadeDia obtemProximoPorCategoria(long id, String valorMaximo) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" inner join categoria_produto_produto " +
				" on categoria_produto_produto.id_produto_ra = oportunidade_dia.id_produto_ra " +
				" where id_categoria_produto_ra =  " + id + 
				" and valor_consumidor_atual <= " + valorMaximo +
				" and url_afiliado <> 'null' " +
				" and url_afiliado <> 'Copiar e colar este código para montar o seu link !' " +
				" and imagem_local <> 'null' " +
				" and data_ultima_preco_anterior > '2015-07-01' " +
				" and percentual_ajuste_atual >= 5 " +
				" order by quantidade_exibicao asc, data_ultima_preco_anterior desc, valor_consumidor_atual desc limit 1";
		return (OportunidadeDia) this.getObjeto(sql);
	}
	public void somaExibicao(long idOportunidadeDia) throws DaoException {
		String sql = "update " + tabelaSelect() + 
				" set quantidade_exibicao = quantidade_exibicao + 1 " +
				" where id_oportunidade_dia = " + idOportunidadeDia;
		this.executaSql(sql);
	}

	@Override
	public List<OportunidadeDia> listaSemImagem()
			throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + 
				tabelaSelect() + 
				" inner join produto on produto.id_produto = oportunidade_dia.id_produto_ra " +
				" where produto.imagem is not null and produto.imagem_local = 'null'";
		return this.getListaSql(sql);
	}
	
	public List<OportunidadeDia> listaComIdFacebbok()
			throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + 
				tabelaSelect() + 
				" where codigo_facebook <> 'null'";
		return this.getListaSql(sql);
	}

	@Override
	public List<OportunidadeDia> listaPorCategoria(long idCategoria)
			throws DaoException {
		String sql = "select " + camposOrdenados() + " from " +
			tabelaSelect() +
			" inner join categoria_produto_produto on categoria_produto_produto.id_produto_ra = oportunidade_dia.id_produto_ra " +
			" where categoria_produto_produto.id_categoria_produto_ra = " + idCategoria;
		return getListaSql(sql);
	}

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaPorProdutoReferenteA(long idItem) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
