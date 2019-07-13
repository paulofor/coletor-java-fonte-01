package br.com.digicom.parse;

public class CampoPost {

	private String chave;
	private String valor;
	
	public CampoPost(String chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}
	
	public String getChave() {
		return chave;
	}
	
	public String getValor() {
		return valor;
	}
}
