package GUI;

import Application.*;
import Database.*;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Class_Group> classes;
    private ArrayList<Module> modules;
    private Class_Group class_group;
    private StudentTable st;
    private TeacherTable teacherTable;
    private ModuleTable moduleTable;
    private StudentsModulesTable studentsModulesTable;
    private DisplayStudents displayStudents;
    private AddStudent addStudent;
    private School school;
    private ClassTable classTable;

    public Controller(MainPage v) {
        st = new StudentTable();
        students = new ArrayList<>();
        school = new School();
        classTable = new ClassTable();
        teacherTable = new TeacherTable();
        moduleTable = new ModuleTable();
        class_group = new Class_Group();
        studentsModulesTable = new StudentsModulesTable();
    }

    public ArrayList<Student> readList() {
        students = st.returnList();
//        class_group.setListOfStudents(students); // always updating the list of students in a class-group
        return students;
    }
    public ArrayList<Class_Group> readClassesList() {
//        this.classes = school.getListOfClasses();
        this.classes = classTable.returnList();

        return classes;
    }

    // Method for Add Student Class
    public void addStudent(Student s) {
        students.add(s);
        System.out.println(s.getStudentID()+ s.getFirstName()+ s.getMiddleName()+ s.getLastName()+ s.getEmail()+ s.getPhone() + s.getDob() +"SDH2-C");
        st.Insert(s.getStudentID(),s.getFirstName(),s.getMiddleName(),s.getLastName(),s.getEmail(),s.getPhone(),s.getDob(),"SDH2-C");

    }
    // Method for DisplayStudents Class
    public void removeFromList(Student s) {
        int studentID = s.getStudentID();
        students.remove(s);
        st.Delete(studentID);
    }

    // Method for StudentsInClass
    public void setDisplayStudents(TextArea displayArea, String classID) {
//        System.out.println("Hello from controller setDisplayStudents method");

        ArrayList<Student> studentsInClass = st.returnStudentsInClass(classID);
//        System.out.println(classID);
        String text = "";
        for (int i = 0; i<studentsInClass.size();i++) {
            text += studentsInClass.get(i).getStudentID()+ " " + studentsInClass.get(i).getFirstName() + " " + studentsInClass.get(i).getMiddleName()+" "
            + studentsInClass.get(i).getLastName() + " " + studentsInClass.get(i).getEmail() + " " + studentsInClass.get(i).getPhone() + " "
            + studentsInClass.get(i).getDob() + "\n";
//            System.out.print(text);
        }
        if (text.contentEquals("")) {
            displayArea.setText("No students enrolled in this class or class doesn't exist");
        }
        else {
            displayArea.setText(text);
        }
    }

    public void updateClassOfStudent(int studentId, String classID) {
        st.updateStudent(studentId, classID);
    }

    // Method for Display Teachers
    public ArrayList<Teacher> readListOfTeachers() {
        teachers = teacherTable.returnList();
        return teachers;
    }

    // Method for update qualification of teacher
    public void updateTeacherQualification(String qualification, int teacherID) {
        teacherTable.updateTeacher(qualification, teacherID);
    }

    // Method for Display Modules Class
    public ArrayList<Module> readListOfModules(){
        modules = moduleTable.returnList();
        return modules;
    }
    // Method for studentsModules to insert/register student in a module
    public void insertStudentModule(int studentID, String moduleCode, int grade) {
        studentsModulesTable.Insert(studentID, moduleCode, grade);
    }

    public ArrayList<Module> readListOfStudentModules(int studentID) {
        ArrayList<Module> studentModules = studentsModulesTable.returnList(studentID);
        return studentModules;
    }

    public void updateGradeOfStudent(int studentID, String moduleCode, int grade) {
        studentsModulesTable.updateStudentsModules(studentID, moduleCode, grade);
    }
}
