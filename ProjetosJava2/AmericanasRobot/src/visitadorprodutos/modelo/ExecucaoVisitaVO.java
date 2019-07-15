package visitadorprodutos.modelo;


import digicom.conexao.*;
import java.util.Date;


public interface ExecucaoVisitaVO {


public void setIdExecucaoVisita(int idExecucaoVisita);

public int getIdExecucaoVisita();

public void setData(Date data);

public Date getData();

public void setMaisRecente(boolean maisRecente);

public boolean getMaisRecente();

public void addObservacaoVisita(ObservacaoVisitaVO item );

public Collection getListaObservacaoVisita();

}
