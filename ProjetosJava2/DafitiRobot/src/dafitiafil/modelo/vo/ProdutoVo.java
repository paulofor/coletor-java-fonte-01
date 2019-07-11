package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ProdutoVo implements Produto
{
		
	public long getIdObj()
    {
       return idProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdProduto\" : \"" + idProduto + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"Url\" : \"" + url + "\" "
		+ ", \"Imagem\" : \"" + imagem + "\" "
		+ ", \"TamanhoImagem\" : \"" + tamanhoImagem + "\" "
		+ ", \"DataInclusao\" : \"" + dataInclusao + "\" "
		+ ", \"ImagemLocal\" : \"" + imagemLocal + "\" "
		+ ", \"UrlOrigem\" : \"" + urlOrigem + "\" "
		+ ", \"UrlAfiliado\" : \"" + urlAfiliado + "\" "
		+ ", \"PosicaoProduto\" : \"" + posicaoProduto + "\" "
		+ ", \"IdMarcaPa\" : \"" + idMarcaPa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ProdutoDerivada derivada = null;
	private ProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ProdutoDerivada(this);
		}
		return derivada;
	}

	private ProdutoAgregado agregado = null;
	private ProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Marca getMarcaPertenceA()
	{
		return getAgregado().getMarcaPertenceA(); 
	} 
	public void setMarcaPertenceA(Marca value) 
	{
		getAgregado().setMarcaPertenceA(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaMarca_PertenceA(Marca value)
	{
		getAgregado().setMarcaPertenceA(value); 
	} 
	public Marca getCorrenteMarca_PertenceA()
	{
		return getAgregado().getMarcaPertenceA(); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaCategoriaProdutoProduto_Possui() {
		return getAgregado().existeListaCategoriaProdutoProduto_Possui();
	}
	public void criaVaziaListaCategoriaProdutoProduto_Possui() {
		getAgregado().criaVaziaListaCategoriaProdutoProduto_Possui();
	}
	public List<CategoriaProdutoProduto> getListaCategoriaProdutoProduto_Possui() 
	{
		return getAgregado().getListaCategoriaProdutoProduto_Possui(); 
	} 
	public void setListaCategoriaProdutoProduto_Possui(List<CategoriaProdutoProduto> value) 
	{
		getAgregado().setListaCategoriaProdutoProduto_Possui(value); 
	} 
	public void addListaCategoriaProdutoProduto_Possui(CategoriaProdutoProduto value) 
	{
		getAgregado().addListaCategoriaProdutoProduto_Possui(value); 
	} 
	public CategoriaProdutoProduto getCorrenteCategoriaProdutoProduto_Possui()
	{
		return getAgregado().getCorrenteCategoriaProdutoProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaPrecoProduto_Possui() {
		return getAgregado().existeListaPrecoProduto_Possui();
	}
	public void criaVaziaListaPrecoProduto_Possui() {
		getAgregado().criaVaziaListaPrecoProduto_Possui();
	}
	public List<PrecoProduto> getListaPrecoProduto_Possui() 
	{
		return getAgregado().getListaPrecoProduto_Possui(); 
	} 
	public void setListaPrecoProduto_Possui(List<PrecoProduto> value) 
	{
		getAgregado().setListaPrecoProduto_Possui(value); 
	} 
	public void addListaPrecoProduto_Possui(PrecoProduto value) 
	{
		getAgregado().addListaPrecoProduto_Possui(value); 
	} 
	public PrecoProduto getCorrentePrecoProduto_Possui()
	{
		return getAgregado().getCorrentePrecoProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaOportunidadeDia_PodePossuir() {
		return getAgregado().existeListaOportunidadeDia_PodePossuir();
	}
	public void criaVaziaListaOportunidadeDia_PodePossuir() {
		getAgregado().criaVaziaListaOportunidadeDia_PodePossuir();
	}
	public List<OportunidadeDia> getListaOportunidadeDia_PodePossuir() 
	{
		return getAgregado().getListaOportunidadeDia_PodePossuir(); 
	} 
	public void setListaOportunidadeDia_PodePossuir(List<OportunidadeDia> value) 
	{
		getAgregado().setListaOportunidadeDia_PodePossuir(value); 
	} 
	public void addListaOportunidadeDia_PodePossuir(OportunidadeDia value) 
	{
		getAgregado().addListaOportunidadeDia_PodePossuir(value); 
	} 
	public OportunidadeDia getCorrenteOportunidadeDia_PodePossuir()
	{
		return getAgregado().getCorrenteOportunidadeDia_PodePossuir(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaPrecoProdutoDiario_Possui() {
		return getAgregado().existeListaPrecoProdutoDiario_Possui();
	}
	public void criaVaziaListaPrecoProdutoDiario_Possui() {
		getAgregado().criaVaziaListaPrecoProdutoDiario_Possui();
	}
	public List<PrecoProdutoDiario> getListaPrecoProdutoDiario_Possui() 
	{
		return getAgregado().getListaPrecoProdutoDiario_Possui(); 
	} 
	public void setListaPrecoProdutoDiario_Possui(List<PrecoProdutoDiario> value) 
	{
		getAgregado().setListaPrecoProdutoDiario_Possui(value); 
	} 
	public void addListaPrecoProdutoDiario_Possui(PrecoProdutoDiario value) 
	{
		getAgregado().addListaPrecoProdutoDiario_Possui(value); 
	} 
	public PrecoProdutoDiario getCorrentePrecoProdutoDiario_Possui()
	{
		return getAgregado().getCorrentePrecoProdutoDiario_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaFacebookFotoPost_Gerou() {
		return getAgregado().existeListaFacebookFotoPost_Gerou();
	}
	public void criaVaziaListaFacebookFotoPost_Gerou() {
		getAgregado().criaVaziaListaFacebookFotoPost_Gerou();
	}
	public List<FacebookFotoPost> getListaFacebookFotoPost_Gerou() 
	{
		return getAgregado().getListaFacebookFotoPost_Gerou(); 
	} 
	public void setListaFacebookFotoPost_Gerou(List<FacebookFotoPost> value) 
	{
		getAgregado().setListaFacebookFotoPost_Gerou(value); 
	} 
	public void addListaFacebookFotoPost_Gerou(FacebookFotoPost value) 
	{
		getAgregado().addListaFacebookFotoPost_Gerou(value); 
	} 
	public FacebookFotoPost getCorrenteFacebookFotoPost_Gerou()
	{
		return getAgregado().getCorrenteFacebookFotoPost_Gerou(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaFacebookPerfil_Aparece() {
		return getAgregado().existeListaFacebookPerfil_Aparece();
	}
	public void criaVaziaListaFacebookPerfil_Aparece() {
		getAgregado().criaVaziaListaFacebookPerfil_Aparece();
	}
	public List<FacebookPerfil> getListaFacebookPerfil_Aparece() 
	{
		return getAgregado().getListaFacebookPerfil_Aparece(); 
	} 
	public void setListaFacebookPerfil_Aparece(List<FacebookPerfil> value) 
	{
		getAgregado().setListaFacebookPerfil_Aparece(value); 
	} 
	public void addListaFacebookPerfil_Aparece(FacebookPerfil value) 
	{
		getAgregado().addListaFacebookPerfil_Aparece(value); 
	} 
	public FacebookPerfil getCorrenteFacebookPerfil_Aparece()
	{
		return getAgregado().getCorrenteFacebookPerfil_Aparece(); 
	} 
	

	
	
	
	
	
	private long idProduto;
	public long getIdProduto()
	{
		return idProduto;
	}
	public  void setIdProduto(long value)
	{
		idProduto = value; 
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
	
	
	
	
	
	private String imagem;
	public String getImagem()
	{
		return imagem;
	}
	public  void setImagem(String value)
	{
		imagem = value; 
	}
	
	
	
	
	
	private long tamanhoImagem;
	public long getTamanhoImagem()
	{
		return tamanhoImagem;
	}
	public  void setTamanhoImagem(long value)
	{
		tamanhoImagem = value; 
	}
	
	
	
	
	
	private String dataInclusao;
	public String getDataInclusao()
	{
		return dataInclusao;
	}
	public  void setDataInclusao(String value)
	{
		dataInclusao = value; 
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
	
	
	
	
	
	private String urlOrigem;
	public String getUrlOrigem()
	{
		return urlOrigem;
	}
	public  void setUrlOrigem(String value)
	{
		urlOrigem = value; 
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
	
	
	
	
	
	private long posicaoProduto;
	public long getPosicaoProduto()
	{
		return posicaoProduto;
	}
	public  void setPosicaoProduto(long value)
	{
		posicaoProduto = value; 
	}
	
	
	
	
		
	private long idMarcaPa;
	public long getIdMarcaPa() {
		// relacionamento
		if (idMarcaPa==0 && this.getMarcaPertenceA()!=null) 
			return getMarcaPertenceA().getIdObj();
		else
			return idMarcaPa;
	}
	public void setIdMarcaPa(long _valor) {
		idMarcaPa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
