package app;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * A chart that displays rectangular bars with heights indicating data sales
 * value for each category. Each rectangular bar has different colours indicating
 * a different company in that catagory.
 * @author: Kevin Basta
 */
public class ChartAppBar extends Application {
 
    private Stage importedStage;
    private static ArrayList<Company> companyList = new ArrayList<Company>();
    private StackedBarChart chart;
    private CategoryAxis namesXAxis;
    private NumberAxis yAxis;
    
    /**
     * Method that creates all the javafx for the bar chart and buttons
     *
     * @return Returns the container that the scene is made of
     */
    private Parent createContent() throws IOException {
        // Making the BarChart
        namesXAxis = new CategoryAxis();
        namesXAxis.setLabel("Company Type");

        yAxis = new NumberAxis();
        yAxis.setLabel("Sales ($Billion)");

        chart = new StackedBarChart<>(namesXAxis, yAxis);
        for (int i = 0; i < companyList.size(); i++) {
            XYChart.Series barChartSeries = new XYChart.Series<>();
            barChartSeries.getData().add(new XYChart.Data(String.valueOf(companyList.get(i).getCompanyType()), companyList.get(i).getCompanySales()));
            chart.getData().add(barChartSeries);
        }
        chart.setTitle("Total Sales By Category");
        chart.setLegendVisible(false);
        

        // Making the chart stackpane for the vertical box
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
      this.companyList = CompanyList.selectionSortDouble(2);
      this.importedStage = theStage;
      return new Scene(createContent(), 800, 500);
    }
    

    /**
     * A method required by the javafx library for independant running
     * 
     * @param primaryStage  A stage created by this java file
     */
    @Override public void start(Stage primaryStage) throws Exception {}
}