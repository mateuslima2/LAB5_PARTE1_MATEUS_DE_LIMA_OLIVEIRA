package models;

public class Aposta {
	private String nome;
	private int valor;
	private String previsao;
	
	/**
	 * Construção uma agenda, sem necessidade de parametros
	 *@param nome nome do apostador
	 *@param valor valor da aposta
	 *@param previsao previsao da aposta
	 */
	
	public Aposta(String nome, int valor, String previsao) {
		
		if((nome == null) || (nome.trim().equals("")))
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		if(valor <= 0)
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		if((previsao == null) ||(previsao.trim().equals("")))
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		if((!previsao.equals("N VAI ACONTECER")) &&(!previsao.equals("VAI ACONTECER")))
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
	}

	public int getValor() {
		return valor;
	}
	public String getPrevisao() {
		return previsao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((previsao == null) ? 0 : previsao.hashCode());
		result = prime * result + valor;
		return result;
	}

	/**
	 * Retorna true se o objeto for igual ou false se for falso. 
	 *@param obj outro objeto aposta
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
		Aposta other = (Aposta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (previsao == null) {
			if (other.previsao != null)
				return false;
		} else if (!previsao.equals(other.previsao))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

	 /**
	 * Retorna a String que representa uma aposta. 
	 * @returns a representação em String de uma aposta.
	 */
	@Override
	public String toString() {
		return  nome + " - R$" + (valor/100) + ",00 - "	+ previsao +"\n";
	}

}
