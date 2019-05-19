package Application;

public class Module {
    private String moduleCode;
    private String name;
    private int grade;

    public Module() {}

    public Module(String moduleCode, String name) {
        this.name = name;
        this.moduleCode = moduleCode;
    }

    public Module(String moduleCode, String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.moduleCode = moduleCode;
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

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}
