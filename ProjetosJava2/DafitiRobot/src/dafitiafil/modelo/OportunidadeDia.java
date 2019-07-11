package dafitiafil.modelo;

import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface OportunidadeDia extends DCIObjetoDominio , OportunidadeDiaAgregadoI , OportunidadeDiaDerivadaI
{

	
	public long getIdOportunidadeDia();
	public void setIdOportunidadeDia(long valor);
	
	
	public String getDataInicioPrecoAtual();
	public void setDataInicioPrecoAtual(String valor);
	
	
	public String getNomeProduto();
	public void setNomeProduto(String valor);
	
	
	public String getUrlProduto();
	public void setUrlProduto(String valor);
	
	
	public float getValorParcelaAtual();
	public void setValorParcelaAtual(float valor);
	
	public String getValorParcelaAtualFormatada();
	
	
	public float getValorParcelaAnterior();
	public void setValorParcelaAnterior(float valor);
	
	public String getValorParcelaAnteriorFormatada();
	
	
	public long getQuantidadeParcelaAnterior();
	public void setQuantidadeParcelaAnterior(long valor);
	
	
	public long getQuantidadeParcelaAtual();
	public void setQuantidadeParcelaAtual(long valor);
	
	
	public float getValorConsumidorAtual();
	public void setValorConsumidorAtual(float valor);
	
	public String getValorConsumidorAtualFormatada();
	
	
	public float getValorConsumidorAnterior();
	public void setValorConsumidorAnterior(float valor);
	
	public String getValorConsumidorAnteriorFormatada();
	
	
	public float getPercentualAjusteAtual();
	public void setPercentualAjusteAtual(float valor);
	
	
	public String getUrlImagem();
	public void setUrlImagem(String valor);
	
	
	public String getImagemLocal();
	public void setImagemLocal(String valor);
	
	
	public long getQuantidadeExibicao();
	public void setQuantidadeExibicao(long valor);
	
	
	public String getCodigoFacebook();
	public void setCodigoFacebook(String valor);
	
	
	public String getDataUltimaPrecoAnterior();
	public void setDataUltimaPrecoAnterior(String valor);
	
	
	public String getUrlAfiliado();
	public void setUrlAfiliado(String valor);
	
	
	public String getNomeMarca();
	public void setNomeMarca(String valor);
	
	
	public long getPosicaoProduto();
	public void setPosicaoProduto(long valor);
	
	
	public long getIdProdutoRa();
	public void setIdProdutoRa(long valor);
	
	
}

