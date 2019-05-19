package GUI;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class UpdateQualification extends Tab {
    private Label teacherID;
    private Label qualificationLabel;
    private Button enterBtn;
    private TextField teacherId;
    private TextField qualification;
    private TextArea displayArea;
    private Controller c;

    public UpdateQualification(MainPage v) {
        c = new Controller(v);
        displayArea = new TextArea();
        Text text = new Text("Enter Teacher ID and the qualification to update");
        text.setFont(Font.font ("Verdana", 20));
        text.setFill(Color.BLACK);

        teacherID = new Label("Teacher ID: ");
        qualificationLabel = new Label("Qualification: ");
        teacherId = new TextField();
        qualification = new TextField();
        enterBtn = new Button("Update");
        enterBtn.setOnAction(e -> handle());

        GridPane grid = new GridPane();
        grid.add(text, 0, 0);
        grid.add(teacherID, 0, 1);
        grid.add(teacherId, 1, 1);
        grid.add(qualificationLabel, 0, 2);
        grid.add(qualification, 1, 2);
        grid.add(enterBtn, 1, 3);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(text, grid, displayArea);

        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-color: #336699;");
        setContent(vBox);
        setText("Update Qualification");
    }
    public void handle() {
        c.updateTeacherQualification(qualification.getText(), Integer.parseInt(teacherId.getText()));
        displayArea.setText("Update Completed");
    }

}


