/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.campus.Campus;
import br.campus.CampusDAO;
import br.category.Category;
import br.category.CategoryDAO;
import br.category.SubCategory;
import br.category.SubCategoryDAO;
import br.course.Course;
import br.course.CourseDAO;
import br.document.Document;
import br.document.DocumentDAO;
import br.person.Person;
import br.person.PersonDAO;
import br.util.EnviaEmails;
import br.util.Util;
import java.awt.JobAttributes;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class DocumentsFrm extends javax.swing.JDialog {

    /**
     * Creates new form DocumentsFrm
     */
    public DocumentsFrm() {
        setTitle("Entrega de documentos");
        initComponents();
        setLocationRelativeTo(null);

        insertCourse();
        insertCategory();
        insertPersons();
        insertPersonRe();
        insertCampus();
        rbSim.setSelected(true);
        setModal(true);

    }
    
    public void insertCampus() {
        cbCampus.removeAllItems();
        cbCampus.addItem("-");

        CampusDAO cdao = new CampusDAO();
        List<Campus> lista = cdao.list("descricao");

        for (int i = 0; i < lista.size(); i++) {
            cbCampus.addItem(lista.get(i));
        }
    }

    public void insertCategory() {
        cbCategory.removeAllItems();
        cbCategory.addItem("-");

        CategoryDAO cdao = new CategoryDAO();
        List<Category> lista = cdao.list("descricao");

        for (int i = 0; i < lista.size(); i++) {
            cbCategory.addItem(lista.get(i));
        }
    }

    private void insertPersons() {
        Person p = null;
        cbPerson.removeAllItems();
        cbPerson.addItem("-");

        PersonDAO pDAO = new PersonDAO();
        List<Person> lista = pDAO.list("nome");
        for (int i = 0; i < lista.size(); i++) {
            cbPerson.addItem(lista.get(i));
        }
    }

    public void insertCourse() {
        cbCourse.removeAllItems();
        cbCourse.addItem("-");

        CourseDAO cDAO = new CourseDAO();
        List<Course> lista = cDAO.list("descricao");
        for (int i = 0; i < lista.size(); i++) {
            cbCourse.addItem(lista.get(i));
        }
    }

    public void insertPersonRe() {
        cbResponsavel.removeAllItems();
        cbResponsavel.addItem("-");

        PersonDAO pdao = new PersonDAO();
        List<Person> lista = pdao.listarPessoaResponsavel();
        for (int i = 0; i < lista.size(); i++) {
            cbResponsavel.addItem(lista.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPrazo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox();
        cbSub = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbPerson = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbCourse = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cbResponsavel = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rbSim = new javax.swing.JRadioButton();
        rbNao = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        cbCampus = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Modalidade*:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        cbCategory.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbCategory.setPreferredSize(new java.awt.Dimension(68, 22));
        cbCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoryItemStateChanged(evt);
            }
        });
        getContentPane().add(cbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 350, 20));

        cbSub.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbSub.setPreferredSize(new java.awt.Dimension(68, 22));
        cbSub.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSubItemStateChanged(evt);
            }
        });
        getContentPane().add(cbSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 350, 20));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Tipo*:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Pessoa entregadora*:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        cbPerson.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbPerson.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPersonItemStateChanged(evt);
            }
        });
        getContentPane().add(cbPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 350, 20));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/application-add-icon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 40, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/application-add-icon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 40, 30));

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Entrega de Documentos");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 390, 30);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 35));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/SA.png"))); // NOI18N
        jButton5.setToolTipText("Sair");
        jButton5.setPreferredSize(new java.awt.Dimension(63, 39));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 50, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/confi.gif"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, 40));

        cbCourse.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCourseActionPerformed(evt);
            }
        });
        jPanel1.add(cbCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 350, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Curso*:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/add-512.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 30, 30));

        cbResponsavel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(cbResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 350, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Pessoa Responsável*:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Está dentro do prazo?");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        rbSim.setBackground(new java.awt.Color(255, 255, 255));
        bgPrazo.add(rbSim);
        rbSim.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbSim.setText("Sim");
        jPanel4.add(rbSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        rbNao.setBackground(new java.awt.Color(255, 255, 255));
        bgPrazo.add(rbNao);
        rbNao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbNao.setText("Não");
        rbNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNaoActionPerformed(evt);
            }
        });
        jPanel4.add(rbNao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 180, 50));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/procurar_1.png"))); // NOI18N
        jButton6.setToolTipText("Pesquisar Certificados");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        cbCampus.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(cbCampus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 350, 20));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Campus*:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoryItemStateChanged

        if (cbCategory.getSelectedIndex() != 0) {
            SubCategoryDAO sdao = new SubCategoryDAO();

            List<SubCategory> lista = sdao.listarPorCategoria((Category) cbCategory.getSelectedItem());
            List<SubCategory> lista2 = new ArrayList(new HashSet(lista));
            cbSub.removeAllItems();
            cbSub.addItem("-");
            for (int i = 0; i < lista2.size(); i++) {
                cbSub.addItem(lista.get(i));

            }
        } else {
            cbSub.removeAllItems();
            cbSub.addItem("-");
        }
    }//GEN-LAST:event_cbCategoryItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Category cat; 
        SubCategory scat;
        Course cor ;
        Person pen;
        Person penr;
        Campus campus;

        if (cbCategory.getSelectedIndex() == 0 || cbCourse.getSelectedIndex() == 0 || cbPerson.getSelectedIndex() == 0
                || cbResponsavel.getSelectedIndex() == 0 || cbSub.getSelectedIndex() == 0 || cbCampus.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(rootPane, "Informe os campos obrigatórios!");

        } else {
            Document doc = new Document();
            DocumentDAO docDAO = new DocumentDAO();

            cat = (Category) cbCategory.getSelectedItem();
            scat = (SubCategory) cbSub.getSelectedItem();
            cor = (Course) cbCourse.getSelectedItem();
            pen = (Person) cbPerson.getSelectedItem();
            penr = (Person) cbResponsavel.getSelectedItem();
            campus = (Campus) cbCampus.getSelectedItem();

            doc.setCurso(cor);
            doc.setPessoaEntregadora(pen);
            doc.setSubCategoria(scat);
            doc.setPessoaResponsavel(penr);
            doc.setHora(new Date());
            doc.setData(new Date());
            doc.setCampus(campus);
            if (rbSim.isSelected()) {
                doc.setEstaDentroDoPrazo(true);
            } else {
                doc.setEstaDentroDoPrazo(false);
            }

            docDAO.add(doc);
            
            try {
                
            
           
            String emailPen = pen.getEmail();
            PersonDAO pDAO = new PersonDAO();
            if (emailPen == null) {
                emailPen = "";
            }
            while (emailPen.isEmpty()) {
                emailPen = JOptionPane.showInputDialog("Informe o email da Pessoa Entregadora: ");
                if (emailPen == null) {
                    break; 
                }
                if (!Util.validEmail(emailPen)) {
                    emailPen = "";
                } else {
                    pen.setEmail(emailPen);
                    pDAO.update(pen);
                }
            }
            
            new EnviaEmails(pen, doc);
                 
            

            String emailPenR = penr.getEmail();
            if (emailPenR == null) {
                emailPenR = "";
            }
            while (emailPenR.isEmpty()) {
                emailPenR = JOptionPane.showInputDialog("Informe o email da Pessoa Responsável: ");
                if (emailPenR == null) {
                    break;
                }
                if (!Util.validEmail(emailPenR)) {
                    emailPenR = "";
                } else {
                    penr.setEmail(emailPenR);
                    pDAO.update(penr);
                }
            }
            new EnviaEmails(penr, doc);
//            EnviaEmails.mandarEmail(penr, doc);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Não Foi Possivel Enviar os E-mail's.");
            }
            clearFields();
            JOptionPane.showMessageDialog(rootPane, "Documento Cadastrado!");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void clearFields() {
        cbCategory.setSelectedIndex(0);
        cbSub.setSelectedIndex(0);
        cbCourse.setSelectedIndex(0);
        cbResponsavel.setSelectedIndex(0);
        cbPerson.setSelectedIndex(0);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        RegisterPersonFrm rcf = new RegisterPersonFrm();
        rcf.setVisible(true);

        insertPersons();
        insertPersonRe();
//        insertBoxes();
//        insertCertificates();
//        insertCampus();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbSubItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSubItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSubItemStateChanged

    private void cbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCourseActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CategoryFrm c = new CategoryFrm();
        c.setVisible(true);
        insertCategory();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        SubCategoryFrm s = new SubCategoryFrm();
        s.setVisible(true);
        cbCategoryItemStateChanged(null);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void rbNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNaoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (cbPerson.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Pessoa!");
            cbPerson.requestFocus();
            return;
        }
        FindDocumentFrm.show((Person) cbPerson.getSelectedItem());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbPersonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPersonItemStateChanged

    }//GEN-LAST:event_cbPersonItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DocumentsFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocumentsFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocumentsFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocumentsFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocumentsFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPrazo;
    private javax.swing.JComboBox cbCampus;
    private javax.swing.JComboBox cbCategory;
    private javax.swing.JComboBox cbCourse;
    private javax.swing.JComboBox cbPerson;
    private javax.swing.JComboBox cbResponsavel;
    private javax.swing.JComboBox cbSub;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    // End of variables declaration//GEN-END:variables
}
