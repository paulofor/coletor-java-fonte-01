package dafitiafil.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dafitiafil.dao.UsuarioDao;
import dafitiafil.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import dafitiafil.parse.dados.*;
import dafitiafil.modelo.*;
import br.com.digicom.parse.log.ArquivoLog;


public abstract class UsuarioDadosParseBase extends DadosParseDao {

	protected UsuarioDao dao = null;
	protected Usuario itemDetalhe = null;
	protected List<Usuario> lista = null;
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto Usuario
	// Para listas usar itemCorrente.
	public Usuario getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Usuario itemCorrente = null;
	
	
	public UsuarioDadosParseBase() {
		super();
		lista = new ArrayList<Usuario>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Usuario getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Usuario item) {
		ArquivoLog.getInstancia().salvaLog("Usuario(adicionaCorrenteExterno):" + displayLog(item));
		lista.add(item);
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Usuario(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaUsuario();
	}


	public void setItemDetalhe(Usuario item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em UsuarioDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em UsuarioDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getUsuarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getUsuarioDao();
			dao.setConexao(getConexao());
			List<Usuario> listaBanco = dao.ListaCorrente();
			List<Usuario> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Usuario> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Usuario> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Usuario item = it.next();
				System.out.println("Usuario Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Usuario> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Usuario item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Usuario item, UsuarioDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Usuario item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Usuario item) {
		try {
			dao = DBB.getInstancia().getUsuarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> subtraiListaPorNome(List<Usuario> listaMaior, List<Usuario> listaMenor) {
		Iterator<Usuario> itMaior = listaMaior.iterator();
		Iterator<Usuario> itMenor = null;
		List<Usuario> listaDiferenca = new ArrayList<Usuario>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Usuario corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Usuario comparador = itMenor.next();
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
	protected boolean iguais(Usuario item1, Usuario item2) {
		throw new RuntimeException("Fazer override em UsuarioDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Usuario item) {
		return "Fazer override em UsuarioDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<Usuario> lista, String codigo) {
		for (Usuario item : lista) {
			ArquivoLog.getInstancia().salvaLog("Usuario(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Usuario item) {
		StringBuffer display = new StringBuffer();
		display.append("Usuario {");
		
		display.append("IdUsuario:" + item.getIdUsuario() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}