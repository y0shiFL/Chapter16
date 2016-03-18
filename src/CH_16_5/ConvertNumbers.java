package CH_16_5;/**
 * Created by yoshi on 3/17/2016.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConvertNumbers extends Application {


    private TextField tfDecimal = new TextField();
    private TextField tfHex = new TextField();
    private TextField tfBinary = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Decimal"),0,0);
        gridPane.add(tfDecimal, 1,0);
        gridPane.add(new Label("Hex"), 0,1);
        gridPane.add(tfHex, 1,1);
        gridPane.add(new Label("Binary"),0,2);
        gridPane.add(tfBinary,1,2);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(15,15,15,15));

        tfDecimal.setOnKeyPressed(e->{

            switch(e.getCode())
            {
                case ENTER: ConvertFromDecimal();
                    break;
            }
        });

        tfHex.setOnKeyPressed(e-> {
            switch(e.getCode())
            {
                case ENTER: ConvertFromHex();
                    break;
            }
        });

        tfBinary.setOnKeyPressed(e-> {
            switch(e.getCode())
            {
                case ENTER: ConvertFromBinary();
                    break;
            }
        });


        Scene scene = new Scene(gridPane,400,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miles/Kilometers Converter");
        primaryStage.show();
    }

    public void ConvertFromDecimal()
    {

        int decimal = Integer.parseInt(tfDecimal.getText());

        String decToHex = Integer.toHexString(decimal);
        String decToBinary = Integer.toBinaryString(decimal);

        tfHex.setText(String.format(decToHex));
        tfBinary.setText(String.format(decToBinary));

    }

    public void ConvertFromHex()
    {
        int hex = Integer.parseInt(tfHex.getText(), 16);

        String hexToDec = Integer.toString(hex);
        String hexToBinary = Integer.toBinaryString(hex);

        tfDecimal.setText(String.format(hexToDec));
        tfBinary.setText(String.format(hexToBinary));
    }

    public void ConvertFromBinary()
    {
        int binary = Integer.parseInt(tfBinary.getText(), 2);

        String binaryToDec = Integer.toString(binary);
        String binaryToHex = Integer.toHexString(binary);

        tfDecimal.setText(String.format(binaryToDec));
        tfHex.setText(String.format(binaryToHex));
    }


}
