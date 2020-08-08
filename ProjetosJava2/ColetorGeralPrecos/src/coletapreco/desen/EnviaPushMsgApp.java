package coletapreco.desen;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.remoting.Repository;

import br.com.digicom.modelo.DispositivoUsuario;
import br.com.digicom.modelo.repositorio.RepositorioBase;


public class EnviaPushMsgApp {

	private static RestAdapter adapter;
	private static Repository testClass;

	public static void main(String[] args) {
		System.out.println("Ola Mundo");
		RestAdapter adapter = new RestAdapter("https://www.digicom.inf.br:21101/api");
		RepositorioBase.DispositivoUsuarioRepository rep = adapter.createRepository(RepositorioBase.DispositivoUsuarioRepository.class);
		
		rep.cosmeticCenterNotificacao(new ListCallback<DispositivoUsuario>() { 
            
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<DispositivoUsuario> objects) {
				System.out.println("Total Dispositivo: " + objects.size());

				for (DispositivoUsuario item : objects) {
					System.out.println("Token:" + item.getTokenFcm());
				}
			} 
        });
                
		
	}
}
