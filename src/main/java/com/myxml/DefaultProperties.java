package com.myxml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Uziel on 30/08/2014.
 */
public class DefaultProperties {
    private static Properties config;

    static {
        Properties fallback = new Properties();
        fallback.put("key", "default");
        config = new Properties(fallback);
        try {
            InputStream stream = DefaultProperties.class.getResourceAsStream("/com/myxml/properties/default.properties");
            try {
                config.load(stream);
            }
            finally {
                stream.close();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String get(String str){
        return config.getProperty(str);
    }
}