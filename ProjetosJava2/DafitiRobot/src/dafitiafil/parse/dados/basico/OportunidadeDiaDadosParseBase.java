package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.OportunidadeDiaDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class OportunidadeDiaDadosParseBase extends DadosParseDao {

	protected OportunidadeDiaDao dao = null;
	protected OportunidadeDia itemDetalhe = null;
	protected List<OportunidadeDia> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto OportunidadeDia
	// Para listas usar itemCorrente.
	public OportunidadeDia getItemDetalhe() {
		return itemDetalhe;
	}
	
	private OportunidadeDia itemCorrente = null;
	
	
	public OportunidadeDiaDadosParseBase() {
		super();
		lista = new ArrayList<OportunidadeDia>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public OportunidadeDia getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(OportunidadeDia item) {
		ArquivoLog.getInstancia().salvaLog("OportunidadeDia(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("OportunidadeDia(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaOportunidadeDia();
	}


	public void setItemDetalhe(OportunidadeDia item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em OportunidadeDiaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em OportunidadeDiaDadosParse";
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
			dao = DBB.getInstancia().getOportunidadeDiaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getOportunidadeDiaDao();
			dao.setConexao(getConexao());
			List<OportunidadeDia> listaBanco = dao.ListaCorrente();
			List<OportunidadeDia> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<OportunidadeDia> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<OportunidadeDia> it = listaInclusao.iterator();
			while (it.hasNext()) {
				OportunidadeDia item = it.next();
				System.out.println("OportunidadeDia Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<OportunidadeDia> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				OportunidadeDia item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(OportunidadeDia item, OportunidadeDiaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(OportunidadeDia item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(OportunidadeDia item) {
		try {
			dao = DBB.getInstancia().getOportunidadeDiaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<OportunidadeDia> subtraiListaPorNome(List<OportunidadeDia> listaMaior, List<OportunidadeDia> listaMenor) {
		Iterator<OportunidadeDia> itMaior = listaMaior.iterator();
		Iterator<OportunidadeDia> itMenor = null;
		List<OportunidadeDia> listaDiferenca = new ArrayList<OportunidadeDia>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			OportunidadeDia corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				OportunidadeDia comparador = itMenor.next();
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
	protected boolean iguais(OportunidadeDia item1, OportunidadeDia item2) {
		throw new RuntimeException("Fazer override em OportunidadeDiaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(OportunidadeDia item) {
		return "Fazer override em OportunidadeDiaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<OportunidadeDia> lista, String codigo) {
		for (OportunidadeDia item : lista) {
			ArquivoLog.getInstancia().salvaLog("OportunidadeDia(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(OportunidadeDia item) {
		StringBuffer display = new StringBuffer();
		display.append("OportunidadeDia {");
		
		display.append("IdOportunidadeDia:" + item.getIdOportunidadeDia() + ";");
		
		display.append("DataInicioPrecoAtual:" + item.getDataInicioPrecoAtual() + ";");
		
		display.append("NomeProduto:" + item.getNomeProduto() + ";");
		
		display.append("UrlProduto:" + item.getUrlProduto() + ";");
		
		display.append("ValorParcelaAtual:" + item.getValorParcelaAtual() + ";");
		
		display.append("ValorParcelaAnterior:" + item.getValorParcelaAnterior() + ";");
		
		display.append("QuantidadeParcelaAnterior:" + item.getQuantidadeParcelaAnterior() + ";");
		
		display.append("QuantidadeParcelaAtual:" + item.getQuantidadeParcelaAtual() + ";");
		
		display.append("ValorConsumidorAtual:" + item.getValorConsumidorAtual() + ";");
		
		display.append("ValorConsumidorAnterior:" + item.getValorConsumidorAnterior() + ";");
		
		display.append("PercentualAjusteAtual:" + item.getPercentualAjusteAtual() + ";");
		
		display.append("UrlImagem:" + item.getUrlImagem() + ";");
		
		display.append("ImagemLocal:" + item.getImagemLocal() + ";");
		
		display.append("QuantidadeExibicao:" + item.getQuantidadeExibicao() + ";");
		
		display.append("CodigoFacebook:" + item.getCodigoFacebook() + ";");
		
		display.append("DataUltimaPrecoAnterior:" + item.getDataUltimaPrecoAnterior() + ";");
		
		display.append("UrlAfiliado:" + item.getUrlAfiliado() + ";");
		
		display.append("NomeMarca:" + item.getNomeMarca() + ";");
		
		display.append("PosicaoProduto:" + item.getPosicaoProduto() + ";");
		
		display.append("IdProdutoRa:" + item.getIdProdutoRa() + ";");
		
		
		
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