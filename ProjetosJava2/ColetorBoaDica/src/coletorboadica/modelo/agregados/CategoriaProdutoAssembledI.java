package coletorboadica.modelo.agregados;


import coletorboadica.modelo.*;

public interface CategoriaProdutoAssembledI
 { 
	public ProdutoComum getProdutoComumAssociada();
	public void setProdutoComumAssociada( ProdutoComum dado );
	public Categoria getCategoriaAssociada();
	public void setCategoriaAssociada( Categoria dado );
}
