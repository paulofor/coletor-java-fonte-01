package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class FacebookFanpageAgregado implements FacebookFanpageAgregadoI
	{
		/*
		private FacebookFanpageCarregador carregador = null;
		private FacebookFanpageCarregador getCarregador() {
			if (carregador==null) {
				carregador = new FacebookFanpageCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.FacebookPerfil_EstaEm != null)
				vo.FacebookPerfil_EstaEm.setConexaoCarregador(conexao);
			if (vo.CategoriaProduto_ReferenteA != null)
				vo.CategoriaProduto_ReferenteA.setConexaoCarregador(conexao);
			
		}
		*/
		
		private FacebookFanpage vo;
		public FacebookFanpageAgregado(FacebookFanpage item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private FacebookPerfil facebookPerfilEstaEm;
		// Montador Tradicional
		public FacebookPerfil getFacebookPerfilEstaEm() 
		{	
			//if (facebookPerfilEstaEm==null)
			//{
			//	getCarregador().CarregaItemFacebookPerfil_EstaEm(vo);
			//}
			return facebookPerfilEstaEm;
		} 
		public void setFacebookPerfilEstaEm(FacebookPerfil value) 
		{	
			facebookPerfilEstaEm = value;
		} 
		
		public void addListaFacebookPerfil_EstaEm(FacebookPerfil  value) 
		{	
			facebookPerfilEstaEm = value;
		} 
		public FacebookPerfil getCorrenteFacebookPerfil_EstaEm()
		{	
			return facebookPerfilEstaEm;
		} 
		
 		
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
 		
	}
