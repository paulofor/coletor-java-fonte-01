package dafitiafil.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
public interface PrecoProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Produto getProdutoPertenceA();
	public void setProdutoPertenceA(Produto item);
	// Montador alternativo
	
	public void addListaProduto_PertenceA(Produto item); 
	public Produto getCorrenteProduto_PertenceA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
}
