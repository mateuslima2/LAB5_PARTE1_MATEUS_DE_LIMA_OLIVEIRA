package models;

public class CenarioWithBonus extends Cenario {
	private int bonus;
	
	public CenarioWithBonus(String descricao, int bonus) {
		super(descricao);
		if(bonus == 0)
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		this.bonus = bonus;
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
		return soma+bonus;
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
		return soma+bonus;
		
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
		return  " - " + descricao +" - "+ estado+" - R$ " + this.bonus + ",00";
	}
}
