package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class OportunidadeDiaVo implements OportunidadeDia
{
		
	public long getIdObj()
    {
       return idOportunidadeDia;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdOportunidadeDia\" : \"" + idOportunidadeDia + "\" "
		+ ", \"DataInicioPrecoAtual\" : \"" + dataInicioPrecoAtual + "\" "
		+ ", \"NomeProduto\" : \"" + nomeProduto + "\" "
		+ ", \"UrlProduto\" : \"" + urlProduto + "\" "
		+ ", \"ValorParcelaAtual\" : \"" + valorParcelaAtual + "\" "
		+ ", \"ValorParcelaAnterior\" : \"" + valorParcelaAnterior + "\" "
		+ ", \"QuantidadeParcelaAnterior\" : \"" + quantidadeParcelaAnterior + "\" "
		+ ", \"QuantidadeParcelaAtual\" : \"" + quantidadeParcelaAtual + "\" "
		+ ", \"ValorConsumidorAtual\" : \"" + valorConsumidorAtual + "\" "
		+ ", \"ValorConsumidorAnterior\" : \"" + valorConsumidorAnterior + "\" "
		+ ", \"PercentualAjusteAtual\" : \"" + percentualAjusteAtual + "\" "
		+ ", \"UrlImagem\" : \"" + urlImagem + "\" "
		+ ", \"ImagemLocal\" : \"" + imagemLocal + "\" "
		+ ", \"QuantidadeExibicao\" : \"" + quantidadeExibicao + "\" "
		+ ", \"CodigoFacebook\" : \"" + codigoFacebook + "\" "
		+ ", \"DataUltimaPrecoAnterior\" : \"" + dataUltimaPrecoAnterior + "\" "
		+ ", \"UrlAfiliado\" : \"" + urlAfiliado + "\" "
		+ ", \"NomeMarca\" : \"" + nomeMarca + "\" "
		+ ", \"PosicaoProduto\" : \"" + posicaoProduto + "\" "
		+ ", \"IdProdutoRa\" : \"" + idProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private OportunidadeDiaDerivada derivada = null;
	private OportunidadeDiaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new OportunidadeDiaDerivada(this);
		}
		return derivada;
	}

	private OportunidadeDiaAgregado agregado = null;
	private OportunidadeDiaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new OportunidadeDiaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Produto getProdutoReferenteA()
	{
		return getAgregado().getProdutoReferenteA(); 
	} 
	public void setProdutoReferenteA(Produto value) 
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_ReferenteA(Produto value)
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	public Produto getCorrenteProduto_ReferenteA()
	{
		return getAgregado().getProdutoReferenteA(); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	public String getCodigoImagemLocal()
	{
		return getDerivada().getCodigoImagemLocal(); 
	} 
	public void setCodigoImagemLocal(String value)
	{
		getDerivada().setCodigoImagemLocal(value); 
	} 
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idOportunidadeDia;
	public long getIdOportunidadeDia()
	{
		return idOportunidadeDia;
	}
	public  void setIdOportunidadeDia(long value)
	{
		idOportunidadeDia = value; 
	}
	
	
	
	
	
	private String dataInicioPrecoAtual;
	public String getDataInicioPrecoAtual()
	{
		return dataInicioPrecoAtual;
	}
	public  void setDataInicioPrecoAtual(String value)
	{
		dataInicioPrecoAtual = value; 
	}
	
	
	
	
	
	private String nomeProduto;
	public String getNomeProduto()
	{
		return nomeProduto;
	}
	public  void setNomeProduto(String value)
	{
		nomeProduto = value; 
	}
	
	
	
	
	
	private String urlProduto;
	public String getUrlProduto()
	{
		return urlProduto;
	}
	public  void setUrlProduto(String value)
	{
		urlProduto = value; 
	}
	
	
	
	public String getValorParcelaAtualFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorParcelaAtual);
	}
	
	
	
	private float valorParcelaAtual;
	public float getValorParcelaAtual()
	{
		return valorParcelaAtual;
	}
	public  void setValorParcelaAtual(float value)
	{
		valorParcelaAtual = value; 
	}
	
	
	
	public String getValorParcelaAnteriorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorParcelaAnterior);
	}
	
	
	
	private float valorParcelaAnterior;
	public float getValorParcelaAnterior()
	{
		return valorParcelaAnterior;
	}
	public  void setValorParcelaAnterior(float value)
	{
		valorParcelaAnterior = value; 
	}
	
	
	
	
	
	private long quantidadeParcelaAnterior;
	public long getQuantidadeParcelaAnterior()
	{
		return quantidadeParcelaAnterior;
	}
	public  void setQuantidadeParcelaAnterior(long value)
	{
		quantidadeParcelaAnterior = value; 
	}
	
	
	
	
	
	private long quantidadeParcelaAtual;
	public long getQuantidadeParcelaAtual()
	{
		return quantidadeParcelaAtual;
	}
	public  void setQuantidadeParcelaAtual(long value)
	{
		quantidadeParcelaAtual = value; 
	}
	
	
	
	public String getValorConsumidorAtualFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorConsumidorAtual);
	}
	
	
	
	private float valorConsumidorAtual;
	public float getValorConsumidorAtual()
	{
		return valorConsumidorAtual;
	}
	public  void setValorConsumidorAtual(float value)
	{
		valorConsumidorAtual = value; 
	}
	
	
	
	public String getValorConsumidorAnteriorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorConsumidorAnterior);
	}
	
	
	
	private float valorConsumidorAnterior;
	public float getValorConsumidorAnterior()
	{
		return valorConsumidorAnterior;
	}
	public  void setValorConsumidorAnterior(float value)
	{
		valorConsumidorAnterior = value; 
	}
	
	
	
	
	
	private float percentualAjusteAtual;
	public float getPercentualAjusteAtual()
	{
		return percentualAjusteAtual;
	}
	public  void setPercentualAjusteAtual(float value)
	{
		percentualAjusteAtual = value; 
	}
	
	
	
	
	
	private String urlImagem;
	public String getUrlImagem()
	{
		return urlImagem;
	}
	public  void setUrlImagem(String value)
	{
		urlImagem = value; 
	}
	
	
	
	
	
	private String imagemLocal;
	public String getImagemLocal()
	{
		return imagemLocal;
	}
	public  void setImagemLocal(String value)
	{
		imagemLocal = value; 
	}
	
	
	
	
	
	private long quantidadeExibicao;
	public long getQuantidadeExibicao()
	{
		return quantidadeExibicao;
	}
	public  void setQuantidadeExibicao(long value)
	{
		quantidadeExibicao = value; 
	}
	
	
	
	
	
	private String codigoFacebook;
	public String getCodigoFacebook()
	{
		return codigoFacebook;
	}
	public  void setCodigoFacebook(String value)
	{
		codigoFacebook = value; 
	}
	
	
	
	
	
	private String dataUltimaPrecoAnterior;
	public String getDataUltimaPrecoAnterior()
	{
		return dataUltimaPrecoAnterior;
	}
	public  void setDataUltimaPrecoAnterior(String value)
	{
		dataUltimaPrecoAnterior = value; 
	}
	
	
	
	
	
	private String urlAfiliado;
	public String getUrlAfiliado()
	{
		return urlAfiliado;
	}
	public  void setUrlAfiliado(String value)
	{
		urlAfiliado = value; 
	}
	
	
	
	
	
	private String nomeMarca;
	public String getNomeMarca()
	{
		return nomeMarca;
	}
	public  void setNomeMarca(String value)
	{
		nomeMarca = value; 
	}
	
	
	
	
	
	private long posicaoProduto;
	public long getPosicaoProduto()
	{
		return posicaoProduto;
	}
	public  void setPosicaoProduto(long value)
	{
		posicaoProduto = value; 
	}
	
	
	
	
		
	private long idProdutoRa;
	public long getIdProdutoRa() {
		// relacionamento
		if (idProdutoRa==0 && this.getProdutoReferenteA()!=null) 
			return getProdutoReferenteA().getIdObj();
		else
			return idProdutoRa;
	}
	public void setIdProdutoRa(long _valor) {
		idProdutoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
