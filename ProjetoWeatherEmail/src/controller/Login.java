package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;
import util.EnviarEmail;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnome = request.getParameter("nome");
		String psenha = request.getParameter("senha");
		String acao = request.getParameter("acao");
		
		Cliente cliente = new Cliente();
		cliente.setNome(pnome);
		cliente.setSenha(psenha);
		
		ClienteService ps = new ClienteService();
		RequestDispatcher dispatcher = null;
		
			
			if(acao.equals("Login")) {
			cliente = ps.checkLogin(cliente.getNome(), cliente.getSenha());
			//manda parametro para o JSP via request
			request.setAttribute("cliente", cliente);
			dispatcher = request.getRequestDispatcher("Logado.jsp");
			}
			else if("Enviar".equals(acao)) {
				int id = Integer.parseInt(request.getParameter("id"));
				cliente.setId(id);
				cliente = ps.carregar(cliente.getId());
				EnviarEmail.enviarEmail(cliente);
				request.setAttribute("cliente", cliente);
				dispatcher = request.getRequestDispatcher("Logado.jsp");
			}
			
		dispatcher.forward(request, response);
	}

}
