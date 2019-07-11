package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class CategoriaProdutoProdutoAgregado implements CategoriaProdutoProdutoAgregadoI
	{
		/*
		private CategoriaProdutoProdutoCarregador carregador = null;
		private CategoriaProdutoProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CategoriaProdutoProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.CategoriaProduto_ReferenteA != null)
				vo.CategoriaProduto_ReferenteA.setConexaoCarregador(conexao);
			if (vo.Produto_ReferenteA != null)
				vo.Produto_ReferenteA.setConexaoCarregador(conexao);
			
		}
		*/
		
		private CategoriaProdutoProduto vo;
		public CategoriaProdutoProdutoAgregado(CategoriaProdutoProduto item) {
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
