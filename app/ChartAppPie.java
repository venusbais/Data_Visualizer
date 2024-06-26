package app;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
 
/**
 * A circular chart divided into segments. The value of each segment represents
 * a proportion of the total. Shows the top 5 Assets as well as an other catagory
 * containing all assets values of the rest of the csv file.
 * @author: Kevin Basta
 */
public class ChartAppPie extends Application {

    private static ArrayList<Company> companyList = new ArrayList<Company>();
    private Stage importedStage;
    private PieChart chart;

    /**
     * Method that creates the pie chart
     */
    private void generateData() {
        // Setting up the PieChart
        chart = new PieChart();
        chart.setTitle("Top 5 Company Assets In Billions");
        chart.setClockwise(false);
        chart.setLegendVisible(false);

        // Putting the top 5 assets in the PieChart
        for (int i = 0; i < 5; i++) {
            PieChart.Data pieChartData = new PieChart.Data(companyList.get(i).getCompanyName(), companyList.get(i).getCompanyAssets());
            chart.getData().add(pieChartData);
        }

        // Putting the "other" catagory in the PieChart
        Double otherCompanyAssets = 0.0;
        for (int j = 5; j < companyList.size(); j++) {
            otherCompanyAssets += companyList.get(j).getCompanyAssets();
        }
        PieChart.Data pieChartOtherData = new PieChart.Data("other", otherCompanyAssets);
        chart.getData().add(pieChartOtherData);
    }
 

    /**
     * Method that creates all the javafx for the pie chart and buttons
     *
     * @return Returns the container that the scene is made of
     */
    public Parent createContent() {
        // Calling the method to create the pie chart
        generateData();
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().add(chart);

        // Making the Go Back Button
        Button button = new Button("<< Go Back");
        button.setOnMouseClicked((event)->{
            Main.setOwnStage(importedStage);
        });

        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);
        spButton.setPadding(new Insets(5, 5, 5, 5));
        spButton.setAlignment(Pos.BASELINE_RIGHT);

        // Putting the chart and the button in a layout
        VBox vbox = new VBox();
        VBox.setVgrow(spLineChart, Priority.ALWAYS);
        vbox.setMargin(spButton, new Insets(0, 30, 0, 75));
        vbox.getChildren().addAll(spLineChart, spButton);

        return vbox;
    }
    
 
    /**
     * A method that sends the chart scene back to the main stage
     * in the Main.java
     * 
     * @param theStage  This parameter gets the main.java stage so 
     * that it's able to set the main stage to a different scene later
     * @return  A scene from the createContent method
     */
    public Scene getScene(Stage theStage) throws IOException {
        companyList = CompanyList.selectionSortDouble(4);
        importedStage = theStage;
        return new Scene(createContent(), 800, 500);
    }


    /**
     * A method required by the javafx library for independant running
     * 
     * @param primaryStage  A stage created by this java file
     */
    @Override public void start(Stage primaryStage) throws Exception {}
}