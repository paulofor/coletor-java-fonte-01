package digicom.facebook.obj;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.digicom.lib.dao.DaoException;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Account;
import com.restfb.types.Album;
import com.restfb.types.User;

import dafitiafil.modelo.FacebookPerfil;
import dafitiafil.regracolecao.FabricaRegra;
import dafitiafil.regracolecao.FacebookFotoPostRegraColecao;
import dafitiafil.regracolecao.FacebookPerfilRegraColecao;

public class FbEnviadorObj implements Job{

	private static int idxAlbum = 0;
	private static List<Album> listaAlbum = null;
	
	private FacebookPerfil perfil = null;
	private FacebookFotoPostRegraColecao postSrv = null;
	
	private String tokenPage = null;
	
	public FbEnviadorObj() {
		System.out.println("Inicializou o FbEnviadorObj");
		try {
			perfil = getPerfil();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		criaListaAlbum();
		postSrv = FabricaRegra.getInstancia().getFacebookFotoPostRegraColecao();
		postSrv.getFiltro().setAlvoPostPerfil(perfil);
	}
	
	public FacebookPerfil getPerfil() throws DaoException {
		FacebookPerfilRegraColecao perfilSrv = FabricaRegra.getInstancia().getFacebookPerfilRegraColecao();
		FacebookPerfil perfil = perfilSrv.obtemPorChave(1);
		return perfil;

	}
	
	public boolean ExluiItem(String id) {
		FacebookClient facebookClient = new DefaultFacebookClient(perfil.getTokenAcesso());
		Boolean deleted = facebookClient.deleteObject(id);
		return deleted;
	}
	private void criaListaAlbum() {
		if (listaAlbum!=null) return;
		FacebookClient facebookClient = new DefaultFacebookClient(perfil.getTokenAcesso());
		// Para testar
		User user = facebookClient.fetchObject("me", User.class);
		Connection<Album> albuns = facebookClient.fetchConnection("me/albums", Album.class);
		Connection<Account> paginas = facebookClient.fetchConnection("me/accounts", Account.class);
		this.tokenPage = paginas.getData().get(0).getAccessToken().toString();
		listaAlbum = albuns.getData();
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		enviaOportunidade();
	}
	
	public void enviaOportunidade() {
		int ind = getIndiceAlbum();
		Album corrente = listaAlbum.get(ind);
		System.out.println("Album:" + corrente.getName());
		postSrv.getFiltro().setFacebookIdAlbum(corrente.getId());
		try {
			postSrv.EnviaFotoPost();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int getIndiceAlbum() {
		idxAlbum++;
		if (idxAlbum>=listaAlbum.size())
			idxAlbum = 1;
		return idxAlbum;
	}
}
