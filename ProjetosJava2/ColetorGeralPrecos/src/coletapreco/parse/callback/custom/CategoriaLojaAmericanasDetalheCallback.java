package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.log.ArquivoLog;
import coletapreco.modelo.CategoriaLojaProduto;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.Marca;
import coletapreco.modelo.PrecoProduto;
import coletapreco.modelo.Produto;
import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;

public class CategoriaLojaAmericanasDetalheCallback extends CategoriaLojaDetalheCallbackHtml {

	private int TOTAL = 500;

	public CategoriaLojaAmericanasDetalheCallback() {
		//this.setDebug();
	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (classeNome.indexOf("product-grid-item") != -1) {
			this.inicializaProduto();
		}
	}
	
	public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		super.handleStartTag(t, a, pos);
		if (t==HTML.Tag.SPAN && a.getAttribute("aria-label")!=null ) {
			String valor = (String) a.getAttribute("aria-label");
			if ("Next".equals(valor)) {
				this.urlCorrente = "https://www.americanas.com.br" + this.getUtlUrl();
				this.loop = true;
			}
		}
	}

	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			if (this.getUltClasse().indexOf("TitleUI") != -1) {
				this.nomeProduto = texto;
				this.urlProduto = "https://www.americanas.com.br" + this.getUtlUrl();
				System.out.println("Produto: " + this.nomeProduto);
				System.out.println("Url: " + this.urlProduto);
			}
			if (this.getUltClasse().indexOf("PriceUI") != -1 && texto.indexOf("$") == -1) {
				this.precoRegular = texto;
				System.out.println("Preço: " + this.precoRegular);
				this.finalizaProduto();
			}
		}

	}

}
