package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class PrecoProdutoAgregado implements PrecoProdutoAgregadoI
	{
		/*
		private PrecoProdutoCarregador carregador = null;
		private PrecoProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PrecoProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.Produto_PertenceA != null)
				vo.Produto_PertenceA.setConexaoCarregador(conexao);
			
		}
		*/
		
		private PrecoProduto vo;
		public PrecoProdutoAgregado(PrecoProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Produto produtoPertenceA;
		// Montador Tradicional
		public Produto getProdutoPertenceA() 
		{	
			//if (produtoPertenceA==null)
			//{
			//	getCarregador().CarregaItemProduto_PertenceA(vo);
			//}
			return produtoPertenceA;
		} 
		public void setProdutoPertenceA(Produto value) 
		{	
			produtoPertenceA = value;
		} 
		
		public void addListaProduto_PertenceA(Produto  value) 
		{	
			produtoPertenceA = value;
		} 
		public Produto getCorrenteProduto_PertenceA()
		{	
			return produtoPertenceA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
