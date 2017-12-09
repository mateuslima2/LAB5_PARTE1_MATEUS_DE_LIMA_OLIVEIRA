package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import models.Aposta;
import models.Cenario;

public class Sistema {
	private int caixa;
	private double taxa;
	HashMap<Integer, Cenario> cenarios = new HashMap<>();
		
	public Sistema() {}
	
    public void inicializa(int caixa, double taxa){
    	this.caixa = caixa;
    	this.taxa = taxa;
    }

	public int getCaixa() {
		return caixa;
	}

	public void cadastrarCenario(String descricao){
		Cenario c = new Cenario(descricao);
		cenarios.put(c.getNumeracao(), c);
	}
	
	public String exibirCenario(int num){
		return cenarios.get(num).toString();
	}
	
	public String exibirCenarios(){
		String aux = "";
		for (Integer key : cenarios.keySet()) 
			aux += cenarios.get(key).toString()+"\n"; 
		 return aux;
	}
	
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		Aposta a = new Aposta(apostador, valor, previsao);
		cenarios.get(cenario).cadAposta(a);
	}
	
	public int totalDeApostas(int cenario) {
		return cenarios.get(cenario).numApostas();
	}
	
	public String exibeApostas(int cenario) {
		return cenarios.get(cenario).exibeApostas();
	}
    
	public void fecharAposta(int cenario, boolean ocorreu) {
		if (ocorreu == true)
			cenarios.get(cenario).setEstado("Finalizado(ocorreu)");
		else
			cenarios.get(cenario).setEstado("Finalizado(n ocorreu)");
	}
	
	public int getCaixaCenario(int cenario) {
		if (cenarios.get(cenarios).getEstado().equals("Finalizado(ocorreu)")) {
			this.caixa += (int)(cenarios.get(cenarios).ocorreArracadacao() * this.taxa);
			return (int)(cenarios.get(cenarios).ocorreArracadacao() * this.taxa);
		}else {
			this.caixa += (int)(cenarios.get(cenarios).nOcorreArrecadacao()*this.taxa);
			return (int)(cenarios.get(cenarios).nOcorreArrecadacao()*this.taxa);
		}
	}
	
	public int getTotalRateioCenario(int cenario) {
		if (cenarios.get(cenarios).getEstado().equals("Finalizado(ocorreu)")) 
			return (cenarios.get(cenarios).ocorreArracadacao()/100);
		else 
			return (cenarios.get(cenarios).nOcorreArrecadacao())/100;
	}
	

}
