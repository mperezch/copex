/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package br.person;

import br.location.*;
import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @author adriano
 */
@SuppressWarnings("serial")
public class PersonTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Nome", "Email", " "};
    private List<Person> persons;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Cidade).
     */
    public PersonTableModel(List<Person> lista) {
        persons = new ArrayList(new HashSet(lista));
        this.persons.clear();
        Collections.sort(lista);
        this.persons.addAll(lista);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return persons.size();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    /**
     * Método sobrescrito.
     *
     * @param rowIndex int
     * @param columnIndex int.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person l = persons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(l.getId());
            case 1:
                return l.getNome();
            case 2:
                return (l.getEmail() != null ? l.getEmail() : " - ");
            case 3:
                return l.getProfessorAluno();

        }
        return null;
    }
    
    public Person getPessoa(int rowIndex) {
        return persons.get(rowIndex);
    }
    /**
     * Método sobrescrito.
     *
     * @param column int.
     * @return String nomeColunas[index].
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColunas[0];
            case 1:
                return nomeColunas[1];
            case 2:
                return nomeColunas[2];
            case 3:
                return nomeColunas[3];
        }
        return null;
    }
}
