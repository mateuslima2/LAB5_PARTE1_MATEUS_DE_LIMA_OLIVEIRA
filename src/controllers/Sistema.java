package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import models.Aposta;
import models.Cenario;
import models.CenarioWithBonus;

public class Sistema {
	
	private int caixa;
	private double taxa;
	ArrayList<Cenario> cenarios = new ArrayList<>();
		
	public Sistema() {}
	/**
	 * Constrói um Sistema a partir do seu valor inicial (em centavos) em caixa e da taxa de ganho
	 * de seu caixa sobre as apostas perdedoras.
	 * 
	 * @param caixa O valor inicial (em centavos) do caixa do Sistema.
	 * @param taxa O percentual (representado em double) do ganho do Sistema sobre as apostas.
	 * 
	 */
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
	/**
	 * Cadastra um novo Cenario no Sistema e retorna o int que será o ID do Cenario cadastrado.
	 * @param descricao descrição do Cenario.
	 * @returns int id do cadastro.
	 * 
	 */
	public int cadastrarCenario(String descricao){
		Cenario c = new Cenario(descricao);
		cenarios.add(c);
		return (this.cenarios.indexOf(c)+1);
	}
	
	public int cadastrarCenario(String descricao, int bonus) {
		Cenario c = new CenarioWithBonus(descricao, bonus);
		cenarios.add(c);
		return (this.cenarios.indexOf(c)+1);
	}
	
	/**
	 * Retorna a representação textual do Cenario cujo ID é o parâmetro desse método. 
	 * @param num O numero(id) do Cenario que se deseja acessar.
	 * 
	 * @returns String que representa o Cenario acessado.
	 * 
	 */
	public String exibirCenario(int num){
		if(num < 0)
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		return num + cenarios.get(num-1).toString();
	}
	/**
	 * Retorna a listagem do Cenarios cadastros no Sistema até o momento. 
	 * @returns A listagem de Cenarios registrados no Sistema.
	 * 
	 */
	public String exibirCenarios(){
		String aux = "";
		for (Cenario c : cenarios) 
			aux += Integer.toString(this.cenarios.indexOf(c)+1) + c.toString(); 
		return aux;
	}
	/**
	 * A partir dos parâmetros recebidos, cadastra uma nova Aposta em um Cenario já registrado no
	 * Sistema.
	 * 
	 * @param cenario O ID do Cenario .
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor que foi apostado.
	 * @param previsao previsao sobre a ocorrência do Cenario.
	 * 
	 * @returns void.
	 * 
	 */
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
	
	/**
	 * Retorna o número de Apostas registradas em um dos Cenarios registrados no Sistema até o mo-
	 * mento. 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns O número de Apostas registradas no Cenario acessado.
	 * 
	 */
	public int totalDeApostas(int cenario) {
		if(cenario < 0)
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		return cenarios.get(cenario).numApostas();
	}
	
	/**
	 * Retorna o valor total (em centavos) que foi apostado em um dos Cenarios registrados no Sis-
	 * tema até o momento.  
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns O valor total (em centavos) que foi apostado no Cenario acessado.
	 * 
	 */
	public int valorTotalDeApostas(int cenario) {
		if(cenario < 0)
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		return this.cenarios.get(cenario - 1).totalDeApostas();
	}
	
	/**
	 * Retorna a listagem de Apostas registradas em um dos Cenarios registrados no Sistema até o mo-
	 * mento.
	 * @param cenario O ID do Cenario.
	 * 
	 * @returns String A listagem de Apostas registradas.
	 * 
	 */
	public String exibeApostas(int cenario) {
		return cenarios.get(cenario).toString();
	}
	/**
	 * Finaliza um dos Cenarios registrados no Sistema até o momento. Dentre os dois estados "Fina-
	 * lizado" possíveis, o correto é escolhido a partir do boolean passado como parâmetro do méto-
	 * do. 
	 * 
	 * @param cenario O ID do Cenario.
	 * @param ocorrencia true ou false.
	 * 
	 * @returns void.
	 * 
	 */
	public void fecharCenario(int cenario, boolean ocorreu) {
		if (ocorreu == true)
			cenarios.get(cenario-1).setEstado("Finalizado(ocorreu)");
		else
			cenarios.get(cenario-1).setEstado("Finalizado(n ocorreu)");
	}
	
	/**
	 * Retorna o valor (em centavos) correspondente ao lucro do caixa a partir das Apostas perdedo-
	 * ras de um Cenario registrado no Sistema até o momento. 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns O valor (em centavos) de lucro do caixa em decorrência do Cenario acessado.
	 * 
	 */
	public int getCaixaCenario(int cenario) {
		if (cenarios.get(cenario).getEstado().equals("Não finalizado"))
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		
		if (cenarios.get(cenario).getEstado().equals("Finalizado(ocorreu)")) {
			this.caixa += (int)(cenarios.get(cenario).ocorreArracadacao() * this.taxa);
			return (int)(cenarios.get(cenario).ocorreArracadacao() * this.taxa);
		}else {
			this.caixa += (int)(cenarios.get(cenario).nOcorreArrecadacao()*this.taxa);
			return (int)(cenarios.get(cenario).nOcorreArrecadacao()*this.taxa);
		}
	}
	
	/**
	 * Retorna o valor (em centavos) que será destinado ao rateio entre os vencedores de um Cenario
	 * registrado no Sistema até o momento. 
	 * @param cenario O ID do Cenario.
	 * @returns O valor (em centavos) que será destinado ao rateio entre os vencedores.
	 * 
	 */
	public int getTotalRateioCenario(int cenario) {
		if (cenarios.get(cenario).getEstado().equals("Não finalizado"))
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		
		if (cenarios.get(cenario).getEstado().equals("Finalizado(ocorreu)")) 
			return (cenarios.get(cenario).ocorreArracadacao()/100);
		else 
			return (cenarios.get(cenario).nOcorreArrecadacao())/100;
	}
	
}
