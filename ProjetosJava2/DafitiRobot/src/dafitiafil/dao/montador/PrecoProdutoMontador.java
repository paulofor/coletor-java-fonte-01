package dafitiafil.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import dafitiafil.modelo.PrecoProduto;
import dafitiafil.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class PrecoProdutoMontador   implements MontadorDaoI { 

	public DaoItemRetorno extraiRegistroListaInterna(ResultadoLista result,DCIObjetoDominio objeto) throws  DaoException
    {
		DaoItemRetorno retorno = new DaoItemRetorno();
    	objeto = ((MontadorDaoI)this).extraiRegistro(result);
    	retorno.setInsere(true);
    	retorno.setObjeto(objeto);
        return retorno;
    }
	
    public DaoItemRetorno extraiRegistroInterno(ResultadoLista result, DCIObjetoDominio objeto) throws  DaoException
    {
    	DaoItemRetorno retorno = new DaoItemRetorno();
    	objeto = ((MontadorDaoI)this).extraiRegistro(result);
    	retorno.setInsere(true);
    	retorno.setObjeto(objeto);
        return retorno;
    }
    
    public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaPrecoProduto();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaPrecoProduto();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		PrecoProduto objeto;
		objeto = (PrecoProduto)entrada;
		  
	  	objeto.setIdPrecoProduto(resultadoLista.getInt(pos++));  
	  	objeto.setValorPrecoAvista(resultadoLista.getFloat(pos++));  
	  	objeto.setDataVisitaInicial(resultadoLista.getString(pos++));  
	  	objeto.setQuantidadeParcela(resultadoLista.getInt(pos++));  
	  	objeto.setValorParcela(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoPromocional(resultadoLista.getFloat(pos++));  
	  	objeto.setValorConsumidor(resultadoLista.getFloat(pos++));  
	  	objeto.setDataUltimaVisita(resultadoLista.getString(pos++));  
	  	objeto.setPercentualAjuste(resultadoLista.getFloat(pos++));  
	  	objeto.setIdProdutoPa(resultadoLista.getInt(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 10;
	}

}
