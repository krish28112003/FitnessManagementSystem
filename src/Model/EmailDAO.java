package Model;

import Resources.LoginDTO;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;

public class EmailDAO {

    public static void sendEmail(byte[] data, LoginDTO loginDTO) {
        // Email properties
        String host = "smtp.gmail.com"; // SMTP server
        String username = "madhanofficial08@gmail.com"; // Your email username
        String password = "nvdberblgyndoxeb"; // Your email password
        String from = "madhanofficial08@gmail.com"; // Your email address
        String to = loginDTO.getMailID();
        String subject = "Hello Here is your diet plan"; // Provide a meaningful subject line

        try {
            // Setup mail server properties
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");

            // Get the Session object and authenticate with the server
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Create MimeBodyPart for the message body
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Your message here"); // Provide a meaningful message

            // Create MimeBodyPart for the attachment
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new ByteArrayDataSource(data, "application/pdf");
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("500-1000.pdf");

            // Create Multipart and add the message body part and attachment body part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            // Set the Multipart as the message's content
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Email with attached file sent successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
