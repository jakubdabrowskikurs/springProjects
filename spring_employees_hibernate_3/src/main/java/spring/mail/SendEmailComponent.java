package spring.mail;

import spring.hibernate.Employees;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailComponent {

    private Session session;
    private String username;
    private String password;
    private Properties prop;

    public SendEmailComponent() {
        config();
    }

    private void config() {
        this.username = "test.kurs.123123@gmail.com";
        this.password = "Test1234@";

        prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        this.session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public void sendEmailUpdate(Employees employees) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(employees.getEmail()));
            message.setSubject("Aktualizacja danych");
            message.setText("Dzień dobry " + employees.getFirstName() + "," + "\n\n Twoje dane zostały zaktualizowane");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailDelete(Employees employees) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(employees.getEmail()));
            message.setSubject("Usunięcie danych");
            message.setText("Dzień dobry " + employees.getFirstName() + "," + "\n\n Twoje dane zostały usunięte");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public void sendEmailAdd(Employees employees) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(employees.getEmail()));
            message.setSubject("Aktualizacja danych");
            message.setText("Dzień dobry " + employees.getFirstName() + "," + "\n\n Twoje dane zostały dodane do bazy pracowników");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
