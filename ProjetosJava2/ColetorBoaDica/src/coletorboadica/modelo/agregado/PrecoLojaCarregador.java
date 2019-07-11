package coletorboadica.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorboadica.modelo.*;
import coletorboadica.regracolecao.FabricaRegra;
import coletorboadica.regracolecao.*;

public class PrecoLojaCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemProdutoComum_ReferenteA(PrecoLoja vo) throws DaoException
    {
       	ProdutoComumRegraColecao servico = FabricaRegra.getInstancia().getProdutoComumRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoComumReferenteA(servico.obtemPorChave(vo.getIdProdutoComumRa(), conexao));
	    } else {
	    	vo.setProdutoComumReferenteA(servico.obtemPorChave(vo.getIdProdutoComumRa()));
    	}
    }
 	
	
	
}