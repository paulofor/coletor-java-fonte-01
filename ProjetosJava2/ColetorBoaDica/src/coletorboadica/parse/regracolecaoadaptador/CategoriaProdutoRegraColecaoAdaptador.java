package coletorboadica.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import coletorboadica.dao.*;
import coletorboadica.modelo.*;
import coletorboadica.parse.callback.CategoriaProdutoListaCallbackHtml;
import coletorboadica.parse.callback.CategoriaProdutoDetalheCallbackHtml;
import coletorboadica.parse.dados.CategoriaProdutoDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;

// Instnaciar um filho desse.
public abstract class CategoriaProdutoRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected CategoriaProdutoDadosParse dadosParse = null;
	
	public CategoriaProdutoRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		dadosParse = new CategoriaProdutoDadosParse();
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
		return new CategoriaProdutoListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new CategoriaProdutoDetalheCallbackHtml();
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
	
	protected void preparaDadosLista(CategoriaProdutoDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		CategoriaProdutoDao daoFonte = DBB.getInstancia().getCategoriaProdutoDao(); // 
		daoFonte.setConexao(conexao);
		List<CategoriaProduto> lista = daoFonte.ListaCorrente();
		Iterator<CategoriaProduto> itLista = lista.iterator();
		while (itLista.hasNext()) {
			CategoriaProduto corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(CategoriaProduto itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(CategoriaProdutoDadosParse dados) {
	}
	public CategoriaProduto getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new CategoriaProdutoListaCallbackHtml();
		CategoriaProdutoDadosParse dadosParse = new CategoriaProdutoDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		CategoriaProdutoDao daoFonte = DBB.getInstancia().getCategoriaProdutoDao(); // 
		daoFonte.setConexao(conexao);
		List<CategoriaProduto> lista = daoFonte.ListaCorrente();
		Iterator<CategoriaProduto> itLista = lista.iterator();
		while (itLista.hasNext()) {
			CategoriaProduto corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}