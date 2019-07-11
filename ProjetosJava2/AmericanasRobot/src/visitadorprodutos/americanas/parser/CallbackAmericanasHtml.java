package visitadorprodutos.americanas.parser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import visitadorprodutos.modelo.ObservacaoVisita;
import visitadorprodutos.modelo.ProdutoSite;
import americanasrobot.aplicacao.CategoriaSiteManipuladorI;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;

public class CallbackAmericanasHtml extends CallbackParseHtml {

	private CategoriaSiteManipuladorI categoriaSite;
	private ProdutoSite produtoCorrente;
	private ObservacaoVisita observacaoCorrente;
	private ArrayList listaSaida;
	
	private boolean itens;
	private int contador;
	private boolean leuPagina;
	private String urlCorrente = "";
	private String classeUrlCorrente = "";
	private boolean temLoop;
	private String urlAcesso;
	
	public CallbackAmericanasHtml() {
		super();
		//this.setDebug();
	}
	

	public void finalizacaoErro() {
		// TODO Auto-generated method stub
	}

	public void finalizacaoOk() {
		// TODO Auto-generated method stub
	}

	public URL getUrl() throws MalformedURLException {
		// TODO Auto-generated method stub
		System.out.println("url=" + urlAcesso);
		return new URL(urlAcesso);
	}

	public void inicializacao() {
		// TODO Auto-generated method stub
		System.out.println("********** Inicializacao **********");
		itens = false;
		leuPagina = false;
		temLoop = false;
	}

	public void setDados(IDadosParse arg0) {
		// TODO Auto-generated method stub
		categoriaSite = (CategoriaSiteManipuladorI) arg0;
		urlAcesso = categoriaSite.getUrl();
	}

	public boolean getLoop() {
		// TODO Auto-generated method stub
		return temLoop;
	}
	
	protected void handleUrl(String url,String classe){
		this.urlCorrente = url;
		this.classeUrlCorrente = classe;
	}
	
	private float extraiValor(String valorTexto) {
		int posicaoIni = valorTexto.indexOf("R$");
		valorTexto = valorTexto.substring(posicaoIni+3);
		valorTexto = valorTexto.replace(".", "");
		valorTexto = valorTexto.replace(",", ".");
		return Float.parseFloat(valorTexto);
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String dado = String.copyValueOf(data);
		if (this.classeUrlCorrente.compareTo("namePriceLink")==0) {
			System.out.println("Produto=" + dado);
			produtoCorrente = new ProdutoSite();
			produtoCorrente.setRotuloSite(dado);
			classeUrlCorrente = "";
		}
		if (this.classeUrlCorrente.compareTo("for")==0 || this.classeUrlCorrente.compareTo("price")==0) {
			System.out.println("Preço=" + dado);
			this.observacaoCorrente = new ObservacaoVisita();
			this.observacaoCorrente.setPreco(extraiValor(dado));
			classeUrlCorrente = "";
		}

		if (dado.indexOf("página")!=-1 && (!leuPagina)) {
			itens = true;
			contador = 0;
		}
		if (dado.indexOf("Mostrando")!=-1 && itens) {
			itens = false;
			leuPagina = true;
		}
		
		if (leuPagina && dado.compareTo("Próxima")==0) {
			int posIni = this.urlCorrente.indexOf("'") + 1;
			int posFim = urlCorrente.substring(posIni).indexOf("'");
			String sufixo = urlCorrente.substring(posIni,posIni+posFim);
			temLoop = true;
			urlAcesso = categoriaSite.getUrl() + sufixo;
		}
	}

}
