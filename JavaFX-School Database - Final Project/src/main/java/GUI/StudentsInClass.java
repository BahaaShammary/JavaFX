package GUI;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class StudentsInClass extends Tab {
    private Label classID;
    private Button enterBtn;
    private TextField classId;
    private TextArea displayArea;
    private Controller c;

    public StudentsInClass(MainPage v) {
        c = new Controller(v);
        displayArea = new TextArea();
        Text text = new Text("Enter class ID to find students in that class");
        text.setFont(Font.font ("Verdana", 20));
        text.setFill(Color.BLACK);

        classID = new Label("Class ID:");
        classId = new TextField();
        enterBtn = new Button("Enter");
        enterBtn.setOnAction(e -> handle());

        GridPane grid = new GridPane();
        grid.add(text, 0, 0);
        grid.add(classID, 0, 1);
        grid.add(classId, 2, 1);
        grid.add(enterBtn, 2, 2);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(text, grid, displayArea);

        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-color: #336699;");
        setContent(vBox);
        setText("Display Students in Class");
    }

    public void handle() {
            c.setDisplayStudents(displayArea, classId.getText());

    }
}
