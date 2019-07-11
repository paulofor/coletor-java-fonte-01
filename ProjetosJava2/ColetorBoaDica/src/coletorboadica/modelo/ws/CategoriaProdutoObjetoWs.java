package coletorboadica.modelo.ws;


import coletorboadica.modelo.vo.*;
import coletorboadica.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class CategoriaProdutoObjetoWs   { 
      long _idCategoriaProduto;
	public long getIdCategoriaProduto() {
		return _idCategoriaProduto;
	}
	public void setIdCategoriaProduto( long dado ) {
		_idCategoriaProduto = dado;
	}
      long _idProdutoComumA;
	public long getIdProdutoComumA() {
		return _idProdutoComumA;
	}
	public void setIdProdutoComumA( long dado ) {
		_idProdutoComumA = dado;
	}
      long _idCategoriaA;
	public long getIdCategoriaA() {
		return _idCategoriaA;
	}
	public void setIdCategoriaA( long dado ) {
		_idCategoriaA = dado;
	}
  private ProdutoComumObjetoWs _ProdutoComumAssociada;
	public ProdutoComumObjetoWs getProdutoComumAssociada() {
		return _ProdutoComumAssociada;
	}
	public void setProdutoComumAssociada( ProdutoComumObjetoWs dado ) {
		_ProdutoComumAssociada = dado;
	}
  private CategoriaObjetoWs _CategoriaAssociada;
	public CategoriaObjetoWs getCategoriaAssociada() {
		return _CategoriaAssociada;
	}
	public void setCategoriaAssociada( CategoriaObjetoWs dado ) {
		_CategoriaAssociada = dado;
	}
}
