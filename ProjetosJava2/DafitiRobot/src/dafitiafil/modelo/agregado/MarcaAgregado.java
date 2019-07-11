package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class MarcaAgregado implements MarcaAgregadoI
	{
		/*
		private MarcaCarregador carregador = null;
		private MarcaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new MarcaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		*/
		
		private Marca vo;
		public MarcaAgregado(Marca item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaProduto_Possui() {
			return listaprodutoPossui!= null;
		}
		private List<Produto> listaprodutoPossui;
		public void setListaProduto_Possui(List<Produto> value) 
		{	
			listaprodutoPossui = value;
		} 
		public List<Produto> getListaProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprodutoPossui == null)
			//{
            //	getCarregador().CarregaListaProduto_Possui(vo);
            //}
			return listaprodutoPossui;
			
		} 
		public void addListaProduto_Possui(Produto value)
		{	
			criaVaziaListaProduto_Possui();
			listaprodutoPossui.add(value);
		} 
		public Produto getCorrenteProduto_Possui()
		{	
			if (listaprodutoPossui==null || listaprodutoPossui.size()==0) return null;
			return listaprodutoPossui.get(listaprodutoPossui.size()-1);
		} 
		public void criaVaziaListaProduto_Possui() {
			if (listaprodutoPossui == null)
            {
            	listaprodutoPossui = new ArrayList<Produto>();
            }
		}
 		
	}
