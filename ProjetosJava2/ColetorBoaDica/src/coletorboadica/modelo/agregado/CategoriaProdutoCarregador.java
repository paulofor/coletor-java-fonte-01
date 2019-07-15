package coletorboadica.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorboadica.modelo.*;
import coletorboadica.regracolecao.FabricaRegra;
import coletorboadica.regracolecao.*;

public class CategoriaProdutoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemProdutoComum_Associada(CategoriaProduto vo) throws DaoException
    {
       	ProdutoComumRegraColecao servico = FabricaRegra.getInstancia().getProdutoComumRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoComumAssociada(servico.obtemPorChave(vo.getIdProdutoComumA(), conexao));
	    } else {
	    	vo.setProdutoComumAssociada(servico.obtemPorChave(vo.getIdProdutoComumA()));
    	}
    }
 	
	public void CarregaItemCategoria_Associada(CategoriaProduto vo) throws DaoException
    {
       	CategoriaRegraColecao servico = FabricaRegra.getInstancia().getCategoriaRegraColecao();
    	if (conexao!=null ) { 
            vo.setCategoriaAssociada(servico.obtemPorChave(vo.getIdCategoriaA(), conexao));
	    } else {
	    	vo.setCategoriaAssociada(servico.obtemPorChave(vo.getIdCategoriaA()));
    	}
    }
 	
	
	
}