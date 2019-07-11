package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface FacebookPerfil extends DCIObjetoDominio , FacebookPerfilAgregadoI , FacebookPerfilDerivadaI
{

	
	public long getIdFacebookPerfil();
	public void setIdFacebookPerfil(long valor);
	
	
	public String getFacebookId();
	public void setFacebookId(String valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getSobrenome();
	public void setSobrenome(String valor);
	
	
	public String getEmailUtilizado();
	public void setEmailUtilizado(String valor);
	
	
	public String getAplicacaoNome();
	public void setAplicacaoNome(String valor);
	
	
	public String getAplicacaoId();
	public void setAplicacaoId(String valor);
	
	
	public String getAplicacaoChave();
	public void setAplicacaoChave(String valor);
	
	
	public String getTokenAcesso();
	public void setTokenAcesso(String valor);
	
	
	public float getValorMaximoProduto();
	public void setValorMaximoProduto(float valor);
	
	public String getValorMaximoProdutoFormatada();
	
	
	public float getValorMinimoProduto();
	public void setValorMinimoProduto(float valor);
	
	public String getValorMinimoProdutoFormatada();
	
	
	public long getIdCategoriaProdutoRa();
	public void setIdCategoriaProdutoRa(long valor);
	
	
	public long getIdProdutoI();
	public void setIdProdutoI(long valor);
	
	
}

