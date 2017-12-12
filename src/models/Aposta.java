package models;

public class Aposta {
	private String nome;
	private int valor;
	private String previsao;
	
	public Aposta(String nome, int valor, String previsao) {
		
		if(nome == null)
			throw new NullPointerException();
		else if(nome.trim().equals(""))
			throw new IllegalArgumentException();
		
		if(valor <= 0)
			throw new IllegalArgumentException();
				
		if(previsao == null)
			throw new NullPointerException();
		else if(previsao.trim().equals(""))
			throw new IllegalArgumentException();
		
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

	@Override
	public String toString() {
		return  nome + " - R$" + (valor/100) + ",00 - "	+ previsao +"\n";
	}
	
	

}
