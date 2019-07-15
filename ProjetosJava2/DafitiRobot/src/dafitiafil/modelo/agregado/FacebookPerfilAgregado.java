package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class FacebookPerfilAgregado implements FacebookPerfilAgregadoI
	{
		/*
		private FacebookPerfilCarregador carregador = null;
		private FacebookPerfilCarregador getCarregador() {
			if (carregador==null) {
				carregador = new FacebookPerfilCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.CategoriaProduto_ReferenteA != null)
				vo.CategoriaProduto_ReferenteA.setConexaoCarregador(conexao);
			if (vo.Produto_Icone != null)
				vo.Produto_Icone.setConexaoCarregador(conexao);
			
		}
		*/
		
		private FacebookPerfil vo;
		public FacebookPerfilAgregado(FacebookPerfil item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private CategoriaProduto categoriaProdutoReferenteA;
		// Montador Tradicional
		public CategoriaProduto getCategoriaProdutoReferenteA() 
		{	
			//if (categoriaProdutoReferenteA==null)
			//{
			//	getCarregador().CarregaItemCategoriaProduto_ReferenteA(vo);
			//}
			return categoriaProdutoReferenteA;
		} 
		public void setCategoriaProdutoReferenteA(CategoriaProduto value) 
		{	
			categoriaProdutoReferenteA = value;
		} 
		
		public void addListaCategoriaProduto_ReferenteA(CategoriaProduto  value) 
		{	
			categoriaProdutoReferenteA = value;
		} 
		public CategoriaProduto getCorrenteCategoriaProduto_ReferenteA()
		{	
			return categoriaProdutoReferenteA;
		} 
		
 		
		private Produto produtoIcone;
		// Montador Tradicional
		public Produto getProdutoIcone() 
		{	
			//if (produtoIcone==null)
			//{
			//	getCarregador().CarregaItemProduto_Icone(vo);
			//}
			return produtoIcone;
		} 
		public void setProdutoIcone(Produto value) 
		{	
			produtoIcone = value;
		} 
		
		public void addListaProduto_Icone(Produto  value) 
		{	
			produtoIcone = value;
		} 
		public Produto getCorrenteProduto_Icone()
		{	
			return produtoIcone;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaFacebookFotoPost_Recebe() {
			return listafacebookFotoPostRecebe!= null;
		}
		private List<FacebookFotoPost> listafacebookFotoPostRecebe;
		public void setListaFacebookFotoPost_Recebe(List<FacebookFotoPost> value) 
		{	
			listafacebookFotoPostRecebe = value;
		} 
		public List<FacebookFotoPost> getListaFacebookFotoPost_Recebe ()
		{	
			// ligando o LazyLoader
			//if (listafacebookFotoPostRecebe == null)
			//{
            //	getCarregador().CarregaListaFacebookFotoPost_Recebe(vo);
            //}
			return listafacebookFotoPostRecebe;
			
		} 
		public void addListaFacebookFotoPost_Recebe(FacebookFotoPost value)
		{	
			criaVaziaListaFacebookFotoPost_Recebe();
			listafacebookFotoPostRecebe.add(value);
		} 
		public FacebookFotoPost getCorrenteFacebookFotoPost_Recebe()
		{	
			if (listafacebookFotoPostRecebe==null || listafacebookFotoPostRecebe.size()==0) return null;
			return listafacebookFotoPostRecebe.get(listafacebookFotoPostRecebe.size()-1);
		} 
		public void criaVaziaListaFacebookFotoPost_Recebe() {
			if (listafacebookFotoPostRecebe == null)
            {
            	listafacebookFotoPostRecebe = new ArrayList<FacebookFotoPost>();
            }
		}
 		
		public boolean existeListaFacebookFanpage_Possui() {
			return listafacebookFanpagePossui!= null;
		}
		private List<FacebookFanpage> listafacebookFanpagePossui;
		public void setListaFacebookFanpage_Possui(List<FacebookFanpage> value) 
		{	
			listafacebookFanpagePossui = value;
		} 
		public List<FacebookFanpage> getListaFacebookFanpage_Possui ()
		{	
			// ligando o LazyLoader
			//if (listafacebookFanpagePossui == null)
			//{
            //	getCarregador().CarregaListaFacebookFanpage_Possui(vo);
            //}
			return listafacebookFanpagePossui;
			
		} 
		public void addListaFacebookFanpage_Possui(FacebookFanpage value)
		{	
			criaVaziaListaFacebookFanpage_Possui();
			listafacebookFanpagePossui.add(value);
		} 
		public FacebookFanpage getCorrenteFacebookFanpage_Possui()
		{	
			if (listafacebookFanpagePossui==null || listafacebookFanpagePossui.size()==0) return null;
			return listafacebookFanpagePossui.get(listafacebookFanpagePossui.size()-1);
		} 
		public void criaVaziaListaFacebookFanpage_Possui() {
			if (listafacebookFanpagePossui == null)
            {
            	listafacebookFanpagePossui = new ArrayList<FacebookFanpage>();
            }
		}
 		
	}
