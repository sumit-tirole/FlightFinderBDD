package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class ConfigReader {

    public String readFromPropertyFile(String key) throws IOException
    {
        String osName = System.getProperty("os.name");
        FileInputStream fis;

        if (osName.contains("Windows")) {
            fis = new FileInputStream(".\\src\\test\\resources\\Config\\testData.properties");
        } else {
            fis = new FileInputStream("./src/test/resources/Config/testData.properties");
        }

        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty(key);
        return decrypt(value);
    }

    public String readConfigFromPropertyFile(String key) throws IOException
    {
        String osName = System.getProperty("os.name");
        FileInputStream fis;

        if (osName.contains("Windows")) {
            fis = new FileInputStream(".\\src\\test\\resources\\Config\\config.properties");
        } else {
            fis = new FileInputStream("./src/test/resources/Config/config.properties");
        }

        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty(key);
        return value;
    }

    private String decrypt(String encryptedValue) { // Added decryption method
        return new String(Base64.getDecoder().decode(encryptedValue));
    }
}
