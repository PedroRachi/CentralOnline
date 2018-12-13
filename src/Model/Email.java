package Model;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Email
{
	
      public void enviar(String remetente, String senha, String destinatario, String titulo, String menssagem){
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
 
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication(remetente, senha);
                             }
                        });
 
            /** Ativa Debug para sessão */
            session.setDebug(true);
 
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(remetente)); //Remetente
 
                  Address[] toUser = InternetAddress //Destinatário(s) , seucolega@hotmail.com, seuparente@yahoo.com.br
                             .parse(destinatario);  
 
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject(titulo);//Assunto
                  message.setText(menssagem);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
 
                  System.out.println("Feito!!!");
 
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
      
      public void enviarPadrao(String destinatario, String titulo, String menssagem){
          Properties props = new Properties();
          /** Parâmetros de conexão com servidor Gmail */
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.port", "587");

          Session session = Session.getDefaultInstance(props,
                      new javax.mail.Authenticator() {
                           protected PasswordAuthentication getPasswordAuthentication() 
                           {
                                 return new PasswordAuthentication("centralonlinesaojudas@gmail.com", "saojudas1234");
                           }
                      });

          /** Ativa Debug para sessão */
          session.setDebug(true);

          try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("centralonlinesaojudas@gmail.com")); //Remetente

                Address[] toUser = InternetAddress //Destinatário(s) , seucolega@hotmail.com, seuparente@yahoo.com.br
                           .parse(destinatario);  

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject(titulo);//Assunto
                message.setText(menssagem);
                /**Método para enviar a mensagem criada*/
                Transport.send(message);

                System.out.println("Feito!!!");

           } catch (MessagingException e) {
                throw new RuntimeException(e);
          }
    }
}