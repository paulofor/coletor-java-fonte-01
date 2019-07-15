package dafitiafil.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
public interface FacebookFanpageAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public FacebookPerfil getFacebookPerfilEstaEm();
	public void setFacebookPerfilEstaEm(FacebookPerfil item);
	// Montador alternativo
	
	public void addListaFacebookPerfil_EstaEm(FacebookPerfil item); 
	public FacebookPerfil getCorrenteFacebookPerfil_EstaEm();
	
		
	// Montador tradicional
	public CategoriaProduto getCategoriaProdutoReferenteA();
	public void setCategoriaProdutoReferenteA(CategoriaProduto item);
	// Montador alternativo
	
	public void addListaCategoriaProduto_ReferenteA(CategoriaProduto item); 
	public CategoriaProduto getCorrenteCategoriaProduto_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	public FacebookFotoPost getCorrenteFacebookFotoPost_Recebe();
	public void addListaFacebookFotoPost_Recebe(FacebookFotoPost item);
	public List<FacebookFotoPost> getListaFacebookFotoPost_Recebe(); 
	public void setListaFacebookFotoPost_Recebe(List<FacebookFotoPost> item); 
	public void criaVaziaListaFacebookFotoPost_Recebe();
	public boolean existeListaFacebookFotoPost_Recebe();
 		
	
	// Um pra um
	
}
