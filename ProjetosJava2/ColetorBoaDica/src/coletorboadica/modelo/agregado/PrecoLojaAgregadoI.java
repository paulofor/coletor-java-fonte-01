package coletorboadica.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorboadica.modelo.*;

// Gera??o autom?tica n?o alterar
public interface PrecoLojaAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public ProdutoComum getProdutoComumReferenteA(boolean lazyLoader);
	public void setProdutoComumReferenteA(ProdutoComum item);
	//public void setProdutoComumReferenteAComReversao(ProdutoComum item);
	
	// Montador alternativo
	
	public void addListaProdutoComum_ReferenteA(ProdutoComum item); 
	public ProdutoComum getCorrenteProdutoComum_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
