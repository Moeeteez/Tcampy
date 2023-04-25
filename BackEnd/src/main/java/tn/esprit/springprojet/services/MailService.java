package tn.esprit.springprojet.services;

import org.springframework.mail.MailException;

import javax.mail.MessagingException;

public interface MailService {

    //public void sendEmailNotifAgent(User agent) throws MessagingException;
    public void sendEmail(String email)throws MailException, MessagingException;
    public void sendEmailSale(long idUser, long idProduct) throws MessagingException;
}
