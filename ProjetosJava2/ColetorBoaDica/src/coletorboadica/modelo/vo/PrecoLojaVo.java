package coletorboadica.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorboadica.modelo.*;
import coletorboadica.modelo.agregado.*;
import coletorboadica.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PrecoLojaVo implements PrecoLoja
{
		
	public long getIdObj()
    {
       return idPrecoLoja;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPrecoLoja\" : \"" + idPrecoLoja + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"NomeLoja\" : \"" + nomeLoja + "\" "
		+ ", \"CodigoLoja\" : \"" + codigoLoja + "\" "
		+ ", \"Valor\" : \"" + valor + "\" "
		+ ", \"BairroLoja\" : \"" + bairroLoja + "\" "
		+ ", \"MunicipioLoja\" : \"" + municipioLoja + "\" "
		+ ", \"IdProdutoComumRa\" : \"" + idProdutoComumRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PrecoLojaDerivada derivada = null;
	private PrecoLojaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PrecoLojaDerivada(this);
		}
		return derivada;
	}

	private PrecoLojaAgregado agregado = null;
	private PrecoLojaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PrecoLojaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public ProdutoComum getProdutoComumReferenteA(boolean lazyLoader)
	{
		return getAgregado().getProdutoComumReferenteA(lazyLoader); 
	} 
	public void setProdutoComumReferenteA(ProdutoComum value) 
	{
		getAgregado().setProdutoComumReferenteA(value); 
	} 
	/*
	public void setProdutoComumReferenteAComReversao(ProdutoComum value) 
	{
		getAgregado().setProdutoComumReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProdutoComum_ReferenteA(ProdutoComum value)
	{
		getAgregado().setProdutoComumReferenteA(value); 
	} 
	public ProdutoComum getCorrenteProdutoComum_ReferenteA()
	{
		return getAgregado().getProdutoComumReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idPrecoLoja;
	public long getIdPrecoLoja()
	{
		return idPrecoLoja;
	}
	public  void setIdPrecoLoja(long value)
	{
		idPrecoLoja = value; 
	}
	
	
	
	
	
	private String data;
	public String getData()
	{
		return data;
	}
	public  void setData(String value)
	{
		data = value; 
	}
	
	
	
	
	
	private String nomeLoja;
	public String getNomeLoja()
	{
		return nomeLoja;
	}
	public  void setNomeLoja(String value)
	{
		nomeLoja = value; 
	}
	
	
	
	
	
	private String codigoLoja;
	public String getCodigoLoja()
	{
		return codigoLoja;
	}
	public  void setCodigoLoja(String value)
	{
		codigoLoja = value; 
	}
	
	
	
	public String getValorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valor);
	}
	
	
	
	private float valor;
	public float getValor()
	{
		return valor;
	}
	public  void setValor(float value)
	{
		valor = value; 
	}
	
	
	
	
	
	private String bairroLoja;
	public String getBairroLoja()
	{
		return bairroLoja;
	}
	public  void setBairroLoja(String value)
	{
		bairroLoja = value; 
	}
	
	
	
	
	
	private String municipioLoja;
	public String getMunicipioLoja()
	{
		return municipioLoja;
	}
	public  void setMunicipioLoja(String value)
	{
		municipioLoja = value; 
	}
	
	
	
	
		
	private long idProdutoComumRa;
	public long getIdProdutoComumRa() {
		// relacionamento
		if (idProdutoComumRa==0 && this.getProdutoComumReferenteA(false)!=null) 
			return getProdutoComumReferenteA(false).getIdObj();
		else
			return idProdutoComumRa;
	}
	public void setIdProdutoComumRa(long _valor) {
		idProdutoComumRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
