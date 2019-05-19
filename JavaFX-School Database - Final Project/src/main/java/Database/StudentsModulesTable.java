package Database;

import Application.Module;
import Application.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentsModulesTable extends Database {
    private Connection myConn;
    public StudentsModulesTable() {
        super();
        myConn = super.makeConnection();

    }
    public void Insert(int studentID, String moduleCode, int grade) {
        try {
            // Get connection

            // Create a statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "INSERT INTO studentsmodules(studentID, moduleCode, grade) VALUES(" + studentID + ",'"+moduleCode+"', "+grade+" );";

            myStmt.executeUpdate(sql);

            System.out.println("Insert completed");
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentsModulesTable in Insert method\n" + e);
        }
    }

    public void Delete(int studentID, String moduleCode) {
        try{
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "DELETE FROM studentsmodules WHERE moduleCode='"+ moduleCode+"' AND studentID="+studentID+";";
            int rowsAffected = myStmt.executeUpdate(sql);

            System.out.println("Rows affected " + rowsAffected);
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentsModulesTable in Delete method\n" + e);
        }

    }
    public void Display() {
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from studentsmodules");
            while (myRes.next()) {
                System.out.println(myRes.getString("studentID") + " " + myRes.getString("moduleCode") + " " + myRes.getString("grade"));
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentsModulesTable in Display method\n" + e);
        }
    }
    public void updateStudentsModules(int studentID, String moduleCode, int grade) {
        try {
            // Get connection
            System.out.println("Updating Class for Student...");
            // Create a statement
            Statement myStmt = myConn.createStatement();
                // Execute SQL Query
                String sql = "Update studentsmodules SET grade =" + grade + " WHERE studentID = " + studentID + " AND moduleCode='" + moduleCode +"';";

                myStmt.executeUpdate(sql);

            System.out.println("Update completed");
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentTable in updateStudent method\n" + e);
        }
    }
    public ArrayList<Module> returnList(int studentID) {
        ArrayList<Module> modules = new ArrayList<>();
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from studentsmodules where studentID=" + studentID+";");
            while (myRes.next()) {
                Module m = new Module();
                m.setModuleCode(myRes.getString("moduleCode"));
                m.setGrade(Integer.parseInt(myRes.getString("grade")));
                modules.add(m);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentsModuleTable in ReturnList method\n" + e);
        }
        return modules;
    }
}
