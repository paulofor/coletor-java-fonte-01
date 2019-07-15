package coletorboadica.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorboadica.dao.ProdutoComumDao;
import coletorboadica.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorboadica.parse.dados.*;
import coletorboadica.modelo.*;
import coletorboadica.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ProdutoComumDadosParseBase extends DadosParseDao {

	protected ProdutoComumDao dao = null;
	protected ProdutoComum itemDetalhe = null;
	protected List<ProdutoComum> lista = null;
	
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
	// do Objeto ProdutoComum
	// Para listas usar itemCorrente.
	public ProdutoComum getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ProdutoComum itemCorrente = null;
	
	//Possui 
	private	PrecoLoja correntePrecoLoja;
	protected List<PrecoLoja> listaPrecoLoja = new ArrayList<PrecoLoja>();
	
	// Adicionado em 01-08-2016
	public void adicionaPrecoLoja(PrecoLoja itemLista) {
		itemLista.setIdProdutoComumRa(itemDetalhe.getIdProdutoComum());
		//ArquivoLog.getInstancia().salvaLog("ProdutoComum(adicionaCorrentePrecoLoja):" + PrecoLojaDadosParseBase.displayLog(correntePrecoLoja));
		listaPrecoLoja.add(itemLista);
	}
	
	
	
	@Deprecated
	public PrecoLoja getCorrentePrecoLoja() {
		return correntePrecoLoja;
	}
	@Deprecated
	public void adicionaCorrentePrecoLoja() {
		correntePrecoLoja.setIdProdutoComumRa(itemDetalhe.getIdProdutoComum());
		ArquivoLog.getInstancia().salvaLog("ProdutoComum(adicionaCorrentePrecoLoja):" + PrecoLojaDadosParseBase.displayLog(correntePrecoLoja));
		
		listaPrecoLoja.add(correntePrecoLoja);
	}
	@Deprecated
	public void criaCorrentePrecoLoja() {
		correntePrecoLoja = FabricaVo.criaPrecoLoja();
	}
 		
	//Associada 
	private	CategoriaProduto correnteCategoriaProduto;
	protected List<CategoriaProduto> listaCategoriaProduto = new ArrayList<CategoriaProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaCategoriaProduto(CategoriaProduto itemLista) {
		itemLista.setIdProdutoComumA(itemDetalhe.getIdProdutoComum());
		//ArquivoLog.getInstancia().salvaLog("ProdutoComum(adicionaCorrenteCategoriaProduto):" + CategoriaProdutoDadosParseBase.displayLog(correnteCategoriaProduto));
		listaCategoriaProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public CategoriaProduto getCorrenteCategoriaProduto() {
		return correnteCategoriaProduto;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaProduto() {
		correnteCategoriaProduto.setIdProdutoComumA(itemDetalhe.getIdProdutoComum());
		ArquivoLog.getInstancia().salvaLog("ProdutoComum(adicionaCorrenteCategoriaProduto):" + CategoriaProdutoDadosParseBase.displayLog(correnteCategoriaProduto));
		
		listaCategoriaProduto.add(correnteCategoriaProduto);
	}
	@Deprecated
	public void criaCorrenteCategoriaProduto() {
		correnteCategoriaProduto = FabricaVo.criaCategoriaProduto();
	}
 		
	
	public ProdutoComumDadosParseBase() {
		super();
		lista = new ArrayList<ProdutoComum>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ProdutoComum getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ProdutoComum item) {
		ArquivoLog.getInstancia().salvaLog("ProdutoComum(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ProdutoComum item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ProdutoComum(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaProdutoComum();
	}


	public void setItemDetalhe(ProdutoComum item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ProdutoComumDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ProdutoComumDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getProdutoComumDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getProdutoComumDao();
			dao.setConexao(getConexao());
			List<ProdutoComum> listaBanco = dao.ListaCorrente();
			List<ProdutoComum> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ProdutoComum> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ProdutoComum> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ProdutoComum item = it.next();
				System.out.println("ProdutoComum Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ProdutoComum> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ProdutoComum item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ProdutoComum item, ProdutoComumDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ProdutoComum item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ProdutoComum item) {
		try {
			dao = DBB.getInstancia().getProdutoComumDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProdutoComum> subtraiListaPorNome(List<ProdutoComum> listaMaior, List<ProdutoComum> listaMenor) {
		Iterator<ProdutoComum> itMaior = listaMaior.iterator();
		Iterator<ProdutoComum> itMenor = null;
		List<ProdutoComum> listaDiferenca = new ArrayList<ProdutoComum>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ProdutoComum corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ProdutoComum comparador = itMenor.next();
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
	protected boolean iguais(ProdutoComum item1, ProdutoComum item2) {
		throw new RuntimeException("Fazer override em ProdutoComumDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ProdutoComum item) {
		return "Fazer override em ProdutoComumDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaPrecoLoja.clear();
		listaCategoriaProduto.clear();
	
	}
	
	
	public void displayLogLista(List<ProdutoComum> lista, String codigo) {
		for (ProdutoComum item : lista) {
			ArquivoLog.getInstancia().salvaLog("ProdutoComum(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ProdutoComum item) {
		StringBuffer display = new StringBuffer();
		display.append("ProdutoComum {");
		
		display.append("IdProdutoComum:" + item.getIdProdutoComum() + ";");
		
		display.append("NomeProduto:" + item.getNomeProduto() + ";");
		
		display.append("Marca:" + item.getMarca() + ";");
		
		display.append("Descricao:" + item.getDescricao() + ";");
		
		display.append("Url:" + item.getUrl() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}