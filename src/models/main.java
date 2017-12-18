package models;
import java.util.ArrayList;
import easyaccept.EasyAccept;

public class main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ArrayList<String> testes = new ArrayList<>();
		testes.add("acceptance_test/us1_test.txt");
		testes.add("acceptance_test/us2_test.txt");
		EasyAccept.executeEasyAcceptTests("controllers.Facade", testes);
	}
}
