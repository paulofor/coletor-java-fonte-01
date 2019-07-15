package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.ProdutoDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class ProdutoDadosParseBase extends DadosParseDao {

	protected ProdutoDao dao = null;
	protected Produto itemDetalhe = null;
	protected List<Produto> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto Produto
	// Para listas usar itemCorrente.
	public Produto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Produto itemCorrente = null;
	
	//Possui 
	private	CategoriaProdutoProduto correnteCategoriaProdutoProduto;
	protected List<CategoriaProdutoProduto> listaCategoriaProdutoProduto = new ArrayList<CategoriaProdutoProduto>();
	
	@Deprecated
	public CategoriaProdutoProduto getCorrenteCategoriaProdutoProduto() {
		return correnteCategoriaProdutoProduto;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaProdutoProduto() {
		correnteCategoriaProdutoProduto.setIdProdutoRa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteCategoriaProdutoProduto):" + CategoriaProdutoProdutoDadosParseBase.displayLog(correnteCategoriaProdutoProduto));
		listaCategoriaProdutoProduto.add(correnteCategoriaProdutoProduto);
	}
	@Deprecated
	public void criaCorrenteCategoriaProdutoProduto() {
		correnteCategoriaProdutoProduto = FabricaVo.criaCategoriaProdutoProduto();
	}
 		
	//Possui 
	private	PrecoProduto correntePrecoProduto;
	protected List<PrecoProduto> listaPrecoProduto = new ArrayList<PrecoProduto>();
	
	@Deprecated
	public PrecoProduto getCorrentePrecoProduto() {
		return correntePrecoProduto;
	}
	@Deprecated
	public void adicionaCorrentePrecoProduto() {
		correntePrecoProduto.setIdProdutoPa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrentePrecoProduto):" + PrecoProdutoDadosParseBase.displayLog(correntePrecoProduto));
		listaPrecoProduto.add(correntePrecoProduto);
	}
	@Deprecated
	public void criaCorrentePrecoProduto() {
		correntePrecoProduto = FabricaVo.criaPrecoProduto();
	}
 		
	//PodePossuir 
	private	OportunidadeDia correnteOportunidadeDia;
	protected List<OportunidadeDia> listaOportunidadeDia = new ArrayList<OportunidadeDia>();
	
	@Deprecated
	public OportunidadeDia getCorrenteOportunidadeDia() {
		return correnteOportunidadeDia;
	}
	@Deprecated
	public void adicionaCorrenteOportunidadeDia() {
		correnteOportunidadeDia.setIdProdutoRa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteOportunidadeDia):" + OportunidadeDiaDadosParseBase.displayLog(correnteOportunidadeDia));
		listaOportunidadeDia.add(correnteOportunidadeDia);
	}
	@Deprecated
	public void criaCorrenteOportunidadeDia() {
		correnteOportunidadeDia = FabricaVo.criaOportunidadeDia();
	}
 		
	//Possui 
	private	PrecoProdutoDiario correntePrecoProdutoDiario;
	protected List<PrecoProdutoDiario> listaPrecoProdutoDiario = new ArrayList<PrecoProdutoDiario>();
	
	@Deprecated
	public PrecoProdutoDiario getCorrentePrecoProdutoDiario() {
		return correntePrecoProdutoDiario;
	}
	@Deprecated
	public void adicionaCorrentePrecoProdutoDiario() {
		correntePrecoProdutoDiario.setIdProdutoPa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrentePrecoProdutoDiario):" + PrecoProdutoDiarioDadosParseBase.displayLog(correntePrecoProdutoDiario));
		listaPrecoProdutoDiario.add(correntePrecoProdutoDiario);
	}
	@Deprecated
	public void criaCorrentePrecoProdutoDiario() {
		correntePrecoProdutoDiario = FabricaVo.criaPrecoProdutoDiario();
	}
 		
	//Gerou 
	private	FacebookFotoPost correnteFacebookFotoPost;
	protected List<FacebookFotoPost> listaFacebookFotoPost = new ArrayList<FacebookFotoPost>();
	
	@Deprecated
	public FacebookFotoPost getCorrenteFacebookFotoPost() {
		return correnteFacebookFotoPost;
	}
	@Deprecated
	public void adicionaCorrenteFacebookFotoPost() {
		correnteFacebookFotoPost.setIdProdutoRa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteFacebookFotoPost):" + FacebookFotoPostDadosParseBase.displayLog(correnteFacebookFotoPost));
		listaFacebookFotoPost.add(correnteFacebookFotoPost);
	}
	@Deprecated
	public void criaCorrenteFacebookFotoPost() {
		correnteFacebookFotoPost = FabricaVo.criaFacebookFotoPost();
	}
 		
	//Aparece 
	private	FacebookPerfil correnteFacebookPerfil;
	protected List<FacebookPerfil> listaFacebookPerfil = new ArrayList<FacebookPerfil>();
	
	@Deprecated
	public FacebookPerfil getCorrenteFacebookPerfil() {
		return correnteFacebookPerfil;
	}
	@Deprecated
	public void adicionaCorrenteFacebookPerfil() {
		correnteFacebookPerfil.setIdProdutoI(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteFacebookPerfil):" + FacebookPerfilDadosParseBase.displayLog(correnteFacebookPerfil));
		listaFacebookPerfil.add(correnteFacebookPerfil);
	}
	@Deprecated
	public void criaCorrenteFacebookPerfil() {
		correnteFacebookPerfil = FabricaVo.criaFacebookPerfil();
	}
 		
	
	public ProdutoDadosParseBase() {
		super();
		lista = new ArrayList<Produto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Produto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Produto item) {
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaProduto();
	}


	public void setItemDetalhe(Produto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ProdutoDadosParse";
 	}

	
	private Marca _marca_PertenceA; 
	
	@Deprecated
	public void setMarca_PertenceA(Marca item) {
		_marca_PertenceA = item;
	}
	@Deprecated
	public Marca getMarca_PertenceA() {
		return _marca_PertenceA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getProdutoDao();
			dao.setConexao(getConexao());
			List<Produto> listaBanco = dao.ListaCorrente();
			List<Produto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Produto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Produto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Produto item = it.next();
				System.out.println("Produto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Produto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Produto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Produto item, ProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Produto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Produto item) {
		try {
			dao = DBB.getInstancia().getProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> subtraiListaPorNome(List<Produto> listaMaior, List<Produto> listaMenor) {
		Iterator<Produto> itMaior = listaMaior.iterator();
		Iterator<Produto> itMenor = null;
		List<Produto> listaDiferenca = new ArrayList<Produto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Produto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Produto comparador = itMenor.next();
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
	protected boolean iguais(Produto item1, Produto item2) {
		throw new RuntimeException("Fazer override em ProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Produto item) {
		return "Fazer override em ProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaCategoriaProdutoProduto.clear();
		listaPrecoProduto.clear();
		listaOportunidadeDia.clear();
		listaPrecoProdutoDiario.clear();
		listaFacebookFotoPost.clear();
		listaFacebookPerfil.clear();
	
	}
	
	
	public void displayLogLista(List<Produto> lista, String codigo) {
		for (Produto item : lista) {
			ArquivoLog.getInstancia().salvaLog("Produto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Produto item) {
		StringBuffer display = new StringBuffer();
		display.append("Produto {");
		
		display.append("IdProduto:" + item.getIdProduto() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("Url:" + item.getUrl() + ";");
		
		display.append("Imagem:" + item.getImagem() + ";");
		
		display.append("TamanhoImagem:" + item.getTamanhoImagem() + ";");
		
		display.append("DataInclusao:" + item.getDataInclusao() + ";");
		
		display.append("ImagemLocal:" + item.getImagemLocal() + ";");
		
		display.append("UrlOrigem:" + item.getUrlOrigem() + ";");
		
		display.append("UrlAfiliado:" + item.getUrlAfiliado() + ";");
		
		display.append("PosicaoProduto:" + item.getPosicaoProduto() + ";");
		
		display.append("IdMarcaPa:" + item.getIdMarcaPa() + ";");
		
		
		
		if (item.getMarcaPertenceA()!=null) {
			display.append("Marca{");
			display.append(MarcaDadosParse.displayLog(item.getMarcaPertenceA()));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}