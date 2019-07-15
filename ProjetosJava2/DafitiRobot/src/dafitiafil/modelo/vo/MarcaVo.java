package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class MarcaVo implements Marca
{
		
	public long getIdObj()
    {
       return idMarca;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdMarca\" : \"" + idMarca + "\" "
		+ ", \"NomeMarca\" : \"" + nomeMarca + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private MarcaDerivada derivada = null;
	private MarcaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new MarcaDerivada(this);
		}
		return derivada;
	}

	private MarcaAgregado agregado = null;
	private MarcaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new MarcaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaProduto_Possui() {
		return getAgregado().existeListaProduto_Possui();
	}
	public void criaVaziaListaProduto_Possui() {
		getAgregado().criaVaziaListaProduto_Possui();
	}
	public List<Produto> getListaProduto_Possui() 
	{
		return getAgregado().getListaProduto_Possui(); 
	} 
	public void setListaProduto_Possui(List<Produto> value) 
	{
		getAgregado().setListaProduto_Possui(value); 
	} 
	public void addListaProduto_Possui(Produto value) 
	{
		getAgregado().addListaProduto_Possui(value); 
	} 
	public Produto getCorrenteProduto_Possui()
	{
		return getAgregado().getCorrenteProduto_Possui(); 
	} 
	

	
	
	
	
	
	private long idMarca;
	public long getIdMarca()
	{
		return idMarca;
	}
	public  void setIdMarca(long value)
	{
		idMarca = value; 
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
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
