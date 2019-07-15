package coletorboadica.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorboadica.modelo.*;

// Gera??o autom?tica n?o alterar
public interface CategoriaAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public CategoriaProduto getCorrenteCategoriaProduto_Associada();
	public void addListaCategoriaProduto_Associada(CategoriaProduto item);
	public List<CategoriaProduto> getListaCategoriaProduto_Associada(); 
	public void setListaCategoriaProduto_Associada(List<CategoriaProduto> item); 
	public void criaVaziaListaCategoriaProduto_Associada();
	public boolean existeListaCategoriaProduto_Associada();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
