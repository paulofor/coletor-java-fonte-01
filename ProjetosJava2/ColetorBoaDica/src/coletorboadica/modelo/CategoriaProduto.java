package coletorboadica.modelo;

import coletorboadica.modelo.agregado.*;
import coletorboadica.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CategoriaProduto extends DCIObjetoDominio , CategoriaProdutoAgregadoI , CategoriaProdutoDerivadaI
{

	
	public long getIdCategoriaProduto();
	public void setIdCategoriaProduto(long valor);
	
	
	public long getIdProdutoComumA();
	public void setIdProdutoComumA(long valor);
	
	
	public long getIdCategoriaA();
	public void setIdCategoriaA(long valor);
	
	
}

