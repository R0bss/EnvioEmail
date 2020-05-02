package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnviarEmail
 */
@WebServlet("/EnviarEmail")
public class EnviarEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String myEmail = request.getParameter("myEmail"); //Variavel que armazena o email remetente, esta comentado pois é fixo
		String youEmail = request.getParameter("youEmail");
		String titulo = request.getParameter("titulo");
		String mensagem = request.getParameter("mensagem");
		
		
		Properties props = new Properties();
        /** Parâmetros de conexão com servidor Hotmail */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.outlook.com");
        //props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.port", "587");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication()
                         {
                               return new PasswordAuthentication("WeatherNotificacao@hotmail.com", "weather123");
                         }
                    });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("WeatherNotificacao@hotmail.com")); //Remetente

              message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(youEmail)); //Destinatário(s)
              message.setSubject(titulo);//Assunto
              message.setText(mensagem);// Mensagem do Corpo do Email
              //Método para enviar a mensagem criada/
              Transport.send(message);

              System.out.println("Feito!!!");

         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
       request.getRequestDispatcher("index.jsp");
        
	}

}
