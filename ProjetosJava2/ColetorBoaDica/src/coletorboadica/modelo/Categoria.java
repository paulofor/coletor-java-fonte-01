package coletorboadica.modelo;

import coletorboadica.modelo.agregado.*;
import coletorboadica.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Categoria extends DCIObjetoDominio , CategoriaAgregadoI , CategoriaDerivadaI
{

	
	public long getIdCategoria();
	public void setIdCategoria(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getUrl();
	public void setUrl(String valor);
	
	
}

