import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private Connection myConn;
    public Connection makeConnection(){
        //myConn = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/school?useTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "";
//            Class.forName(driver);
            myConn = DriverManager.getConnection(url, "root", "");

            System.out.println("Connected");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return myConn;
    }


}
