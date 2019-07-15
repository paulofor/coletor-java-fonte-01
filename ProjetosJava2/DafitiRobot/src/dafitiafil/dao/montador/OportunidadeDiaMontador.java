package dafitiafil.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import dafitiafil.modelo.OportunidadeDia;
import dafitiafil.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class OportunidadeDiaMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaOportunidadeDia();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaOportunidadeDia();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		OportunidadeDia objeto;
		objeto = (OportunidadeDia)entrada;
		  
	  	objeto.setIdOportunidadeDia(resultadoLista.getInt(pos++));  
	  	objeto.setDataInicioPrecoAtual(resultadoLista.getString(pos++));  
	  	objeto.setNomeProduto(resultadoLista.getString(pos++));  
	  	objeto.setUrlProduto(resultadoLista.getString(pos++));  
	  	objeto.setValorParcelaAtual(resultadoLista.getFloat(pos++));  
	  	objeto.setValorParcelaAnterior(resultadoLista.getFloat(pos++));  
	  	objeto.setQuantidadeParcelaAnterior(resultadoLista.getInt(pos++));  
	  	objeto.setQuantidadeParcelaAtual(resultadoLista.getInt(pos++));  
	  	objeto.setValorConsumidorAtual(resultadoLista.getFloat(pos++));  
	  	objeto.setValorConsumidorAnterior(resultadoLista.getFloat(pos++));  
	  	objeto.setPercentualAjusteAtual(resultadoLista.getFloat(pos++));  
	  	objeto.setUrlImagem(resultadoLista.getString(pos++));  
	  	objeto.setImagemLocal(resultadoLista.getString(pos++));  
	  	objeto.setQuantidadeExibicao(resultadoLista.getInt(pos++));  
	  	objeto.setCodigoFacebook(resultadoLista.getString(pos++));  
	  	objeto.setDataUltimaPrecoAnterior(resultadoLista.getString(pos++));  
	  	objeto.setUrlAfiliado(resultadoLista.getString(pos++));  
	  	objeto.setNomeMarca(resultadoLista.getString(pos++));  
	  	objeto.setPosicaoProduto(resultadoLista.getInt(pos++));  
	  	objeto.setIdProdutoRa(resultadoLista.getInt(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 20;
	}

}
