/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.document;

import br.campus.Campus;
import br.category.SubCategory;
import br.course.Course;
import br.person.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JComboBox;

/**
 *
 * @author João
 */
@Entity
public class Document {
    @Id
    @GeneratedValue
    private int id;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    private boolean estaDentroDoPrazo;
    
    @ManyToOne
    private Person pessoaEntregadora;
    
    @ManyToOne
    private Person pessoaResponsavel;
    
    @ManyToOne
    private SubCategory subCategoria;
    
    @ManyToOne
    private Course curso;
    
    @ManyToOne
    private Campus campus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public boolean isEstaDentroDoPrazo() {
        return estaDentroDoPrazo;
    }

    public void setEstaDentroDoPrazo(boolean estaDentroDoPrazo) {
        this.estaDentroDoPrazo = estaDentroDoPrazo;
    }

    public Person getPessoaEntregadora() {
        return pessoaEntregadora;
    }

    public void setPessoaEntregadora(Person pessoaEntregadora) {
        this.pessoaEntregadora = pessoaEntregadora;
    }

    public Person getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    public void setPessoaResponsavel(Person pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public SubCategory getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategory subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Course getCurso() {
        return curso;
    }

    public void setCurso(Course curso) {
        this.curso = curso;
    }

    public String getPrazo(){
        if(estaDentroDoPrazo){
            return "Sim";
        } 
        return "Não";
    }   

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
    
    
    
}
