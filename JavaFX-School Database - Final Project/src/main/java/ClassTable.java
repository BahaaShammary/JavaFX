import java.sql.*;

public class ClassTable extends Database {
    private Connection myConn;
    public ClassTable() {
        super();
        myConn = super.makeConnection();

    }
    public void Insert(String classID) {
        try {
            // Get connection

            // Create a statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "INSERT INTO classes(classID) VALUES('" + classID + "')";

            myStmt.executeUpdate(sql);

            System.out.println("Insert completed");
        }
        catch (Exception e) {
            System.out.println("ERROR in Class Database in Insert method\n" + e);
        }
    }

    public void Delete(String classID) {
        try{
        Statement myStmt = myConn.createStatement();

        // Execute SQL Query
        String sql = "DELETE FROM classes WHERE classID='" + classID + "'";

        int rowsAffected = myStmt.executeUpdate(sql);

        System.out.println("Rows affected " + rowsAffected);
        }
        catch (Exception e) {
        System.out.println("ERROR in Class Database in Delete method\n" + e);
        }

    }
}
