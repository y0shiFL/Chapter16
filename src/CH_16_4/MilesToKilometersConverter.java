package CH_16_4;/**
 * Created by yoshi on 3/16/2016.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.internal.util.xml.impl.Input;

import java.util.Scanner;

public class MilesToKilometersConverter extends Application {


    private TextField tfMile = new TextField();
    private TextField tfKilometer = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Miles"),0,0);
        gridPane.add(tfMile, 1,0);
        gridPane.add(new Label("Kilometers"), 0,1);
        gridPane.add(tfKilometer, 1,1);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(15,15,15,15));

        tfMile.setOnKeyPressed(e->{

            switch(e.getCode())
            {
                case ENTER: ConvertToKilometers();
                    break;
            }
        });

        tfKilometer.setOnKeyPressed(e-> {
            switch(e.getCode())
            {
                case ENTER: ConvertToMiles();
                    break;
            }
        });

        Scene scene = new Scene(gridPane,300,100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miles/Kilometers Converter");
        primaryStage.show();

    }

    public void ConvertToKilometers()
    {

        double mile = Double.parseDouble(tfMile.getText());

        /** 1 km = .6241 mi */
        /** 1 mi = 1.602307322544464 km */
        mile *= 1.602307322544464;

        tfKilometer.setText(String.format("%.10f", mile));

    }

    public void ConvertToMiles()
    {
        double kilometer =  Double.parseDouble(tfKilometer.getText());
        /** 1 km = .6241 mi */
        /** 1 mi = 1.602307322544464 km */
        kilometer *= .6241;

        tfMile.setText(String.format("%.10f", kilometer));
    }

}
