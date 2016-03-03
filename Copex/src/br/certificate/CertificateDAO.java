/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.certificate;

import br.location.Location;
import br.person.Person;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class CertificateDAO extends GenericDAO<Certificate>{

    public CertificateDAO() {
        super(Certificate.class);
    }
    
    
    
    
    
}
