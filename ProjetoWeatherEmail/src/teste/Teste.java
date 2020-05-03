package teste;

import dao.UsuarioDAO;
import model.Cliente;
import service.ClienteService;

public class Teste {

	public static void main(String[] args) {
		UsuarioDAO user = new UsuarioDAO();
		ClienteService service = new ClienteService();
		
		
		System.out.println(user.checkLogin("Eduardo", "senha123"));

	}

}
