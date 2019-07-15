package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.CategoriaProdutoProdutoDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class CategoriaProdutoProdutoDadosParseBase extends DadosParseDao {

	protected CategoriaProdutoProdutoDao dao = null;
	protected CategoriaProdutoProduto itemDetalhe = null;
	protected List<CategoriaProdutoProduto> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto CategoriaProdutoProduto
	// Para listas usar itemCorrente.
	public CategoriaProdutoProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private CategoriaProdutoProduto itemCorrente = null;
	
	
	public CategoriaProdutoProdutoDadosParseBase() {
		super();
		lista = new ArrayList<CategoriaProdutoProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public CategoriaProdutoProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(CategoriaProdutoProduto item) {
		ArquivoLog.getInstancia().salvaLog("CategoriaProdutoProduto(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("CategoriaProdutoProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCategoriaProdutoProduto();
	}


	public void setItemDetalhe(CategoriaProdutoProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CategoriaProdutoProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CategoriaProdutoProdutoDadosParse";
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
			dao = DBB.getInstancia().getCategoriaProdutoProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCategoriaProdutoProdutoDao();
			dao.setConexao(getConexao());
			List<CategoriaProdutoProduto> listaBanco = dao.ListaCorrente();
			List<CategoriaProdutoProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<CategoriaProdutoProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<CategoriaProdutoProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				CategoriaProdutoProduto item = it.next();
				System.out.println("CategoriaProdutoProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<CategoriaProdutoProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				CategoriaProdutoProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(CategoriaProdutoProduto item, CategoriaProdutoProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(CategoriaProdutoProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(CategoriaProdutoProduto item) {
		try {
			dao = DBB.getInstancia().getCategoriaProdutoProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<CategoriaProdutoProduto> subtraiListaPorNome(List<CategoriaProdutoProduto> listaMaior, List<CategoriaProdutoProduto> listaMenor) {
		Iterator<CategoriaProdutoProduto> itMaior = listaMaior.iterator();
		Iterator<CategoriaProdutoProduto> itMenor = null;
		List<CategoriaProdutoProduto> listaDiferenca = new ArrayList<CategoriaProdutoProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			CategoriaProdutoProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				CategoriaProdutoProduto comparador = itMenor.next();
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
	protected boolean iguais(CategoriaProdutoProduto item1, CategoriaProdutoProduto item2) {
		throw new RuntimeException("Fazer override em CategoriaProdutoProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(CategoriaProdutoProduto item) {
		return "Fazer override em CategoriaProdutoProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<CategoriaProdutoProduto> lista, String codigo) {
		for (CategoriaProdutoProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("CategoriaProdutoProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(CategoriaProdutoProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("CategoriaProdutoProduto {");
		
		display.append("IdCategoriaProdutoProduto:" + item.getIdCategoriaProdutoProduto() + ";");
		
		display.append("DataInclusao:" + item.getDataInclusao() + ";");
		
		display.append("IdCategoriaProdutoRa:" + item.getIdCategoriaProdutoRa() + ";");
		
		display.append("IdProdutoRa:" + item.getIdProdutoRa() + ";");
		
		
		
		if (item.getCategoriaProdutoReferenteA()!=null) {
			display.append("CategoriaProduto{");
			display.append(CategoriaProdutoDadosParse.displayLog(item.getCategoriaProdutoReferenteA()));
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