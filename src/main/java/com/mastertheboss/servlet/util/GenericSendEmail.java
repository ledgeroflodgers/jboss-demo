package com.mastertheboss.servlet.util;


import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class GenericSendEmail  {
    private final String CLASS_NAME = this.getClass().getSimpleName();
    private final static String FROM_ADDRESS ="<no-reply@onland.ca>";
    private Session session=null;
    private Properties props=new Properties();

    public GenericSendEmail() throws Exception {

        //setting gmail as SMTP host
        props.put("mail.smtp.host","smtp-unix");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        this.session = Session.getDefaultInstance(props, null);

       //email sender details
        /*final String fromEmail = "saeeddadashi82@gmail.com";
        final String password = "2nestiInoHakKon!";
        props.put("mail.smtp.host", "smtp.gmail.com"); //for GMAIL SMTP server
        //props.put("mail.smtp.host", "smtp.office365.com"); // for outlook SMTP server
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");

        //Adding authenticator
        Authenticator auth = new Authenticator() {
            // override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        this.session = Session.getDefaultInstance(props, auth); //add auth to the session*/


        this.session.setDebug(true);
    }

    public void sendConfirmationEmail(String to, String from, String subject,
                                      String msgbody, List<String> attName, List<byte []> attachment) throws MessagingException, Exception {
        if (to == null)
            return;

        try {
            System.out.println(" to: "+to +" from: "+from +" subject: "+subject);
            int trademark=174;
            char R = (char)trademark;
            //char[] ch = {'O', 'n', 'l', 'a', 'n', 'd', R , '<', 'n', 'o', '-', 'r' ,'e', 'p', 'l', 'y', '@', 'o', 'n','l', 'a','n','d','.','c','a','>'};
            //String str = new String(ch);
            String cleanedFrom = new String(FROM_ADDRESS.getBytes("UTF-8"), "UTF-8");
            //MimeMessage msg = new MimeMessage(session);
            //msg.setFrom(new InternetAddress(cleanedFrom));

            Message msg = new MimeMessage(session);
            InternetAddress ia = new InternetAddress("no-reply@onland.ca", "OnLand\u00AE", "UTF-8" );
            msg.setFrom(ia);

            Vector<InternetAddress> vectAddress=new Vector<InternetAddress>();
            String oneEmail=null;
            int iSemicolon=0;
            int iLast=0;
            while (iSemicolon!= -1)	{
                iSemicolon=to.indexOf(";");
                if (iSemicolon==-1)
                    vectAddress.addElement(new InternetAddress(to.trim()));
                else{
                    oneEmail=to.substring(0,iSemicolon).trim();
                    iLast=iSemicolon+1;
                    vectAddress.addElement(new InternetAddress(oneEmail));
                    to=to.substring(iLast).trim();
                }
            }

            InternetAddress[] address=new InternetAddress[vectAddress.size()];
            vectAddress.copyInto(address);

            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); //adding UTF-8 to subject
            msg.setSentDate(new Date());

            // create the Multipart and its parts to it
            Multipart mp = new MimeMultipart();

            // create and fill the first message part
            MimeBodyPart mbp1 = new MimeBodyPart();

            mbp1.setText(msgbody, "ISO-8859-1", "html");
            mp.addBodyPart(mbp1);

            //msg.setContent(mp);
            msg.setContent(mp,"text/plain; charset=UTF-8");

            // send the message
            Transport.send(msg);
            System.out.println( "<<< " + session.toString() + " " + CLASS_NAME + ":sendFulfillmentEmail end.");

        } catch (MessagingException mex) {
            throw mex;
        } catch (Exception e) {
            throw e;
        }
    }

}

