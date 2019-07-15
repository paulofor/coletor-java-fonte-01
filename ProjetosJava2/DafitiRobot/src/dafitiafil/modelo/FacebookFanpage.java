package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface FacebookFanpage extends DCIObjetoDominio , FacebookFanpageAgregadoI , FacebookFanpageDerivadaI
{

	
	public long getIdFacebookFanpage();
	public void setIdFacebookFanpage(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getFacebookId();
	public void setFacebookId(String valor);
	
	
	public long getIdFacebookPerfilEe();
	public void setIdFacebookPerfilEe(long valor);
	
	
	public long getIdCategoriaProdutoRa();
	public void setIdCategoriaProdutoRa(long valor);
	
	
}

