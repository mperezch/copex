/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.person;

import br.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class PersonDAO extends GenericDAO<Person>{

    public PersonDAO() {
        super(Person.class);
    }
    
    
    
}
