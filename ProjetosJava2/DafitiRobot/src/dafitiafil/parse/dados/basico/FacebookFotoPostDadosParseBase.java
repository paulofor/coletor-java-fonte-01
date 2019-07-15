package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.FacebookFotoPostDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class FacebookFotoPostDadosParseBase extends DadosParseDao {

	protected FacebookFotoPostDao dao = null;
	protected FacebookFotoPost itemDetalhe = null;
	protected List<FacebookFotoPost> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto FacebookFotoPost
	// Para listas usar itemCorrente.
	public FacebookFotoPost getItemDetalhe() {
		return itemDetalhe;
	}
	
	private FacebookFotoPost itemCorrente = null;
	
	
	public FacebookFotoPostDadosParseBase() {
		super();
		lista = new ArrayList<FacebookFotoPost>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public FacebookFotoPost getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(FacebookFotoPost item) {
		ArquivoLog.getInstancia().salvaLog("FacebookFotoPost(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("FacebookFotoPost(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaFacebookFotoPost();
	}


	public void setItemDetalhe(FacebookFotoPost item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em FacebookFotoPostDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em FacebookFotoPostDadosParse";
 	}

	
	private FacebookFanpage _facebookFanpage_EnviadoPara; 
	
	@Deprecated
	public void setFacebookFanpage_EnviadoPara(FacebookFanpage item) {
		_facebookFanpage_EnviadoPara = item;
	}
	@Deprecated
	public FacebookFanpage getFacebookFanpage_EnviadoPara() {
		return _facebookFanpage_EnviadoPara;
	}
 	
	private FacebookPerfil _facebookPerfil_EnviadoPara; 
	
	@Deprecated
	public void setFacebookPerfil_EnviadoPara(FacebookPerfil item) {
		_facebookPerfil_EnviadoPara = item;
	}
	@Deprecated
	public FacebookPerfil getFacebookPerfil_EnviadoPara() {
		return _facebookPerfil_EnviadoPara;
	}
 	
	private Produto _produto_ReferenteA; 
	
	@Deprecated
	public void setProduto_ReferenteA(Produto item) {
		_produto_ReferenteA = item;
	}
	@Deprecated
	public Produto getProduto_ReferenteA() {
		return _produto_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getFacebookFotoPostDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getFacebookFotoPostDao();
			dao.setConexao(getConexao());
			List<FacebookFotoPost> listaBanco = dao.ListaCorrente();
			List<FacebookFotoPost> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<FacebookFotoPost> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<FacebookFotoPost> it = listaInclusao.iterator();
			while (it.hasNext()) {
				FacebookFotoPost item = it.next();
				System.out.println("FacebookFotoPost Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<FacebookFotoPost> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				FacebookFotoPost item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(FacebookFotoPost item, FacebookFotoPostDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(FacebookFotoPost item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(FacebookFotoPost item) {
		try {
			dao = DBB.getInstancia().getFacebookFotoPostDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<FacebookFotoPost> subtraiListaPorNome(List<FacebookFotoPost> listaMaior, List<FacebookFotoPost> listaMenor) {
		Iterator<FacebookFotoPost> itMaior = listaMaior.iterator();
		Iterator<FacebookFotoPost> itMenor = null;
		List<FacebookFotoPost> listaDiferenca = new ArrayList<FacebookFotoPost>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			FacebookFotoPost corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				FacebookFotoPost comparador = itMenor.next();
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
	protected boolean iguais(FacebookFotoPost item1, FacebookFotoPost item2) {
		throw new RuntimeException("Fazer override em FacebookFotoPostDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(FacebookFotoPost item) {
		return "Fazer override em FacebookFotoPostDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<FacebookFotoPost> lista, String codigo) {
		for (FacebookFotoPost item : lista) {
			ArquivoLog.getInstancia().salvaLog("FacebookFotoPost(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(FacebookFotoPost item) {
		StringBuffer display = new StringBuffer();
		display.append("FacebookFotoPost {");
		
		display.append("IdFacebookFotoPost:" + item.getIdFacebookFotoPost() + ";");
		
		display.append("DataHora:" + item.getDataHora() + ";");
		
		display.append("FacebookId:" + item.getFacebookId() + ";");
		
		display.append("QtdeClick:" + item.getQtdeClick() + ";");
		
		display.append("Mensagem:" + item.getMensagem() + ";");
		
		display.append("PrecoConsumidor:" + item.getPrecoConsumidor() + ";");
		
		display.append("IdFacebookFanpageEp:" + item.getIdFacebookFanpageEp() + ";");
		
		display.append("IdFacebookPerfilEp:" + item.getIdFacebookPerfilEp() + ";");
		
		display.append("IdProdutoRa:" + item.getIdProdutoRa() + ";");
		
		
		
		if (item.getFacebookFanpageEnviadoPara()!=null) {
			display.append("FacebookFanpage{");
			display.append(FacebookFanpageDadosParse.displayLog(item.getFacebookFanpageEnviadoPara()));
			display.append("}");
		}
 		
		if (item.getFacebookPerfilEnviadoPara()!=null) {
			display.append("FacebookPerfil{");
			display.append(FacebookPerfilDadosParse.displayLog(item.getFacebookPerfilEnviadoPara()));
			display.append("}");
		}
 		
		if (item.getProdutoReferenteA()!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoReferenteA()));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}