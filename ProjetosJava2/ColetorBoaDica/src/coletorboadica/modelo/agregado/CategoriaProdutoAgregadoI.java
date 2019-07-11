package coletorboadica.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorboadica.modelo.*;

// Gera??o autom?tica n?o alterar
public interface CategoriaProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public ProdutoComum getProdutoComumAssociada(boolean lazyLoader);
	public void setProdutoComumAssociada(ProdutoComum item);
	//public void setProdutoComumAssociadaComReversao(ProdutoComum item);
	
	// Montador alternativo
	
	public void addListaProdutoComum_Associada(ProdutoComum item); 
	public ProdutoComum getCorrenteProdutoComum_Associada();
	
		
	// Montador tradicional
	public Categoria getCategoriaAssociada(boolean lazyLoader);
	public void setCategoriaAssociada(Categoria item);
	//public void setCategoriaAssociadaComReversao(Categoria item);
	
	// Montador alternativo
	
	public void addListaCategoria_Associada(Categoria item); 
	public Categoria getCorrenteCategoria_Associada();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
