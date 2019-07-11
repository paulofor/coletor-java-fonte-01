package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Produto extends DCIObjetoDominio , ProdutoAgregadoI , ProdutoDerivadaI
{

	
	public long getIdProduto();
	public void setIdProduto(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getUrl();
	public void setUrl(String valor);
	
	
	public String getImagem();
	public void setImagem(String valor);
	
	
	public long getTamanhoImagem();
	public void setTamanhoImagem(long valor);
	
	
	public String getDataInclusao();
	public void setDataInclusao(String valor);
	
	
	public String getImagemLocal();
	public void setImagemLocal(String valor);
	
	
	public String getUrlOrigem();
	public void setUrlOrigem(String valor);
	
	
	public String getUrlAfiliado();
	public void setUrlAfiliado(String valor);
	
	
	public long getPosicaoProduto();
	public void setPosicaoProduto(long valor);
	
	
	public long getIdMarcaPa();
	public void setIdMarcaPa(long valor);
	
	
}

