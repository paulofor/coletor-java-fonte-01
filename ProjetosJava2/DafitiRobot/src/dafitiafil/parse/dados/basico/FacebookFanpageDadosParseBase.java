package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.FacebookFanpageDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class FacebookFanpageDadosParseBase extends DadosParseDao {

	protected FacebookFanpageDao dao = null;
	protected FacebookFanpage itemDetalhe = null;
	protected List<FacebookFanpage> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto FacebookFanpage
	// Para listas usar itemCorrente.
	public FacebookFanpage getItemDetalhe() {
		return itemDetalhe;
	}
	
	private FacebookFanpage itemCorrente = null;
	
	//Recebe 
	private	FacebookFotoPost correnteFacebookFotoPost;
	protected List<FacebookFotoPost> listaFacebookFotoPost = new ArrayList<FacebookFotoPost>();
	
	@Deprecated
	public FacebookFotoPost getCorrenteFacebookFotoPost() {
		return correnteFacebookFotoPost;
	}
	@Deprecated
	public void adicionaCorrenteFacebookFotoPost() {
		correnteFacebookFotoPost.setIdFacebookFanpageEp(itemDetalhe.getIdFacebookFanpage());
		ArquivoLog.getInstancia().salvaLog("FacebookFanpage(adicionaCorrenteFacebookFotoPost):" + FacebookFotoPostDadosParseBase.displayLog(correnteFacebookFotoPost));
		listaFacebookFotoPost.add(correnteFacebookFotoPost);
	}
	@Deprecated
	public void criaCorrenteFacebookFotoPost() {
		correnteFacebookFotoPost = FabricaVo.criaFacebookFotoPost();
	}
 		
	
	public FacebookFanpageDadosParseBase() {
		super();
		lista = new ArrayList<FacebookFanpage>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public FacebookFanpage getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(FacebookFanpage item) {
		ArquivoLog.getInstancia().salvaLog("FacebookFanpage(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("FacebookFanpage(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaFacebookFanpage();
	}


	public void setItemDetalhe(FacebookFanpage item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em FacebookFanpageDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em FacebookFanpageDadosParse";
 	}

	
	private FacebookPerfil _facebookPerfil_EstaEm; 
	
	@Deprecated
	public void setFacebookPerfil_EstaEm(FacebookPerfil item) {
		_facebookPerfil_EstaEm = item;
	}
	@Deprecated
	public FacebookPerfil getFacebookPerfil_EstaEm() {
		return _facebookPerfil_EstaEm;
	}
 	
	private CategoriaProduto _categoriaProduto_ReferenteA; 
	
	@Deprecated
	public void setCategoriaProduto_ReferenteA(CategoriaProduto item) {
		_categoriaProduto_ReferenteA = item;
	}
	@Deprecated
	public CategoriaProduto getCategoriaProduto_ReferenteA() {
		return _categoriaProduto_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getFacebookFanpageDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getFacebookFanpageDao();
			dao.setConexao(getConexao());
			List<FacebookFanpage> listaBanco = dao.ListaCorrente();
			List<FacebookFanpage> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<FacebookFanpage> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<FacebookFanpage> it = listaInclusao.iterator();
			while (it.hasNext()) {
				FacebookFanpage item = it.next();
				System.out.println("FacebookFanpage Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<FacebookFanpage> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				FacebookFanpage item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(FacebookFanpage item, FacebookFanpageDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(FacebookFanpage item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(FacebookFanpage item) {
		try {
			dao = DBB.getInstancia().getFacebookFanpageDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<FacebookFanpage> subtraiListaPorNome(List<FacebookFanpage> listaMaior, List<FacebookFanpage> listaMenor) {
		Iterator<FacebookFanpage> itMaior = listaMaior.iterator();
		Iterator<FacebookFanpage> itMenor = null;
		List<FacebookFanpage> listaDiferenca = new ArrayList<FacebookFanpage>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			FacebookFanpage corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				FacebookFanpage comparador = itMenor.next();
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
	protected boolean iguais(FacebookFanpage item1, FacebookFanpage item2) {
		throw new RuntimeException("Fazer override em FacebookFanpageDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(FacebookFanpage item) {
		return "Fazer override em FacebookFanpageDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaFacebookFotoPost.clear();
	
	}
	
	
	public void displayLogLista(List<FacebookFanpage> lista, String codigo) {
		for (FacebookFanpage item : lista) {
			ArquivoLog.getInstancia().salvaLog("FacebookFanpage(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(FacebookFanpage item) {
		StringBuffer display = new StringBuffer();
		display.append("FacebookFanpage {");
		
		display.append("IdFacebookFanpage:" + item.getIdFacebookFanpage() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("FacebookId:" + item.getFacebookId() + ";");
		
		display.append("IdFacebookPerfilEe:" + item.getIdFacebookPerfilEe() + ";");
		
		display.append("IdCategoriaProdutoRa:" + item.getIdCategoriaProdutoRa() + ";");
		
		
		
		if (item.getFacebookPerfilEstaEm()!=null) {
			display.append("FacebookPerfil{");
			display.append(FacebookPerfilDadosParse.displayLog(item.getFacebookPerfilEstaEm()));
			display.append("}");
		}
 		
		if (item.getCategoriaProdutoReferenteA()!=null) {
			display.append("CategoriaProduto{");
			display.append(CategoriaProdutoDadosParse.displayLog(item.getCategoriaProdutoReferenteA()));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}