package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class CategoriaProdutoAgregado implements CategoriaProdutoAgregadoI
	{
		/*
		private CategoriaProdutoCarregador carregador = null;
		private CategoriaProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CategoriaProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		*/
		
		private CategoriaProduto vo;
		public CategoriaProdutoAgregado(CategoriaProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaCategoriaProdutoProduto_Possui() {
			return listacategoriaProdutoProdutoPossui!= null;
		}
		private List<CategoriaProdutoProduto> listacategoriaProdutoProdutoPossui;
		public void setListaCategoriaProdutoProduto_Possui(List<CategoriaProdutoProduto> value) 
		{	
			listacategoriaProdutoProdutoPossui = value;
		} 
		public List<CategoriaProdutoProduto> getListaCategoriaProdutoProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listacategoriaProdutoProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaCategoriaProdutoProduto_Possui(vo);
            //}
			return listacategoriaProdutoProdutoPossui;
			
		} 
		public void addListaCategoriaProdutoProduto_Possui(CategoriaProdutoProduto value)
		{	
			criaVaziaListaCategoriaProdutoProduto_Possui();
			listacategoriaProdutoProdutoPossui.add(value);
		} 
		public CategoriaProdutoProduto getCorrenteCategoriaProdutoProduto_Possui()
		{	
			if (listacategoriaProdutoProdutoPossui==null || listacategoriaProdutoProdutoPossui.size()==0) return null;
			return listacategoriaProdutoProdutoPossui.get(listacategoriaProdutoProdutoPossui.size()-1);
		} 
		public void criaVaziaListaCategoriaProdutoProduto_Possui() {
			if (listacategoriaProdutoProdutoPossui == null)
            {
            	listacategoriaProdutoProdutoPossui = new ArrayList<CategoriaProdutoProduto>();
            }
		}
 		
		public boolean existeListaFacebookPerfil_Gera() {
			return listafacebookPerfilGera!= null;
		}
		private List<FacebookPerfil> listafacebookPerfilGera;
		public void setListaFacebookPerfil_Gera(List<FacebookPerfil> value) 
		{	
			listafacebookPerfilGera = value;
		} 
		public List<FacebookPerfil> getListaFacebookPerfil_Gera ()
		{	
			// ligando o LazyLoader
			//if (listafacebookPerfilGera == null)
			//{
            //	getCarregador().CarregaListaFacebookPerfil_Gera(vo);
            //}
			return listafacebookPerfilGera;
			
		} 
		public void addListaFacebookPerfil_Gera(FacebookPerfil value)
		{	
			criaVaziaListaFacebookPerfil_Gera();
			listafacebookPerfilGera.add(value);
		} 
		public FacebookPerfil getCorrenteFacebookPerfil_Gera()
		{	
			if (listafacebookPerfilGera==null || listafacebookPerfilGera.size()==0) return null;
			return listafacebookPerfilGera.get(listafacebookPerfilGera.size()-1);
		} 
		public void criaVaziaListaFacebookPerfil_Gera() {
			if (listafacebookPerfilGera == null)
            {
            	listafacebookPerfilGera = new ArrayList<FacebookPerfil>();
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
