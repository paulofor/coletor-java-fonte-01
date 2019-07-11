package visitadorprodutos.americanas.parser;

import americanasrobot.aplicacao.CategoriaSiteManipuladorI;
import br.com.digicom.parse.IPesquisador;
import br.com.digicom.parse.Pesquisador;

public class PesquisadorAmericanas extends Pesquisador implements IPesquisador{

	public PesquisadorAmericanas(CategoriaSiteManipuladorI manipulador) {
		super();
		super.setCallbackParse(new CallbackAmericanasHtml());
		super.setDadosParse(manipulador);
	}
}
