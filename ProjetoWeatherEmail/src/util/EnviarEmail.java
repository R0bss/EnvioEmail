package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Cliente;

public class EnviarEmail {
	
	public static void enviarEmail(Cliente cliente) {
		
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
                        	 //Login padrao que sera usado para enviar os emails
                               return new PasswordAuthentication("WeatherNotificacao@hotmail.com", "weather123");
                         }
                    });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("WeatherNotificacao@hotmail.com")); //Remetente

              message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(cliente.getEmail())); //Destinatário(s)
              message.setSubject("Weather.Me Informa - Clima do dia");//Assunto
           // Essa parte é a mensagem do clima que vai ser mandada para o usuario
           // Que no momento tamo mandando so a cidade porque é o parametro que o api de tempo pede
              message.setText(cliente.getCidade());
              //Método para enviar a mensagem criada/
              Transport.send(message);

              System.out.println("Feito!!!");

         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
		
	}
}
