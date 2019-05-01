public class Student extends Person {
    private String dob;
    private Module listOfModules[];
    private int noOfModules;

    public Student() {
        listOfModules = new Module[6];
        noOfModules = 0;
    }

    public Student(String firstName, String middleName, String lastName, String email, int phone, String dob) {
        super(firstName, middleName, lastName, email, phone);
        this.dob = dob;
        listOfModules = new Module[6];
        noOfModules = 0;
    }

    public Student(String firstName, String lastName, String email, int phone, String dob) {
        super(firstName, lastName, email, phone);
        this.dob = dob;
        listOfModules = new Module[6];
        noOfModules = 0;
    }
    public Student(String firstName, String email, int phone, String dob) {
        super(firstName, email, phone);
        this.dob = dob;
        listOfModules = new Module[6];
        noOfModules = 0;
    }

    public void addModule(Module m) {
        if (noOfModules >= 6) {
            System.out.println("You cannot add more modules");
        }
        else {
            listOfModules[noOfModules] = m;
            noOfModules++;
        }
    }

    public void changeMark(String moduleName, int newGrade) {
        for (int i = 0;i<listOfModules.length;i++) {
            if (listOfModules[i].getName().contentEquals(moduleName)) {
                listOfModules[i].setGrade(newGrade);
            }
        }
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Module[] getListOfModules() {
        return listOfModules;
    }

    public void setListOfModules(Module[] listOfModules) {
        this.listOfModules = listOfModules;
    }

    public int getNoOfModules() {
        return noOfModules;
    }

    public void setNoOfModules(int noOfModules) {
        this.noOfModules = noOfModules;
    }
}
