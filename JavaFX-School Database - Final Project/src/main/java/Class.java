import java.util.ArrayList;

public class Class {
    private String classID;
    private ArrayList<Student> listOfStudents;

    public Class(){
        listOfStudents = new ArrayList<Student>();
    }
    public Class(int id){
        listOfStudents = new ArrayList<Student>();
    }

    public void addStudent(Student s) {
        listOfStudents.add(s);}

    public void removeStudent(int StudentId) {
        for (int i = 0; i <listOfStudents.size();i++) {
            if (listOfStudents.get(i).getPhone() == StudentId) {
                listOfStudents.remove(i);
            }
        }
    }

    public ArrayList<Student> returnList() {
        return this.listOfStudents;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
