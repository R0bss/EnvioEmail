import com.sendgrid.*;
import java.io.IOException;

public class Exemplo {
  public static void main(String[] args) throws IOException {
    Email from = new Email("luizroberto1957@gmail.com"); // email de envio
    String subject = "Sending with Twilio SendGrid is Fun"; // texto do email
    Email to = new Email("luizroberto1957@hotmail.com"); // email de recebimento
    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}