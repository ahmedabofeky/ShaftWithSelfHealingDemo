package Utilities;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SelfHealingConfig {
    @Getter
    private static boolean enabled = false;

    static {
        try (InputStream input = SelfHealingConfig.class.getClassLoader()
                .getResourceAsStream("selfhealing.properties")) {
            Properties prop = new Properties();
            if (input != null) {
                prop.load(input);
                enabled = Boolean.parseBoolean(prop.getProperty("enableSelfHealing", "false"));
            }
        } catch (IOException e) {
            enabled = false;
        }
    }

}
