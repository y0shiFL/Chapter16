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

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AudioFun extends Application {

    AudioClip clip;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL resource = getClass().getResource("tos_com_beep_1.mp3");
        String sClipResource = resource.toString();
        System.out.println("Looking for audio clip at: " + sClipResource);  // need to put mp3 file here

        clip = new AudioClip(resource.toString());

        Button btnPlay = new Button("Play");
        btnPlay.setOnAction(e -> {
            clip.stop();
            clip.setCycleCount(1);
            clip.play(0.5);   // 0.5 is half volume
        });

        Button btnLoop = new Button("Loop");
        btnLoop.setOnAction(e -> {
            clip.setCycleCount(AudioClip.INDEFINITE);
            clip.play(0.5);
        });

        Button btnStop = new Button("Stop");
        btnStop.setOnAction(e -> {
            clip.stop();
        });

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
