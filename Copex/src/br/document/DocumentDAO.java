/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.document;

import br.person.Person;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author João
 */
public class DocumentDAO extends GenericDAO<Document> {
    
    public DocumentDAO() {
        super(Document.class);
    }

    public List<Document> listPerPerson(Person person) {
        List<Document> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Document.class)
                    .add(Restrictions.eq("pessoaEntregadora", person)).
                    addOrder(Order.desc("data")).
                   list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;
    }
    
}
