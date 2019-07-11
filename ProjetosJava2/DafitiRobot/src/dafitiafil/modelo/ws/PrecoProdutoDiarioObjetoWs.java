package dafitiafil.modelo.ws;


import dafitiafil.modelo.vo.*;
import dafitiafil.modelo.*;


public  class PrecoProdutoDiarioObjetoWs   { 
      long _idPrecoProdutoDiario;
	public long getIdPrecoProdutoDiario() {
		return _idPrecoProdutoDiario;
	}
	public void setIdPrecoProdutoDiario( long dado ) {
		_idPrecoProdutoDiario = dado;
	}
      float _valorPrecoAvista;
	public float getValorPrecoAvista() {
		return _valorPrecoAvista;
	}
	public void setValorPrecoAvista( float dado ) {
		_valorPrecoAvista = dado;
	}
      long _quantidadeParcela;
	public long getQuantidadeParcela() {
		return _quantidadeParcela;
	}
	public void setQuantidadeParcela( long dado ) {
		_quantidadeParcela = dado;
	}
      String _dataVisita;
	public String getDataVisita() {
		return _dataVisita;
	}
	public void setDataVisita( String dado ) {
		_dataVisita = dado;
	}
      float _valorParcela;
	public float getValorParcela() {
		return _valorParcela;
	}
	public void setValorParcela( float dado ) {
		_valorParcela = dado;
	}
      float _precoPromocional;
	public float getPrecoPromocional() {
		return _precoPromocional;
	}
	public void setPrecoPromocional( float dado ) {
		_precoPromocional = dado;
	}
      float _valorConsumidor;
	public float getValorConsumidor() {
		return _valorConsumidor;
	}
	public void setValorConsumidor( float dado ) {
		_valorConsumidor = dado;
	}
      long _idProdutoPa;
	public long getIdProdutoPa() {
		return _idProdutoPa;
	}
	public void setIdProdutoPa( long dado ) {
		_idProdutoPa = dado;
	}
  private ProdutoObjetoWs _ProdutoPertenceA;
	public ProdutoObjetoWs getProdutoPertenceA() {
		return _ProdutoPertenceA;
	}
	public void setProdutoPertenceA( ProdutoObjetoWs dado ) {
		_ProdutoPertenceA = dado;
	}
}
