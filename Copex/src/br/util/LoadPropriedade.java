package br.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadPropriedade {

    private static Properties config = new Properties();
    private static String arquivo = "config.ini";//local do arquivo

    public static String loadProperty(String property) {

        try {
            config.load(new FileInputStream(arquivo));

            
            return config.getProperty(property);
//                        System.out.println(config.getProperty("param1"));
//                        System.out.println(config.getProperty("final"));

            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
