package Database;

import Application.Class_Group;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
            System.out.println("ERROR in ClassTable in Insert method\n" + e);
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
        System.out.println("ERROR in ClassTable in Delete method\n" + e);
        }

    }

    public void Display() {
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from classes");
            System.out.println("Class ID");
            while (myRes.next()) {
                System.out.println(myRes.getString("classID") + " " );
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in ClassTable in Display method\n" + e);
        }
    }
    public ArrayList<Class_Group> returnList() {
        ArrayList classes = new ArrayList();
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from classes");
            while (myRes.next()) {
                Class_Group c = new Class_Group();
                c.setClassID(myRes.getString("classID"));
                classes.add(c);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in ClassTable in ReturnList method\n" + e);
        }
        return classes;
    }
}
