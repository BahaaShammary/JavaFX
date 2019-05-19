package GUI;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class MainPage extends Application {
    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5;
    Button backBtn, backBtn1, backBtn2, backBtn3;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Main Page");
        window.setMinHeight(500);
        window.setMinWidth(700);
        Text text = new Text("Welcome To Pupil Management System");
        text.setFont(Font.font ("Verdana", 20));
        text.setFill(Color.BLACK);

        Button studentbtn = new Button("Manage Students");
        Button teacherbtn = new Button("Manage Teachers");
        Button modulesbtn = new Button("Manage Modules");

        //Button btn1 = new Button("Scene 2");
        studentbtn.setOnAction(e -> window.setScene(scene2));

        // Back button
        backBtn = new Button("<< Back");
        backBtn.setOnAction(e -> window.setScene(scene1));

        backBtn1 = new Button("<< Back");
        backBtn1.setOnAction(e -> window.setScene(scene1));

        backBtn2 = new Button("<< Back");
        backBtn2.setOnAction(e -> window.setScene(scene1));

        backBtn3 = new Button("<< Back");
        backBtn3.setOnAction(e -> window.setScene(scene1));

        VBox vBox1 = new VBox();
        HBox layout1 = new HBox();
        Label label2 = new Label("Manage Students");
        label2.setFont(Font.font ("Verdana", 20));
        label2.setAlignment(Pos.CENTER);
        Button btn = new Button("Scene 1");
        layout1.getChildren().addAll(btn);
        vBox1.getChildren().addAll(label2, layout1);
        btn.setOnAction(e -> window.setScene(scene1));

        DisplayStudents showStudents = new DisplayStudents(this, backBtn);
        AddStudent addStudent = new AddStudent(this);
        AddStudentToClass addStudentToClass = new AddStudentToClass(this);
        TabPane layout = new TabPane();
        layout.getTabs().addAll(showStudents, addStudent, addStudentToClass);
        scene2 = new Scene(layout, 700, 500);

        DisplayClasses displayClasses = new DisplayClasses(this, backBtn1);
        StudentsInClass studentsInClass = new StudentsInClass(this);
        TabPane layout2 = new TabPane();
        layout2.getTabs().addAll(displayClasses, studentsInClass);
        Button classbtn = new Button("Manage Classes");
        scene3 = new Scene(layout2,700, 500);
        classbtn.setOnAction(e -> window.setScene(scene3));

        DisplayTeachers displayTeachers = new DisplayTeachers(this, backBtn2);
        UpdateQualification updateQualification = new UpdateQualification(this);
        TabPane layout3 = new TabPane();
        layout3.getTabs().addAll(displayTeachers, updateQualification);
        scene4 = new Scene(layout3, 750, 500);
        teacherbtn.setOnAction(e -> window.setScene(scene4));

        DisplayModules displayModules = new DisplayModules(this, backBtn3);
        RegisterStudentForModule registerStudentForModule = new RegisterStudentForModule(this);
        StudentModulesAndGrades studentModulesAndGrades = new StudentModulesAndGrades(this);
        EditGradesOfAStudent editGradesOfAStudent = new EditGradesOfAStudent(this);
        TabPane layout4 = new TabPane();
        layout4.getTabs().addAll(displayModules, registerStudentForModule, studentModulesAndGrades, editGradesOfAStudent);
        scene5 = new Scene(layout4, 780, 530);
        modulesbtn.setOnAction(e -> window.setScene(scene5));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(text, studentbtn, classbtn, teacherbtn, modulesbtn);
        vBox.setPadding(new Insets(15, 12, 15, 15));
        vBox.setSpacing(20);
        //vBox.setStyle("-fx-background-color: #336699;");
        scene1 = new Scene(vBox, 700, 500);
        window.setScene(scene1);
        window.show();

    }
}
