package coletorboadica.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorboadica.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ProdutoComumAgregado implements ProdutoComumAgregadoI
	{
		
		private ProdutoComumCarregador carregador = null;
		private ProdutoComumCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ProdutoComumCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private ProdutoComum vo;
		public ProdutoComumAgregado(ProdutoComum item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaPrecoLoja_Possui() {
			return listaprecoLojaPossui!= null;
		}
		private List<PrecoLoja> listaprecoLojaPossui;
		public void setListaPrecoLoja_Possui(List<PrecoLoja> value) 
		{	
			listaprecoLojaPossui = value;
		} 
		public List<PrecoLoja> getListaPrecoLoja_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprecoLojaPossui == null)
			//{
            //	getCarregador().CarregaListaPrecoLoja_Possui(vo);
            //}
			return listaprecoLojaPossui;
			
		} 
		public void addListaPrecoLoja_Possui(PrecoLoja value)
		{	
			criaVaziaListaPrecoLoja_Possui();
			listaprecoLojaPossui.add(value);
		} 
		public PrecoLoja getCorrentePrecoLoja_Possui()
		{	
			if (listaprecoLojaPossui==null || listaprecoLojaPossui.size()==0) return null;
			return listaprecoLojaPossui.get(listaprecoLojaPossui.size()-1);
		} 
		public void criaVaziaListaPrecoLoja_Possui() {
			if (listaprecoLojaPossui == null)
            {
            	listaprecoLojaPossui = new ArrayList<PrecoLoja>();
            }
		}
 		
		public boolean existeListaCategoriaProduto_Associada() {
			return listacategoriaProdutoAssociada!= null;
		}
		private List<CategoriaProduto> listacategoriaProdutoAssociada;
		public void setListaCategoriaProduto_Associada(List<CategoriaProduto> value) 
		{	
			listacategoriaProdutoAssociada = value;
		} 
		public List<CategoriaProduto> getListaCategoriaProduto_Associada ()
		{	
			// ligando o LazyLoader
			//if (listacategoriaProdutoAssociada == null)
			//{
            //	getCarregador().CarregaListaCategoriaProduto_Associada(vo);
            //}
			return listacategoriaProdutoAssociada;
			
		} 
		public void addListaCategoriaProduto_Associada(CategoriaProduto value)
		{	
			criaVaziaListaCategoriaProduto_Associada();
			listacategoriaProdutoAssociada.add(value);
		} 
		public CategoriaProduto getCorrenteCategoriaProduto_Associada()
		{	
			if (listacategoriaProdutoAssociada==null || listacategoriaProdutoAssociada.size()==0) return null;
			return listacategoriaProdutoAssociada.get(listacategoriaProdutoAssociada.size()-1);
		} 
		public void criaVaziaListaCategoriaProduto_Associada() {
			if (listacategoriaProdutoAssociada == null)
            {
            	listacategoriaProdutoAssociada = new ArrayList<CategoriaProduto>();
            }
		}
 		
	}
