package dafitiafil.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.parse.callback.PrecoProdutoListaCallbackHtml;
import dafitiafil.parse.callback.PrecoProdutoDetalheCallbackHtml;
import dafitiafil.parse.dados.PrecoProdutoDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;


public class PrecoProdutoRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected PrecoProdutoDadosParse dadosParse = null;
	
	public PrecoProdutoRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		//callbackLista = criaListaCallbackHtml();
		//callbackDetalhe = criaDetalheCallbackHtml();
		dadosParse = new PrecoProdutoDadosParse();
	}
	private ICallbackParse getCallbackLista() {
		if (callbackLista==null) {
			callbackLista = criaListaCallbackHtml();
		}
		return callbackLista;
	}
	private ICallbackParse getCallbackDetalhe() {
		if (callbackDetalhe==null) {
			callbackDetalhe = criaDetalheCallbackHtml();
		}
		return callbackDetalhe;
	}
	protected ICallbackParse criaListaCallbackHtml() {
		return new PrecoProdutoListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new PrecoProdutoDetalheCallbackHtml();
	}

	// Atualizar uma lista de objeto em uma p?gina sem referencia de objeto pai.
	// Exemplo Categorias em uma loja Virtual
	public final void atualizaLista(DaoConexao conexao)
			throws DaoException {
		
		dadosParse.setConexao(conexao);
		preparaDadosLista(dadosParse);
		exec.setCallbackParse(getCallbackLista()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
		return;
		
		/*
		// Passo 2 - Montagem da fonte das urls
		
		return;
		*/
	}
	
	protected void preparaDadosLista(PrecoProdutoDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao daoFonte = DBB.getInstancia().getPrecoProdutoDao(); // 
		daoFonte.setConexao(conexao);
		List<PrecoProduto> lista = daoFonte.ListaCorrente();
		Iterator<PrecoProduto> itLista = lista.iterator();
		while (itLista.hasNext()) {
			PrecoProduto corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(PrecoProduto itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(PrecoProdutoDadosParse dados) {
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new PrecoProdutoListaCallbackHtml();
		PrecoProdutoDadosParse dadosParse = new PrecoProdutoDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		
		PrecoProdutoDao daoFonte = DBB.getInstancia().getPrecoProdutoDao(); // 
		daoFonte.setConexao(conexao);
		List<PrecoProduto> lista = daoFonte.ListaCorrente();
		Iterator<PrecoProduto> itLista = lista.iterator();
		while (itLista.hasNext()) {
			PrecoProduto corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}