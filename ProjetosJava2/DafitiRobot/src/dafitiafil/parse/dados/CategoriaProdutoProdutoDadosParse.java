package dafitiafil.parse.dados;

import dafitiafil.modelo.CategoriaProdutoProduto;
import dafitiafil.parse.dados.basico.CategoriaProdutoProdutoDadosParseBase;

public class CategoriaProdutoProdutoDadosParse extends CategoriaProdutoProdutoDadosParseBase{

	protected boolean iguais(CategoriaProdutoProduto item1, CategoriaProdutoProduto item2) {
		return (item1.getIdProdutoRa()==item2.getIdProdutoRa() && item1.getIdCategoriaProdutoRa()==item2.getIdCategoriaProdutoRa());
	}

}