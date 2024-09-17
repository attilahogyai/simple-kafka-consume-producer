package org.brickztech;

import java.io.*;
import java.util.Properties;

;

public class ConfigReader {

    private final Properties properties = new Properties();

    public Properties getData(String filePath) throws IOException {
        if(new File(filePath).isFile()){
            try (FileInputStream inputStream = new FileInputStream(filePath)) {
                properties.load(inputStream);
            }
        }else{
            try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("test.properties")) {
                properties.load(inputStream);
            }
        }
        return properties;
    }
}
