package coletorboadica.modelo;

import  coletorboadica.modelo.vo.*;

// versao templates

public  class FabricaVo   {
	public static ProdutoComum criaProdutoComum()  {
          return new ProdutoComumVo();
	}
	public static CategoriaProduto criaCategoriaProduto()  {
          return new CategoriaProdutoVo();
	}
	public static PrecoLoja criaPrecoLoja()  {
          return new PrecoLojaVo();
	}
	public static Categoria criaCategoria()  {
          return new CategoriaVo();
	}

}