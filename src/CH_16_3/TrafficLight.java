package CH_16_3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by yoshi on 3/16/2016.
 */
public class TrafficLight extends Application {


    BorderPane borderPane = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        /**Circle*/
        Circle c1 = new Circle(10);
        c1.setStroke(Color.BLACK);
        c1.setFill(null);
        Circle c2 = new Circle(10);
        c2.setStroke(Color.BLACK);
        c2.setFill(null);
        Circle c3 = new Circle(10);
        c3.setStroke(Color.BLACK);
        c3.setFill(null);

        VBox vBox = new VBox(20);
        vBox.setMaxSize(30,10);
        vBox.setPadding(new Insets(5,5,5,5));
        vBox.getChildren().addAll(c1,c2,c3);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-border-color: Black");



        /**Radio Buttons*/
        RadioButton btnRed = new RadioButton("Red");
        btnRed.setOnAction((e->{
            if(btnRed.isSelected()) {
                c1.setFill(Color.RED);
                c2.setFill(null);
                c3.setFill(null);
            }
        }));
        RadioButton btnYellow = new RadioButton("Yellow");
        btnYellow.setOnAction(e->{
            if(btnYellow.isSelected())
                c2.setFill(Color.YELLOW);
                c1.setFill(null);
                c3.setFill(null);
        });
        RadioButton btnGreen = new RadioButton("Green");
        EventHandler<ActionEvent> event;
        btnGreen.setOnAction(e->{
            if(btnGreen.isSelected())
                c3.setFill(Color.GREEN);
                c1.setFill(null);
                c2.setFill(null);
        });



        ToggleGroup group = new ToggleGroup();
        btnRed.setToggleGroup(group);
        btnYellow.setToggleGroup(group);
        btnGreen.setToggleGroup(group);

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(btnRed,btnYellow,btnGreen);
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setAlignment(Pos.TOP_CENTER);

        /**BorderPane*/

        borderPane.setCenter(vBox);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 480, 360);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Traffic Light");
        primaryStage.show();
    }
/*
    class radioBtnHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {

        }
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}
