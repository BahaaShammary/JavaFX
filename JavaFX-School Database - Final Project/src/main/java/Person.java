public class Person extends Name {
    private String email;
    private int phone;

    public Person() {}

    public Person(String firstName, String middleName, String lastName, String email, int phone) {
        super(firstName, middleName, lastName);
        this.email = email;
        this.phone = phone;
    }

    public Person(String firstName, String lastName, String email, int phone) { // in case Person has no middle name
        super(firstName, lastName);
        this.email = email;
        this.phone = phone;
    }
    public Person(String firstName, String email, int phone) { // in case Person has no middle name
        super(firstName);
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
