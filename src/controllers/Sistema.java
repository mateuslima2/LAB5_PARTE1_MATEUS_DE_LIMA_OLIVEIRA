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
		return cenarios.get(num).toString();
	}
	
	public String exibirCenarios(){
		String aux = "";
		for (Cenario c : cenarios) 
			aux += Integer.toString(this.cenarios.indexOf(c)+1) + c.toString(); 
		 return aux;
	}
	
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		Aposta a = new Aposta(apostador, valor, previsao);
		cenarios.get(cenario).cadAposta(a);
	}
	
	public int totalDeApostas(int cenario) {
		return cenarios.get(cenario).numApostas();
	}
	
	public int valorTotalDeApostas(int cenario) {
		return 0;
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
