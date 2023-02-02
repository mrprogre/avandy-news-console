package email;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmailManager {
    private final String today = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.now());
    private final String subject = ("News (" + today + ")");
    private final StringBuilder text = new StringBuilder();

    // Отправка письма
    public void sendMessage(List<String> headlinesList, String sendEmail, String emailPwd, String sendTo) {
        for (String s : headlinesList) {
            text.append(s).append("\n\n");
        }
        try {
            new Sender().send(subject, text.toString(),
                    sendEmail,
                    emailPwd,
                    sendTo);
            System.out.println("e-mail sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}