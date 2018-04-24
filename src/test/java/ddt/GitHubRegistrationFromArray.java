package ddt;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class GitHubRegistrationFromArray extends GitHubRegistration {

    @Parameterized.Parameters
    public static Collection<User> testData() {
        return Arrays.asList(new User("Testeruser1",  "email1@email.com", "password" ),
            new User("Testeruser2",  "email2@email.com", "password" ),
            new User("Testeruser3",  "email3@email.com", "password" ),
            new User("Testeruser4",  "email4@email.com", "password" )
        );
    }

    public GitHubRegistrationFromArray(User user) {
        super(user);
    }
}
