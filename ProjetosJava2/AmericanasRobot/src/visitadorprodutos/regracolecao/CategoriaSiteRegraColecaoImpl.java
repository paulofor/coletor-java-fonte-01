package visitadorprodutos.regracolecao;


import java.util.Collection;

import visitadorprodutos.dao.DBB;
import visitadorprodutos.regracolecao.base.CategoriaSiteRegraColecao;
import br.com.digicom.lib.dao.DaoException;


public  class CategoriaSiteRegraColecaoImpl  extends CategoriaSiteRegraColecao {

	public Collection ColecaoPorPlanejamentoVisita() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection Pendentes() {
		// TODO Auto-generated method stub
		Collection listaSaida = null;
		try {
			DBB.getInstancia().getCategoriaSiteDao().abreConexao();
			listaSaida = DBB.getInstancia().getCategoriaSiteDao().listaPendente();
			DBB.getInstancia().getCategoriaSiteDao().fechaConexao();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return listaSaida;
	} 
}
