package CH_16_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by yoshi on 3/15/2016.
 */
public class RadioButtons extends Application {


    BorderPane borderPane = new BorderPane();
    @Override
    public void start(Stage primaryStage) {

        /**Text*/
        Text text = new Text(140,140,"Programming is Fun");
        text.setFont(Font.font("Times", 20));
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);


        /**Radio Buttons*/
            RadioButton yellow = new RadioButton("Yellow");
        yellow.setOnAction(e->{
            if(yellow.isSelected())
                text.setFill(Color.YELLOW);
        });
            RadioButton red = new RadioButton("Red");
        red.setOnAction(e->{
            if(red.isSelected())
                text.setFill(Color.RED);
        });
            RadioButton green = new RadioButton("Green");
        green.setOnAction(e->{
            if(green.isSelected())
                text.setFill(Color.GREEN);
        });
            RadioButton blue = new RadioButton("Blue");
        blue.setOnAction(e-> {
            if(blue.isSelected())
                text.setFill(Color.BLUE);
        });
            ToggleGroup group = new ToggleGroup();
            yellow.setToggleGroup(group);
            red.setToggleGroup(group);
            green.setToggleGroup(group);
            blue.setToggleGroup(group);

            HBox radioBox = new HBox();
            radioBox.setSpacing(20);
            radioBox.setPadding(new Insets(15,15,15,15));
            radioBox.getChildren().addAll(yellow, red, green, blue);
            radioBox.setAlignment(Pos.CENTER);


        /**Left and Right Buttons*/
            Button btnLeft = new Button("<--");
        btnLeft.setOnAction(e->text.setX(text.getX()-50));
            Button btnRight = new Button("-->");
        btnRight.setOnAction(e->text.setX(text.getX()+50));

            HBox btnBox = new HBox();
            btnBox.setSpacing(20);
            btnBox.setPadding(new Insets(15,15,15,15));
            btnBox.getChildren().addAll(btnLeft, btnRight);
            btnBox.setAlignment(Pos.CENTER);

            borderPane.setTop(radioBox);
            borderPane.setCenter(paneForText);
            borderPane.setBottom(btnBox);

            Scene scene = new Scene(borderPane, 480, 360);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Color Buttons");
            primaryStage.show();
        }

    public static void main(String[] args) {
        launch(args);
    }
}
