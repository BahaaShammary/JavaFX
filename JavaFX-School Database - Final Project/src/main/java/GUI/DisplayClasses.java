package GUI;

import Application.Class_Group;
import Application.Student;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class DisplayClasses extends Tab {
    private TableView table;
    //    TextField nameIn, modelIn, yearIn, millageIn, regNumIn;
    private Controller c;
    private Button refreshBtn, backbtn;

    public DisplayClasses(MainPage v, Button backbtn) {
        c = new Controller(v);
        setText("Display Classes");
        //Class ID Column:
        TableColumn<Student, Integer > classIDCol = new TableColumn<>("Class ID");
        classIDCol.setMinWidth(80);
        classIDCol.setCellValueFactory(new PropertyValueFactory<>("classID"));

        table = new TableView<>();
        table.setItems(getClasses());
        table.getColumns().addAll(classIDCol);
        refreshBtn = new Button("Refresh Table");
        refreshBtn.setOnAction(e-> table.setItems(getClasses()));

//        backbtn = backBtn;

//        deleteStudentBtn = new Button("Delete Student");
//        deleteStudentBtn.setOnAction(e-> deleteStudent());
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().setAll(backbtn, refreshBtn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hbox);

        setText("Display Classes");
        setContent(vBox);

    }

    public ObservableList<Class_Group> getClasses() {
        ObservableList<Class_Group> classes = FXCollections.observableArrayList();
        ArrayList<Class_Group> readList = c.readClassesList();
        for (int i = 0; i<readList.size(); i++) {
            classes.add(readList.get(i));
        }
        return classes;
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
