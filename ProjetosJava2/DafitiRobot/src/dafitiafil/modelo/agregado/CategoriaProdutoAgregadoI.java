package dafitiafil.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
public interface CategoriaProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public CategoriaProdutoProduto getCorrenteCategoriaProdutoProduto_Possui();
	public void addListaCategoriaProdutoProduto_Possui(CategoriaProdutoProduto item);
	public List<CategoriaProdutoProduto> getListaCategoriaProdutoProduto_Possui(); 
	public void setListaCategoriaProdutoProduto_Possui(List<CategoriaProdutoProduto> item); 
	public void criaVaziaListaCategoriaProdutoProduto_Possui();
	public boolean existeListaCategoriaProdutoProduto_Possui();
 		
	public FacebookPerfil getCorrenteFacebookPerfil_Gera();
	public void addListaFacebookPerfil_Gera(FacebookPerfil item);
	public List<FacebookPerfil> getListaFacebookPerfil_Gera(); 
	public void setListaFacebookPerfil_Gera(List<FacebookPerfil> item); 
	public void criaVaziaListaFacebookPerfil_Gera();
	public boolean existeListaFacebookPerfil_Gera();
 		
	public FacebookFanpage getCorrenteFacebookFanpage_Possui();
	public void addListaFacebookFanpage_Possui(FacebookFanpage item);
	public List<FacebookFanpage> getListaFacebookFanpage_Possui(); 
	public void setListaFacebookFanpage_Possui(List<FacebookFanpage> item); 
	public void criaVaziaListaFacebookFanpage_Possui();
	public boolean existeListaFacebookFanpage_Possui();
 		
	
	// Um pra um
	
}
