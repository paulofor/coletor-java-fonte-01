package dafitiafil.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import dafitiafil.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Marca getMarcaPertenceA();
	public void setMarcaPertenceA(Marca item);
	// Montador alternativo
	
	public void addListaMarca_PertenceA(Marca item); 
	public Marca getCorrenteMarca_PertenceA();
	
		
	
	// Sem Chave Estrangeira
	
	public CategoriaProdutoProduto getCorrenteCategoriaProdutoProduto_Possui();
	public void addListaCategoriaProdutoProduto_Possui(CategoriaProdutoProduto item);
	public List<CategoriaProdutoProduto> getListaCategoriaProdutoProduto_Possui(); 
	public void setListaCategoriaProdutoProduto_Possui(List<CategoriaProdutoProduto> item); 
	public void criaVaziaListaCategoriaProdutoProduto_Possui();
	public boolean existeListaCategoriaProdutoProduto_Possui();
 		
	public PrecoProduto getCorrentePrecoProduto_Possui();
	public void addListaPrecoProduto_Possui(PrecoProduto item);
	public List<PrecoProduto> getListaPrecoProduto_Possui(); 
	public void setListaPrecoProduto_Possui(List<PrecoProduto> item); 
	public void criaVaziaListaPrecoProduto_Possui();
	public boolean existeListaPrecoProduto_Possui();
 		
	public OportunidadeDia getCorrenteOportunidadeDia_PodePossuir();
	public void addListaOportunidadeDia_PodePossuir(OportunidadeDia item);
	public List<OportunidadeDia> getListaOportunidadeDia_PodePossuir(); 
	public void setListaOportunidadeDia_PodePossuir(List<OportunidadeDia> item); 
	public void criaVaziaListaOportunidadeDia_PodePossuir();
	public boolean existeListaOportunidadeDia_PodePossuir();
 		
	public PrecoProdutoDiario getCorrentePrecoProdutoDiario_Possui();
	public void addListaPrecoProdutoDiario_Possui(PrecoProdutoDiario item);
	public List<PrecoProdutoDiario> getListaPrecoProdutoDiario_Possui(); 
	public void setListaPrecoProdutoDiario_Possui(List<PrecoProdutoDiario> item); 
	public void criaVaziaListaPrecoProdutoDiario_Possui();
	public boolean existeListaPrecoProdutoDiario_Possui();
 		
	public FacebookFotoPost getCorrenteFacebookFotoPost_Gerou();
	public void addListaFacebookFotoPost_Gerou(FacebookFotoPost item);
	public List<FacebookFotoPost> getListaFacebookFotoPost_Gerou(); 
	public void setListaFacebookFotoPost_Gerou(List<FacebookFotoPost> item); 
	public void criaVaziaListaFacebookFotoPost_Gerou();
	public boolean existeListaFacebookFotoPost_Gerou();
 		
	public FacebookPerfil getCorrenteFacebookPerfil_Aparece();
	public void addListaFacebookPerfil_Aparece(FacebookPerfil item);
	public List<FacebookPerfil> getListaFacebookPerfil_Aparece(); 
	public void setListaFacebookPerfil_Aparece(List<FacebookPerfil> item); 
	public void criaVaziaListaFacebookPerfil_Aparece();
	public boolean existeListaFacebookPerfil_Aparece();
 		
	
	// Um pra um
	
}
