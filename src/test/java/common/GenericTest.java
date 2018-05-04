package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface GenericTest {

    static Properties getProperties() {
        InputStream is = ClassLoader.getSystemResourceAsStream("test.properties");
        try {
            Properties props = new Properties();
            props.load(is);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
