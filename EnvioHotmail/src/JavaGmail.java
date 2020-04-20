import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaGmail
{
      public static void main(String[] args) {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication()
                             {
                                   return new PasswordAuthentication("luizroberto943@gmail.com", "");
                             }
                        });
 
            /*Ativa Debug para sessão */
            session.setDebug(true);
 
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("luizroberto943@gmail.com")); //Remetente
 
                  message.setRecipients(Message.RecipientType.TO,
                                    InternetAddress.parse("luizroberto943@gmail.com")); //Destinatário(s)
                  message.setSubject("Enviando email com JavaMail");//Assunto
                  message.setText("Enviei este email utilizando JavaMail com minha conta Gmail!");
                  /*Método para enviar a mensagem criada*/
                  Transport.send(message);
 
                  System.out.println("Feito!!!");
 
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}