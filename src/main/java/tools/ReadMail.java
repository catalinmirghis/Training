package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

import net.thucydides.core.pages.SystemClock;

public class ReadMail {
	String beta = "";
	Properties properties = null;
	private Session session = null;
	private Store store = null;
	private Folder inbox = null;
	private String userName = "catalin.mirghis@evozon.com";// provide user name
	private String password = "Monkey123!";// provide password

	public ReadMail() {

	}

	public void readLastMails() {
		
		String sbj = "You have submitted a new Vacation Request";
		
		
		
		properties = new Properties();
		properties.setProperty("mail.host", "mail.evozon.com");
		properties.setProperty("mail.port", "993");
		properties.setProperty("mail.transport.protocol", "imaps");
		session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(userName, password);
					}
				});
		try {
			store = session.getStore("imaps");
			store.connect();
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			Message messages[] = inbox.search(new FlagTerm(
					new Flags(Flag.SEEN), false));
			;
			System.out.println("Number of mails = " + messages.length);

			Message message = messages[messages.length - 1];
			Address[] from = message.getFrom();
			System.out.println("-------------------------------");
			System.out.println("Date : " + message.getSentDate());
			System.out.println("From : " + from[0]);
			

			System.out.println("Subject: " + message.getSubject());
			
			String subject = message.getSubject();
			
			System.out.println("Content :");
			processMessageBody(message);
			System.out.println();
			System.out.println("--------------------------------");

			// }
		
			
			if (subject.toLowerCase().trim().equals(sbj.toLowerCase().trim())){
				System.out.println("The subject is the same");

			}
			
	
			inbox.close(true);
			store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void processMessageBody(Message message) {
		try {
			Object content = message.getContent();
			// check for string
			// then check for multipart
			if (content instanceof String) {
				System.out.println(content);
				
				beta = content.toString();
				
			} else if (content instanceof Multipart) {
				Multipart multiPart = (Multipart) content;
				procesMultiPart(multiPart);
			} else if (content instanceof InputStream) {
				InputStream inStream = (InputStream) content;
				int ch;
				while ((ch = inStream.read()) != -1) {
					System.out.write(ch);
				}

			}
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void getContentDate(String startdate, String enddate){
		int i;
		StringBuilder started = new StringBuilder();
		StringBuilder ended = new StringBuilder();
		
		i=tools.StringUtils.getAllIntegerNumbersFromString(beta).get(0);
		started.append(i);
		started.append("/");
		i=tools.StringUtils.getAllIntegerNumbersFromString(beta).get(1);
		started.append(i);
		started.append("/");
		i=tools.StringUtils.getAllIntegerNumbersFromString(beta).get(2);
		started.append(i);
		
		System.out.println(started);
		
		i=tools.StringUtils.getAllIntegerNumbersFromString(beta).get(3);
		ended.append(i);
		ended.append("/");
		i=tools.StringUtils.getAllIntegerNumbersFromString(beta).get(4);
		ended.append(i);
		ended.append("/");
		i=tools.StringUtils.getAllIntegerNumbersFromString(beta).get(5);
		ended.append(i);
		
		System.out.println(ended);
		
		if(startdate.equals(started.toString()) && enddate.equals(ended.toString())){
			System.out.println("The content is the same");
		}
	}
	public void procesMultiPart(Multipart content) {

		try {
			int multiPartCount = content.getCount();
			for (int i = 0; i < multiPartCount; i++) {
				BodyPart bodyPart = content.getBodyPart(i);
				Object o;

				o = bodyPart.getContent();
				if (o instanceof String) {
					System.out.println(o);
				} else if (o instanceof Multipart) {
					procesMultiPart((Multipart) o);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ReadMail sample = new ReadMail();
		sample.readLastMails();
		sample.getContentDate("18/1/2016","20/1/2016");
	}

}