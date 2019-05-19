package Application;

import java.util.ArrayList;

public class School {
    private String name;
    private String address;
    private ArrayList<Class_Group> listOfClasses;

    public School(){
        this.listOfClasses = new ArrayList<Class_Group>();
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
        this.listOfClasses = new ArrayList<Class_Group>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void addClass(Class_Group c) {
        listOfClasses.add(c);
    }
    public void removeClass(Class_Group c) {
        for (int i = 0;i<listOfClasses.size();i++) {
            if (listOfClasses.get(i).getClassID() == c.getClassID()) {
                listOfClasses.remove(i);
            }
        }
    }

    public ArrayList<Class_Group> getListOfClasses() {
        return listOfClasses;
    }

    public void setListOfClasses(ArrayList<Class_Group> listOfClasses) {
        this.listOfClasses = listOfClasses;
    }
}
