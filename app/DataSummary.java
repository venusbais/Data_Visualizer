package app;

import java.io.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * A javafx scene for displaying the summary data of the data set
 * @author: Kevin Basta
 */
public class DataSummary extends Application {
    private Stage importedStage;
    private String[] strDataSummary;

    /**
     * Method that creates all the javafx for the summary page and buttons
     *
     * @return Returns the container that the scene is made of
     */
    public Parent createContent() throws IOException {
        // Making the Go Back Button
        Button button = new Button("<< Go Back");
        button.setOnMouseClicked((event) -> {
            Main.setOwnStage(importedStage);
        });
        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);

        // Vertical Wrapper
        VBox vbox = new VBox();

        // Horizontal Wrapper #0
        Text summaryTitle = new Text("Japanese Largest Companies");
        summaryTitle.setFont(Font.font("Tahoma", FontWeight.BLACK, 35));
        HBox hbox0 = new HBox(30);
        hbox0.getChildren().addAll(summaryTitle);
        hbox0.setPadding(new Insets(15, 25, 0, 25));
        hbox0.setAlignment(Pos.BASELINE_LEFT);

        // Horizontal Wrapper #1
        Text summaryTitleTwo = new Text("Dataset Summary");
        summaryTitleTwo.setFont(Font.font("Tahoma", FontWeight.BLACK, 35));
        HBox hbox = new HBox(30);
        hbox.getChildren().addAll(summaryTitleTwo);
        hbox.setPadding(new Insets(15, 25, 25, 25));
        hbox.setAlignment(Pos.BASELINE_LEFT);

        // Horizontal Wrapper #2 SMALL TITLES
        Text AverageSales = new Text("AVERAGE SALES (billion)");
        AverageSales.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text AverageAssets = new Text("AVERAGE ASSETS (billion)");
        AverageAssets.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text AverageMarketValue = new Text("AVERAGE MARKET VALUE (billion)");
        AverageMarketValue.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));

        HBox hbox2 = new HBox(8);
        hbox2.getChildren().addAll(AverageSales, AverageAssets, AverageMarketValue);
        hbox2.setMargin(AverageSales, new Insets(0, 100, 5, 0));
        hbox2.setMargin(AverageAssets, new Insets(0, 100, 5, 0));
        hbox2.setMargin(AverageMarketValue, new Insets(0, 0, 5, 0));
        hbox2.setPadding(new Insets(0, 100, 5, 100));
        hbox2.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #3 VALUES
        Text AverageSalesValue = new Text("$" + strDataSummary[0]);
        AverageSalesValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text AverageAssetsValue = new Text("$" + (strDataSummary[2]));
        AverageAssetsValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text AverageMarketValueValue = new Text("$" + (strDataSummary[3]));
        AverageMarketValueValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

        HBox hbox3 = new HBox(8);
        hbox3.getChildren().addAll(AverageSalesValue, AverageAssetsValue, AverageMarketValueValue);
        hbox3.setMargin(AverageSalesValue, new Insets(5, 110, 5, 0));
        hbox3.setMargin(AverageAssetsValue, new Insets(5, 110, 5, 0));
        hbox3.setMargin(AverageMarketValueValue, new Insets(5, 0, 5, 0));
        hbox3.setPadding(new Insets(0, 75, 50, 75));
        hbox3.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #5 SMALL TITLES
        Text AverageProfit = new Text("AVERAGE PROFIT (billion)");
        AverageProfit.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text MaxProfit = new Text("MAX PROFIT (billion)");
        MaxProfit.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text MinProfit = new Text("MIN PROFIT (billion)");
        MinProfit.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));

        HBox hbox5 = new HBox(8);
        hbox5.getChildren().addAll(AverageProfit, MaxProfit, MinProfit);
        hbox5.setMargin(AverageProfit, new Insets(0, 100, 5, 5));
        hbox5.setMargin(MaxProfit, new Insets(0, 100, 5, 0));
        hbox5.setMargin(MinProfit, new Insets(0, 0, 5, 0));
        hbox5.setPadding(new Insets(0, 100, 5, 100));
        hbox5.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #6 VALUES
        Text AverageProfitValue = new Text("$" + strDataSummary[1]);
        AverageProfitValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text MaxProfitValue = new Text("$" + strDataSummary[4]);
        MaxProfitValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text MinProfitValue = new Text("$" + strDataSummary[5]);
        MinProfitValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

        HBox hbox6 = new HBox(8);
        hbox6.getChildren().addAll(AverageProfitValue, MaxProfitValue, MinProfitValue);
        hbox6.setMargin(AverageProfitValue, new Insets(5, 100, 5, 0));
        hbox6.setMargin(MaxProfitValue, new Insets(5, 100, 5, 0));
        hbox6.setMargin(MinProfitValue, new Insets(5, 0, 5, 0));
        hbox6.setPadding(new Insets(0, 100, 5, 100));
        hbox6.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #4 RETURN BUTTON
        HBox hbox4 = new HBox(8);
        hbox4.getChildren().addAll(spButton);
        hbox4.setMargin(spButton, new Insets(0, 30, 0, 75));
        hbox4.setPadding(new Insets(5, 5, 5, 5));
        hbox4.setAlignment(Pos.BASELINE_RIGHT);

        // Adding all the horizontal boxes to the vertical box
        vbox.getChildren().addAll(hbox0, hbox, hbox2, hbox3, hbox5, hbox6, hbox4);
        return vbox;
    }

    /**
     * A method that sends the summary scene back to the main stage in the Main.java
     * 
     * @param theStage This parameter gets the main.java stage so that it's able to
     * set the main stage to a different scene later
     * @return A scene from the createContent method
     */
    public Scene getScene(Stage theStage) throws IOException {
        strDataSummary = CompanyList.getDataSummary();
        importedStage = theStage;
        return new Scene(createContent(), 800, 500);
    }

    /**
     * A method required by the javafx library for independant running
     * 
     * @param primaryStage A stage created by this java file
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
    }
}
