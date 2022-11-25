
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.*;
import java.sql.*;
import java.util.logging.Logger;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/QuizApplication",
                "vaibhavj",
                "rockatale"
        );
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Users");

    }
}