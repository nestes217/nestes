package m11a1nestes;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class M11A1Nestes extends Application {

    List <String> list;

    @Override
    public void start(Stage primaryStage) {
        list = new ArrayList<>();
        //create label to display state text
        Label lb = new Label();
        lb.setAlignment(Pos.TOP_RIGHT);
        lb.setText("Ryan likes poop");
        //create HBox for "Add State" button
        HBox btnBox = new HBox();
        btnBox.setPadding(new Insets(25, 25, 25, 25));
        //create "Add State" button
        Button bAddState = new Button("Add State");
        btnBox.getChildren().add(bAddState);
        btnBox.setAlignment(Pos.BOTTOM_CENTER);
        //create ListView to add states to
        ObservableList<String> states =
                FXCollections.observableArrayList();
        ListView<String> lv = new ListView<>(states);
        //create TextField to enter states
        TextField tf = new TextField();
        tf.setOnAction(e -> {
            lv.getItems().add(tf.getText());
            tf.clear();
            tf.requestFocus();
                });
        bAddState.setOnAction(e -> {
            lv.getItems().add(tf.getText());
            tf.clear();
            tf.requestFocus();
                });
//        lv.getSelectionModel().selectedItemProperty().addListener(
//        ov -> {
//            lb.setText(lv.se);
//        });

        //create VBox to put lv and tf into
        VBox vB = new VBox();
        vB.setSpacing(20);
        vB.setPadding(new Insets(20, 20, 20, 20));
        vB.setMaxSize(200, 400);
        vB.getChildren().addAll(tf, lv);

        BorderPane root = new BorderPane();
        root.setTop(null);
        root.setRight(btnBox);
        root.setLeft(vB);
        root.setCenter(lb);

        Scene scene = new Scene(root, 500, 300);

        primaryStage.setTitle("State List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
