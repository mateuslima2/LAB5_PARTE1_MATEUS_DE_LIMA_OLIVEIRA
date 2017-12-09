package models;

import java.util.ArrayList;
import java.util.HashSet;

public class Cenario {
	private int numeracao = 0;
	private String descricao;
	private String estado;
	private ArrayList<Aposta> apostas = new ArrayList<>();
		
	public Cenario(String descricao) {
		this.numeracao = setNumeracao(this.numeracao++);
		this.descricao = descricao;
		this.estado = "Não finalizado";
	}

	public void cadAposta(Aposta a) {
		apostas.add(a);
	}
	
	public String exibeApostas() {
		String aux = "";
		for (Aposta ap : apostas) 
			aux += ap.toString()+"\n"; 
		return aux;
	}
	
	public int ocorreArracadacao() {
		int soma = 0;
		for (Aposta ap : apostas) 
			if(ap.getPrevisao().getClass().equals("VAI ACONTECER"))
				soma += ap.getValor(); 
		return soma;
	}

	public int nOcorreArrecadacao() {
		int soma = 0;
		for (Aposta ap : apostas) 
			if(ap.getPrevisao().getClass().equals("N VAI ACONTECER"))
				soma += ap.getValor(); 
		return soma;
		
	}
	
	public int numApostas() {
		return apostas.size();
	}
	public int getNumeracao() {
		return numeracao;
	}
	public int setNumeracao(int numeracao) {
		return this.numeracao = numeracao;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return numeracao + " - " + descricao +" - "+ estado;
	}
	
	
	

}
