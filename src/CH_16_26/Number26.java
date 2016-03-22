package CH_16_26;/**
 * Created by bill on 3/21/16.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Number26 extends Application {

    private final static String URLBase =
            "http://cs.armstrong.edu/liang/common";
    private int currentIndex = 0;

    double currentImageY = 0;
    double currentDirection = -1.0;
    final Image image = new Image("http://cs.armstrong.edu/liang/common/image/flag6.gif");
    final ImageView imageView = new ImageView(image);
    final MediaPlayer mp = new MediaPlayer(new Media(URLBase + "/audio/anthem/anthem6.mp3"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        currentImageY = image.getHeight();
        imageView.setLayoutX(0);
        imageView.setLayoutY(currentImageY);

        final Pane root = new Pane();
        /**
        final VBox buttonBox = new VBox(5);
        Button btTest = new Button(">");
        btTest.setOnAction(e -> {
            currentImageY -= 5;
            imageView.setLayoutY(currentImageY);
        });
        buttonBox.getChildren().addAll(btTest);
        root.getChildren().add(buttonBox);
        **/

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        mp.play();

        root.getChildren().add(imageView);

        primaryStage.setScene(new Scene(root, image.getWidth(), image.getHeight()));
        primaryStage.show();

    }

    EventHandler<ActionEvent> eventHandler = e -> {
        if (currentImageY <= 0)
            currentDirection = 1.0;
        else if (currentImageY >= image.getHeight())
            currentDirection = -1.0;

        currentImageY+=currentDirection;
        imageView.setLayoutY(currentImageY);
    };


}
