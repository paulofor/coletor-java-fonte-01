package visitadorprodutos.modelo;


import digicom.conexao.*;
import java.util.Date;


public interface ProdutoVO {


public void setIdProduto(int idProduto);

public int getIdProduto();

public void setNome(String nome);

public String getNome();

public void addProdutoSite(ProdutoSiteVO item );

public Collection getListaProdutoSite();

}
