package GUI;

import Application.Student;
import Application.Teacher;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class DisplayTeachers extends Tab {
    private TableView table;
    private Controller c;
    private Button refreshBtn, deleteStudentBtn, backbtn;

    public DisplayTeachers(MainPage v, Button backBtn) {
        c = new Controller(v);

        //Student ID Column:
        TableColumn<Student, Integer > teacherIDCol = new TableColumn<>("teacher ID");
        teacherIDCol.setMinWidth(80);
        teacherIDCol.setCellValueFactory(new PropertyValueFactory<>("teacherID"));

        //First Name Column:
        TableColumn<Student, String > firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        //Middle Name Column:
        TableColumn<Student, String > middleNameCol = new TableColumn<>("Middle Name");
        middleNameCol.setMinWidth(100);
        middleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        //Last Name Column:
        TableColumn<Student, String > lastNameCol = new TableColumn<>("First Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //Phone Column:
        TableColumn<Student, Integer > phoneCol = new TableColumn<>("Phone");
        phoneCol.setMinWidth(80);
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        //Email Column:
        TableColumn<Student, String > emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(150);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        //DOB Column:
        TableColumn<Student, String > qualificationCol = new TableColumn<>("Qualification");
        qualificationCol.setMinWidth(130);
        qualificationCol.setCellValueFactory(new PropertyValueFactory<>("degreeQualification"));

        table = new TableView<>();
        table.setItems(getTeachers());
        table.getColumns().addAll(teacherIDCol, firstNameCol, middleNameCol, lastNameCol, emailCol, phoneCol, qualificationCol);
        refreshBtn = new Button("Refresh Table");
        refreshBtn.setOnAction(e-> table.setItems(getTeachers()));
        deleteStudentBtn = new Button("Delete Teacher");
//        deleteStudentBtn.setOnAction(e-> deleteTeacher());
        backbtn = backBtn;
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().setAll(backbtn, refreshBtn, deleteStudentBtn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hbox);

        setText("Display Teachers");
        setContent(vBox);
    }

    public ObservableList<Teacher> getTeachers() {
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        ArrayList<Teacher> readList = c.readListOfTeachers();
        for (int i = 0; i<readList.size(); i++) {
            teachers.add(readList.get(i));
        }
        return teachers;
    }

//    public void deleteStudent() {
//        ObservableList<Student> selectedStudent, allStudents;
//        allStudents = table.getItems();
//        selectedStudent = table.getSelectionModel().getSelectedItems();
//        //System.out.println(selectedProduct.get(0).getName());
//        c.removeFromList(selectedStudent.get(0));
////        c.writeListToFile();
//        selectedStudent.forEach(allStudents::remove);
//    }

}
