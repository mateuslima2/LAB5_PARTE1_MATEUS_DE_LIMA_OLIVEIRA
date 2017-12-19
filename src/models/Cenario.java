package models;	

import java.util.ArrayList;
import java.util.HashSet;

public class Cenario {
	private String descricao;
	private String estado;
	private ArrayList<Aposta> apostas = new ArrayList<>();
		
	/**
	* Construção um cenario da descrição
	* @param descricao descricao do cenario
	*/
	public Cenario(String descricao) {
		if(descricao == null)
			throw new NullPointerException();
		else if(descricao.trim().equals(""))
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		
		this.descricao = descricao;
		this.estado = "Nao finalizado";
	}

	/**
	*cadastra aposta
	* @returns 
	*/
	public void cadAposta(Aposta a) {
		if(a == null)
			throw new NullPointerException();
		apostas.add(a);
	}
	
	/**
	*lista apostas de determinado cenario
	* @returns lista de apostas do cenario
	*/
	public String exibeApostas() {
		String aux = "";
		for (Aposta ap : apostas) 
			aux += ap.toString(); 
		return aux;
	}
	
	public int totalDeApostas() {
		return 0;
	}
	
	/**
	*soma valores de apostas campeas
	* @returns soma dos valores de apostas campeas
	*/
	public int ocorreArracadacao() {
		int soma = 0;
		for (Aposta ap : apostas) 
			if(ap.getPrevisao().getClass().equals("VAI ACONTECER"))
				soma += ap.getValor(); 
		return soma;
	}
	/**
	*soma valores de apostas campeas
	* @returns soma dos valores de apostas campeas
	*/
	public int nOcorreArrecadacao() {
		int soma = 0;
		for (Aposta ap : apostas) 
			if(ap.getPrevisao().getClass().equals("N VAI ACONTECER"))
				soma += ap.getValor(); 
		return soma;
		
	}
	/**
	*retorna numero de apostas de determinado cenario
	* @returns int numero de apostas
	*/
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
	/**
	 * Retorna true se o objeto for igual ou false se for falso. 
	 *@param obj outro objeto cenario
	 * @returns boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
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
	/**
	 * Retorna a String que representa um cenario. 
	 * @returns a representação em String de um cenario.
	 */
	@Override
	public String toString() {
		return  " - " + descricao +" - "+ estado;
	}
}
