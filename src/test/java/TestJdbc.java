import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Created by Myriad 72 on 10/16/2016.
 */
public class TestJdbc {

    @Test
    public void test() {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database " + jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
