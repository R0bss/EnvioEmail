import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {
	
	public static void main(String[] args) {
		
		//commons-email-1.5.jar
		//mail-1.4.7.jar
		
		String meuEmail = "robertolrv1957@gmail.com";
		String minhaSenha = "23R45j67a";
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true);
		
		try  {
			email.setFrom(meuEmail);
			email.setSubject("Teste 1");
			email.setMsg("Testando envio de email");
			email.addTo(meuEmail);
			email.send();
			System.out.println("Email foi enviado com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
