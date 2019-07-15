package coletorboadica.regracolecao;

import  coletorboadica.regracolecao.impl.*;

// versao templates

public  class FabricaRegra   {

	private static FabricaRegra _instancia =  null;
	public static FabricaRegra getInstancia() {
		if (_instancia==null) _instancia = new FabricaRegra();
		return _instancia;
	}

	private  ProdutoComumRegraColecao _produtoComumRegraColecao;
	public  ProdutoComumRegraColecao getProdutoComumRegraColecao() {
		if (_produtoComumRegraColecao==null) _produtoComumRegraColecao = new ProdutoComumRegraColecaoImpl();
		return _produtoComumRegraColecao;
	}
	private  CategoriaProdutoRegraColecao _categoriaProdutoRegraColecao;
	public  CategoriaProdutoRegraColecao getCategoriaProdutoRegraColecao() {
		if (_categoriaProdutoRegraColecao==null) _categoriaProdutoRegraColecao = new CategoriaProdutoRegraColecaoImpl();
		return _categoriaProdutoRegraColecao;
	}
	private  PrecoLojaRegraColecao _precoLojaRegraColecao;
	public  PrecoLojaRegraColecao getPrecoLojaRegraColecao() {
		if (_precoLojaRegraColecao==null) _precoLojaRegraColecao = new PrecoLojaRegraColecaoImpl();
		return _precoLojaRegraColecao;
	}
	private  CategoriaRegraColecao _categoriaRegraColecao;
	public  CategoriaRegraColecao getCategoriaRegraColecao() {
		if (_categoriaRegraColecao==null) _categoriaRegraColecao = new CategoriaRegraColecaoImpl();
		return _categoriaRegraColecao;
	}

}