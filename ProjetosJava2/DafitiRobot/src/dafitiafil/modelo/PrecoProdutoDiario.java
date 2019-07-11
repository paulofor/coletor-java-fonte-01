package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PrecoProdutoDiario extends DCIObjetoDominio , PrecoProdutoDiarioAgregadoI , PrecoProdutoDiarioDerivadaI
{

	
	public long getIdPrecoProdutoDiario();
	public void setIdPrecoProdutoDiario(long valor);
	
	
	public float getValorPrecoAvista();
	public void setValorPrecoAvista(float valor);
	
	public String getValorPrecoAvistaFormatada();
	
	
	public long getQuantidadeParcela();
	public void setQuantidadeParcela(long valor);
	
	
	public String getDataVisita();
	public void setDataVisita(String valor);
	
	
	public float getValorParcela();
	public void setValorParcela(float valor);
	
	public String getValorParcelaFormatada();
	
	
	public float getPrecoPromocional();
	public void setPrecoPromocional(float valor);
	
	public String getPrecoPromocionalFormatada();
	
	
	public float getValorConsumidor();
	public void setValorConsumidor(float valor);
	
	public String getValorConsumidorFormatada();
	
	
	public long getIdProdutoPa();
	public void setIdProdutoPa(long valor);
	
	
}

