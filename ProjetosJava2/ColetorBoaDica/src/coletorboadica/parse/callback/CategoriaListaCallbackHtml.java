package coletorboadica.parse.callback;

import coletorboadica.parse.callback.basico.CategoriaListaCallbackHtmlBase;

public class CategoriaListaCallbackHtml extends CategoriaListaCallbackHtmlBase{


/*
Cuidado para n?o sobrescrever as vari?veis da classe pai !!!

protected CategoriaDadosParseBase dadosParse;
protected boolean ligaColetaLista = false;
protected List<LinhaProduto> lista = null;
protected LinhaProduto corrente = null;
*/

	// Se a p?gina estiver com erro de acentos e precisa usar um vers?o de charset diferente.
		// Possibilidades: ICallbackParse.HTML4_CHARSET ou ICallbackParse.HTML5_CHARSET
		@Override
		public String getCharSet() {
			return null;
		}
	
}