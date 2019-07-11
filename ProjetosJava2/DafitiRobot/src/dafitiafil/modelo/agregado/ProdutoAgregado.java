package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class ProdutoAgregado implements ProdutoAgregadoI
	{
		/*
		private ProdutoCarregador carregador = null;
		private ProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.Marca_PertenceA != null)
				vo.Marca_PertenceA.setConexaoCarregador(conexao);
			
		}
		*/
		
		private Produto vo;
		public ProdutoAgregado(Produto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Marca marcaPertenceA;
		// Montador Tradicional
		public Marca getMarcaPertenceA() 
		{	
			//if (marcaPertenceA==null)
			//{
			//	getCarregador().CarregaItemMarca_PertenceA(vo);
			//}
			return marcaPertenceA;
		} 
		public void setMarcaPertenceA(Marca value) 
		{	
			marcaPertenceA = value;
		} 
		
		public void addListaMarca_PertenceA(Marca  value) 
		{	
			marcaPertenceA = value;
		} 
		public Marca getCorrenteMarca_PertenceA()
		{	
			return marcaPertenceA;
		} 
		
 		
     	
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
 		
		public boolean existeListaPrecoProduto_Possui() {
			return listaprecoProdutoPossui!= null;
		}
		private List<PrecoProduto> listaprecoProdutoPossui;
		public void setListaPrecoProduto_Possui(List<PrecoProduto> value) 
		{	
			listaprecoProdutoPossui = value;
		} 
		public List<PrecoProduto> getListaPrecoProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprecoProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaPrecoProduto_Possui(vo);
            //}
			return listaprecoProdutoPossui;
			
		} 
		public void addListaPrecoProduto_Possui(PrecoProduto value)
		{	
			criaVaziaListaPrecoProduto_Possui();
			listaprecoProdutoPossui.add(value);
		} 
		public PrecoProduto getCorrentePrecoProduto_Possui()
		{	
			if (listaprecoProdutoPossui==null || listaprecoProdutoPossui.size()==0) return null;
			return listaprecoProdutoPossui.get(listaprecoProdutoPossui.size()-1);
		} 
		public void criaVaziaListaPrecoProduto_Possui() {
			if (listaprecoProdutoPossui == null)
            {
            	listaprecoProdutoPossui = new ArrayList<PrecoProduto>();
            }
		}
 		
		public boolean existeListaOportunidadeDia_PodePossuir() {
			return listaoportunidadeDiaPodePossuir!= null;
		}
		private List<OportunidadeDia> listaoportunidadeDiaPodePossuir;
		public void setListaOportunidadeDia_PodePossuir(List<OportunidadeDia> value) 
		{	
			listaoportunidadeDiaPodePossuir = value;
		} 
		public List<OportunidadeDia> getListaOportunidadeDia_PodePossuir ()
		{	
			// ligando o LazyLoader
			//if (listaoportunidadeDiaPodePossuir == null)
			//{
            //	getCarregador().CarregaListaOportunidadeDia_PodePossuir(vo);
            //}
			return listaoportunidadeDiaPodePossuir;
			
		} 
		public void addListaOportunidadeDia_PodePossuir(OportunidadeDia value)
		{	
			criaVaziaListaOportunidadeDia_PodePossuir();
			listaoportunidadeDiaPodePossuir.add(value);
		} 
		public OportunidadeDia getCorrenteOportunidadeDia_PodePossuir()
		{	
			if (listaoportunidadeDiaPodePossuir==null || listaoportunidadeDiaPodePossuir.size()==0) return null;
			return listaoportunidadeDiaPodePossuir.get(listaoportunidadeDiaPodePossuir.size()-1);
		} 
		public void criaVaziaListaOportunidadeDia_PodePossuir() {
			if (listaoportunidadeDiaPodePossuir == null)
            {
            	listaoportunidadeDiaPodePossuir = new ArrayList<OportunidadeDia>();
            }
		}
 		
		public boolean existeListaPrecoProdutoDiario_Possui() {
			return listaprecoProdutoDiarioPossui!= null;
		}
		private List<PrecoProdutoDiario> listaprecoProdutoDiarioPossui;
		public void setListaPrecoProdutoDiario_Possui(List<PrecoProdutoDiario> value) 
		{	
			listaprecoProdutoDiarioPossui = value;
		} 
		public List<PrecoProdutoDiario> getListaPrecoProdutoDiario_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprecoProdutoDiarioPossui == null)
			//{
            //	getCarregador().CarregaListaPrecoProdutoDiario_Possui(vo);
            //}
			return listaprecoProdutoDiarioPossui;
			
		} 
		public void addListaPrecoProdutoDiario_Possui(PrecoProdutoDiario value)
		{	
			criaVaziaListaPrecoProdutoDiario_Possui();
			listaprecoProdutoDiarioPossui.add(value);
		} 
		public PrecoProdutoDiario getCorrentePrecoProdutoDiario_Possui()
		{	
			if (listaprecoProdutoDiarioPossui==null || listaprecoProdutoDiarioPossui.size()==0) return null;
			return listaprecoProdutoDiarioPossui.get(listaprecoProdutoDiarioPossui.size()-1);
		} 
		public void criaVaziaListaPrecoProdutoDiario_Possui() {
			if (listaprecoProdutoDiarioPossui == null)
            {
            	listaprecoProdutoDiarioPossui = new ArrayList<PrecoProdutoDiario>();
            }
		}
 		
		public boolean existeListaFacebookFotoPost_Gerou() {
			return listafacebookFotoPostGerou!= null;
		}
		private List<FacebookFotoPost> listafacebookFotoPostGerou;
		public void setListaFacebookFotoPost_Gerou(List<FacebookFotoPost> value) 
		{	
			listafacebookFotoPostGerou = value;
		} 
		public List<FacebookFotoPost> getListaFacebookFotoPost_Gerou ()
		{	
			// ligando o LazyLoader
			//if (listafacebookFotoPostGerou == null)
			//{
            //	getCarregador().CarregaListaFacebookFotoPost_Gerou(vo);
            //}
			return listafacebookFotoPostGerou;
			
		} 
		public void addListaFacebookFotoPost_Gerou(FacebookFotoPost value)
		{	
			criaVaziaListaFacebookFotoPost_Gerou();
			listafacebookFotoPostGerou.add(value);
		} 
		public FacebookFotoPost getCorrenteFacebookFotoPost_Gerou()
		{	
			if (listafacebookFotoPostGerou==null || listafacebookFotoPostGerou.size()==0) return null;
			return listafacebookFotoPostGerou.get(listafacebookFotoPostGerou.size()-1);
		} 
		public void criaVaziaListaFacebookFotoPost_Gerou() {
			if (listafacebookFotoPostGerou == null)
            {
            	listafacebookFotoPostGerou = new ArrayList<FacebookFotoPost>();
            }
		}
 		
		public boolean existeListaFacebookPerfil_Aparece() {
			return listafacebookPerfilAparece!= null;
		}
		private List<FacebookPerfil> listafacebookPerfilAparece;
		public void setListaFacebookPerfil_Aparece(List<FacebookPerfil> value) 
		{	
			listafacebookPerfilAparece = value;
		} 
		public List<FacebookPerfil> getListaFacebookPerfil_Aparece ()
		{	
			// ligando o LazyLoader
			//if (listafacebookPerfilAparece == null)
			//{
            //	getCarregador().CarregaListaFacebookPerfil_Aparece(vo);
            //}
			return listafacebookPerfilAparece;
			
		} 
		public void addListaFacebookPerfil_Aparece(FacebookPerfil value)
		{	
			criaVaziaListaFacebookPerfil_Aparece();
			listafacebookPerfilAparece.add(value);
		} 
		public FacebookPerfil getCorrenteFacebookPerfil_Aparece()
		{	
			if (listafacebookPerfilAparece==null || listafacebookPerfilAparece.size()==0) return null;
			return listafacebookPerfilAparece.get(listafacebookPerfilAparece.size()-1);
		} 
		public void criaVaziaListaFacebookPerfil_Aparece() {
			if (listafacebookPerfilAparece == null)
            {
            	listafacebookPerfilAparece = new ArrayList<FacebookPerfil>();
            }
		}
 		
	}
