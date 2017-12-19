package controllers;

public class Facade {
	private Sistema sistema;

	public Facade() {
		this.sistema = new Sistema();
	}
	/**
	 * Inicializa o Sistema de Apostas.
	 * 
	 * @param caixa valor do caixa do Sistema.
	 * @param taxa percentual de ganho do Sistema sobre as apostas.
	 * 
	 * @return void.
	 * 
	 * @see Sistema#inicializa(int, double)
	 * 
	 */
	public void inicializa(int caixa, double taxa) {
		sistema.inicializa(caixa, taxa);
	}
	
	public int getCaixa() {
		return sistema.getCaixa();
	}
	
	/**
	 * Cadastra um novo Cenario no Sistema de Apostas.
	 * 
	 * @param descricao A descrição do novo Cenario a ser cadastrado.
	 * 
	 * @return O ID do Cenario cadastrado.
	 * 
	 * @see Sistema#cadastrarCenario(String)
	 * 
	 */
	public int cadastrarCenario(String descricao) {
		return sistema.cadastrarCenario(descricao);
	}

	public String exibirCenario(int cenario) {
		return sistema.exibirCenario(cenario);
	}
	/**
	 * Exibe todos os Cenarios cadastrados no Sistema de Apostas.
	 * 
	 * @return A listagem de Cenarios registrados.
	 *
	 * @see Sistema#exibirCenarios()
	 * 
	 */
	public String exibirCenarios() {
		return sistema.exibirCenarios();
	}
	/**
	 * Cadastra uma nova Aposta em um dos Cenarios cadastrados no Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario que receberá a Aposta.
	 * @param apostador O nome do apostador.
	 * @param valor O valor apostado.
	 * @param previsao A previsão da Aposta.
	 * 
	 * @return void.
	 * 
	 * @see Sistema#cadastrarAposta(int, String, int, String)
	 * 
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		sistema.cadastraAposta(cenario, apostador, valor, previsao);
	}
	
	/**
	 * Calcula o valor total apostado em um dos Cenarios do Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return O valor total apostato no Cenario.
	 * 
	 * @see Sistema#valorTotalDeApostas(int)
	 * 
	 */
	public int valorTotalDeApostas(int cenario) {
		return sistema.totalDeApostas(cenario);
	}
	
	/**
	 * Calcula o número de Apostas de um dos Cenarios do Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return O número de Apostas registradas no Cenario.
	 * 
	 * @see Sistema#totalDeApostas(int)
	 * 
	 */
	public int totalDeApostas(int cenario) {
		return sistema.valorTotalDeApostas(cenario);
	}

	/**
	 * Exibe as Apostas feitas sobre um dos Cenarios do Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return A listagem de Apostas do Cenario.
	 * 
	 * @see Sistema#exibeApostas(int)
	 * 
	 */
	public String exibeApostas(int cenario) {
		return sistema.exibeApostas(cenario);
	}
	
	/**
	 * Encerra as Apostas de um dos Cenarios do Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * @param ocorreu A ocorrência do Cenario a ser encerrado.
	 * 
	 * @return void.
	 * 
	 * @see Sistema#fecharCenario(int, boolean)
	 * 
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		sistema.fecharCenario(cenario, ocorreu);
	}

	
	/**
	 * Calcula o ganho do caixa a partir do encerramento de um Cenario no Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return O lucro do caixa.
	 * 
	 * @see Sistema#getCaixaCenario(int)
	 * 
	 */
	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}
	
	/**
	 * Calcula o valor a ser rateado entre os vencedores a partir do encerramento de um Cenario no
	 * Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return O valor a ser rateado entre os vencedores.
	 * 
	 * @see Sistema#getTotalRateioCenario(int)
	 * 
	 */
	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateioCenario(cenario);
	}
	
	
}
