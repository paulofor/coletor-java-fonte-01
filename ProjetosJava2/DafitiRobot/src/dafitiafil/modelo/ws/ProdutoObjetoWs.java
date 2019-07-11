package dafitiafil.modelo.ws;


import dafitiafil.modelo.vo.*;
import dafitiafil.modelo.*;


public  class ProdutoObjetoWs   { 
      long _idProduto;
	public long getIdProduto() {
		return _idProduto;
	}
	public void setIdProduto( long dado ) {
		_idProduto = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _url;
	public String getUrl() {
		return _url;
	}
	public void setUrl( String dado ) {
		_url = dado;
	}
      String _imagem;
	public String getImagem() {
		return _imagem;
	}
	public void setImagem( String dado ) {
		_imagem = dado;
	}
      long _tamanhoImagem;
	public long getTamanhoImagem() {
		return _tamanhoImagem;
	}
	public void setTamanhoImagem( long dado ) {
		_tamanhoImagem = dado;
	}
      String _dataInclusao;
	public String getDataInclusao() {
		return _dataInclusao;
	}
	public void setDataInclusao( String dado ) {
		_dataInclusao = dado;
	}
      String _imagemLocal;
	public String getImagemLocal() {
		return _imagemLocal;
	}
	public void setImagemLocal( String dado ) {
		_imagemLocal = dado;
	}
      String _urlOrigem;
	public String getUrlOrigem() {
		return _urlOrigem;
	}
	public void setUrlOrigem( String dado ) {
		_urlOrigem = dado;
	}
      String _urlAfiliado;
	public String getUrlAfiliado() {
		return _urlAfiliado;
	}
	public void setUrlAfiliado( String dado ) {
		_urlAfiliado = dado;
	}
      long _idMarcaPa;
	public long getIdMarcaPa() {
		return _idMarcaPa;
	}
	public void setIdMarcaPa( long dado ) {
		_idMarcaPa = dado;
	}
  private MarcaObjetoWs _MarcaPertenceA;
	public MarcaObjetoWs getMarcaPertenceA() {
		return _MarcaPertenceA;
	}
	public void setMarcaPertenceA( MarcaObjetoWs dado ) {
		_MarcaPertenceA = dado;
	}
}
