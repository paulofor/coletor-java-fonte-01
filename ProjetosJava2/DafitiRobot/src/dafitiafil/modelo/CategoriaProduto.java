package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CategoriaProduto extends DCIObjetoDominio , CategoriaProdutoAgregadoI , CategoriaProdutoDerivadaI
{

	
	public long getIdCategoriaProduto();
	public void setIdCategoriaProduto(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getUrl();
	public void setUrl(String valor);
	
	
	public String getDataInclusao();
	public void setDataInclusao(String valor);
	
	
}

