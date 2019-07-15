package dafitiafil.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.parse.callback.PrecoProdutoDiarioListaCallbackHtml;
import dafitiafil.parse.callback.PrecoProdutoDiarioDetalheCallbackHtml;
import dafitiafil.parse.dados.PrecoProdutoDiarioDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;


public class PrecoProdutoDiarioRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected PrecoProdutoDiarioDadosParse dadosParse = null;
	
	public PrecoProdutoDiarioRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		//callbackLista = criaListaCallbackHtml();
		//callbackDetalhe = criaDetalheCallbackHtml();
		dadosParse = new PrecoProdutoDiarioDadosParse();
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
		return new PrecoProdutoDiarioListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new PrecoProdutoDiarioDetalheCallbackHtml();
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
	
	protected void preparaDadosLista(PrecoProdutoDiarioDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		PrecoProdutoDiarioDao daoFonte = DBB.getInstancia().getPrecoProdutoDiarioDao(); // 
		daoFonte.setConexao(conexao);
		List<PrecoProdutoDiario> lista = daoFonte.ListaCorrente();
		Iterator<PrecoProdutoDiario> itLista = lista.iterator();
		while (itLista.hasNext()) {
			PrecoProdutoDiario corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(PrecoProdutoDiario itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(PrecoProdutoDiarioDadosParse dados) {
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new PrecoProdutoDiarioListaCallbackHtml();
		PrecoProdutoDiarioDadosParse dadosParse = new PrecoProdutoDiarioDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		
		PrecoProdutoDiarioDao daoFonte = DBB.getInstancia().getPrecoProdutoDiarioDao(); // 
		daoFonte.setConexao(conexao);
		List<PrecoProdutoDiario> lista = daoFonte.ListaCorrente();
		Iterator<PrecoProdutoDiario> itLista = lista.iterator();
		while (itLista.hasNext()) {
			PrecoProdutoDiario corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}