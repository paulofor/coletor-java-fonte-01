package dafitiafil.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.basica.CategoriaProdutoProdutoDaoBase;
import dafitiafil.modelo.CategoriaProdutoProduto;


public  class CategoriaProdutoProdutoDaoExtendida  extends CategoriaProdutoProdutoDaoBase implements CategoriaProdutoProdutoDao {
	
	// Colocar no gerador em versão template
		public  CategoriaProdutoProduto obtemPorChavesAssociativas( CategoriaProdutoProduto item )  throws  DaoException{
			String query = null;
			query = " select " + camposOrdenados() + " from " + tabelaSelect() + 
					"  where id_categoria_produto_ra = " + item.getIdCategoriaProdutoRa() + " and " +
					"  id_produto_ra = " + item.getIdProdutoRa();
			return (CategoriaProdutoProduto)getObjeto(query);
		}
		public boolean insereSeNaoExisteAssociativa(CategoriaProdutoProduto item) throws DaoException {
			CategoriaProdutoProduto itemExistente = obtemPorChavesAssociativas(item);
			if (itemExistente == null)
			{
				insereItem(item);
			    return true;
			} else {
			    return false;
			}
		}
		@Override
		public List ListaCorrenteAgrupada() throws DaoException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List ListaPorCategoriaProdutoReferenteA(long idItem)
				throws DaoException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List ListaPorProdutoReferenteA(long idItem) throws DaoException {
			// TODO Auto-generated method stub
			return null;
		}
}
