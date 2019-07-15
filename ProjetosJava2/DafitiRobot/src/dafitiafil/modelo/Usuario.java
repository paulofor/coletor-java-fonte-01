package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Usuario extends DCIObjetoDominio , UsuarioAgregadoI , UsuarioDerivadaI
{

	
	public long getIdUsuario();
	public void setIdUsuario(long valor);
	
	
}

