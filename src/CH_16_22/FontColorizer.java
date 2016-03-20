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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FontColorizer extends Application {

    Text textInCenter = new Text(50, 150, "Programming is fun!");
    ComboBox<Integer> comboFontSize = new ComboBox<>();
    ComboBox<String> comboFontFamily = new ComboBox<>();
    CheckBox chkBold = new CheckBox("Bold");
    CheckBox chkItalic = new CheckBox("Italics");

    Font fontBoldItalic;
    Font fontBold;
    Font fontItalic;
    Font fontNormal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        List<String> fontFams = Font.getFamilies();
        ObservableList<String> fontFamiliesList = FXCollections.observableArrayList(fontFams);
        comboFontFamily.setItems(fontFamiliesList);
        comboFontFamily.setValue( fontFams.get(1) );  // first font in list
        //comboFontFamily.setValue( "Arial" );

        List<Integer> fontSizes = new ArrayList<Integer>();
        for (int i = 1; i < 100; i++) {
            fontSizes.add(i);
        }
        ObservableList<Integer> fontSizeList = FXCollections.<Integer> observableList(fontSizes);
        comboFontSize.setItems(fontSizeList);
        comboFontSize.setValue(20);

        EventHandler<ActionEvent> handlerFF = e -> { rebuildFonts(); };
        comboFontFamily.setOnAction(handlerFF);
        comboFontSize.setOnAction(handlerFF);

        HBox hboxTop = new HBox(5,comboFontFamily,comboFontSize);
        hboxTop.setAlignment(Pos.CENTER);
        hboxTop.setPadding(new Insets(10));
        hboxTop.setStyle("-fx-border-color: black");


        Pane paneForText = new Pane();
        paneForText.getChildren().add(textInCenter);

        EventHandler<ActionEvent> handler = e -> { showSelFont(); };
        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);

        HBox hboxBottom = new HBox(5,chkBold,chkItalic);
        hboxBottom.setAlignment(Pos.CENTER);
        hboxBottom.setPadding(new Insets(10));
        hboxBottom.setStyle("-fx-border-color: black");



        ScrollBar sbRed = new ScrollBar();
        sbRed.valueProperty().addListener(ov -> {
            double newRed = sbRed.getValue() / sbRed.getMax();
            Color clr = (Color) textInCenter.getFill();  // casting to Color assumes it's a solid colid, not a gradient
            textInCenter.setFill( new Color(newRed, clr.getGreen(), clr.getBlue(), clr.getOpacity()) );
        });
        ScrollBar sbGreen = new ScrollBar();
        sbGreen.valueProperty().addListener(ov -> {
            double newGreen = sbGreen.getValue() / sbGreen.getMax();
            Color clr = (Color) textInCenter.getFill();  // casting to Color assumes it's a solid colid, not a gradient
            textInCenter.setFill( new Color(clr.getRed(), newGreen, clr.getBlue(), clr.getOpacity()) );
        });

        GridPane paneRight = new GridPane();
        paneRight.setAlignment(Pos.CENTER);
        paneRight.setPadding(new Insets(10));
        paneRight.setStyle("-fx-border-color: black");

        paneRight.add(new Label("Red"), 0, 0);
        paneRight.add(sbRed,1,0);
        paneRight.add(new Label("Green"), 0, 1);
        paneRight.add(sbGreen,1,1);


        // need to call rebuildFonts to build for the first time
        rebuildFonts();

        // Create a border pane to hold text and scroll bars
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hboxTop);
        borderPane.setCenter(paneForText);
        borderPane.setBottom(hboxBottom);
        borderPane.setRight(paneRight);

        Scene scene = new Scene(borderPane, 600, 360);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Font Colorizer");
        primaryStage.show();

    }


    private void showSelFont() {
        if (chkBold.isSelected() && chkItalic.isSelected()) {
            textInCenter.setFont(fontBoldItalic);
        }
        else if(chkBold.isSelected()){
            textInCenter.setFont(fontBold);
        }
        else if(chkItalic.isSelected()) {
            textInCenter.setFont(fontItalic);
        }
        else{
            textInCenter.setFont(fontNormal);
        }
    }

    private void rebuildFonts() {
        double size = (double)comboFontSize.getValue();
        String fam = comboFontFamily.getValue();
        fontBoldItalic = Font.font(fam, FontWeight.BOLD, FontPosture.ITALIC, size);
        fontBold = Font.font(fam, FontWeight.BOLD, FontPosture.REGULAR, size);
        fontItalic = Font.font(fam, FontWeight.NORMAL, FontPosture.ITALIC, size);
        fontNormal = Font.font(fam, FontWeight.NORMAL, FontPosture.REGULAR, size);
        showSelFont();
    }


}
