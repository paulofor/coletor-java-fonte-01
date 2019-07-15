package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class OportunidadeDiaAgregado implements OportunidadeDiaAgregadoI
	{
		/*
		private OportunidadeDiaCarregador carregador = null;
		private OportunidadeDiaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new OportunidadeDiaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.Produto_ReferenteA != null)
				vo.Produto_ReferenteA.setConexaoCarregador(conexao);
			
		}
		*/
		
		private OportunidadeDia vo;
		public OportunidadeDiaAgregado(OportunidadeDia item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
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
