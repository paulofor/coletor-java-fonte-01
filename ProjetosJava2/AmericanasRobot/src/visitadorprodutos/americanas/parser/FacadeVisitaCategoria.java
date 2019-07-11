package visitadorprodutos.americanas.parser;

import americanasrobot.aplicacao.CategoriaSiteManipuladorI;
import br.com.digicom.parse.IPesquisador;

public class FacadeVisitaCategoria {

	public void acessaCategoria(CategoriaSiteManipuladorI manipulador) {
		IPesquisador pesquisador = new PesquisadorAmericanas(manipulador);
		pesquisador.run();
	}
}
