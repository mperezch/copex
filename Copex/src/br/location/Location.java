package br.location;

import br.box.Box;
import br.campus.Campus;
import br.certificate.Certificate;
import br.person.Person;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    
    @ManyToMany
    private List<Person> cooautores;
    
    @ManyToOne
    private Certificate certificate;
    
    @ManyToOne
    private Box box;
    
    @Temporal(TemporalType.DATE)
    private Date dataEntregue;
    
    private boolean entregue;
    
    @ManyToOne
    private Person pessoaEntregue;
    
    @ManyToOne
    private Campus campus;

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

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public List<Person> getCooautores() {
        return cooautores;
    }

    public void setCooautores(List<Person> cooautores) {
        this.cooautores = cooautores;
    }

    public Person getPessoaEntregue() {
        return pessoaEntregue;
    }

    public void setPessoaEntregue(Person pessoaEntregue) {
        this.pessoaEntregue = pessoaEntregue;
    }
    
}
