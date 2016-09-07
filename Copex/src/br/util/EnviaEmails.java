/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import br.document.Document;
import br.person.Person;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class EnviaEmails implements Runnable{
    
    private static String retornaDataHoraFormatada(String formato, Date dataHora){
        SimpleDateFormat dfdtData;
        dfdtData = new SimpleDateFormat(formato);
        return dfdtData.format(dataHora);
    }

    public static void mandarEmail(Person person, Document doc) {

   

        String mensagem = "Através deste e-mail a COPEX vem dar ciência da entrega do "
                + "Documento de Nº " + Util.decimalFormat().format(doc.getId()) + ", recebido de " + doc.getPessoaEntregadora().getNome()
                + " sob responsabilidade de " + doc.getPessoaResponsavel().getNome() + ", na data de " + retornaDataHoraFormatada("dd/MM/yyyy", doc.getData()) 
                + " às "+retornaDataHoraFormatada("hh:mm", doc.getHora())+ ".\n"
                + "\n" + doc.getSubCategoria().getDescricao() + " - " + doc.getSubCategoria().getCategoria().getDescricao()+"."
                + "\nCurso: " + doc.getCurso().getDescricao()+".";
        
        if(doc.isEstaDentroDoPrazo()){
            mensagem+="\nO documento ESTÁ no prazo de entrega.";
        } else {
            mensagem+="\nO documento NÃO está no prazo de entrega.";
        }
        
        mensagem+="\n\n\nSIC - UniLeão - Desenvolvido por Alunos do Curso de Análise e Desenvolvimento de Sistemas.";

        try {
            mandarEmail("copex@leaosampaio.edu.br", "senhadocopex", person.getEmail(),
                    "Sistema Informatizado Copex - SIC ("+Util.decimalFormat().format(doc.getId())+")", mensagem);
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Não foi possível enviar e-mail para: "
                     + person.getNome() + "\nMotivo: " + e.getMessage());
        }

    }

    private static void mandarEmail(final String remetente, final String senha, String destinatario,
            String assunto, String mensagem) {

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente)); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(destinatario);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);//Assunto
            message.setText(mensagem);
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        mandarEmail(p,d);
    }
    
    private Person p;
    private Document d;
    private Thread thr;
    
    public EnviaEmails(Person p, Document d){
        this.p = p;
        this.d = d;
        
        thr = new Thread(this);
        thr.start();
        
    }

}
