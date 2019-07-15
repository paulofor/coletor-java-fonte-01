package dafitiafil.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.basica.MarcaDaoBase;
import dafitiafil.modelo.Marca;


public  class MarcaDaoExtendida  extends MarcaDaoBase implements MarcaDao { 
	
	public Marca obtemPorNome(String nome) throws DaoException {
		String sql = "select " + camposOrdenados() + 
				" from " + tabelaSelect() +
				" where nome_marca = '" + nome + "'";
		return (Marca) this.getObjeto(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmProdutoListaPossui(long idProduto)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
