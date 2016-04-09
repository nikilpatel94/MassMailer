/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massmailer;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Evosys
 */
public class MailerEngine {
  
    static String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 )
            month = months[num];
        return month;
    }
    
      
    public void sendMail(String uname,String uemail,double allow,double expe)
    {
                Calendar now = Calendar.getInstance();
                final String username = "nikilp@evosysglobal.com";
		final String password = "Givemerain@#";
                String currmonth=MailerEngine.getMonthForInt((now.get(Calendar.MONTH)));
                int year = Calendar.getInstance().get(Calendar.YEAR);
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("nikilp@evosysglobal.com"));
                        if(uemail!=null)
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(uemail));
			message.setSubject("Reimbusment of "+currmonth);
			message.setText("Dear "+uname+","
				+ "\n\nCan you please confirm receipt of "+currmonth+"-"+year+""+" Allowance QAR "+allow+"/- Expense Re-imbursement QAR "+expe+"/- ,total Amount QAR "+(allow+expe)+"/-.");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    
}
}
