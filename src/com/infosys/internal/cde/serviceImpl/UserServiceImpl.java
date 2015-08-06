package com.infosys.internal.cde.serviceImpl;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.internal.cde.dao.UserDao;
import com.infosys.internal.cde.model.User;
import com.infosys.internal.cde.service.UserService;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
   
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> listUsers() {
		return userDao.listUsers();		
	}
	
	@Override
	public void saveUser(User user){
	 	 userDao.saveUser(user);
	  }
	
	@Override
	public List<User> getUserByUserEmail(String userEmail){
		   return userDao.getUserByUserEmail(userEmail);
	  }
	
	@Override
	public List<User> validateLoginUser(String userEmail,String password){
		return userDao.validateLoginUser(userEmail, password);


	}

	@Override
	public void sendActivationMail(User user) {

		String url = generateActivationURL(user);
		
		System.out.println("URL generated :: "+url);

		Properties props = new Properties();
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.host", "javamail.cisco.com");
		props.put("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(props);
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cde_development@cisco.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(user.getUserEmail()));
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			message.setSubject("CDE Account Confirmation");
			String htmlText ="Hi "+user.getUserName()+","+"<br><br>"+"You just signed up for CDE. Please follow this link to confirm that this is your e-mail address."+"<br><br>";
			htmlText = htmlText +"<a href="+url+"><button type='button'>Activate your account</button></a>";
			htmlText = htmlText+"<br><br><br>"+"Thanks,"+"<br>"+"CDE Team."+"<br><br><img width=200 Height=50 src=\"cid:image\">";
			messageBodyPart.setContent(htmlText, "text/html");
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
	       String fileName = "/download2.png";
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			if (classLoader == null) {
			    classLoader = this.getClass().getClassLoader();
			}

			DataSource fds = new FileDataSource(new File(classLoader.getResource(fileName).toURI()));
	        messageBodyPart.setDataHandler(new DataHandler(fds));
	        messageBodyPart.setHeader("Content-ID","<image>");
	        multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);

			System.out.println("Mail sent successfully!!!!!!!!");

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public String generateActivationURL(User user) {
		// TODO Auto-generated method stub
		return "http://localhost:8080/CDE/forms/user/userconfirmation.html?&token="+user.getRandom();
	}

	@Override
	public boolean ValidateEmailDomain(String userEmail) {
		// TODO Auto-generated method stub
		if(userEmail.contains("@cisco.")||userEmail.contains("@infosys.")){
			return true;
		}
		return false;
	}

	@Override
	public List<User> getStatusOfUser(String userEmail) {
		// TODO Auto-generated method stub
		 return userDao.getStatusOfUser(userEmail);
	}

	@Override
	public void activateUser(int token) {
		// TODO Auto-generated method stub
		userDao.activateUser(token);
		
	}
}
