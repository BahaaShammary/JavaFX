package Application;

public class Teacher extends Person {
    private int teacherID;
    private String degreeQualification;

    public Teacher() {}

    public Teacher(String firstName, String middleName, String lastName, String email, int phone, String degreeQualification) {
        super(firstName, middleName, lastName, email, phone);
        this.degreeQualification = degreeQualification;
    }

    public Teacher(String firstName, String lastName, String email, int phone, String degreeQualification) { // in case person has no middle name
        super(firstName, lastName, email, phone);
        this.degreeQualification = degreeQualification;
    }

    public String getDegreeQualification() {
        return degreeQualification;
    }

    public void setDegreeQualification(String degreeQualification) {
        this.degreeQualification = degreeQualification;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
