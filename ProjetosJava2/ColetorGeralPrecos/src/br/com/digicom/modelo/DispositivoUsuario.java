package br.com.digicom.modelo;

import com.strongloop.android.loopback.Model;

public class DispositivoUsuario extends Model {
	
	private String tokenFcm;

	public String getTokenFcm() {
		return tokenFcm;
	}

	public void setTokenFcm(String tokenFcm) {
		this.tokenFcm = tokenFcm;
	}
	
	
}
