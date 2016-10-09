/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storagecalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Kris Hayes
 */
public class StorageCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        VideoStorage videoBean = new VideoStorage();
        Label enterSize = new Label("Enter length in Seconds:");
        Label enterQuality = new Label("Enter quality of video (720 or 1080):");
        Text calcAmount = new Text();
        TextField textSize = new TextField();
        TextField textQuality = new TextField();
    
        Button btn = new Button("Calculate");
        btn.setOnAction(value -> {
            videoBean.setSeconds(Integer.parseInt(enterSize.getText()));
            videoBean.setVideoQuality(Integer.parseInt(enterQuality.getText()));
            calcAmount.setText(videoBean.calcStorage());
        });
        
        GridPane pane1 = new GridPane();
        pane1.setAlignment(Pos.CENTER);
        pane1.setHgap(10);
        pane1.setVgap(10);
        pane1.setPadding(new Insets(25, 25, 25, 25));
        
        pane1.add(enterSize, 0, 0);
        pane1.add(textSize, 1, 0);
        pane1.add(enterQuality, 0, 1);
        pane1.add(textQuality, 1, 1);
        pane1.add(btn, 0, 2);
        pane1.add(calcAmount, 0, 3);
        
        Scene scene = new Scene(pane1, 500, 300);
        
        primaryStage.setTitle("Storage Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
