package CH_16_22;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AudioFun extends Application {

    final AudioClip clip = new AudioClip("tos_com_beep_1.mp3");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button btnPlay = new Button("Play");
        btnPlay.setOnAction(e -> { clip.play();} );

        Button btnLoop = new Button("Loop");
        btnLoop.setOnAction(e -> { clip.setCycleCount(10);} );

        Button btnStop = new Button("Stop");
        HBox hboxTop = new HBox(5, btnPlay, btnLoop, btnStop);
        hboxTop.setAlignment(Pos.CENTER);
        hboxTop.setPadding(new Insets(10));
        hboxTop.setStyle("-fx-border-color: black");


        // Create a border pane to hold text and scroll bars
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hboxTop);

        Scene scene = new Scene(borderPane, 600, 360);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Font Colorizer");
        primaryStage.show();

    }



}
