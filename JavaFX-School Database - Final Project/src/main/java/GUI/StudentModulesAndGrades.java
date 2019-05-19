package GUI;

import Application.Module;
import Application.Student;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentModulesAndGrades extends Tab {
    private TableView table;
    private Controller c;
    private Button refreshBtn, submitButton;
    private TextField studentIdInput, studentNameOutput;
    private Label studentIdLabel;

    public StudentModulesAndGrades(MainPage v) {
        this.c = new Controller(v);
        Text text = new Text("Enter Student ID to display grades of that student for the relevant modules");
        text.setFont(Font.font ("Verdana", 20));
        text.setFill(Color.BLACK);

        //Module Code Column:
        TableColumn<Module, String > moduleCodeCol = new TableColumn<>("Module Code");
        moduleCodeCol.setMinWidth(80);
        moduleCodeCol.setCellValueFactory(new PropertyValueFactory<>("moduleCode"));

        //Module Name Column:
        TableColumn<Module, String > moduleNameCol = new TableColumn<>("Module Name");
        moduleNameCol.setMinWidth(100);
        moduleNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Grade Column:
        TableColumn<Module, Integer > gradeCol = new TableColumn<>("Grade");
        gradeCol.setMinWidth(100);
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));

        table = new TableView<>();
//        table.setItems(getModules());
        table.getColumns().addAll(moduleCodeCol, moduleNameCol, gradeCol);
        submitButton = new Button("Submit");
        submitButton.setOnAction(e-> table.setItems(getModules()));

        studentIdLabel = new Label("Student ID: ");
        studentIdInput = new TextField();
        studentNameOutput = new TextField();

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(studentIdLabel, studentIdInput, submitButton, studentNameOutput);
        hBox1.setSpacing(10);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(text, table, hBox1);
        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-color: #336699;");
        setText("Display Grades of a Student");
        setContent(vBox);
    }

    public ObservableList<Module> getModules() {
        ObservableList<Module> modules = FXCollections.observableArrayList();
        ArrayList<Module> readList = c.readListOfStudentModules(Integer.parseInt(studentIdInput.getText()));
        ArrayList<Module> modulesList = c.readListOfModules();
        ArrayList<Student> students = c.readList();
        for (int i = 0; i<readList.size(); i++) {
            modules.add(readList.get(i));
        }

        modules.get(0).setName("C");
        for (int i = 0;i<readList.size();i++) {
            for (int j = 0; j<modulesList.size();j++){
                if (readList.get(i).getModuleCode().contentEquals(modulesList.get(j).getModuleCode())) {
                    modules.get(i).setName(modulesList.get(j).getName());
                }
            }
        }
        String studentName = "";
        for (int i = 0; i<students.size(); i++) {
            if (Integer.parseInt(studentIdInput.getText()) == students.get(i).getStudentID()) {
                studentName += students.get(i).getFirstName() + " " + students.get(i).getLastName();
            }
        }
        studentNameOutput.setText(studentName);
        return modules;
    }

}