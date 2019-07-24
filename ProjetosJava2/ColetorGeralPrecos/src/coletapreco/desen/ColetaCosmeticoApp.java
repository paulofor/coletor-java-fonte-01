package coletapreco.desen;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaVirtualRegraColecao;

public class ColetaCosmeticoApp {

	public static void main(String[] args) {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		try {
			srv.AtualizaCosmetico();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
