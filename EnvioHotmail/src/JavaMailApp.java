import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp
{
      public static void main(String[] args) {
            Properties props = new Properties();
            /** Par�metros de conex�o com servidor Hotmail */
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
                                   return new PasswordAuthentication("luizroberto@hotmail.com", "23r45j67a");
                             }
                        });
 
            /** Ativa Debug para sess�o */
            session.setDebug(true);
 
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("luizroberto@hotmail.com")); //Remetente
 
                  message.setRecipients(Message.RecipientType.TO,
                                    InternetAddress.parse("luizroberto1957@hotmail.com")); //Destinat�rio(s)
                  message.setSubject("Enviando email com JavaMail");//Assunto
                  message.setText("Enviei este email utilizando JavaMail com minha conta Hotmail!");
                  /**M�todo para enviar a mensagem criada*/
                  Transport.send(message);
 
                  System.out.println("Feito!!!");
 
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}