/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.person;


import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class PersonDAO extends GenericDAO<Person>{

    public PersonDAO() {
        super(Person.class);
    }
    public List<Person> listarPessoaResponsavel(){
        this.setSessao(HibernateUtil.getSessionFactory().openSession());
        List<Person> lista;
        lista = getSessao().createCriteria(Person.class).add(Restrictions.eq("professor", true)).list();
        return lista;
    }
    
    
}
