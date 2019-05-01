public class Module {
    private String name;
    private int grade;

    public Module() {}

    public Module(String name) {
        this.name = name;
    }

    public Module(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
