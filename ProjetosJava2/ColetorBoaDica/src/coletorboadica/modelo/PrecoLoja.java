package coletorboadica.modelo;

import coletorboadica.modelo.agregado.*;
import coletorboadica.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PrecoLoja extends DCIObjetoDominio , PrecoLojaAgregadoI , PrecoLojaDerivadaI
{

	
	public long getIdPrecoLoja();
	public void setIdPrecoLoja(long valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public String getNomeLoja();
	public void setNomeLoja(String valor);
	
	
	public String getCodigoLoja();
	public void setCodigoLoja(String valor);
	
	
	public float getValor();
	public void setValor(float valor);
	
	public String getValorFormatada();
	
	
	public String getBairroLoja();
	public void setBairroLoja(String valor);
	
	
	public String getMunicipioLoja();
	public void setMunicipioLoja(String valor);
	
	
	public long getIdProdutoComumRa();
	public void setIdProdutoComumRa(long valor);
	
	
}

