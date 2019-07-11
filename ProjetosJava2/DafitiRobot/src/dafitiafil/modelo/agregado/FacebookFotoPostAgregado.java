package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class FacebookFotoPostAgregado implements FacebookFotoPostAgregadoI
	{
		/*
		private FacebookFotoPostCarregador carregador = null;
		private FacebookFotoPostCarregador getCarregador() {
			if (carregador==null) {
				carregador = new FacebookFotoPostCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.FacebookFanpage_EnviadoPara != null)
				vo.FacebookFanpage_EnviadoPara.setConexaoCarregador(conexao);
			if (vo.FacebookPerfil_EnviadoPara != null)
				vo.FacebookPerfil_EnviadoPara.setConexaoCarregador(conexao);
			if (vo.Produto_ReferenteA != null)
				vo.Produto_ReferenteA.setConexaoCarregador(conexao);
			
		}
		*/
		
		private FacebookFotoPost vo;
		public FacebookFotoPostAgregado(FacebookFotoPost item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private FacebookFanpage facebookFanpageEnviadoPara;
		// Montador Tradicional
		public FacebookFanpage getFacebookFanpageEnviadoPara() 
		{	
			//if (facebookFanpageEnviadoPara==null)
			//{
			//	getCarregador().CarregaItemFacebookFanpage_EnviadoPara(vo);
			//}
			return facebookFanpageEnviadoPara;
		} 
		public void setFacebookFanpageEnviadoPara(FacebookFanpage value) 
		{	
			facebookFanpageEnviadoPara = value;
		} 
		
		public void addListaFacebookFanpage_EnviadoPara(FacebookFanpage  value) 
		{	
			facebookFanpageEnviadoPara = value;
		} 
		public FacebookFanpage getCorrenteFacebookFanpage_EnviadoPara()
		{	
			return facebookFanpageEnviadoPara;
		} 
		
 		
		private FacebookPerfil facebookPerfilEnviadoPara;
		// Montador Tradicional
		public FacebookPerfil getFacebookPerfilEnviadoPara() 
		{	
			//if (facebookPerfilEnviadoPara==null)
			//{
			//	getCarregador().CarregaItemFacebookPerfil_EnviadoPara(vo);
			//}
			return facebookPerfilEnviadoPara;
		} 
		public void setFacebookPerfilEnviadoPara(FacebookPerfil value) 
		{	
			facebookPerfilEnviadoPara = value;
		} 
		
		public void addListaFacebookPerfil_EnviadoPara(FacebookPerfil  value) 
		{	
			facebookPerfilEnviadoPara = value;
		} 
		public FacebookPerfil getCorrenteFacebookPerfil_EnviadoPara()
		{	
			return facebookPerfilEnviadoPara;
		} 
		
 		
		private Produto produtoReferenteA;
		// Montador Tradicional
		public Produto getProdutoReferenteA() 
		{	
			//if (produtoReferenteA==null)
			//{
			//	getCarregador().CarregaItemProduto_ReferenteA(vo);
			//}
			return produtoReferenteA;
		} 
		public void setProdutoReferenteA(Produto value) 
		{	
			produtoReferenteA = value;
		} 
		
		public void addListaProduto_ReferenteA(Produto  value) 
		{	
			produtoReferenteA = value;
		} 
		public Produto getCorrenteProduto_ReferenteA()
		{	
			return produtoReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
