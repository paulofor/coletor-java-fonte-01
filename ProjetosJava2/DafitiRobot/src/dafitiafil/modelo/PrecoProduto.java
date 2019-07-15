package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PrecoProduto extends DCIObjetoDominio , PrecoProdutoAgregadoI , PrecoProdutoDerivadaI
{

	
	public long getIdPrecoProduto();
	public void setIdPrecoProduto(long valor);
	
	
	public float getValorPrecoAvista();
	public void setValorPrecoAvista(float valor);
	
	public String getValorPrecoAvistaFormatada();
	
	
	public String getDataVisitaInicial();
	public void setDataVisitaInicial(String valor);
	
	
	public long getQuantidadeParcela();
	public void setQuantidadeParcela(long valor);
	
	
	public float getValorParcela();
	public void setValorParcela(float valor);
	
	public String getValorParcelaFormatada();
	
	
	public float getPrecoPromocional();
	public void setPrecoPromocional(float valor);
	
	public String getPrecoPromocionalFormatada();
	
	
	public float getValorConsumidor();
	public void setValorConsumidor(float valor);
	
	public String getValorConsumidorFormatada();
	
	
	public String getDataUltimaVisita();
	public void setDataUltimaVisita(String valor);
	
	
	public float getPercentualAjuste();
	public void setPercentualAjuste(float valor);
	
	
	public long getIdProdutoPa();
	public void setIdProdutoPa(long valor);
	
	
}

