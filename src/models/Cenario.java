package models;	

import java.util.ArrayList;
import java.util.HashSet;

public class Cenario {
	private String descricao;
	private String estado;
	private ArrayList<Aposta> apostas = new ArrayList<>();
		
	public Cenario(String descricao) {
		
		if(descricao == null)
			throw new NullPointerException();
		else if(descricao.trim().equals(""))
			throw new IllegalArgumentException();
		
		this.descricao = descricao;
		this.estado = "Nao finalizado";
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apostas == null) ? 0 : apostas.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (apostas == null) {
			if (other.apostas != null)
				return false;
		} else if (!apostas.equals(other.apostas))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  " - " + descricao +" - "+ estado;
	}
}
