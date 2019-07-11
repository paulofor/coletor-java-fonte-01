package coletorboadica.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorboadica.modelo.*;
import coletorboadica.modelo.agregado.*;
import coletorboadica.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CategoriaVo implements Categoria
{
		
	public long getIdObj()
    {
       return idCategoria;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCategoria\" : \"" + idCategoria + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"Url\" : \"" + url + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CategoriaDerivada derivada = null;
	private CategoriaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CategoriaDerivada(this);
		}
		return derivada;
	}

	private CategoriaAgregado agregado = null;
	private CategoriaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CategoriaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaCategoriaProduto_Associada() {
		return getAgregado().existeListaCategoriaProduto_Associada();
	}
	public void criaVaziaListaCategoriaProduto_Associada() {
		getAgregado().criaVaziaListaCategoriaProduto_Associada();
	}
	public List<CategoriaProduto> getListaCategoriaProduto_Associada() 
	{
		return getAgregado().getListaCategoriaProduto_Associada(); 
	} 
	public void setListaCategoriaProduto_Associada(List<CategoriaProduto> value) 
	{
		getAgregado().setListaCategoriaProduto_Associada(value); 
	} 
	public void addListaCategoriaProduto_Associada(CategoriaProduto value) 
	{
		getAgregado().addListaCategoriaProduto_Associada(value); 
	} 
	public CategoriaProduto getCorrenteCategoriaProduto_Associada()
	{
		return getAgregado().getCorrenteCategoriaProduto_Associada(); 
	} 
	

	
	
	
	
	
	private long idCategoria;
	public long getIdCategoria()
	{
		return idCategoria;
	}
	public  void setIdCategoria(long value)
	{
		idCategoria = value; 
	}
	
	
	
	
	
	private String nome;
	public String getNome()
	{
		return nome;
	}
	public  void setNome(String value)
	{
		nome = value; 
	}
	
	
	
	
	
	private String url;
	public String getUrl()
	{
		return url;
	}
	public  void setUrl(String value)
	{
		url = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
