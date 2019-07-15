package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import coletapreco.dao.basica.DataSourceAplicacao;
import coletapreco.dao.basica.DataSourceNuvem;
import coletapreco.dao.basica.OportunidadeDiaDaoBase;
import coletapreco.modelo.OportunidadeDia;


public  class OportunidadeDiaDaoExtendida  extends OportunidadeDiaDaoBase implements OportunidadeDiaDao {

	
	
	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public void limparTabela() throws DaoException {
		String sql = " delete from " + tabelaSelect();
		this.executaSql(sql);
	}

	@Override
	public void enviaListaNuvem(List<OportunidadeDia> listaOportunidade) throws DaoException {
		DataFonte ds = new DataSourceNuvem();
		this.setDataSource(ds);
		DaoConexao conexao = this.criaConexao();
		this.setConexao(conexao);
		limpaTabela();
		for (OportunidadeDia item : listaOportunidade) {
			this.insereItem(item);
		}
		ds = new DataSourceAplicacao();
		this.setDataSource(ds);
		this.setConexao(null);
	} 
	
	private void limpaTabela() throws DaoException {
		String sql = "delete from oportunidade_dia";
		this.executaSql(sql);
	}

	

	@Override
	public List<OportunidadeDia> ListaPorFanpage(long idFacebookFanpage) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinNaturezaProduto_PertenceA() +
				NaturezaProdutoDaoExtendida.innerJoinAppProduto_AtendidoPor() + 
				AppProdutoDaoExtendida.innerJoinFacebookFanpage_DivulgadoPor() +
				" where id_facebook_fanpage = " + idFacebookFanpage;
		return this.getListaSql(sql);
	}

	@Override
	public List<OportunidadeDia> ListaPorFanpageData(long idFacebookFanpage, String dataLimite) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinNaturezaProduto_PertenceA() +
				NaturezaProdutoDaoExtendida.innerJoinAppProduto_AtendidoPor() + 
				AppProdutoDaoExtendida.innerJoinFacebookFanpage_DivulgadoPor() +
				" where id_facebook_fanpage = " + idFacebookFanpage +
				" and id_produto_ra not in (select id_produto_d from facebook_post where data_hora >= '" + dataLimite + "')";
		return this.getListaSql(sql);
	}
}
