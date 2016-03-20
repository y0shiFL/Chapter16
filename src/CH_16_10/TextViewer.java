package CH_16_10;/**
 * Created by yoshi on 3/17/2016.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class TextViewer extends Application {


    private TextField tfInput = new TextField();
    private TextArea taOutput = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();

        taOutput.setFont(Font.font("Times", 20));
        taOutput.setEditable(false);
        taOutput.setWrapText(true);
        taOutput.setMaxSize(300, 300);

        ScrollPane outputScroll = new ScrollPane(taOutput);


        tfInput.setFont(Font.font("Times", 12));
        tfInput.setEditable(true);
        tfInput.setMaxSize(300, 50);

        ScrollPane inputScroll = new ScrollPane(tfInput);


        Button btn = new Button("View");
        btn.setMaxSize(50, 50);
        btn.setAlignment(Pos.BOTTOM_CENTER);

        btn.setOnAction(e -> getTextFile());

        gridPane.add(outputScroll, 0, 0);
        gridPane.add(inputScroll, 0, 1);
        gridPane.add(btn, 0, 2);


        Scene scene = new Scene(gridPane, 450, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Viewer");
        primaryStage.show();
    }

    public void getTextFile() {
        taOutput.clear();

        String txtFile = tfInput.getText();
        Boolean bLoadOk = Boolean.FALSE;
        try {
            Scanner scan = new Scanner(new FileReader(txtFile));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                taOutput.appendText(line);
            }

           /*
            BufferedReader in = new BufferedReader(new FileReader(txtFile));

            String line = null;
            while ((line = in.readLine()) != null) {
                taOutput.appendText(line);
            }
            */
            // bLoadOk = Boolean.TRUE;

        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //
        }
        if (!bLoadOk) {
            taOutput.appendText("File not found");
        }
    }
}

