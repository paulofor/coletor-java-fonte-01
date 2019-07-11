package dafitiafil.parse.callback.custom;

import java.util.List;

import javax.swing.text.html.HTML;

import dafitiafil.parse.callback.basico.ProdutoDetalheCallbackHtmlBase;

public class ProdutoDetalheUrlCallbackHtml extends ProdutoDetalheCallbackHtmlBase{

	private boolean ativo = false;
	private String urlDafiti = null;
	
	



	public ProdutoDetalheUrlCallbackHtml() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		if (ativo) {
			urlDafiti = String.copyValueOf(data);
			ativo = false;
			transfereValores();
		}
	}
	
	protected void inicioTag(HTML.Tag t, String classeNome, String idNome) {
		if (t == HTML.Tag.TEXTAREA) {
			ativo = true;
		}
	}
	
	private void transfereValores() {
		this.dadosParse.getItemDetalhe().setUrlAfiliado(urlDafiti);
	}
}