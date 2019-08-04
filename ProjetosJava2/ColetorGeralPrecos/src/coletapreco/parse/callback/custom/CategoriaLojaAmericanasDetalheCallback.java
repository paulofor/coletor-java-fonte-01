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


public class CategoriaLojaAmericanasDetalheCallback  extends CategoriaLojaDetalheCallbackHtml {

	private boolean ligaBoleto = false;
	private String dataImagem = null;
	
	private String urlMatriz = "http://www.americanas.com";
	
	private int limite = 24;
	private int offset = 0;
	
	private int TOTAL = 500;
	
	private boolean ligaPicture = false;
	private String ultimaFigura = null;
	private String ultimaFigura2 = null;
	
	
		
	public CategoriaLojaAmericanasDetalheCallback() {
		this.setDebug();
	}
	

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (classeNome.indexOf("product-grid-item")!=-1) {
			ligaColeta();
		}
		
	}
	
	
	@Override
	protected void handleImagem(String imagem) {
		super.handleImagem(imagem);
		
	}

	




	


	@Override
	protected void finalizaObjeto() {
		// TODO Auto-generated method stub
		super.finalizaObjeto();
		if (offset< TOTAL) {
			offset+= 24;
			//loop = true;
			urlCorrente = dadosParse.getUrlDetalhe() + "?limite=" + limite + "&offset=" + offset;
		} else {
			loop = false;
		}
		
	}


	@Override
	public void inicializacao() {
		super.inicializacao();
	}


	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);
		
	}


	@Override
	public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
		super.handleSimpleTag(t, a, pos);
		String nome = t.toString();
		if (ligaPicture && "source".equals(nome)) {
			ultimaFigura2 = ultimaFigura;
			ultimaFigura = (String) a.getAttribute("srcset");
			ligaPicture = false;
		}
		if ("picture".equals(nome)) {
			ligaPicture = true;
		}
	}

	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			String classe = this.getUltClasse();
			String classe2 = this.getUltClasse2();
			String ultTexto = this.getUltConteudo2();
			if (texto.trim().length() > 0) {
				
				if ("card-product-name".equals(classe)) {
					nomeProduto = texto;
					this.urlProduto = urlMatriz  + this.getUtlUrl();
					int posic = urlProduto.indexOf("?");
					if (posic!=-1) {
						urlProduto = urlProduto.substring(0, posic);
					}
					String imagem[] = ultimaFigura2.split(",");
					this.imagemProduto = imagem[0];
					return;
				}
				if ("value".equals(classe) && "value".equals(classe2)) {
					this.precoVenda = texto;
					this.desligaColeta();
					return;
				}

			}
		}
		

	}

	
	

}
