/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.person;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
public class Person implements Comparable<Person>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nome;
    
    private boolean pExterno;
    
    private boolean professor;
    
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public boolean ispExterno() {
        return pExterno;
    }

    public void setpExterno(boolean pExterno) {
        this.pExterno = pExterno;
    }

    public boolean isProfessor() {
        return professor;
    }

    public void setProfessor(boolean professor) {
        this.professor = professor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getProfessorAluno(){
        if(professor){
            return "Professor";
        } else {
            return "Aluno";
        }
    }

    @Override
    public int compareTo(Person o) {
        return nome.compareTo(o.nome);
    }

    
    
}
