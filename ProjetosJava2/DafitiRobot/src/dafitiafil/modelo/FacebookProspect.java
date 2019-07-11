package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface FacebookProspect extends DCIObjetoDominio , FacebookProspectAgregadoI , FacebookProspectDerivadaI
{

	
	public long getIdFacebookProspect();
	public void setIdFacebookProspect(long valor);
	
	
	public long getFacebookId();
	public void setFacebookId(long valor);
	
	
}

