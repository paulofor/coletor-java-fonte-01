package dafitiafil.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
public interface CategoriaProdutoProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public CategoriaProduto getCategoriaProdutoReferenteA();
	public void setCategoriaProdutoReferenteA(CategoriaProduto item);
	// Montador alternativo
	
	public void addListaCategoriaProduto_ReferenteA(CategoriaProduto item); 
	public CategoriaProduto getCorrenteCategoriaProduto_ReferenteA();
	
		
	// Montador tradicional
	public Produto getProdutoReferenteA();
	public void setProdutoReferenteA(Produto item);
	// Montador alternativo
	
	public void addListaProduto_ReferenteA(Produto item); 
	public Produto getCorrenteProduto_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
}
