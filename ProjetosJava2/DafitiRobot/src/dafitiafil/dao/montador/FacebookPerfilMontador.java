package dafitiafil.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import dafitiafil.modelo.FacebookPerfil;
import dafitiafil.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class FacebookPerfilMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaFacebookPerfil();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaFacebookPerfil();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		FacebookPerfil objeto;
		objeto = (FacebookPerfil)entrada;
		  
	  	objeto.setIdFacebookPerfil(resultadoLista.getInt(pos++));  
	  	objeto.setFacebookId(resultadoLista.getString(pos++));  
	  	objeto.setNome(resultadoLista.getString(pos++));  
	  	objeto.setSobrenome(resultadoLista.getString(pos++));  
	  	objeto.setEmailUtilizado(resultadoLista.getString(pos++));  
	  	objeto.setAplicacaoNome(resultadoLista.getString(pos++));  
	  	objeto.setAplicacaoId(resultadoLista.getString(pos++));  
	  	objeto.setAplicacaoChave(resultadoLista.getString(pos++));  
	  	objeto.setTokenAcesso(resultadoLista.getString(pos++));  
	  	objeto.setValorMaximoProduto(resultadoLista.getFloat(pos++));  
	  	objeto.setValorMinimoProduto(resultadoLista.getFloat(pos++));  
	  	objeto.setIdCategoriaProdutoRa(resultadoLista.getInt(pos++));  
	  	objeto.setIdProdutoI(resultadoLista.getInt(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 13;
	}

}
