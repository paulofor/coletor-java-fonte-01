package dafitiafil.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
public interface FacebookPerfilAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public CategoriaProduto getCategoriaProdutoReferenteA();
	public void setCategoriaProdutoReferenteA(CategoriaProduto item);
	// Montador alternativo
	
	public void addListaCategoriaProduto_ReferenteA(CategoriaProduto item); 
	public CategoriaProduto getCorrenteCategoriaProduto_ReferenteA();
	
		
	// Montador tradicional
	public Produto getProdutoIcone();
	public void setProdutoIcone(Produto item);
	// Montador alternativo
	
	public void addListaProduto_Icone(Produto item); 
	public Produto getCorrenteProduto_Icone();
	
		
	
	// Sem Chave Estrangeira
	
	public FacebookFotoPost getCorrenteFacebookFotoPost_Recebe();
	public void addListaFacebookFotoPost_Recebe(FacebookFotoPost item);
	public List<FacebookFotoPost> getListaFacebookFotoPost_Recebe(); 
	public void setListaFacebookFotoPost_Recebe(List<FacebookFotoPost> item); 
	public void criaVaziaListaFacebookFotoPost_Recebe();
	public boolean existeListaFacebookFotoPost_Recebe();
 		
	public FacebookFanpage getCorrenteFacebookFanpage_Possui();
	public void addListaFacebookFanpage_Possui(FacebookFanpage item);
	public List<FacebookFanpage> getListaFacebookFanpage_Possui(); 
	public void setListaFacebookFanpage_Possui(List<FacebookFanpage> item); 
	public void criaVaziaListaFacebookFanpage_Possui();
	public boolean existeListaFacebookFanpage_Possui();
 		
	
	// Um pra um
	
}
