package GUI;

import Application.Module;
import Application.Student;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class DisplayModules extends Tab {
    private TableView table;
    private Controller c;
    private Button refreshBtn, deleteStudentBtn, backbtn;

    public DisplayModules(MainPage v, Button backBtn) {
        c = new Controller(v);

        //Module Code Column:
        TableColumn<Module, String > moduleCodeCol = new TableColumn<>("Module Code");
        moduleCodeCol.setMinWidth(80);
        moduleCodeCol.setCellValueFactory(new PropertyValueFactory<>("moduleCode"));

        //Module Name Column:
        TableColumn<Module, String > moduleNameCol = new TableColumn<>("Module Name");
        moduleNameCol.setMinWidth(100);
        moduleNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        table = new TableView<>();
        table.setItems(getModules());
        table.getColumns().addAll(moduleCodeCol, moduleNameCol);
        refreshBtn = new Button("Refresh Table");
        refreshBtn.setOnAction(e-> table.setItems(getModules()));
        deleteStudentBtn = new Button("Delete Student");
//        deleteStudentBtn.setOnAction(e-> deleteStudent());
        backbtn = backBtn;
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().setAll(backbtn, refreshBtn, deleteStudentBtn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hbox);

        setText("Display Modules");
        setContent(vBox);
    }

    public ObservableList<Module> getModules() {
        ObservableList<Module> modules = FXCollections.observableArrayList();
        ArrayList<Module> readList = c.readListOfModules();
        for (int i = 0; i<readList.size(); i++) {
            modules.add(readList.get(i));
        }
        return modules;
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
