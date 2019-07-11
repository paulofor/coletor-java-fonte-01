package dafitiafil.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
public interface FacebookFotoPostAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public FacebookFanpage getFacebookFanpageEnviadoPara();
	public void setFacebookFanpageEnviadoPara(FacebookFanpage item);
	// Montador alternativo
	
	public void addListaFacebookFanpage_EnviadoPara(FacebookFanpage item); 
	public FacebookFanpage getCorrenteFacebookFanpage_EnviadoPara();
	
		
	// Montador tradicional
	public FacebookPerfil getFacebookPerfilEnviadoPara();
	public void setFacebookPerfilEnviadoPara(FacebookPerfil item);
	// Montador alternativo
	
	public void addListaFacebookPerfil_EnviadoPara(FacebookPerfil item); 
	public FacebookPerfil getCorrenteFacebookPerfil_EnviadoPara();
	
		
	// Montador tradicional
	public Produto getProdutoReferenteA();
	public void setProdutoReferenteA(Produto item);
	// Montador alternativo
	
	public void addListaProduto_ReferenteA(Produto item); 
	public Produto getCorrenteProduto_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
}
