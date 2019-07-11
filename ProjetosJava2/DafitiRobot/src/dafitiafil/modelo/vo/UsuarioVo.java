package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class UsuarioVo implements Usuario
{
		
	public long getIdObj()
    {
       return idUsuario;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdUsuario\" : \"" + idUsuario + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private UsuarioDerivada derivada = null;
	private UsuarioDerivada getDerivada() {
		if (derivada==null) {
			derivada = new UsuarioDerivada(this);
		}
		return derivada;
	}

	private UsuarioAgregado agregado = null;
	private UsuarioAgregado getAgregado() {
		if (agregado==null) {
			agregado = new UsuarioAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idUsuario;
	public long getIdUsuario()
	{
		return idUsuario;
	}
	public  void setIdUsuario(long value)
	{
		idUsuario = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
