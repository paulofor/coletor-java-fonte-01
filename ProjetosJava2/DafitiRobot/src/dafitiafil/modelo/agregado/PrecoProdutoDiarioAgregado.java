package dafitiafil.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
	public class PrecoProdutoDiarioAgregado implements PrecoProdutoDiarioAgregadoI
	{
		/*
		private PrecoProdutoDiarioCarregador carregador = null;
		private PrecoProdutoDiarioCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PrecoProdutoDiarioCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.Produto_PertenceA != null)
				vo.Produto_PertenceA.setConexaoCarregador(conexao);
			
		}
		*/
		
		private PrecoProdutoDiario vo;
		public PrecoProdutoDiarioAgregado(PrecoProdutoDiario item) {
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
