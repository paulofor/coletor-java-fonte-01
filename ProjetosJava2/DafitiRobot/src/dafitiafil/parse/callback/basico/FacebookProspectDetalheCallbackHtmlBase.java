package dafitiafil.parse.callback.basico;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import dafitiafil.parse.dados.basico.FacebookProspectDadosParseBase;
import dafitiafil.modelo.FacebookProspect;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class FacebookProspectDetalheCallbackHtmlBase  extends CallbackParseHtml{

	protected FacebookProspectDadosParseBase dadosParse;
	protected boolean ligaColetaLista = false;
	protected String urlCorrente = null;
	protected boolean loop = false;
	private String urlOrigem = null;
	
	@Override
	public final URL getUrl() throws MalformedURLException {
		if (urlCorrente==null)
			urlCorrente = dadosParse.getUrlDetalhe();
		urlOrigem = urlCorrente;
		URL url = new URL(urlCorrente);
		return url;
	}
	
	protected String getUrlOrigem() {
		return urlOrigem;
	}

	@Override
	public final void setDados(IDadosParse paramIDadosParse) {
		dadosParse = (FacebookProspectDadosParseBase) paramIDadosParse;
		ArquivoLog.getInstancia().salvaLog("FacebookProspect(detalhe):"  + dadosParse.displayLog(dadosParse.getItemDetalhe()));
	}

	

	@Override
	public final void finalizacaoErro() {
		// TODO Auto-generated method stub
	}

	@Override
	public final void finalizacaoOk() {
		//if (lista==null) throw new RuntimeException("objeto lista em FacebookProspectListaCallbackHtmlBase esta null");
		finalizaObjeto();
		dadosParse.finalizacaoOkDetalhe();
		limpaListasInternas();
	}
	protected void finalizaObjeto() {
	}
	private void limpaListasInternas() {
	
	}

	@Override
	public void inicializacao() {
		System.out.println("Parser: " + this.getClass().getSimpleName());
		dadosParse.inicializacaoDetalhe();
		loop = false;
		urlCorrente = null;
	}

	@Override
	public final boolean getLoop() {
		// TODO Auto-generated method stub
		return loop;
	}

	@Override
	public final boolean isPost() {
		return (dadosParse.camposPost()!=null);
	}
	@Override
	public final List camposPost() {
		return dadosParse.camposPost();
	}

	
	protected final float extraiValorPreco(String valor) {
		int ini, fimtexto;
		if (valor==null) return 0;
		if (valor.indexOf(",")==-1 && valor.indexOf(".")!=-1) {
			valor = valor.replace('.', ',');
		}
		ini = valor.indexOf("$");
		fimtexto = valor.indexOf(",") + 3;
		valor = valor.substring(ini+1,fimtexto).trim();
		valor = valor.replace(".","");
		valor = valor.replace(',', '.');
		return Float.valueOf(valor);
	}
	
	protected final int extraiParcelas(String parcelamento) {
		if (parcelamento==null) return 0;
		int posicao = parcelamento.toLowerCase().indexOf("x");
		String parcelas = parcelamento.substring(0,posicao).trim();
		int qtde = Integer.parseInt(parcelas);
		return qtde;
	}
	protected final float extraiValorParcelas(String parcelamento) {
		if (parcelamento==null) return 0;
		return this.extraiValorPreco(parcelamento);
	}
	
}