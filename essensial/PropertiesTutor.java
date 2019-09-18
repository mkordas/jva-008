import static org.junit.Assert.*;

import java.io.*;
import java.util.Properties;

import org.junit.Test;

public class PropertiesTutor extends Tutor {

    /**
     * Returns the value of system property java.version
     */
    public String getJavaVersion() {
        String javaVersion = "java.specification.version"; //1.8
        Properties sysProp = System.getProperties();
        String currJavaVer = sysProp.getProperty(javaVersion);
        return currJavaVer;
    }

    @Test
    public void testJavaVersion() {
        String version = getJavaVersion();
        log(getJavaVersion());
        assertTrue(version.startsWith("1."));
    }

    /**
     * Loads properties-file from folder files/props.properties
     * and returns the loaded properties
     * @return
     */
    public Properties getProperties() {
        Properties prop = new Properties();
        try (InputStream is = new FileInputStream("files/props.properties")) {
            prop.load(is);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return prop;
    }

    @Test
    public void testGetProperties() {
        Properties props = getProperties();
        log("country="+props.getProperty("country"));
        log("color="+props.getProperty("color"));
        assertEquals("Australia", props.getProperty("country"));
        assertEquals("red", props.getProperty("color"));
    }

}

