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

import java.util.ArrayList;

public class Main extends Application {

    Stage window;
    TableView table;
    TextField nameIn, modelIn, priceIn;
    Controller c;
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TableView - Demo");
        c = new Controller();
        //Name Column:
        TableColumn<Product, String > nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Model Column:
        TableColumn<Product, String > modelCol = new TableColumn<>("Model");
        modelCol.setMinWidth(200);
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));

        //Price Column:
        TableColumn<Product, Double > priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Name Input
        nameIn = new TextField();
        nameIn.setPromptText("Name");
        nameIn.setMinWidth(100);

        // Model Input
        modelIn = new TextField();
        modelIn.setPromptText("Model");

        // Price Input
        priceIn = new TextField();
        priceIn.setPromptText("Price");

        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> addProduct());
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> deleteProduct());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameIn, modelIn, priceIn, addBtn, deleteBtn);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameCol, modelCol, priceCol);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        ArrayList<Product> readList = c.readList();
        for (int i = 0; i<readList.size(); i++) {
            products.add(readList.get(i));
        }
        return products;
    }

    public void addProduct() {
        Product p = new Product();
        p.setName(nameIn.getText());
        p.setModel(modelIn.getText());
        p.setPrice(Double.parseDouble(priceIn.getText()));
        table.getItems().add(p);
        c.addtoList(p);
        c.writeListToFile();
        nameIn.clear();
        modelIn.clear();
        priceIn.clear();

    }

    public void deleteProduct() {
        ObservableList<Product> selectedProduct, allProducts;
        allProducts = table.getItems();
        selectedProduct = table.getSelectionModel().getSelectedItems();
        //System.out.println(selectedProduct.get(0).getName());
        c.removeFromList(selectedProduct.get(0));
        c.writeListToFile();
        selectedProduct.forEach(allProducts::remove);
    }
}

