package coletapreco.desen;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaVirtualRegraColecao;

public class ColetaCosmeticoApp {

	public static void main(String[] args) {
		System.out.println("Versao: 31-08-2019 (3)");
		
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		ContagemProdutoRegraColecao contagemSrv = FabricaRegra.getInstancia().getContagemProdutoRegraColecao();
		
		try {
			
			srv.AtualizaCosmetico();
			contagemSrv.RegistraQuantidadesDia();
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
