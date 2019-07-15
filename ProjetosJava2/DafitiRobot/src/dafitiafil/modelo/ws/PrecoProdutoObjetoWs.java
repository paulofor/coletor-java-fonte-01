package dafitiafil.modelo.ws;


import dafitiafil.modelo.vo.*;
import dafitiafil.modelo.*;


public  class PrecoProdutoObjetoWs   { 
      long _idPrecoProduto;
	public long getIdPrecoProduto() {
		return _idPrecoProduto;
	}
	public void setIdPrecoProduto( long dado ) {
		_idPrecoProduto = dado;
	}
      float _valorPrecoAvista;
	public float getValorPrecoAvista() {
		return _valorPrecoAvista;
	}
	public void setValorPrecoAvista( float dado ) {
		_valorPrecoAvista = dado;
	}
      String _dataVisitaInicial;
	public String getDataVisitaInicial() {
		return _dataVisitaInicial;
	}
	public void setDataVisitaInicial( String dado ) {
		_dataVisitaInicial = dado;
	}
      long _quantidadeParcela;
	public long getQuantidadeParcela() {
		return _quantidadeParcela;
	}
	public void setQuantidadeParcela( long dado ) {
		_quantidadeParcela = dado;
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
      String _dataUltimaVisita;
	public String getDataUltimaVisita() {
		return _dataUltimaVisita;
	}
	public void setDataUltimaVisita( String dado ) {
		_dataUltimaVisita = dado;
	}
      float _percentualAjuste;
	public float getPercentualAjuste() {
		return _percentualAjuste;
	}
	public void setPercentualAjuste( float dado ) {
		_percentualAjuste = dado;
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
