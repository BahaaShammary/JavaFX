package GUI;

import Application.Module;
import Application.Student;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

import java.util.ArrayList;

public class RegisterStudentForModule extends Tab {
    private Label moduleCodeLabel;
    private Label studentIDLabel;
    private Button enterBtn;
    private TextField moduleCode;
    private TextField studentID;
    private TextArea displayArea;
    private Controller c;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    private Student student;
    private Module listOfModules[];

    RegisterStudentForModule(MainPage v){
        c = new Controller(v);
        displayArea = new TextArea();
        Text text = new Text("Enter Module Code and Student ID to register student in that module");
        text.setFont(Font.font ("Verdana", 20));
        text.setFill(Color.BLACK);
        student = new Student();

//        moduleCodeLabel = new Label("Module Code  ");
//        moduleCode = new TextField();
        studentIDLabel = new Label("Student ID: ");
        studentID = new TextField();
        enterBtn = new Button("Register");
        enterBtn.setOnAction(e -> handle());

        checkBox1 = new CheckBox("C");
        checkBox2 = new CheckBox("Non-Linear");
        checkBox3 = new CheckBox("NoSQL");
        checkBox4 = new CheckBox("OOP");
        checkBox5 = new CheckBox("OOAD");
        checkBox6 = new CheckBox("Maths");
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(studentIDLabel, studentID);
        hBox.setSpacing(15);
        vBox.getChildren().addAll(text, hBox, checkBox1, checkBox2, checkBox3 , checkBox4 , checkBox5, checkBox6, enterBtn, displayArea);

        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-color: #336699;");
        setContent(vBox);
        setText("Register Students in Module");

    }

    // method to hanndle when button is clicked
    private void handle(){
        listOfModules = student.getListOfModules();
        int selected = 0;
        if (checkBox1.isSelected()){
            listOfModules[0] = new Module("SOFT7019", "C");
            selected++;
        }
        if (checkBox2.isSelected()){
            listOfModules[1] = new Module("COMP7038", "Non-Linear");
            selected++;

        }
        if (checkBox3.isSelected()){
            listOfModules[2] = new Module("COMP7037", "NoSQL");
            selected++;
        }
        if (checkBox4.isSelected()){
            listOfModules[3] = new Module("COMP7013", "OOP");
            selected++;
        }
        if (checkBox5.isSelected()){
            listOfModules[4] = new Module("SOFT7005", "OOAD");
            selected++;
        }
        if (checkBox6.isSelected()){
            listOfModules[5] = new Module("STAT7007", "Maths");
            selected++;
        }
        ArrayList<Student> students = c.readList();
        String displayMessage = "";
        for (int j = 0; j<students.size();j++) {
            if (students.get(j).getStudentID() == Integer.parseInt(studentID.getText())) {
                displayMessage += "Student " + students.get(j).getFirstName() + " " + students.get(j).getLastName() + " with ID "
                        + students.get(j).getStudentID() + " is registered for: \n";
            }
        }
        for (int i = 0; i<selected;i++) {
            c.insertStudentModule(Integer.parseInt(studentID.getText()), listOfModules[i].getModuleCode(), 0);
            displayMessage+= listOfModules[i].getModuleCode() + " " + listOfModules[i].getName()+"\n";
        }


        displayArea.setText(displayMessage);
    }

}
