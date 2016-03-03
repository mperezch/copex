/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.certificate;

import br.course.Course;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
public class Certificate {

    @Id
    @GeneratedValue
    private int id;

    private String descricao;

    @ManyToOne
    private Course course;

    private int ch;

    private Date data;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String toString() {
        String dataFormatada = "";
        if (data != null) {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            dataFormatada = dt.format(data);
        }

        return descricao + "( " + dataFormatada + " )";
    }

}
