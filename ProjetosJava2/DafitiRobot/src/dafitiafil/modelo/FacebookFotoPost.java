package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface FacebookFotoPost extends DCIObjetoDominio , FacebookFotoPostAgregadoI , FacebookFotoPostDerivadaI
{

	
	public long getIdFacebookFotoPost();
	public void setIdFacebookFotoPost(long valor);
	
	
	public String getDataHora();
	public void setDataHora(String valor);
	
	
	public String getFacebookId();
	public void setFacebookId(String valor);
	
	
	public long getQtdeClick();
	public void setQtdeClick(long valor);
	
	
	public String getMensagem();
	public void setMensagem(String valor);
	
	
	public float getPrecoConsumidor();
	public void setPrecoConsumidor(float valor);
	
	public String getPrecoConsumidorFormatada();
	
	
	public long getIdFacebookFanpageEp();
	public void setIdFacebookFanpageEp(long valor);
	
	
	public long getIdFacebookPerfilEp();
	public void setIdFacebookPerfilEp(long valor);
	
	
	public long getIdProdutoRa();
	public void setIdProdutoRa(long valor);
	
	
}

