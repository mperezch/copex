/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.location;

import br.box.Box;
import br.certificate.Certificate;
import br.person.Person;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
public class Location {
    
    @Id
    @GeneratedValue
    private int id;
   
    @ManyToOne
    private Person person;
    
    @ManyToOne
    private Certificate certificate;
    
    @ManyToOne
    private Box box;
    
    @Temporal(TemporalType.DATE)
    private Date dataEntregue;
    
    private boolean entregue;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public Date getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(Date dataEntregue) {
        this.dataEntregue = dataEntregue;
    }
    
    
    
}
