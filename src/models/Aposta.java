package models;

public class Aposta {
	private String nome;
	private int valor;
	private String previsao;
	
	public Aposta(String nome, int valor, String previsao) {
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
	}

	@Override
	public String toString() {
		return  nome + " - R$" + (valor/100) + ",00 - "	+ previsao ;
	}
	
	

}
