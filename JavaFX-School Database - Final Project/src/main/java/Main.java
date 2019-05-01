import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        School school = new School("CIT", "Bishopstown");
        Class c1 = new Class();
        c1.setClassID("SDH2-A");


        school.addClass(c1);

        Student s1 = new Student("Bahaulddin", "Shammary", "bahaa@gmail.com", 894895231, "5/2/94");
        Student s2 = new Student("Aaron", "Talbot", "aaron@gmail.com", 894895232, "5/2/96");
        Student s3 = new Student("Cian", "O'Sullivan", "cian@gmail.com", 894895233, "2/2/97");

        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);

        Module m1 = new Module("OOP");
        Module m2 = new Module("OOAD");
        Module m3 = new Module("Non Linear");
        Module m4 = new Module("C");
        Module m5 = new Module("Maths");
        Module m6 = new Module("NoSQL");

        s1.addModule(m1);
        s1.addModule(m2);
        s1.addModule(m3);
        s1.addModule(m4);
        s1.addModule(m5);
        s1.addModule(m6);
        s2.addModule(m1);
        s2.addModule(m2);
        s2.addModule(m3);
        s2.addModule(m4);
        s2.addModule(m5);
        s2.addModule(m6);
        s3.addModule(m1);
        s3.addModule(m2);
        s3.addModule(m3);
        s3.addModule(m4);
        s3.addModule(m5);
        s3.addModule(m6);

        s1.changeMark("OOP", 80);
        s2.changeMark("NoSQL", 70);
        s3.changeMark("Maths", 70);

//        Module listOfModules[] = s1.getListOfModules();
//        System.out.println("The size of student one modules list is " + listOfModules.length);
//        System.out.println("The first module he is enrolled in is " + listOfModules[0].getName());


        System.out.println("SCHOOL: " + school.getName());
        //System.out.println(s1.getFirstName() + " is in enrolled in " + c1.getClassID());
        ArrayList<Class> listOfClasses = school.getListOfClasses();
        for (int i = 0;i<listOfClasses.size();i++) {
            System.out.println("Class Group " + listOfClasses.get(i).getClassID());
            Class c = listOfClasses.get(i);
            ArrayList<Student> listOfStudents = c.returnList();
            for (int j = 0;j<listOfStudents.size();j++) {
                Student s = listOfStudents.get(j);
                System.out.println("Student " + s.getFirstName() + " is enrolled in class group " + c.getClassID());
                ArrayList<Module> a= new ArrayList<Module>();
                Module listOfModules[] = s.getListOfModules();
                for (int k = 0;k<listOfModules.length;k++) {
                    Module m = listOfModules[k];
                    System.out.println("He is studying " + m.getName() + " and received " + m.getGrade());
                }
            }
        }
    Database db = new Database();
        Connection myConn = db.makeConnection();
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from students");

            while (myRes.next()) {
                System.out.println(myRes.getString("firstName") + " " + myRes.getString("middleName") + " " + myRes.getString("lastName"));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        ClassTable classTable = new ClassTable();
        classTable.Insert(c1.getClassID());
        //classTable.Delete(c1.getClassID());
    }
}
