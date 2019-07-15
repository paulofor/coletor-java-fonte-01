package dafitiafil.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import dafitiafil.dao.*;
import dafitiafil.dao.basica.*;
import dafitiafil.modelo.PrecoProduto;


public  class PrecoProdutoDaoExtendida  extends PrecoProdutoDaoBase implements PrecoProdutoDao {

	@Override
	public PrecoProduto obtemMaisRecente(long idProduto) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_produto_pa = " + idProduto + " and " +
				" data_ultima_visita = (select max(data_ultima_visita) from " +
				tabelaSelect() + " where id_produto_pa = " + idProduto + " )";
		return (PrecoProduto) this.getObjeto(sql);

	}

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ListaPorProdutoPertenceA(long idItem) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	} 
}
