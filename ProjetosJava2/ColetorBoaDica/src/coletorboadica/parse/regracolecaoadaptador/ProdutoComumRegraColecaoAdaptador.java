package coletorboadica.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import coletorboadica.dao.*;
import coletorboadica.modelo.*;
import coletorboadica.parse.callback.ProdutoComumListaCallbackHtml;
import coletorboadica.parse.callback.ProdutoComumDetalheCallbackHtml;
import coletorboadica.parse.dados.ProdutoComumDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;

// Instnaciar um filho desse.
public abstract class ProdutoComumRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected ProdutoComumDadosParse dadosParse = null;
	
	public ProdutoComumRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		dadosParse = new ProdutoComumDadosParse();
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
		return new ProdutoComumListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new ProdutoComumDetalheCallbackHtml();
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
	
	protected void preparaDadosLista(ProdutoComumDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		ProdutoComumDao daoFonte = DBB.getInstancia().getProdutoComumDao(); // 
		daoFonte.setConexao(conexao);
		List<ProdutoComum> lista = daoFonte.ListaCorrente();
		Iterator<ProdutoComum> itLista = lista.iterator();
		while (itLista.hasNext()) {
			ProdutoComum corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(ProdutoComum itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(ProdutoComumDadosParse dados) {
	}
	public ProdutoComum getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new ProdutoComumListaCallbackHtml();
		ProdutoComumDadosParse dadosParse = new ProdutoComumDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		ProdutoComumDao daoFonte = DBB.getInstancia().getProdutoComumDao(); // 
		daoFonte.setConexao(conexao);
		List<ProdutoComum> lista = daoFonte.ListaCorrente();
		Iterator<ProdutoComum> itLista = lista.iterator();
		while (itLista.hasNext()) {
			ProdutoComum corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}