package dafitiafil.parse.callback.basico;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import dafitiafil.parse.dados.basico.ProdutoDadosParseBase;
import dafitiafil.modelo.Produto;
import br.com.digicom.parse.log.ArquivoLog;

public abstract class ProdutoListaCallbackHtmlBase  extends CallbackParseHtml{

	protected ProdutoDadosParseBase dadosParse;
	protected boolean ligaColetaLista = false;
	protected List<Produto> lista = null;
	protected Produto corrente = null;
	
	protected String urlCorrente = null;
	
	@Override
	public final URL getUrl() throws MalformedURLException {
		urlCorrente = dadosParse.getUrlLista();
		URL url = new URL(urlCorrente);
		return url;
	}

	@Override
	public final void setDados(IDadosParse paramIDadosParse) {
		dadosParse = (ProdutoDadosParseBase) paramIDadosParse;
	}

	

	@Override
	public final void finalizacaoErro() {
		// TODO Auto-generated method stub
		ArquivoLog.getInstancia().salvaLog(" *** Finalizacao com erro ***");
		//if (lista==null) throw new RuntimeException("objeto lista em ProdutoDetalheCallbackHtmlBase esta null");
		dadosParse.finalizacaoOkLista();
	}

	@Override
	public final void finalizacaoOk() {
		//if (lista==null) throw new RuntimeException("objeto lista em ProdutoListaCallbackHtmlBase esta null");
		dadosParse.finalizacaoOkLista();
	}

	@Override
	public final void inicializacao() {
		//if (lista!=null) 
		//	lista.clear();
		System.out.println("Parser: " + this.getClass().getSimpleName());
		dadosParse.inicializacaoLista();
	}

	@Override
	public final boolean getLoop() {
		return false;
	}
	@Override
	public boolean isPost() {
		return false;
	}
	@Override
	public List camposPost() {
		return null;
	}

	protected final float extraiValorPreco(String valor) {
		int ini, fimtexto;
		if (valor==null) return 0;
		ini = valor.indexOf("$");
		fimtexto = valor.indexOf(",") + 3;
		valor = valor.substring(ini+1,fimtexto).trim();
		valor = valor.replace(".","");
		valor = valor.replace(',', '.');
		return Float.valueOf(valor);
	}
}