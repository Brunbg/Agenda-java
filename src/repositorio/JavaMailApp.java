package repositorio;

//import java.util.ArrayList;
//import java.util.Properties;
//import javax.mail.Address;
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import modelo.Contato;
// 
//public class JavaMailApp
//{
//  public static void notifica(final String senha,String titulo,ArrayList<Contato> contatos) {
//	String contato= contatos.get(0).getEmail();
//	System.out.println(contato+senha);
//    Properties props = new Properties();
//    /** Parâmetros de conexão com servidor Gmail */
//    props.put("mail.smtp.host", "smtp.gmail.com");
//    props.put("mail.smtp.socketFactory.port", "465");
//    props.put("mail.smtp.socketFactory.class", 
//    "javax.net.ssl.SSLSocketFactory");
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.smtp.port", "465");
// 
//    Session session = Session.getDefaultInstance(props,
//      new javax.mail.Authenticator() {
//           protected PasswordAuthentication getPasswordAuthentication() 
//           {
//                 return new PasswordAuthentication("lobox30aqw@gmail.com", 
//                 senha);
//           }
//      });
// 
//    /** Ativa Debug para sessão */
//    session.setDebug(true);
// 
//    try {
// 
//      Message message = new MimeMessage(session);
//      message.setFrom(new InternetAddress("lobox30aqw@gmail.com")); 
//      //Remetente
// 
//      Address[] toUser = InternetAddress //Destinatário(s)
//                 .parse(contato);  
// 
//      message.setRecipients(Message.RecipientType.TO, toUser);
//      message.setSubject("Compromisso em grupo");//Assunto
//      message.setText("Enviei este email para lembrar do seu compromisso <"+titulo+"> em conjunto com seus amigos, não va deixar eles esperando!");
//      /**Método para enviar a mensagem criada*/
//      Transport.send(message);
// 
//      System.out.println("Feito!!!");
// 
//     } catch (MessagingException e) {
//        throw new RuntimeException(e);
//    }
//  }
//	
//
//}
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.ArrayList;
import java.util.Properties;
import modelo.Contato;

public class JavaMailApp {

	public static void notifica(final String senha,String titulo,ArrayList<Contato> contatos) {

        final String usuario = "projetopoonotificacao@gmail.com";
        final String senhaa = senha;
        int size= contatos.size()-1;
        int aux=size;
        String contato="";
        String grupo="";
        if(size>0) {
        	while (aux > 0) {
        		contato=contato.concat( contatos.get(size-aux).getEmail()+",");
        		if(aux>1){
        		grupo=grupo.concat( contatos.get(size-aux).getNome()+",");}
        		else {
        		grupo=grupo.concat( contatos.get(size-aux).getNome()+" e ");}
        		aux--;
        	}
        	contato=contato.concat(contatos.get(size).getEmail());
        	grupo=grupo.concat( contatos.get(size).getNome());
          }
        else {
        	contato= contatos.get(0).getEmail();
        	grupo=contatos.get(0).getNome();
        }
        
    	System.out.println(contato+senha);

    	Properties prop = new Properties();
    	/** Parâmetros de conexão com servidor Gmail */
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario, senhaa);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("projetopoonotificacao@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(contato)//Destinatário(s)
            );
            message.setSubject("Nova atividade em grupo");
            message.setText("Você tem um compromisso pendente com "+grupo+" : "+titulo
                    + "\n\n Não deixe seus companheiros na espera!");

            Transport.send(message);

            System.out.println("Email enviado com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}