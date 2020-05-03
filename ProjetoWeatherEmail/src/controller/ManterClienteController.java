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



/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pCidade = request.getParameter("cidade");
		String pSenha = request.getParameter("senha");
		String acao = request.getParameter("acao");

		//instanciar o javabean
		Cliente cliente = new Cliente();
		cliente.setNome(pNome);
		cliente.setEmail(pEmail);
		cliente.setSenha(pSenha);
		cliente.setCidade(pCidade);

		//instanciar o service
		ClienteService ps = new ClienteService();
		RequestDispatcher dispatcher = null;

		switch(acao){
		case "Criar":
			ps.criar(cliente);
			cliente = ps.carregar(cliente.getId());

			//manda parametro para o JSP via request
			request.setAttribute("cliente", cliente);
			dispatcher = request.getRequestDispatcher("Cliente.jsp");
			break;
		}

		//despachar para o JSP correto
		dispatcher.forward(request, response);

	}

}