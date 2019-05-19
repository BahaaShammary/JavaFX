package GUI;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class EditGradesOfAStudent extends Tab {
    private Label cLabel;
    private Label non_Linear;
    private Label noSQL;
    private Label oop;
    private Label ooad;
    private Label maths;
    private Label module;
    private Label grade;
    private Label studentID;
    private Button enterBtn;
    private TextField cInput;
    private TextField non_LinearInput;
    private TextField noSQLInput;
    private TextField oopInput;
    private TextField ooadInput;
    private TextField mathsInput;
    private TextField studentId;
    private TextArea displayArea;
    private Controller c;

    EditGradesOfAStudent(MainPage v) {
        c = new Controller(v);
        displayArea = new TextArea();
        Text text = new Text("Enter class ID and Student ID to register the student in that class");
        text.setFont(Font.font ("Verdana", 20));
        text.setFill(Color.BLACK);

        module = new Label("Module");
        grade = new Label("Grade");
        cLabel = new Label("C: ");
        non_Linear = new Label("Non-Linear: ");
        noSQL = new Label("NoSQL: ");
        oop = new Label("OOP: ");
        ooad = new Label("OOAD: ");
        maths = new Label("Maths: ");
        studentID = new Label("Student ID");
        cInput = new TextField();
        non_LinearInput= new TextField();
        noSQLInput = new TextField();
        oopInput = new TextField();
        ooadInput = new TextField();
        mathsInput = new TextField();
        studentId = new TextField();
        enterBtn = new Button("Enter");
        cInput.setText("0");
        non_LinearInput.setText("0");
        noSQLInput.setText("0");
        oopInput.setText("0");
        ooadInput.setText("0");
        mathsInput.setText("0");
        enterBtn.setOnAction(e -> handle());

        GridPane grid = new GridPane();
        grid.add(text, 0, 0);
        grid.add(studentID, 0, 1);
        grid.add(studentId, 1, 1);
        grid.add(cLabel, 0, 2);
        grid.add(cInput, 1, 2);
        grid.add(non_Linear, 0, 3);
        grid.add(non_LinearInput, 1, 3);
        grid.add(noSQL, 0, 4);
        grid.add(noSQLInput, 1, 4);
        grid.add(oop, 0, 5);
        grid.add(oopInput, 1, 5);
        grid.add(ooad, 0, 6);
        grid.add(ooadInput, 1, 6);
        grid.add(maths, 0, 7);
        grid.add(mathsInput, 1, 7);
        grid.add(enterBtn, 1, 8);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(text, grid, displayArea);

        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-color: #336699;");
        setContent(vBox);
        setText("Edit Grades Of A student");
    }
    public void handle() {
        c.updateGradeOfStudent(Integer.parseInt(studentId.getText()), "SOFT7019", Integer.parseInt(cInput.getText()));
        c.updateGradeOfStudent(Integer.parseInt(studentId.getText()), "COMP7038", Integer.parseInt(non_LinearInput.getText()));
        c.updateGradeOfStudent(Integer.parseInt(studentId.getText()), "COMP7037", Integer.parseInt(noSQLInput.getText()));
        c.updateGradeOfStudent(Integer.parseInt(studentId.getText()), "COMP7013", Integer.parseInt(oopInput.getText()));
        c.updateGradeOfStudent(Integer.parseInt(studentId.getText()), "SOFT7005", Integer.parseInt(ooadInput.getText()));
        c.updateGradeOfStudent(Integer.parseInt(studentId.getText()), "STAT7007", Integer.parseInt(mathsInput.getText()));
        displayArea.setText("Update Completed");
    }
}

