package dafitiafil.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.*;
import dafitiafil.modelo.*;
import dafitiafil.parse.callback.OportunidadeDiaListaCallbackHtml;
import dafitiafil.parse.callback.OportunidadeDiaDetalheCallbackHtml;
import dafitiafil.parse.dados.OportunidadeDiaDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;


public class OportunidadeDiaRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected OportunidadeDiaDadosParse dadosParse = null;
	
	public OportunidadeDiaRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		//callbackLista = criaListaCallbackHtml();
		//callbackDetalhe = criaDetalheCallbackHtml();
		dadosParse = new OportunidadeDiaDadosParse();
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
		return new OportunidadeDiaListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new OportunidadeDiaDetalheCallbackHtml();
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
	
	protected void preparaDadosLista(OportunidadeDiaDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao daoFonte = DBB.getInstancia().getOportunidadeDiaDao(); // 
		daoFonte.setConexao(conexao);
		List<OportunidadeDia> lista = daoFonte.ListaCorrente();
		Iterator<OportunidadeDia> itLista = lista.iterator();
		while (itLista.hasNext()) {
			OportunidadeDia corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(OportunidadeDia itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(OportunidadeDiaDadosParse dados) {
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new OportunidadeDiaListaCallbackHtml();
		OportunidadeDiaDadosParse dadosParse = new OportunidadeDiaDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		
		OportunidadeDiaDao daoFonte = DBB.getInstancia().getOportunidadeDiaDao(); // 
		daoFonte.setConexao(conexao);
		List<OportunidadeDia> lista = daoFonte.ListaCorrente();
		Iterator<OportunidadeDia> itLista = lista.iterator();
		while (itLista.hasNext()) {
			OportunidadeDia corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}