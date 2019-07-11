package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CategoriaProdutoProduto extends DCIObjetoDominio , CategoriaProdutoProdutoAgregadoI , CategoriaProdutoProdutoDerivadaI
{

	
	public long getIdCategoriaProdutoProduto();
	public void setIdCategoriaProdutoProduto(long valor);
	
	
	public String getDataInclusao();
	public void setDataInclusao(String valor);
	
	
	public long getIdCategoriaProdutoRa();
	public void setIdCategoriaProdutoRa(long valor);
	
	
	public long getIdProdutoRa();
	public void setIdProdutoRa(long valor);
	
	
}

