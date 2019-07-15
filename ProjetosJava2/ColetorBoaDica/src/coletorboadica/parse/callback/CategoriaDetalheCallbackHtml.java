package coletorboadica.parse.callback;

import javax.swing.text.html.HTML.Tag;

import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.parse.callback.CallbackParseHtml;
import coletorboadica.modelo.CategoriaProduto;
import coletorboadica.modelo.FabricaVo;
import coletorboadica.modelo.PrecoLoja;
import coletorboadica.modelo.ProdutoComum;
import coletorboadica.parse.callback.basico.CategoriaDetalheCallbackHtmlBase;

public class CategoriaDetalheCallbackHtml extends CategoriaDetalheCallbackHtmlBase{

	private int contaDado = 0;
	private String urlNova = null;

	private static String PREFIXO = "https://www.boadica.com.br";
	
	
	private String modelo = null;
	private String especificacao = null;
	private String preco = null;
	private String loja = null;
	private String telLoja = null;
	private String cidade = null;
	private String estado = null;
	private String bairro = null;
	private String fabricante = null;
	
	private boolean inicializa = false;
	
	public CategoriaDetalheCallbackHtml() {
		this.setDebug();
	}

	
	
	
	@Override
	public String getCharSet() {
		return CallbackParseHtml.HTML4_CHARSET;
	}




	@Override
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		
		String texto = String.copyValueOf(data);
		if (inicializa) {
			if ("col-md-1 center no-mobile".equals(this.getUltClasse2())) {
				fabricante = texto;
			}
			if (modelo==null && "mobile produto".equals(this.getUltClasse3())) {
				//System.out.println("Modelo:" + texto);
				modelo = texto;
			}
			if (especificacao==null && "no-mobile".equals(this.getUltClasse())) {
				//System.out.println("Especificação:" + texto);
				especificacao = texto;
			}
			if (contaDado==6) {
				//System.out.println("Preço:" + texto);
				preco = texto;
			}
			if (contaDado==7) {
				//System.out.println("Loja:" + texto);
				loja = texto;
			}
			if (contaDado==8) {
				//System.out.println("Tel Loja:" + texto);
				telLoja = texto;
			}
			if (contaDado==9) {
				//System.out.println("Cidade:" + texto);
				cidade = texto;
			}
			if (contaDado==10) {
				//System.out.println("Bairro:" + texto);
				bairro = texto;
				contaDado = -1;
				finalizaObjeto();
			}
			
		}
		if (texto.endsWith("xima")) {
			this.loop = true;
			this.urlCorrente = PREFIXO + this.getUtlUrl();
			//System.out.println("Entrou Texto");
		}
	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if ("row preco detalhe".equals(classeNome)) {
			inicializa();
		}
		//if (idNome.startsWith("trProd")) {
		//	contaDado = 1;
		//}
	}
	
	private void inicializa() {
		this.inicializa = true;
	}

	protected void finalizaObjeto() {
		ProdutoComum produto = FabricaVo.criaProdutoComum();
		produto.setNomeProduto(modelo);
		produto.setDescricao(especificacao);
		produto.setMarca(fabricante);
		PrecoLoja precoLoja = FabricaVo.criaPrecoLoja();
		precoLoja.setValor(this.extraiValorPreco(preco));
		precoLoja.setData(DCConvert.getDataDD_MM_AAAA());
		precoLoja.setNomeLoja(loja);
		precoLoja.setBairroLoja(bairro);
		precoLoja.setMunicipioLoja(cidade);
		produto.addListaPrecoLoja_Possui(precoLoja);
		CategoriaProduto categoriaProduto = FabricaVo.criaCategoriaProduto();
		categoriaProduto.setProdutoComumAssociada(produto);
		
		this.dadosParse.adicionaCategoriaProduto(categoriaProduto);
	}
	
}