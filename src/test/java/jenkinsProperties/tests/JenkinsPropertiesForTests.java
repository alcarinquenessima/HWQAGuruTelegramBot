package jenkinsProperties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class JenkinsPropertiesForTests {

    @Test
    @Tag("Property")
    public void jenkinsPropertiesBrowser (){
    String browser = System.getProperty("browser", "chrome");
    }
}
