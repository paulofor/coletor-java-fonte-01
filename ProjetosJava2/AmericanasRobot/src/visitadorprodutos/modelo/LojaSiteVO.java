package visitadorprodutos.modelo;


import digicom.conexao.*;
import java.util.Date;


public interface LojaSiteVO {


public void setIdLojaSite(int idLojaSite);

public int getIdLojaSite();

public void setNome(String nome);

public String getNome();

public void setUrl(String url);

public String getUrl();

public void addCategoriaSite(CategoriaSiteVO item );

public Collection getListaCategoriaSite();

public void addVisitaCategoria(VisitaCategoriaVO item );

public Collection getListaVisitaCategoria();

}
