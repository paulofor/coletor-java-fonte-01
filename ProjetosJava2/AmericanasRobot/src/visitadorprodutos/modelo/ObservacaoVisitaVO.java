package visitadorprodutos.modelo;


import digicom.conexao.*;
import java.util.Date;


public interface ObservacaoVisitaVO {


public void setIdObservacaoVisita(int idObservacaoVisita);

public int getIdObservacaoVisita();

public void setMaisRecente(boolean maisRecente);

public boolean getMaisRecente();

public void setPreco(float preco);

public float getPreco();

}
