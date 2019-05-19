package GUI;

import Application.Student;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class AddStudent extends Tab {
    private Label studentId, fName,mName,lName,email,phone,dob;
    private Button add;
    private TextField studentID, fNameIn,mNameIn,lNameIn,emailIn,phoneIn,dobIn;
    //private static int studentID;
    private Controller c;

    public AddStudent(MainPage v) {
        c = new Controller(v);
        //studentID = 103;
        Text text = new Text("Enter student details here");
        text.setFont(Font.font ("Verdana", 20));
        text.setFill(Color.BLACK);

        studentId = new Label(("Student ID"));
        fName = new Label("First Name:");
        mName = new Label("Middle Name: ");
        lName = new Label("Last Name: ");
        email = new Label("Email: ");
        phone = new Label("Phone: ");
        dob = new Label("Date Of Birth: ");

        studentID = new TextField();
        fNameIn = new TextField();
        mNameIn = new TextField();
        lNameIn = new TextField();
        emailIn = new TextField();
        phoneIn = new TextField();
        dobIn = new TextField();

//        HBox hBox1 = new HBox();
//        HBox hBox2 = new HBox();
//        HBox hBox3 = new HBox();
//        HBox hBox4 = new HBox();
//        HBox hBox5 = new HBox();
//        HBox hBox6 = new HBox();
//
//        hBox1.getChildren().addAll(fName, fNameIn);
//        hBox2.getChildren().addAll(mName, mNameIn);
//        hBox3.getChildren().addAll(lName, lNameIn);
//        hBox4.getChildren().addAll(email, emailIn);
//        hBox5.getChildren().addAll(phone, phoneIn);
//        hBox6.getChildren().addAll(dob, dobIn);
        add = new Button("Add Student");
        add.setOnAction(e-> handle());
        //add.setOnAction(e -> System.out.println("Clicked add student button"));
        GridPane grid = new GridPane();
        grid.add(studentId, 0, 0);
        grid.add(studentID, 1, 0);
        grid.add(fName, 0, 1);
        grid.add(fNameIn, 1, 1);
        grid.add(mName, 0, 2);
        grid.add(mNameIn, 1, 2);
        grid.add(lName, 0, 3);
        grid.add(lNameIn, 1, 3);
        grid.add(email, 0, 4);
        grid.add(emailIn, 1, 4);
        grid.add(phone, 0, 5);
        grid.add(phoneIn, 1, 5);
        grid.add(dob, 0, 6);
        grid.add(dobIn, 1, 6);
        grid.add(add, 1, 7);

        HBox hBox = new HBox();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(text, grid);

//        hBox.getChildren().addAll(text, grid);
        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-color: #336699;");
        setContent(vBox);
        setText("Add A Student");
    }

    public void handle() {
            System.out.println("Clicked on add button");
            int studentid = Integer.parseInt(studentID.getText());
            String fName = fNameIn.getText();
            String mName = mNameIn.getText();
            String lName = lNameIn.getText();
            String email = emailIn.getText();
            int phoneNum = Integer.parseInt(phoneIn.getText());
            String dob = dobIn.getText();
            Student s = new Student(fName,mName,lName,email,phoneNum,dob);
            s.setStudentID(studentid);
            c.addStudent(s);
            //System.out.println(s.getStudentID()+ s.getFirstName()+ s.getMiddleName()+ s.getLastName()+ s.getEmail()+ s.getPhone() + s.getDob() +"SDH2-C");
    }
}
