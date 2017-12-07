package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sistema {
	private int caixa;
	private double taxa;
	private int contador = 0;
	
	HashMap<Integer, HashSet> apostas = new HashMap<>();
	ArrayList<String> cenarios = new ArrayList<>();
	
	public Sistema() {}
	
    public void inicializa(int caixa, double taxa){
    	this.caixa = caixa;
    	this.taxa = taxa;
    }

	public int getCaixa() {
		return caixa;
	}

	public int cadastrarCenario(String descricao){
		cenarios.add(descricao);
		this.contador += 1;
		return this.contador;
	}
	
	public String exibirCenario(int cenario){
		return cenarios.get(cenario-1);
	}
	
	public String exibirCenarios(){
		 
	}
    

}
