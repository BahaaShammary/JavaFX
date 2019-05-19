package Application;

import Database.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // create school
        School school = new School("CIT", "Bishopstown");

        // create class
        Class_Group c1 = new Class_Group();
        // set the class group name
        c1.setClassID("SDH2-A");
        // add the class group to the list of classes
        school.addClass(c1);

        // create a few students
        Student s1 = new Student("Bahaulddin", "Shammary", "bahaa@gmail.com", 894895231, "5/2/94");
        Student s2 = new Student("Aaron", "Talbot", "aaron@gmail.com", 894895232, "5/2/96");
        Student s3 = new Student("Cian", "OSullivan", "cian@gmail.com", 894895233, "2/2/97");
        // set student IDs
        s1.setStudentID(1);
        s2.setStudentID(2);
        s3.setStudentID(3);

        // add students to class group
        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);

        // create some modules with code and name
        Module m1 = new Module("COMP7013", "OOP");
        Module m2 = new Module("SOFT7005", "OOAD");
        Module m3 = new Module("COMP7038", "Non Linear");
        Module m4 = new Module("SOFT7019", "C");
        Module m5 = new Module("STAT7007", "Maths");
        Module m6 = new Module("COMP7037", "NoSQL");
        Module m7 = new Module("Bla", "BlaBla"); // dummy module

        // register students for modules by adding them to the list of modules
        s1.addModule(m1);
        s1.addModule(m2);
        s1.addModule(m3);
        s1.addModule(m4);
        s1.addModule(m5);
        s1.addModule(m6);
        s1.addModule(m7); // check that student cannot register for more than six modules
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

        // Update the mark the student has received for a certain module
        s1.changeGrade(m1.getName(), 80);
        s2.changeGrade(m6.getName(), 70);
        s3.changeGrade(m5.getName(), 70);

        // create a few teachers
        Teacher t1 = new Teacher("Sheikh", "Ahmad", "Shammary", "shammary@gmail.com", 89234232, "pHD SOFT DEV");
        Teacher t2 = new Teacher("Fouad", "Ahmad", "Abdulameer", "fou@gmail.com", 892234232, "pHD Data Science");
        // set the teacher ID
        t1.setTeacherID(1111);
        t2.setTeacherID(1112);

        // display everything above
        System.out.println("SCHOOL: " + school.getName());
        //System.out.println(s1.getFirstName() + " is in enrolled in " + c1.getClassID());
        ArrayList<Class_Group> listOfClasses = school.getListOfClasses();
        for (int i = 0;i<listOfClasses.size();i++) {
            System.out.println("Class Group " + listOfClasses.get(i).getClassID());
            Class_Group c = listOfClasses.get(i);
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
        // establish the connection
//        Database db = new Database();
//        Connection myConn = db.makeConnection();
//        try {
//            Statement myStat = myConn.createStatement();
//
//            ResultSet myRes = myStat.executeQuery("select * from students");
//
//            while (myRes.next()) {
//                System.out.println(myRes.getString("firstName") + " " + myRes.getString("middleName") + " " + myRes.getString("lastName"));
//            }
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
        ClassTable classTable = new ClassTable();
//        classTable.Display();
//        classTable.Insert(c1.getClassID());
//        classTable.Delete(c1.getClassID());

        StudentTable studentTable = new StudentTable();
//        studentTable.Display();
//        studentTable.Insert(s3.getStudentID(), s3.getFirstName(), s3.getMiddleName(), s3.getLastName(), s3.getEmail(), s3.getPhone(), s3.getDob(), c1.getClassID());
//        studentTable.Delete(2);

        ModuleTable moduleTable = new ModuleTable();
//        moduleTable.Display();
//        moduleTable.Insert(m6.getModuleCode(), m6.getName());
//        moduleTable.Insert(m5.getModuleCode(), m5.getName());
//        moduleTable.Delete(m1.getModuleCode());

        TeacherTable teacherTable = new TeacherTable();
//        teacherTable.Display();
//        teacherTable.Insert(t2.getTeacherID(), t2.getFirstName(), t2.getMiddleName(), t2.getLastName(), t2.getEmail(), t2.getPhone(), t2.getDegreeQualification());
//        teacherTable.Delete(t1.getTeacherID());

        StudentsModulesTable studentsModulesTable = new StudentsModulesTable();
        studentsModulesTable.Display();
//        studentsModulesTable.Insert(s1.getStudentID(), m1.getModuleCode(), s1.getGrade(m1));
//        studentsModulesTable.Insert(s2.getStudentID(), m6.getModuleCode(), s2.getGrade(m6));
//        studentsModulesTable.Insert(s3.getStudentID(), m5.getModuleCode(), s3.getGrade(m5));
//        studentsModulesTable.Delete(s2.getStudentID(), m6.getModuleCode());
//        studentsModulesTable.Delete(s1.getStudentID(), m1.getModuleCode());
//        studentsModulesTable.Delete(s3.getStudentID(), m5.getModuleCode());
    }
}
