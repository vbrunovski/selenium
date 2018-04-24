package ddt;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

@RunWith(value = Parameterized.class)
public class GetHubRegistrationFromTextFile extends GitHubRegistration {

    @Parameterized.Parameters
    public static Collection<User> data() {
        try {
            return FileReader.readFromTextFile("test.txt");
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GetHubRegistrationFromTextFile(User user) {
        super(user);
    }
}
