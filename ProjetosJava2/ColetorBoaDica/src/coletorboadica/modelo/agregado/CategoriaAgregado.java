package coletorboadica.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorboadica.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class CategoriaAgregado implements CategoriaAgregadoI
	{
		
		private CategoriaCarregador carregador = null;
		private CategoriaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CategoriaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private Categoria vo;
		public CategoriaAgregado(Categoria item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
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
