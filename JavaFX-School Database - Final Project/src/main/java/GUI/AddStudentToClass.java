package GUI;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class AddStudentToClass extends Tab {
    private Label classID;
    private Label studentID;
    private Button enterBtn;
    private TextField classId;
    private TextField studentId;
    private TextArea displayArea;
    private Controller c;

public AddStudentToClass(MainPage v) {
    c = new Controller(v);
    displayArea = new TextArea();
    Text text = new Text("Enter class ID and Student ID to register the student in that class");
    text.setFont(Font.font ("Verdana", 20));
    text.setFill(Color.BLACK);

    classID = new Label("Class ID:");
    studentID = new Label("Student ID");
    classId = new TextField();
    studentId = new TextField();
    enterBtn = new Button("Enter");
    enterBtn.setOnAction(e -> handle());

    GridPane grid = new GridPane();
    grid.add(text, 0, 0);
    grid.add(classID, 0, 1);
    grid.add(classId, 1, 1);
    grid.add(studentID, 0, 2);
    grid.add(studentId, 1, 2);
    grid.add(enterBtn, 1, 3);

    VBox vBox = new VBox();
    vBox.getChildren().addAll(text, grid, displayArea);

    vBox.setPadding(new Insets(15, 12, 15, 12));
    vBox.setSpacing(10);
    vBox.setStyle("-fx-background-color: #336699;");
    setContent(vBox);
    setText("Add Student to Class");
}
    public void handle() {
        c.updateClassOfStudent(Integer.parseInt(studentId.getText()), classId.getText());
        displayArea.setText("Update Completed");
    }

}


