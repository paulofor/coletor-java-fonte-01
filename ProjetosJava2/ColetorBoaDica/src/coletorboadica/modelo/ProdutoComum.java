package coletorboadica.modelo;

import coletorboadica.modelo.agregado.*;
import coletorboadica.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ProdutoComum extends DCIObjetoDominio , ProdutoComumAgregadoI , ProdutoComumDerivadaI
{

	
	public long getIdProdutoComum();
	public void setIdProdutoComum(long valor);
	
	
	public String getNomeProduto();
	public void setNomeProduto(String valor);
	
	
	public String getMarca();
	public void setMarca(String valor);
	
	
	public String getDescricao();
	public void setDescricao(String valor);
	
	
	public String getUrl();
	public void setUrl(String valor);
	
	
}

