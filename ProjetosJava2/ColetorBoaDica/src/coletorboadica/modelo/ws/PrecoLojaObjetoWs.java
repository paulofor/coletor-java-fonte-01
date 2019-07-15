package coletorboadica.modelo.ws;


import coletorboadica.modelo.vo.*;
import coletorboadica.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class PrecoLojaObjetoWs   { 
      long _idPrecoLoja;
	public long getIdPrecoLoja() {
		return _idPrecoLoja;
	}
	public void setIdPrecoLoja( long dado ) {
		_idPrecoLoja = dado;
	}
      String _dataVar;
	public String getData() {
		return _dataVar;
	}
	public void setData( String dado ) {
		_dataVar = dado;
	}
      String _nomeLoja;
	public String getNomeLoja() {
		return _nomeLoja;
	}
	public void setNomeLoja( String dado ) {
		_nomeLoja = dado;
	}
      String _codigoLoja;
	public String getCodigoLoja() {
		return _codigoLoja;
	}
	public void setCodigoLoja( String dado ) {
		_codigoLoja = dado;
	}
      float _valor;
	public float getValor() {
		return _valor;
	}
	public void setValor( float dado ) {
		_valor = dado;
	}
      long _idProdutoComumRa;
	public long getIdProdutoComumRa() {
		return _idProdutoComumRa;
	}
	public void setIdProdutoComumRa( long dado ) {
		_idProdutoComumRa = dado;
	}
  private ProdutoComumObjetoWs _ProdutoComumReferenteA;
	public ProdutoComumObjetoWs getProdutoComumReferenteA() {
		return _ProdutoComumReferenteA;
	}
	public void setProdutoComumReferenteA( ProdutoComumObjetoWs dado ) {
		_ProdutoComumReferenteA = dado;
	}
}
