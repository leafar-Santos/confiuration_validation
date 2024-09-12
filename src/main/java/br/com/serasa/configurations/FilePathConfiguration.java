package br.com.serasa.configurations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FilePathConfiguration {

    private static String filePath;
    static {
        Properties properties = new Properties();
        try (InputStream input = FilePathConfiguration.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar o arquivo application.properties");
            }
            properties.load(input);

            filePath = properties.getProperty("file.path");
            if (filePath == null) {
                System.out.println("A propriedade 'file.path' não foi encontrada no arquivo application.properties");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getFilePath() {
        return filePath;
    }

}