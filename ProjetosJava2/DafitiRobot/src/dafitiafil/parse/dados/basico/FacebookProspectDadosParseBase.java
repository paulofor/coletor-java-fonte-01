package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.FacebookProspectDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class FacebookProspectDadosParseBase extends DadosParseDao {

	protected FacebookProspectDao dao = null;
	protected FacebookProspect itemDetalhe = null;
	protected List<FacebookProspect> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto FacebookProspect
	// Para listas usar itemCorrente.
	public FacebookProspect getItemDetalhe() {
		return itemDetalhe;
	}
	
	private FacebookProspect itemCorrente = null;
	
	
	public FacebookProspectDadosParseBase() {
		super();
		lista = new ArrayList<FacebookProspect>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public FacebookProspect getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(FacebookProspect item) {
		ArquivoLog.getInstancia().salvaLog("FacebookProspect(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("FacebookProspect(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaFacebookProspect();
	}


	public void setItemDetalhe(FacebookProspect item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em FacebookProspectDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em FacebookProspectDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getFacebookProspectDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getFacebookProspectDao();
			dao.setConexao(getConexao());
			List<FacebookProspect> listaBanco = dao.ListaCorrente();
			List<FacebookProspect> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<FacebookProspect> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<FacebookProspect> it = listaInclusao.iterator();
			while (it.hasNext()) {
				FacebookProspect item = it.next();
				System.out.println("FacebookProspect Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<FacebookProspect> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				FacebookProspect item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(FacebookProspect item, FacebookProspectDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(FacebookProspect item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(FacebookProspect item) {
		try {
			dao = DBB.getInstancia().getFacebookProspectDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<FacebookProspect> subtraiListaPorNome(List<FacebookProspect> listaMaior, List<FacebookProspect> listaMenor) {
		Iterator<FacebookProspect> itMaior = listaMaior.iterator();
		Iterator<FacebookProspect> itMenor = null;
		List<FacebookProspect> listaDiferenca = new ArrayList<FacebookProspect>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			FacebookProspect corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				FacebookProspect comparador = itMenor.next();
				if (iguais(comparador,corrente)) {
					achou = true;
					break;
				}
			}
			if (!achou) {
				listaDiferenca.add(corrente);
			}
		}
		return listaDiferenca;
	}
	protected boolean iguais(FacebookProspect item1, FacebookProspect item2) {
		throw new RuntimeException("Fazer override em FacebookProspectDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(FacebookProspect item) {
		return "Fazer override em FacebookProspectDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<FacebookProspect> lista, String codigo) {
		for (FacebookProspect item : lista) {
			ArquivoLog.getInstancia().salvaLog("FacebookProspect(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(FacebookProspect item) {
		StringBuffer display = new StringBuffer();
		display.append("FacebookProspect {");
		
		display.append("IdFacebookProspect:" + item.getIdFacebookProspect() + ";");
		
		display.append("FacebookId:" + item.getFacebookId() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}