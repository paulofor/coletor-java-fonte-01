package coletorboadica.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorboadica.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ProdutoComumAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public PrecoLoja getCorrentePrecoLoja_Possui();
	public void addListaPrecoLoja_Possui(PrecoLoja item);
	public List<PrecoLoja> getListaPrecoLoja_Possui(); 
	public void setListaPrecoLoja_Possui(List<PrecoLoja> item); 
	public void criaVaziaListaPrecoLoja_Possui();
	public boolean existeListaPrecoLoja_Possui();
 		
	public CategoriaProduto getCorrenteCategoriaProduto_Associada();
	public void addListaCategoriaProduto_Associada(CategoriaProduto item);
	public List<CategoriaProduto> getListaCategoriaProduto_Associada(); 
	public void setListaCategoriaProduto_Associada(List<CategoriaProduto> item); 
	public void criaVaziaListaCategoriaProduto_Associada();
	public boolean existeListaCategoriaProduto_Associada();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
