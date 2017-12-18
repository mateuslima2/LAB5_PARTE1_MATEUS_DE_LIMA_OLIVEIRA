package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import models.Aposta;
import models.Cenario;

public class Sistema {
	
	private int caixa;
	private double taxa;
	ArrayList<Cenario> cenarios = new ArrayList<>();
		
	public Sistema() {}
	
    public void inicializa(int caixa, double taxa){
    	if(caixa < 0)
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		if(taxa < 0)
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
    	this.caixa = caixa;
    	this.taxa = taxa;
    }

	public int getCaixa() {
		return caixa;
	}

	public int cadastrarCenario(String descricao){
		Cenario c = new Cenario(descricao);
		cenarios.add(c);
		return (this.cenarios.indexOf(c)+1);
	}
	
	public String exibirCenario(int num){
		if(num < 0)
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		return num + cenarios.get(num-1).toString();
	}
	
	public String exibirCenarios(){
		String aux = "";
		for (Cenario c : cenarios) 
			aux += Integer.toString(this.cenarios.indexOf(c)+1) + c.toString(); 
		return aux;
	}
	
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		if (cenario < 1)
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		if((!previsao.equals("N VAI ACONTECER")) &&(!previsao.equals("VAI ACONTECER")))
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		if((previsao == null) ||(previsao.trim().equals("")))
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
	
		Aposta a = new Aposta(apostador, valor, previsao);
		cenarios.get(cenario).cadAposta(a);
	}
	
	public int totalDeApostas(int cenario) {
		if(cenario < 0)
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		return cenarios.get(cenario).numApostas();
	}
	
	public int valorTotalDeApostas(int cenario) {
		if(cenario < 0)
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		return 0;
	}
	
	public String exibeApostas(int cenario) {
		return cenarios.get(cenario).toString();
	}
    
	public void fecharAposta(int cenario, boolean ocorreu) {
		if (ocorreu == true)
			cenarios.get(cenario-1).setEstado("Finalizado(ocorreu)");
		else
			cenarios.get(cenario-1).setEstado("Finalizado(n ocorreu)");
	}
	
	public int getCaixaCenario(int cenario) {
		if (cenarios.get(cenario).getEstado().equals("Finalizado(ocorreu)")) {
			this.caixa += (int)(cenarios.get(cenario).ocorreArracadacao() * this.taxa);
			return (int)(cenarios.get(cenario).ocorreArracadacao() * this.taxa);
		}else {
			this.caixa += (int)(cenarios.get(cenario).nOcorreArrecadacao()*this.taxa);
			return (int)(cenarios.get(cenario).nOcorreArrecadacao()*this.taxa);
		}
	}
	
	public int getTotalRateioCenario(int cenario) {
		if (cenarios.get(cenario).getEstado().equals("Finalizado(ocorreu)")) 
			return (cenarios.get(cenario).ocorreArracadacao()/100);
		else 
			return (cenarios.get(cenario).nOcorreArrecadacao())/100;
	}
	
}
