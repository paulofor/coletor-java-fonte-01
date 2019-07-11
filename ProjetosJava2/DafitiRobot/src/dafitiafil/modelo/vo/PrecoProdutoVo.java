package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PrecoProdutoVo implements PrecoProduto
{
		
	public long getIdObj()
    {
       return idPrecoProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPrecoProduto\" : \"" + idPrecoProduto + "\" "
		+ ", \"ValorPrecoAvista\" : \"" + valorPrecoAvista + "\" "
		+ ", \"DataVisitaInicial\" : \"" + dataVisitaInicial + "\" "
		+ ", \"QuantidadeParcela\" : \"" + quantidadeParcela + "\" "
		+ ", \"ValorParcela\" : \"" + valorParcela + "\" "
		+ ", \"PrecoPromocional\" : \"" + precoPromocional + "\" "
		+ ", \"ValorConsumidor\" : \"" + valorConsumidor + "\" "
		+ ", \"DataUltimaVisita\" : \"" + dataUltimaVisita + "\" "
		+ ", \"PercentualAjuste\" : \"" + percentualAjuste + "\" "
		+ ", \"IdProdutoPa\" : \"" + idProdutoPa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PrecoProdutoDerivada derivada = null;
	private PrecoProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PrecoProdutoDerivada(this);
		}
		return derivada;
	}

	private PrecoProdutoAgregado agregado = null;
	private PrecoProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PrecoProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Produto getProdutoPertenceA()
	{
		return getAgregado().getProdutoPertenceA(); 
	} 
	public void setProdutoPertenceA(Produto value) 
	{
		getAgregado().setProdutoPertenceA(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_PertenceA(Produto value)
	{
		getAgregado().setProdutoPertenceA(value); 
	} 
	public Produto getCorrenteProduto_PertenceA()
	{
		return getAgregado().getProdutoPertenceA(); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idPrecoProduto;
	public long getIdPrecoProduto()
	{
		return idPrecoProduto;
	}
	public  void setIdPrecoProduto(long value)
	{
		idPrecoProduto = value; 
	}
	
	
	
	public String getValorPrecoAvistaFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorPrecoAvista);
	}
	
	
	
	private float valorPrecoAvista;
	public float getValorPrecoAvista()
	{
		return valorPrecoAvista;
	}
	public  void setValorPrecoAvista(float value)
	{
		valorPrecoAvista = value; 
	}
	
	
	
	
	
	private String dataVisitaInicial;
	public String getDataVisitaInicial()
	{
		return dataVisitaInicial;
	}
	public  void setDataVisitaInicial(String value)
	{
		dataVisitaInicial = value; 
	}
	
	
	
	
	
	private long quantidadeParcela;
	public long getQuantidadeParcela()
	{
		return quantidadeParcela;
	}
	public  void setQuantidadeParcela(long value)
	{
		quantidadeParcela = value; 
	}
	
	
	
	public String getValorParcelaFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorParcela);
	}
	
	
	
	private float valorParcela;
	public float getValorParcela()
	{
		return valorParcela;
	}
	public  void setValorParcela(float value)
	{
		valorParcela = value; 
	}
	
	
	
	public String getPrecoPromocionalFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoPromocional);
	}
	
	
	
	private float precoPromocional;
	public float getPrecoPromocional()
	{
		return precoPromocional;
	}
	public  void setPrecoPromocional(float value)
	{
		precoPromocional = value; 
	}
	
	
	
	public String getValorConsumidorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorConsumidor);
	}
	
	
	
	private float valorConsumidor;
	public float getValorConsumidor()
	{
		return valorConsumidor;
	}
	public  void setValorConsumidor(float value)
	{
		valorConsumidor = value; 
	}
	
	
	
	
	
	private String dataUltimaVisita;
	public String getDataUltimaVisita()
	{
		return dataUltimaVisita;
	}
	public  void setDataUltimaVisita(String value)
	{
		dataUltimaVisita = value; 
	}
	
	
	
	
	
	private float percentualAjuste;
	public float getPercentualAjuste()
	{
		return percentualAjuste;
	}
	public  void setPercentualAjuste(float value)
	{
		percentualAjuste = value; 
	}
	
	
	
	
		
	private long idProdutoPa;
	public long getIdProdutoPa() {
		// relacionamento
		if (idProdutoPa==0 && this.getProdutoPertenceA()!=null) 
			return getProdutoPertenceA().getIdObj();
		else
			return idProdutoPa;
	}
	public void setIdProdutoPa(long _valor) {
		idProdutoPa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
