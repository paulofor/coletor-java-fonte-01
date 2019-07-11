package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.PrecoProdutoDiarioDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class PrecoProdutoDiarioDadosParseBase extends DadosParseDao {

	protected PrecoProdutoDiarioDao dao = null;
	protected PrecoProdutoDiario itemDetalhe = null;
	protected List<PrecoProdutoDiario> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto PrecoProdutoDiario
	// Para listas usar itemCorrente.
	public PrecoProdutoDiario getItemDetalhe() {
		return itemDetalhe;
	}
	
	private PrecoProdutoDiario itemCorrente = null;
	
	
	public PrecoProdutoDiarioDadosParseBase() {
		super();
		lista = new ArrayList<PrecoProdutoDiario>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public PrecoProdutoDiario getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(PrecoProdutoDiario item) {
		ArquivoLog.getInstancia().salvaLog("PrecoProdutoDiario(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("PrecoProdutoDiario(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPrecoProdutoDiario();
	}


	public void setItemDetalhe(PrecoProdutoDiario item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PrecoProdutoDiarioDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PrecoProdutoDiarioDadosParse";
 	}

	
	private Produto _produto_PertenceA; 
	
	@Deprecated
	public void setProduto_PertenceA(Produto item) {
		_produto_PertenceA = item;
	}
	@Deprecated
	public Produto getProduto_PertenceA() {
		return _produto_PertenceA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getPrecoProdutoDiarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPrecoProdutoDiarioDao();
			dao.setConexao(getConexao());
			List<PrecoProdutoDiario> listaBanco = dao.ListaCorrente();
			List<PrecoProdutoDiario> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<PrecoProdutoDiario> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<PrecoProdutoDiario> it = listaInclusao.iterator();
			while (it.hasNext()) {
				PrecoProdutoDiario item = it.next();
				System.out.println("PrecoProdutoDiario Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<PrecoProdutoDiario> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				PrecoProdutoDiario item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(PrecoProdutoDiario item, PrecoProdutoDiarioDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(PrecoProdutoDiario item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(PrecoProdutoDiario item) {
		try {
			dao = DBB.getInstancia().getPrecoProdutoDiarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<PrecoProdutoDiario> subtraiListaPorNome(List<PrecoProdutoDiario> listaMaior, List<PrecoProdutoDiario> listaMenor) {
		Iterator<PrecoProdutoDiario> itMaior = listaMaior.iterator();
		Iterator<PrecoProdutoDiario> itMenor = null;
		List<PrecoProdutoDiario> listaDiferenca = new ArrayList<PrecoProdutoDiario>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			PrecoProdutoDiario corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				PrecoProdutoDiario comparador = itMenor.next();
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
	protected boolean iguais(PrecoProdutoDiario item1, PrecoProdutoDiario item2) {
		throw new RuntimeException("Fazer override em PrecoProdutoDiarioDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(PrecoProdutoDiario item) {
		return "Fazer override em PrecoProdutoDiarioDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<PrecoProdutoDiario> lista, String codigo) {
		for (PrecoProdutoDiario item : lista) {
			ArquivoLog.getInstancia().salvaLog("PrecoProdutoDiario(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(PrecoProdutoDiario item) {
		StringBuffer display = new StringBuffer();
		display.append("PrecoProdutoDiario {");
		
		display.append("IdPrecoProdutoDiario:" + item.getIdPrecoProdutoDiario() + ";");
		
		display.append("ValorPrecoAvista:" + item.getValorPrecoAvista() + ";");
		
		display.append("QuantidadeParcela:" + item.getQuantidadeParcela() + ";");
		
		display.append("DataVisita:" + item.getDataVisita() + ";");
		
		display.append("ValorParcela:" + item.getValorParcela() + ";");
		
		display.append("PrecoPromocional:" + item.getPrecoPromocional() + ";");
		
		display.append("ValorConsumidor:" + item.getValorConsumidor() + ";");
		
		display.append("IdProdutoPa:" + item.getIdProdutoPa() + ";");
		
		
		
		if (item.getProdutoPertenceA()!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoPertenceA()));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}