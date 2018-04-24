package ddt;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

@RunWith(value = Parameterized.class)
public class GetHubRegistrationFromExcel extends GitHubRegistration {

    @Parameterized.Parameters
    public static Collection<User> data() {
        try {
            return FileReader.readFromExcelFile("test.xlsx");
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GetHubRegistrationFromExcel(User user) {
        super(user);
    }
}
