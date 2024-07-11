package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setMaxHeight(144);
        stage.setMaxWidth(400);

        //INSTANCIATION
        Label label = new Label("User Input :  ");
        Label label2 = new Label("Copy of the User Input : ");

        TextField textField1 = new TextField("Enter Text");
        TextField textField2 = new TextField("Enter Text");
        textField2.setEditable(false);
       
        Button buttonCopy = new Button("Copy");
        Button buttonErase = new Button("Erase");
        Button buttonQuit = new Button("Quit");

        VBox vbox1 = new VBox(buttonCopy,buttonErase,buttonQuit);
        vbox1.setSpacing(10); //spacing in bbox
        vbox1.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane(); // GRIDPANE
        gridPane.add(label, 0,0);
        gridPane.add(label2, 0,1);
        gridPane.add(textField1,1,0);
        gridPane.add(textField2,1,1);
        gridPane.add(vbox1,2,0,1,2);

        //gridPane.setGridLinesVisible(true); -> LINES
       
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(50);

        gridPane.getRowConstraints().addAll(row1,row2);

       //SEETINGS
       gridPane.setAlignment(Pos.CENTER); //.SETALIGNMENT
       gridPane.setHgap(20);
       gridPane.setVgap(10);

        //"ASSEMBLAGE"
        Scene scene = new Scene(gridPane, 640, 480);
       
        buttonCopy.setOnAction(e -> {
        //String text = textField1.getText(); //.GETTEXT
        //textField2.setText(text);  //.SETTEXT
        textField2.setText(textField1.getText());
        });
       

        //buttonErase.setOnAction(e -> {
        //textField1.setText("Enter Text");
        //textField2.setText(textField1.getText());
        //});

        buttonErase.setOnAction(e ->{
        textField2.clear();
        });


        buttonQuit.setOnAction(e ->Platform.exit());  //.EXIT
        stage.setScene(scene);
        stage.show();

    }  
}