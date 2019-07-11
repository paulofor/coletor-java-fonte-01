package visitadorprodutos.modelo;


import digicom.conexao.*;
import java.util.Date;


public interface PlanejamentoVisitaVO {


public void setIdPlanejamentoVisita(int idPlanejamentoVisita);

public int getIdPlanejamentoVisita();

public void setProximaData(Date proximaData);

public Date getProximaData();

public void setNome(String nome);

public String getNome();

public void setPeriodicidade(String periodicidade);

public String getPeriodicidade();

public void addExecucaoVisita(ExecucaoVisitaVO item );

public Collection getListaExecucaoVisita();

public void addVisitaCategoria(VisitaCategoriaVO item );

public Collection getListaVisitaCategoria();

}
