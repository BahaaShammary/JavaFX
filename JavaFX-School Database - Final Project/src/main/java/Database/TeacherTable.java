package Database;

import Application.Student;
import Application.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherTable extends Database {
    Connection myConn;
    public TeacherTable() {
        super();
        myConn = super.makeConnection();

    }
    public void Insert(int teacherID, String firstName, String middleName, String lastName, String email, int phone, String qualification) {
        try {
            // Get connection

            // Create a statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "INSERT INTO teachers (teacherID, firstName, middleName, lastName, email, phone, qualification) VALUES("
                    + teacherID + ", '" + firstName+ "', '" + middleName + "', '" + lastName + "', '" + email + "', " + phone + ", '"+ qualification+"');";
            ;
            myStmt.executeUpdate(sql);

            System.out.println("Insert completed");
        }
        catch (Exception e) {
            System.out.println("ERROR in TeacherTable in Insert method\n" + e);
        }
    }

    public void Delete(int teacherID) {
        try{
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "DELETE FROM teachers WHERE teacherID=" + teacherID +";";

            int rowsAffected = myStmt.executeUpdate(sql);

            System.out.println("Rows affected " + rowsAffected);
        }
        catch (Exception e) {
            System.out.println("ERROR in TeacherTable in Delete method\n" + e);
        }

    }
    public void Display() {
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from teachers");
            while (myRes.next()) {
                System.out.println(myRes.getString("teacherID") + " " + myRes.getString("firstName") + " " + myRes.getString("middleName") + " " + myRes.getString("lastName") + " " +
                        myRes.getString("email") + " " + myRes.getString("phone") + " " + myRes.getString("qualification") + " ");
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in TeacherTable in Display method\n" + e);
        }
    }

    public ArrayList<Teacher> returnList() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from teachers");
            while (myRes.next()) {
                Teacher t = new Teacher();
                t.setTeacherID(Integer.parseInt(myRes.getString("teacherID")));
                t.setFirstName(myRes.getString("firstName"));
                t.setMiddleName(myRes.getString("middleName"));
                t.setLastName(myRes.getString("lastName"));
                t.setEmail(myRes.getString("email"));
                t.setPhone(Integer.parseInt(myRes.getString("phone")));
                t.setDegreeQualification(myRes.getString("qualification"));
//                System.out.println(myRes.getString("studentID") + " " + myRes.getString("firstName") + " " + myRes.getString("middleName") + " " + myRes.getString("lastName") + " " +
//                        myRes.getString("email") + " " + myRes.getString("phone") + " " + myRes.getString("dob") + " " + myRes.getString("classID") + " ");
                teachers.add(t);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in TeacherTable in ReturnList method\n" + e);
        }
        return teachers;
    }
    public void updateTeacher(String qualification, int teacherID) {
        try {
            // Get connection
            System.out.println("Updating Qualification for Teacher...");
            // Create a statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "UPDATE teachers SET qualification ='"+qualification+"' WHERE teacherID = "+teacherID+";";

            myStmt.executeUpdate(sql);

            System.out.println("Update completed");
        }
        catch (Exception e) {
            System.out.println("ERROR in TeacherTable in updateTeacher method\n" + e);
        }
    }
}
