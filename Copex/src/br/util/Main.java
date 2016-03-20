/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Pedro Saraiva
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        try {
            JFileChooser FileChooser = new JFileChooser();
            
            String filename = null;

            FileChooser.setVisible(true);

            int result = FileChooser.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                filename = FileChooser.getSelectedFile().toString().concat(".sql");

                File file = new File(filename);

                if (file.exists()) {
                    Object option[] = {"Sim", "Nao"};

                    int opcao = JOptionPane.showOptionDialog(null, "aaa", "bbbb", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

                    if (opcao == JOptionPane.YES_OPTION) {
                        Runtime backup = Runtime.getRuntime();
                        backup.exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump.exe -v -v -v --host=localhost --user=root --password=root --port=3306 --protocol=tcp --force --allow-keywords --compress --add-drop-table --result-file=" + filename + " --databases GIVE YOUR DATABSE NAME");
                        JOptionPane.showMessageDialog(null, "Backup succesfully");
                    } else {
//                        FileChooserActionPerformed(null);
                    }
                } else {
                    Runtime backup = Runtime.getRuntime();
                    backup.exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump.exe -v -v -v --host=localhost --user=root --password=root --port=3306 --protocol=tcp --force --allow-keywords --compress --add-drop-table --result-file=" + filename + " --databases GIVE YOUR DATABSE NAME");
                    JOptionPane.showMessageDialog(null, "Backup succesfully");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error.!", 2);
        }
    }

}
