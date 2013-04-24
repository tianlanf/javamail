package yafchentw;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String userName = "yafchen@thoughtworks.com";
        //final char[] password = {'Q','i','u','2','0','3','@','t','i','a','n','l','a','n','f'};

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.port",465);

        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                return new javax.mail.PasswordAuthentication(userName,"Qiu203@tianlanf");
            }
        });
        MimeMessage mimeMessage = new MimeMessage(session);
        try{
            InternetAddress address = new InternetAddress("yafchen@thoughtworks.com");
            mimeMessage.setFrom(address);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("tianlanf126@126.com"));
            mimeMessage.setSubject("the first java mail");
            mimeMessage.setText("hi,there");
            Transport.send(mimeMessage);
        }
        catch (Exception e)
        {}

        //System.out.println( "Hello World!" );
    }
}
