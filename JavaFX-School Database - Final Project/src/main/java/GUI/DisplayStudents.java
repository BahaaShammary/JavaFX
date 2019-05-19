package GUI;

import Application.Student;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class DisplayStudents extends Tab {
    private TableView table;
    private Controller c;
    private Button refreshBtn, deleteStudentBtn, backbtn;

    public DisplayStudents(MainPage v, Button backBtn) {
        c = new Controller(v);

        //Student ID Column:
        TableColumn<Student, Integer > studentIDCol = new TableColumn<>("Student ID");
        studentIDCol.setMinWidth(80);
        studentIDCol.setCellValueFactory(new PropertyValueFactory<>("studentID"));

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
        TableColumn<Student, String > dobCol = new TableColumn<>("Date Of Birth");
        dobCol.setMinWidth(85);
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));

        table = new TableView<>();
        table.setItems(getStudents());
        table.getColumns().addAll(studentIDCol, firstNameCol, middleNameCol, lastNameCol, emailCol, phoneCol, dobCol);
        refreshBtn = new Button("Refresh Table");
        refreshBtn.setOnAction(e-> table.setItems(getStudents()));
        deleteStudentBtn = new Button("Delete Student");
        deleteStudentBtn.setOnAction(e-> deleteStudent());
        backbtn = backBtn;
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().setAll(backbtn, refreshBtn, deleteStudentBtn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hbox);

        setText("Display Students");
        setContent(vBox);
    }

    public ObservableList<Student> getStudents() {
        ObservableList<Student> students = FXCollections.observableArrayList();
        ArrayList<Student> readList = c.readList();
        for (int i = 0; i<readList.size(); i++) {
            students.add(readList.get(i));
        }
        return students;
    }

    public void deleteStudent() {
        ObservableList<Student> selectedStudent, allStudents;
        allStudents = table.getItems();
        selectedStudent = table.getSelectionModel().getSelectedItems();
        //System.out.println(selectedProduct.get(0).getName());
        c.removeFromList(selectedStudent.get(0));
//        c.writeListToFile();
        selectedStudent.forEach(allStudents::remove);
    }

}
