package co.edu.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;


public class MailAppNaver {

	public String sendMail(String from, String to, String subject, String content) {
		
		
		String _email = "nmj_1025@naver.com"; // 메일계정 로그인 아이디
		String _password = "alwnsms!7"; // 비밀번호

		System.out.println("메일 발송 중. 기다려주세요~!");
		System.out.println("〜(￣▽￣〜)(〜￣▽￣)〜〜(￣▽￣〜)(〜￣▽￣)〜〜(￣▽￣〜)(〜￣▽￣)〜");
		String fromMail = from; // "cholee@yedam.ac"; 보내는사람
		String fromName = "miju";
		String toMail = to; // "leadon@naver.com"; // 콤마(,) 나열 가능, 받는사람

		// mail contents
		StringBuffer contents = new StringBuffer();
		contents.append("<h1>Hello</h1>\n");
		contents.append("<p>Nice to meet you ~! :)</p><br>");

		// mail properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.naver.com"); // use Naver
		props.put("mail.smtp.port", "587"); // set port

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); // use TLS
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() { // set authenticator
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(_email, _password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(mailSession);

			message.setFrom(new InternetAddress(fromMail, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 한글의 경우
																											// encoding
																											// 필요
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=UTF-8"); // 내용 설정 (HTML 형식)
			message.setSentDate(new java.util.Date());

			Transport t = mailSession.getTransport("smtp");
			t.connect(_email, _password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();

			System.out.println("임시비밀번호 발송이 완료되었습니다. ~!");
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
	}

}