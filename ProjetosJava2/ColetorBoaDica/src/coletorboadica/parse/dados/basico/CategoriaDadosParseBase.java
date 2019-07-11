package coletorboadica.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorboadica.dao.CategoriaDao;
import coletorboadica.dao.DBB;
import coletorboadica.log.ArquivoLog;
import coletorboadica.modelo.Categoria;
import coletorboadica.modelo.CategoriaProduto;
import coletorboadica.modelo.FabricaVo;



public abstract class CategoriaDadosParseBase extends DadosParseDao {

	protected CategoriaDao dao = null;
	protected Categoria itemDetalhe = null;
	protected List<Categoria> lista = null;
	
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
	// do Objeto Categoria
	// Para listas usar itemCorrente.
	public Categoria getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Categoria itemCorrente = null;
	
	//Associada 
	private	CategoriaProduto correnteCategoriaProduto;
	protected List<CategoriaProduto> listaCategoriaProduto = new ArrayList<CategoriaProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaCategoriaProduto(CategoriaProduto itemLista) {
		itemLista.setIdCategoriaA(itemDetalhe.getIdCategoria());
		//ArquivoLog.getInstancia().salvaLog("Categoria(adicionaCorrenteCategoriaProduto):" + CategoriaProdutoDadosParseBase.displayLog(correnteCategoriaProduto));
		listaCategoriaProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public CategoriaProduto getCorrenteCategoriaProduto() {
		return correnteCategoriaProduto;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaProduto() {
		correnteCategoriaProduto.setIdCategoriaA(itemDetalhe.getIdCategoria());
		ArquivoLog.getInstancia().salvaLog("Categoria(adicionaCorrenteCategoriaProduto):" + CategoriaProdutoDadosParseBase.displayLog(correnteCategoriaProduto));
		
		listaCategoriaProduto.add(correnteCategoriaProduto);
	}
	@Deprecated
	public void criaCorrenteCategoriaProduto() {
		correnteCategoriaProduto = FabricaVo.criaCategoriaProduto();
	}
 		
	
	public CategoriaDadosParseBase() {
		super();
		lista = new ArrayList<Categoria>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Categoria getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Categoria item) {
		ArquivoLog.getInstancia().salvaLog("Categoria(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(Categoria item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Categoria(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCategoria();
	}


	public void setItemDetalhe(Categoria item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CategoriaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CategoriaDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCategoriaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCategoriaDao();
			dao.setConexao(getConexao());
			List<Categoria> listaBanco = dao.ListaCorrente();
			List<Categoria> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Categoria> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Categoria> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Categoria item = it.next();
				System.out.println("Categoria Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Categoria> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Categoria item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Categoria item, CategoriaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Categoria item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Categoria item) {
		try {
			dao = DBB.getInstancia().getCategoriaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Categoria> subtraiListaPorNome(List<Categoria> listaMaior, List<Categoria> listaMenor) {
		Iterator<Categoria> itMaior = listaMaior.iterator();
		Iterator<Categoria> itMenor = null;
		List<Categoria> listaDiferenca = new ArrayList<Categoria>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Categoria corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Categoria comparador = itMenor.next();
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
	protected boolean iguais(Categoria item1, Categoria item2) {
		throw new RuntimeException("Fazer override em CategoriaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Categoria item) {
		return "Fazer override em CategoriaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaCategoriaProduto.clear();
	
	}
	
	
	public void displayLogLista(List<Categoria> lista, String codigo) {
		for (Categoria item : lista) {
			ArquivoLog.getInstancia().salvaLog("Categoria(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Categoria item) {
		StringBuffer display = new StringBuffer();
		display.append("Categoria {");
		
		display.append("IdCategoria:" + item.getIdCategoria() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("Url:" + item.getUrl() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}