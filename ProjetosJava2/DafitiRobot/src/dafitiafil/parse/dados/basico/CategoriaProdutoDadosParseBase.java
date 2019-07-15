package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.CategoriaProdutoDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class CategoriaProdutoDadosParseBase extends DadosParseDao {

	protected CategoriaProdutoDao dao = null;
	protected CategoriaProduto itemDetalhe = null;
	protected List<CategoriaProduto> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto CategoriaProduto
	// Para listas usar itemCorrente.
	public CategoriaProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private CategoriaProduto itemCorrente = null;
	
	//Possui 
	private	CategoriaProdutoProduto correnteCategoriaProdutoProduto;
	protected List<CategoriaProdutoProduto> listaCategoriaProdutoProduto = new ArrayList<CategoriaProdutoProduto>();
	
	@Deprecated
	public CategoriaProdutoProduto getCorrenteCategoriaProdutoProduto() {
		return correnteCategoriaProdutoProduto;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaProdutoProduto() {
		correnteCategoriaProdutoProduto.setIdCategoriaProdutoRa(itemDetalhe.getIdCategoriaProduto());
		ArquivoLog.getInstancia().salvaLog("CategoriaProduto(adicionaCorrenteCategoriaProdutoProduto):" + CategoriaProdutoProdutoDadosParseBase.displayLog(correnteCategoriaProdutoProduto));
		listaCategoriaProdutoProduto.add(correnteCategoriaProdutoProduto);
	}
	@Deprecated
	public void criaCorrenteCategoriaProdutoProduto() {
		correnteCategoriaProdutoProduto = FabricaVo.criaCategoriaProdutoProduto();
	}
 		
	//Gera 
	private	FacebookPerfil correnteFacebookPerfil;
	protected List<FacebookPerfil> listaFacebookPerfil = new ArrayList<FacebookPerfil>();
	
	@Deprecated
	public FacebookPerfil getCorrenteFacebookPerfil() {
		return correnteFacebookPerfil;
	}
	@Deprecated
	public void adicionaCorrenteFacebookPerfil() {
		correnteFacebookPerfil.setIdCategoriaProdutoRa(itemDetalhe.getIdCategoriaProduto());
		ArquivoLog.getInstancia().salvaLog("CategoriaProduto(adicionaCorrenteFacebookPerfil):" + FacebookPerfilDadosParseBase.displayLog(correnteFacebookPerfil));
		listaFacebookPerfil.add(correnteFacebookPerfil);
	}
	@Deprecated
	public void criaCorrenteFacebookPerfil() {
		correnteFacebookPerfil = FabricaVo.criaFacebookPerfil();
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
		correnteFacebookFanpage.setIdCategoriaProdutoRa(itemDetalhe.getIdCategoriaProduto());
		ArquivoLog.getInstancia().salvaLog("CategoriaProduto(adicionaCorrenteFacebookFanpage):" + FacebookFanpageDadosParseBase.displayLog(correnteFacebookFanpage));
		listaFacebookFanpage.add(correnteFacebookFanpage);
	}
	@Deprecated
	public void criaCorrenteFacebookFanpage() {
		correnteFacebookFanpage = FabricaVo.criaFacebookFanpage();
	}
 		
	
	public CategoriaProdutoDadosParseBase() {
		super();
		lista = new ArrayList<CategoriaProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public CategoriaProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(CategoriaProduto item) {
		ArquivoLog.getInstancia().salvaLog("CategoriaProduto(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("CategoriaProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCategoriaProduto();
	}


	public void setItemDetalhe(CategoriaProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CategoriaProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CategoriaProdutoDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCategoriaProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCategoriaProdutoDao();
			dao.setConexao(getConexao());
			List<CategoriaProduto> listaBanco = dao.ListaCorrente();
			List<CategoriaProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<CategoriaProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<CategoriaProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				CategoriaProduto item = it.next();
				System.out.println("CategoriaProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<CategoriaProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				CategoriaProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(CategoriaProduto item, CategoriaProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(CategoriaProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(CategoriaProduto item) {
		try {
			dao = DBB.getInstancia().getCategoriaProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<CategoriaProduto> subtraiListaPorNome(List<CategoriaProduto> listaMaior, List<CategoriaProduto> listaMenor) {
		Iterator<CategoriaProduto> itMaior = listaMaior.iterator();
		Iterator<CategoriaProduto> itMenor = null;
		List<CategoriaProduto> listaDiferenca = new ArrayList<CategoriaProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			CategoriaProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				CategoriaProduto comparador = itMenor.next();
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
	protected boolean iguais(CategoriaProduto item1, CategoriaProduto item2) {
		throw new RuntimeException("Fazer override em CategoriaProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(CategoriaProduto item) {
		return "Fazer override em CategoriaProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaCategoriaProdutoProduto.clear();
		listaFacebookPerfil.clear();
		listaFacebookFanpage.clear();
	
	}
	
	
	public void displayLogLista(List<CategoriaProduto> lista, String codigo) {
		for (CategoriaProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("CategoriaProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(CategoriaProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("CategoriaProduto {");
		
		display.append("IdCategoriaProduto:" + item.getIdCategoriaProduto() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("Url:" + item.getUrl() + ";");
		
		display.append("DataInclusao:" + item.getDataInclusao() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}