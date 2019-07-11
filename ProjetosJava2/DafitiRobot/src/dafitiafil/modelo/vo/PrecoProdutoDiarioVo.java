package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PrecoProdutoDiarioVo implements PrecoProdutoDiario
{
		
	public long getIdObj()
    {
       return idPrecoProdutoDiario;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPrecoProdutoDiario\" : \"" + idPrecoProdutoDiario + "\" "
		+ ", \"ValorPrecoAvista\" : \"" + valorPrecoAvista + "\" "
		+ ", \"QuantidadeParcela\" : \"" + quantidadeParcela + "\" "
		+ ", \"DataVisita\" : \"" + dataVisita + "\" "
		+ ", \"ValorParcela\" : \"" + valorParcela + "\" "
		+ ", \"PrecoPromocional\" : \"" + precoPromocional + "\" "
		+ ", \"ValorConsumidor\" : \"" + valorConsumidor + "\" "
		+ ", \"IdProdutoPa\" : \"" + idProdutoPa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PrecoProdutoDiarioDerivada derivada = null;
	private PrecoProdutoDiarioDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PrecoProdutoDiarioDerivada(this);
		}
		return derivada;
	}

	private PrecoProdutoDiarioAgregado agregado = null;
	private PrecoProdutoDiarioAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PrecoProdutoDiarioAgregado(this);
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
	

	
	
	
	
	
	private long idPrecoProdutoDiario;
	public long getIdPrecoProdutoDiario()
	{
		return idPrecoProdutoDiario;
	}
	public  void setIdPrecoProdutoDiario(long value)
	{
		idPrecoProdutoDiario = value; 
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
	
	
	
	
	
	private long quantidadeParcela;
	public long getQuantidadeParcela()
	{
		return quantidadeParcela;
	}
	public  void setQuantidadeParcela(long value)
	{
		quantidadeParcela = value; 
	}
	
	
	
	
	
	private String dataVisita;
	public String getDataVisita()
	{
		return dataVisita;
	}
	public  void setDataVisita(String value)
	{
		dataVisita = value; 
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
