package coletorboadica.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorboadica.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class PrecoLojaAgregado implements PrecoLojaAgregadoI
	{
		
		private PrecoLojaCarregador carregador = null;
		private PrecoLojaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PrecoLojaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProdutoComumReferenteA(false) != null)
				vo.getProdutoComumReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private PrecoLoja vo;
		public PrecoLojaAgregado(PrecoLoja item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private ProdutoComum produtoComumReferenteA;
		// Montador Tradicional
		public ProdutoComum getProdutoComumReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && produtoComumReferenteA==null)
			{
				try {
					getCarregador().CarregaItemProdutoComum_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoComumReferenteA;
		} 
		public void setProdutoComumReferenteA(ProdutoComum value) 
		{	
			produtoComumReferenteA = value;
		} 
		/*
		public void setProdutoComumReferenteAComReversao(ProdutoComum value) 
		{	
			produtoComumReferenteA = value;
			System.out.println("Alteracao:" + produtoComumReferenteA);
			if (produtoComumReferenteA!=null)
				produtoComumReferenteA.addListaPrecoLoja_Possui(vo);
		} 
		*/
		
		public void addListaProdutoComum_ReferenteA(ProdutoComum  value) 
		{	
			produtoComumReferenteA = value;
		} 
		public ProdutoComum getCorrenteProdutoComum_ReferenteA()
		{	
			return produtoComumReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
