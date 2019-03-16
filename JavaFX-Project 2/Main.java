import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TableView table;
    TextField nameIn, modelIn, yearIn, millageIn;
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TableView - Demo");

        //Name Column:
        TableColumn<Car, String > nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Model Column:
        TableColumn<Car, String > modelCol = new TableColumn<>("Model");
        modelCol.setMinWidth(150);
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));

        //Year Column:
        TableColumn<Car, Integer > yearCol = new TableColumn<>("Year");
        yearCol.setMinWidth(100);
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        //Millage Column:
        TableColumn<Car, Double > millageCol = new TableColumn<>("Millage");
        millageCol.setMinWidth(100);
        millageCol.setCellValueFactory(new PropertyValueFactory<>("millage"));

        // Name Input
        nameIn = new TextField();
        nameIn.setPromptText("Name");
        nameIn.setMinWidth(60);

        // Model Input
        modelIn = new TextField();
        modelIn.setPromptText("Model");
        modelIn.setMinWidth(60);

        // Year Input
        yearIn = new TextField();
        yearIn.setPromptText("Year");
        yearIn.setMinWidth(60);

        // Millage Input
        millageIn = new TextField();
        millageIn.setPromptText("Millage");
        millageIn.setMinWidth(60);

        Button addBtn = new Button("Add");
        addBtn.setMinWidth(50);
        addBtn.setOnAction(e -> addCar());
        Button deleteBtn = new Button("Delete");
        deleteBtn.setMinWidth(50);
        deleteBtn.setOnAction(e -> deleteCar());


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameIn, modelIn, yearIn, millageIn, addBtn, deleteBtn);

        table = new TableView<>();
        table.setItems(getCars());
        table.getColumns().addAll(nameCol, modelCol, yearCol, millageCol);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Car> getCars() {
        ObservableList<Car> carList = FXCollections.observableArrayList();
        carList.add(new Car("Nissan", "Almera", 2000, 22000));
        carList.add(new Car("BMW", "8 Series", 4000, 66000));
        carList.add(new Car("Nissan", "Qashqai", 8000, 70000));
        carList.add(new Car("Nissan", "Sunny", 3500, 98754));
        return carList;
    }

    public void addCar() {
        Car c = new Car();
        c.setName(nameIn.getText());
        c.setModel(modelIn.getText());
        c.setYear(Integer.parseInt(yearIn.getText()));
        c.setMillage(Integer.parseInt(millageIn.getText()));
        table.getItems().add(c);
        nameIn.clear();
        modelIn.clear();
        yearIn.clear();
        millageIn.clear();
    }

    public void deleteCar() {
        ObservableList<Car> selectedCars, allCars;
        allCars = table.getItems();
        selectedCars = table.getSelectionModel().getSelectedItems();

        selectedCars.forEach(allCars::remove);
    }
}
