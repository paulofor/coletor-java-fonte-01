package dafitiafil.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
public interface MarcaAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public Produto getCorrenteProduto_Possui();
	public void addListaProduto_Possui(Produto item);
	public List<Produto> getListaProduto_Possui(); 
	public void setListaProduto_Possui(List<Produto> item); 
	public void criaVaziaListaProduto_Possui();
	public boolean existeListaProduto_Possui();
 		
	
	// Um pra um
	
}
