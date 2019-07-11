package visitadorprodutos.modelo;


import digicom.conexao.*;
import java.util.Date;


public interface ProdutoSiteVO {


public void setIdProdutoSite(int idProdutoSite);

public int getIdProdutoSite();

public void setRotuloSite(String rotuloSite);

public String getRotuloSite();

public void addObservacaoVisita(ObservacaoVisitaVO item );

public Collection getListaObservacaoVisita();

}
