/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.document;

import br.util.Util;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Leonardo
 */
public class DocumentTableModel extends AbstractTableModel {

    private String[] nomeColuna = {"Código", "Data", "Entregue Por", "Responsável", "Tipo/Modalidade", "Está No Prazo?", "Curso", "Campus"};
    private List<Document> documentos;

    public DocumentTableModel(List<Document> documentos) {
        this.documentos = documentos;
    }

    @Override
    public int getRowCount() {
        return documentos.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColuna.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Document d = documentos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(d.getId());
            case 1:
                return d.getData();
            case 2:
                return d.getPessoaEntregadora().getNome();
            case 3:
                return d.getPessoaResponsavel().getNome();
            case 4:
                return d.getSubCategoria().getDescricao() + "-"
                        + d.getSubCategoria().getCategoria().getDescricao();
            case 5:
                return d.getPrazo();
            case 6:
                return d.getCurso().getDescricao();
            case 7:
                return d.getCampus().getDescricao();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColuna[0];
            case 1:
                return nomeColuna[1];
            case 2:
                return nomeColuna[2];
            case 3:
                return nomeColuna[3];
            case 4:
                return nomeColuna[4];
            case 5:
                return nomeColuna[5];
            case 6:
                return nomeColuna[6];
            case 7:
                return nomeColuna[7];
        }
        return null;
    }

    public Document getDocumento(int row) {
        return documentos.get(row);
    }

}
