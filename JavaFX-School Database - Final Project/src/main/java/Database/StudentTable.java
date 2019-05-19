package Database;

import Application.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentTable extends Database {
    Connection myConn;
    public StudentTable() {
        super();
        myConn = super.makeConnection();

    }
    public void Insert(int studentID, String firstName, String middleName, String lastName, String email, int phone, String dob, String classID) {
        try {
            // Get connection
            System.out.println("Inserting...");
            // Create a statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "INSERT INTO students (studentID, firstName, middleName, lastName, email, phone, dob, classID) VALUES("
            + studentID + ", '" + firstName+ "', '" + middleName + "', '" + lastName + "', '" + email + "', " + phone + ", '" + dob + "', '"+ classID+"');";

            myStmt.executeUpdate(sql);

            System.out.println("Insert completed");
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentTable in Insert method\n" + e);
        }
    }

    public void Delete(int studentID) {
        try{
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "DELETE FROM students WHERE studentID=" + studentID +";";

            int rowsAffected = myStmt.executeUpdate(sql);

            System.out.println("Rows affected " + rowsAffected);
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentTable in Delete method\n" + e);
        }

    }

    public void Display() {
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from students");
            while (myRes.next()) {
                System.out.println(myRes.getString("studentID") + " " + myRes.getString("firstName") + " " +myRes.getString("middleName") + " " + myRes.getString("lastName") + " " +
                        myRes.getString("email") + " " + myRes.getString("phone") + " " + myRes.getString("dob") + " " + myRes.getString("classID") + " ");
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentTable in Display method\n" + e);
        }
    }
    public ArrayList<Student> returnList() {
        ArrayList students = new ArrayList();
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from students");
            while (myRes.next()) {
                Student s = new Student();
                s.setStudentID(Integer.parseInt(myRes.getString("studentID")));
                s.setFirstName(myRes.getString("firstName"));
                s.setMiddleName(myRes.getString("middleName"));
                s.setLastName(myRes.getString("lastName"));
                s.setEmail(myRes.getString("email"));
                s.setPhone(Integer.parseInt(myRes.getString("phone")));
                s.setDob(myRes.getString("dob"));
//                System.out.println(myRes.getString("studentID") + " " + myRes.getString("firstName") + " " + myRes.getString("middleName") + " " + myRes.getString("lastName") + " " +
//                        myRes.getString("email") + " " + myRes.getString("phone") + " " + myRes.getString("dob") + " " + myRes.getString("classID") + " ");
            students.add(s);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentTable in ReturnList method\n" + e);
        }
        return students;
    }
    // Method to return list of students in a specified class
    public ArrayList<Student> returnStudentsInClass(String classID) {

        ArrayList students = new ArrayList();
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from students where classID='"+classID+"';");
            while (myRes.next()) {
                Student s = new Student();
                s.setStudentID(Integer.parseInt(myRes.getString("studentID")));
                s.setFirstName(myRes.getString("firstName"));
                s.setMiddleName(myRes.getString("middleName"));
                s.setLastName(myRes.getString("lastName"));
                s.setEmail(myRes.getString("email"));
                s.setPhone(Integer.parseInt(myRes.getString("phone")));
                s.setDob(myRes.getString("dob"));
//                System.out.println(myRes.getString("studentID") + " " + myRes.getString("firstName") + " " + myRes.getString("middleName") + " " + myRes.getString("lastName") + " " +
//                        myRes.getString("email") + " " + myRes.getString("phone") + " " + myRes.getString("dob") + " " + myRes.getString("classID") + " ");

                students.add(s);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentTable in ReturnList method\n" + e);
        }
        return students;
    }
    public void updateStudent(int studentID, String classID) {
        try {
            // Get connection
            System.out.println("Updating Class for Student...");
            // Create a statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "UPDATE students SET classID ='"+classID+"' WHERE studentID = "+studentID+";";

            myStmt.executeUpdate(sql);

            System.out.println("Update completed");
        }
        catch (Exception e) {
            System.out.println("ERROR in StudentTable in updateStudent method\n" + e);
        }
    }
}
