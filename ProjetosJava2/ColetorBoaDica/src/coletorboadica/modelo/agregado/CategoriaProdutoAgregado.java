package coletorboadica.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorboadica.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class CategoriaProdutoAgregado implements CategoriaProdutoAgregadoI
	{
		
		private CategoriaProdutoCarregador carregador = null;
		private CategoriaProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CategoriaProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProdutoComumAssociada(false) != null)
				vo.getProdutoComumAssociada(false).setConexaoCarregador(conexao);
			if (vo.getCategoriaAssociada(false) != null)
				vo.getCategoriaAssociada(false).setConexaoCarregador(conexao);
			
		}
		
		
		private CategoriaProduto vo;
		public CategoriaProdutoAgregado(CategoriaProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private ProdutoComum produtoComumAssociada;
		// Montador Tradicional
		public ProdutoComum getProdutoComumAssociada(boolean lazyloader) 
		{	
			if (lazyloader && produtoComumAssociada==null)
			{
				try {
					getCarregador().CarregaItemProdutoComum_Associada(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoComumAssociada;
		} 
		public void setProdutoComumAssociada(ProdutoComum value) 
		{	
			produtoComumAssociada = value;
		} 
		/*
		public void setProdutoComumAssociadaComReversao(ProdutoComum value) 
		{	
			produtoComumAssociada = value;
			System.out.println("Alteracao:" + produtoComumAssociada);
			if (produtoComumAssociada!=null)
				produtoComumAssociada.addListaCategoriaProduto_Associada(vo);
		} 
		*/
		
		public void addListaProdutoComum_Associada(ProdutoComum  value) 
		{	
			produtoComumAssociada = value;
		} 
		public ProdutoComum getCorrenteProdutoComum_Associada()
		{	
			return produtoComumAssociada;
		} 
		
 		
		private Categoria categoriaAssociada;
		// Montador Tradicional
		public Categoria getCategoriaAssociada(boolean lazyloader) 
		{	
			if (lazyloader && categoriaAssociada==null)
			{
				try {
					getCarregador().CarregaItemCategoria_Associada(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return categoriaAssociada;
		} 
		public void setCategoriaAssociada(Categoria value) 
		{	
			categoriaAssociada = value;
		} 
		/*
		public void setCategoriaAssociadaComReversao(Categoria value) 
		{	
			categoriaAssociada = value;
			System.out.println("Alteracao:" + categoriaAssociada);
			if (categoriaAssociada!=null)
				categoriaAssociada.addListaCategoriaProduto_Associada(vo);
		} 
		*/
		
		public void addListaCategoria_Associada(Categoria  value) 
		{	
			categoriaAssociada = value;
		} 
		public Categoria getCorrenteCategoria_Associada()
		{	
			return categoriaAssociada;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
