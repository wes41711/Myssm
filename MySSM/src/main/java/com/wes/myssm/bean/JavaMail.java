package com.wes.myssm.bean;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.stereotype.Component;

@Component
public class JavaMail {

	private String userName = ""; // 寄件者信箱
	private String password = ""; // 
	private String customer = ""; // 收件者信箱
	private String subject = "密碼信件"; // 信件標題
	private String txt = "";// 信件內容

	/**
	 * @param userName
	 * @param password
	 * @param customer
	 * @param subject
	 * @param txt
	 */
	public JavaMail(String userName, String password, String customer, String subject, String txt) {
		super();
		this.userName = userName;
		this.password = password;
		this.customer = customer;
		this.subject = subject;
		this.txt = txt;
	}

	/**
	 * 
	 */
	public JavaMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void SendMail() {
		// ---------------------------------------------------------連線設定
		Properties prop = new Properties();

		// 設定連線為smtp
		prop.setProperty("mail.transport.protocol", "smtp");

		// host主機:smtp.gmail.com
		prop.setProperty("mail.host", "smtp.gmail.com");

		// host port:465
		prop.put("mail.smtp.port", "465");

		// 寄件者帳號需要驗證：是
		prop.put("mail.smtp.auth", "true");

		// 需要安全資料傳輸層 (SSL)：是
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// 安全資料傳輸層 (SSL) 通訊埠：465
		prop.put("mail.smtp.socketFactory.port", "465");

		// 顯示連線資訊
		prop.put("mail.debug", "true");

		// ---------------------------------------------------------驗證
		// ---------------------------------------------------------Session默認屬性設定值
		// 匿名類別
//		Session session = Session.getDefaultInstance(prop, new Authenticator() {
//
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(userName, password);
//			}
//		});

		// class
		Auth auth = new Auth(userName, password);
		Session session = Session.getDefaultInstance(prop, auth);

		// ---------------------------------------------------------Message郵件格式
		MimeMessage message = new MimeMessage(session);

		try {
			// 寄件者
			// 匿名類別
			// message.setSender(new InternetAddress(userName));

			// class
			InternetAddress sender = new InternetAddress(userName);
			message.setSender(sender);

			// 收件者
			message.setRecipient(RecipientType.TO, new InternetAddress(customer));

			// 標題
			message.setSubject(subject);

			// 內容/格式
			message.setContent(txt, "text/html;charset = UTF-8");

			// ---------------------------------------------------------Transport傳送Message
			Transport transport = session.getTransport();

			// transport將message送出
			transport.send(message);

			// 關閉Transport
			transport.close();

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the txt
	 */
	public String getTxt() {
		return txt;
	}

	/**
	 * @param txt the txt to set
	 */
	public void setTxt(String txt) {
		this.txt = txt;
	}

}

class Auth extends Authenticator {

	private String userName;
	private String password;

	public Auth(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(userName, password);
		return pa;
	}

}