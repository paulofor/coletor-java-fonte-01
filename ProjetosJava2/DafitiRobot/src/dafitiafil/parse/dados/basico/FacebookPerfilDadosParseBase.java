package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.FacebookPerfilDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class FacebookPerfilDadosParseBase extends DadosParseDao {

	protected FacebookPerfilDao dao = null;
	protected FacebookPerfil itemDetalhe = null;
	protected List<FacebookPerfil> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto FacebookPerfil
	// Para listas usar itemCorrente.
	public FacebookPerfil getItemDetalhe() {
		return itemDetalhe;
	}
	
	private FacebookPerfil itemCorrente = null;
	
	//Recebe 
	private	FacebookFotoPost correnteFacebookFotoPost;
	protected List<FacebookFotoPost> listaFacebookFotoPost = new ArrayList<FacebookFotoPost>();
	
	@Deprecated
	public FacebookFotoPost getCorrenteFacebookFotoPost() {
		return correnteFacebookFotoPost;
	}
	@Deprecated
	public void adicionaCorrenteFacebookFotoPost() {
		correnteFacebookFotoPost.setIdFacebookPerfilEp(itemDetalhe.getIdFacebookPerfil());
		ArquivoLog.getInstancia().salvaLog("FacebookPerfil(adicionaCorrenteFacebookFotoPost):" + FacebookFotoPostDadosParseBase.displayLog(correnteFacebookFotoPost));
		listaFacebookFotoPost.add(correnteFacebookFotoPost);
	}
	@Deprecated
	public void criaCorrenteFacebookFotoPost() {
		correnteFacebookFotoPost = FabricaVo.criaFacebookFotoPost();
	}
 		
	//Possui 
	private	FacebookFanpage correnteFacebookFanpage;
	protected List<FacebookFanpage> listaFacebookFanpage = new ArrayList<FacebookFanpage>();
	
	@Deprecated
	public FacebookFanpage getCorrenteFacebookFanpage() {
		return correnteFacebookFanpage;
	}
	@Deprecated
	public void adicionaCorrenteFacebookFanpage() {
		correnteFacebookFanpage.setIdFacebookPerfilEe(itemDetalhe.getIdFacebookPerfil());
		ArquivoLog.getInstancia().salvaLog("FacebookPerfil(adicionaCorrenteFacebookFanpage):" + FacebookFanpageDadosParseBase.displayLog(correnteFacebookFanpage));
		listaFacebookFanpage.add(correnteFacebookFanpage);
	}
	@Deprecated
	public void criaCorrenteFacebookFanpage() {
		correnteFacebookFanpage = FabricaVo.criaFacebookFanpage();
	}
 		
	
	public FacebookPerfilDadosParseBase() {
		super();
		lista = new ArrayList<FacebookPerfil>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public FacebookPerfil getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(FacebookPerfil item) {
		ArquivoLog.getInstancia().salvaLog("FacebookPerfil(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("FacebookPerfil(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaFacebookPerfil();
	}


	public void setItemDetalhe(FacebookPerfil item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em FacebookPerfilDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em FacebookPerfilDadosParse";
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
 	
	private Produto _produto_Icone; 
	
	@Deprecated
	public void setProduto_Icone(Produto item) {
		_produto_Icone = item;
	}
	@Deprecated
	public Produto getProduto_Icone() {
		return _produto_Icone;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getFacebookPerfilDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getFacebookPerfilDao();
			dao.setConexao(getConexao());
			List<FacebookPerfil> listaBanco = dao.ListaCorrente();
			List<FacebookPerfil> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<FacebookPerfil> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<FacebookPerfil> it = listaInclusao.iterator();
			while (it.hasNext()) {
				FacebookPerfil item = it.next();
				System.out.println("FacebookPerfil Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<FacebookPerfil> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				FacebookPerfil item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(FacebookPerfil item, FacebookPerfilDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(FacebookPerfil item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(FacebookPerfil item) {
		try {
			dao = DBB.getInstancia().getFacebookPerfilDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<FacebookPerfil> subtraiListaPorNome(List<FacebookPerfil> listaMaior, List<FacebookPerfil> listaMenor) {
		Iterator<FacebookPerfil> itMaior = listaMaior.iterator();
		Iterator<FacebookPerfil> itMenor = null;
		List<FacebookPerfil> listaDiferenca = new ArrayList<FacebookPerfil>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			FacebookPerfil corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				FacebookPerfil comparador = itMenor.next();
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
	protected boolean iguais(FacebookPerfil item1, FacebookPerfil item2) {
		throw new RuntimeException("Fazer override em FacebookPerfilDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(FacebookPerfil item) {
		return "Fazer override em FacebookPerfilDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaFacebookFotoPost.clear();
		listaFacebookFanpage.clear();
	
	}
	
	
	public void displayLogLista(List<FacebookPerfil> lista, String codigo) {
		for (FacebookPerfil item : lista) {
			ArquivoLog.getInstancia().salvaLog("FacebookPerfil(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(FacebookPerfil item) {
		StringBuffer display = new StringBuffer();
		display.append("FacebookPerfil {");
		
		display.append("IdFacebookPerfil:" + item.getIdFacebookPerfil() + ";");
		
		display.append("FacebookId:" + item.getFacebookId() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("Sobrenome:" + item.getSobrenome() + ";");
		
		display.append("EmailUtilizado:" + item.getEmailUtilizado() + ";");
		
		display.append("AplicacaoNome:" + item.getAplicacaoNome() + ";");
		
		display.append("AplicacaoId:" + item.getAplicacaoId() + ";");
		
		display.append("AplicacaoChave:" + item.getAplicacaoChave() + ";");
		
		display.append("TokenAcesso:" + item.getTokenAcesso() + ";");
		
		display.append("ValorMaximoProduto:" + item.getValorMaximoProduto() + ";");
		
		display.append("ValorMinimoProduto:" + item.getValorMinimoProduto() + ";");
		
		display.append("IdCategoriaProdutoRa:" + item.getIdCategoriaProdutoRa() + ";");
		
		display.append("IdProdutoI:" + item.getIdProdutoI() + ";");
		
		
		
		if (item.getCategoriaProdutoReferenteA()!=null) {
			display.append("CategoriaProduto{");
			display.append(CategoriaProdutoDadosParse.displayLog(item.getCategoriaProdutoReferenteA()));
			display.append("}");
		}
 		
		if (item.getProdutoIcone()!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoIcone()));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}