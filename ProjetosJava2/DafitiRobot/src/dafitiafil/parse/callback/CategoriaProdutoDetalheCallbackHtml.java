package dafitiafil.parse.callback;

import java.net.URLDecoder;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import dafitiafil.modelo.CategoriaProdutoProduto;
import dafitiafil.modelo.FabricaVo;
import dafitiafil.modelo.Marca;
import dafitiafil.modelo.PrecoProduto;
import dafitiafil.modelo.Produto;
import dafitiafil.parse.callback.basico.CategoriaProdutoDetalheCallbackHtmlBase;

public class CategoriaProdutoDetalheCallbackHtml extends CategoriaProdutoDetalheCallbackHtmlBase{

	private boolean ligaColetaTitulo = false;
	private boolean ligaColetaProduto = false;
	private int contaPalavraProduto;
	
	private String texto1, texto2, texto3, texto4, texto5;
	private Produto produto = null;
	private String imagemTrb = null;
	
	// Dados do Produto

	private String url;
	private String imagem;
	private String precoAvista;
	private String precoParcelado;
	private String frete;
	private String valorPromocional;
	
	// Novos
	private String precoFrom;
	private String qtdeParcelas;
	private String precoParcelas;
	private String urlProduto;
	private String marca;
	private String nomeProduto;
	
	private int contaInicio = 0;
	
	
	public CategoriaProdutoDetalheCallbackHtml() {
		//this.setDebug();
	}


	


	@Override
	protected void handleUrl(String url) {
		super.handleUrl(url);
		
	}
	




	@Override
	protected void handleUrl(String url, String classe, String titulo, String id) {
		// TODO Auto-generated method stub
		super.handleUrl(url, classe, titulo, id);
		if ("Próximo".equals(titulo)) {
			loop = true;
			urlCorrente = "http://www.dafiti.com.br" +url;
		}
		
	}



	@Override
	public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
		super.handleSimpleTag(t, a, pos);
		
	}





	@Override
	public void inicializacao() {
		contaInicio = 0;
		ligaColetaProduto = false;
		loop = false;
	}

	



	@Override
	public void inicioTag(HTML.Tag t, String nomeClasse, String nomeId) {
		super.inicioTag(t, nomeClasse, nomeId);
		if ("product-box".equals(nomeClasse) && ligaColetaProduto) {
			insereObjetoListaNovo();
		}
		if ("product-box".equals(nomeClasse)) {
			if (contaInicio==0) contaInicio++;
			else {
				ligaColetaProduto = true;
			}
		}
		
	}
	@Override
	public void handleEndTag(HTML.Tag t, int pos) {
		super.handleEndTag(t,pos);
		
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		if (ligaColetaProduto) {
			String texto = String.copyValueOf(data);
			String classe = this.getUltClasse();
			if (texto.trim().length() > 0) {
				if ("product-box-brand".equals(classe)) { 
					marca = texto;
					this.urlProduto = this.getUtlUrl3();
					return;
				}
				if ("product-box-title hide-mobile".equals(classe)) {
					nomeProduto = texto;
					imagem = imagemTrb;
					return;
				}
				if ("product-box-price-from".equals(classe)) {
					this.precoFrom = texto;
					return;
				}
				if (qtdeParcelas==null && "product-box-installment-parcel".equals(classe)) {
					this.qtdeParcelas = texto;
					return;
				}
				if ("product-box-installment-value".equals(classe)) {
					this.precoParcelas = texto;
					return;
				}
				
				if ("product-box-price-to".equals(classe)) {
					this.valorPromocional = texto;
					return;
				}
				
				
			}
		}

	}
	 
	private void inicializaVariaveis() {
		precoFrom = null;
		qtdeParcelas = null;
		precoParcelas = null;
		urlProduto = null;
		marca = null;
		nomeProduto  = null;
		valorPromocional = null;
	}
	
	 
	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);

		if ( a.getAttribute("data-frz-src")!=null) {
			imagemTrb = a.getAttribute("data-frz-src").toString();
		}

	}
	

	private void insereObjetoListaNovo() {
		produto = FabricaVo.criaProduto();
		
		if (marca!=null) {
			marca =  marca.replaceAll("’", " ");
			marca = marca.replaceAll("'", " ");
			Marca marcaObj = FabricaVo.criaMarca();
			marcaObj.setNomeMarca(marca);
			produto.setMarcaPertenceA(marcaObj);
		}
		
		nomeProduto = nomeProduto.replaceAll("'", " ");
		produto.setNome(nomeProduto);
		produto.setUrl(urlProduto);
		produto.setUrlOrigem(getUrlOrigem());
		produto.setImagem(imagem);
		
		PrecoProduto preco = FabricaVo.criaPrecoProduto();
		if (this.valorPromocional!=null)
			preco.setValorConsumidor(extraiValorPreco(this.valorPromocional));
		else
			preco.setValorConsumidor(extraiValorPreco(this.precoFrom));
		
		preco.setValorParcela(extraiValorPreco(this.precoParcelas));
		int limiteQtde = this.qtdeParcelas.toLowerCase().indexOf("x");
		String valorQtde = this.qtdeParcelas.substring(0,limiteQtde);
		preco.setQuantidadeParcela(Long.parseLong(valorQtde));
		produto.addListaPrecoProduto_Possui(preco);
		
		CategoriaProdutoProduto relacionamento = FabricaVo.criaCategoriaProdutoProduto();
		relacionamento.setProdutoReferenteA(produto);
		dadosParse.getItemDetalhe().addListaCategoriaProdutoProduto_Possui(relacionamento);
		
		inicializaVariaveis();
	}



	private void inicializaObjetoLista() {
		 valorPromocional = null;
	 }
	 
	 private void insereObjetoLista() {
		 produto = FabricaVo.criaProduto();
		 String marca1 = marca.replaceAll("’", " ");
		 String marca2 = marca.replaceAll("'", " ");
		 Marca marca = FabricaVo.criaMarca();
		 marca.setNomeMarca(marca2);
		 produto.setMarcaPertenceA(marca);
		 String nomeProduto1 = nomeProduto.replaceAll("'", " ");
		 produto.setNome(nomeProduto1);
		 produto.setUrl(url);

		 //String img = URLDecoder.decode(imagem);
		 produto.setImagem(imagem);
		 int x = precoParcelado.indexOf("x");
		 String parcela = precoParcelado.substring(0,x).trim();
		 String valorParcela = precoParcelado.substring(x+1).trim();
		 PrecoProduto preco = FabricaVo.criaPrecoProduto();
		 preco.setValorPrecoAvista(extraiValorPreco(precoAvista));
		 preco.setQuantidadeParcela(Long.parseLong(parcela));
		 preco.setValorParcela(extraiValorPreco(valorParcela));
		 if (this.valorPromocional!=null) {
			 preco.setPrecoPromocional(extraiValorPreco(this.valorPromocional));
			 preco.setValorConsumidor(preco.getPrecoPromocional());
		 } else {
			 preco.setValorConsumidor(preco.getValorPrecoAvista());
		 }
		 produto.setUrlOrigem(getUrlOrigem());
		 produto.addListaPrecoProduto_Possui(preco);
		 
		 CategoriaProdutoProduto relac = FabricaVo.criaCategoriaProdutoProduto();
		 dadosParse.getItemDetalhe().addListaCategoriaProdutoProduto_Possui(relac);
		 
		 

		 //dadosParse.criaCorrenteCategoriaProdutoProduto();
		 //dadosParse.getCorrenteCategoriaProdutoProduto().setProdutoReferenteA(produto);
		 //dadosParse.adicionaCorrenteCategoriaProdutoProduto();

		   
	 }
	 
	 /*
	private float extraiValorPreco(String valor) {
		valor = valor.substring(2);
		valor = valor.replace(',', '.');
		return Float.valueOf(valor);

	}
	*/

}