package coletorboadica.app;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;

import coletorboadica.modelo.Categoria;
import coletorboadica.regracolecao.CategoriaRegraColecao;
import coletorboadica.regracolecao.FabricaRegra;

public class ColetorBoaDicaObj {

	private CategoriaRegraColecao categoriaSrv = FabricaRegra.getInstancia().getCategoriaRegraColecao();
	
	public void executa() {
		System.out.println("Ola Mundo !");
		try {
			categoriaSrv.ExecutaDia();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
