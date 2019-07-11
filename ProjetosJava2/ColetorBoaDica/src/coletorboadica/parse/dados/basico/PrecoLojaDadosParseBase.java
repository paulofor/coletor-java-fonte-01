package coletorboadica.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorboadica.dao.PrecoLojaDao;
import coletorboadica.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorboadica.parse.dados.*;
import coletorboadica.modelo.*;
import coletorboadica.log.ArquivoLog;
import org.json.JSONObject;



public abstract class PrecoLojaDadosParseBase extends DadosParseDao {

	protected PrecoLojaDao dao = null;
	protected PrecoLoja itemDetalhe = null;
	protected List<PrecoLoja> lista = null;
	
	private boolean debug;
	
	public void setDebug() {
		debug = true;
	}
	
	private String proximaPagina = null;
	public void setProximaPagina(String url) {
		proximaPagina = url;
	}
	@Override
	public void setJson(JSONObject json) {
		throw new RuntimeException("voce deve implmentar o metodo setJson em " + this.getClass().toString());
	}
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto PrecoLoja
	// Para listas usar itemCorrente.
	public PrecoLoja getItemDetalhe() {
		return itemDetalhe;
	}
	
	private PrecoLoja itemCorrente = null;
	
	
	public PrecoLojaDadosParseBase() {
		super();
		lista = new ArrayList<PrecoLoja>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public PrecoLoja getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(PrecoLoja item) {
		ArquivoLog.getInstancia().salvaLog("PrecoLoja(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(PrecoLoja item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("PrecoLoja(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPrecoLoja();
	}


	public void setItemDetalhe(PrecoLoja item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PrecoLojaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PrecoLojaDadosParse";
 	}

	
	private ProdutoComum _produtoComum_ReferenteA; 
	
	@Deprecated
	public void setProdutoComum_ReferenteA(ProdutoComum item) {
		_produtoComum_ReferenteA = item;
	}
	@Deprecated
	public ProdutoComum getProdutoComum_ReferenteA() {
		return _produtoComum_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getPrecoLojaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPrecoLojaDao();
			dao.setConexao(getConexao());
			List<PrecoLoja> listaBanco = dao.ListaCorrente();
			List<PrecoLoja> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<PrecoLoja> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<PrecoLoja> it = listaInclusao.iterator();
			while (it.hasNext()) {
				PrecoLoja item = it.next();
				System.out.println("PrecoLoja Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<PrecoLoja> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				PrecoLoja item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(PrecoLoja item, PrecoLojaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(PrecoLoja item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(PrecoLoja item) {
		try {
			dao = DBB.getInstancia().getPrecoLojaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<PrecoLoja> subtraiListaPorNome(List<PrecoLoja> listaMaior, List<PrecoLoja> listaMenor) {
		Iterator<PrecoLoja> itMaior = listaMaior.iterator();
		Iterator<PrecoLoja> itMenor = null;
		List<PrecoLoja> listaDiferenca = new ArrayList<PrecoLoja>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			PrecoLoja corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				PrecoLoja comparador = itMenor.next();
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
	protected boolean iguais(PrecoLoja item1, PrecoLoja item2) {
		throw new RuntimeException("Fazer override em PrecoLojaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(PrecoLoja item) {
		return "Fazer override em PrecoLojaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<PrecoLoja> lista, String codigo) {
		for (PrecoLoja item : lista) {
			ArquivoLog.getInstancia().salvaLog("PrecoLoja(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(PrecoLoja item) {
		StringBuffer display = new StringBuffer();
		display.append("PrecoLoja {");
		
		display.append("IdPrecoLoja:" + item.getIdPrecoLoja() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("NomeLoja:" + item.getNomeLoja() + ";");
		
		display.append("CodigoLoja:" + item.getCodigoLoja() + ";");
		
		display.append("Valor:" + item.getValor() + ";");
		
		display.append("BairroLoja:" + item.getBairroLoja() + ";");
		
		display.append("MunicipioLoja:" + item.getMunicipioLoja() + ";");
		
		display.append("IdProdutoComumRa:" + item.getIdProdutoComumRa() + ";");
		
		
		
		if (item.getProdutoComumReferenteA(false)!=null) {
			display.append("ProdutoComum{");
			display.append(ProdutoComumDadosParse.displayLog(item.getProdutoComumReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}