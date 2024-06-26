package app;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * A chart that displays circles representing the profit vs. the market value
 * for all the companies in the csv file. Catagory colours are different based
 * on the type of company.
 * @author: Kevin Basta
 */
public class ChartAppBubble extends Application {

    private Stage importedStage;
    private BubbleChart<Number, Number> chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;

    /**
     * Method that creates the javafx for the bubble chart and buttons layout
     *
     * @return Returns the container that the scene is made of
     */
    private Parent createContent() throws IOException {
        // Making the BubbleChart
        chart = createChart();
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().add(chart);

        // Making the Go Back Button
        Button button = new Button("<< Go Back");
        button.setOnMouseClicked((event) -> {
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
     * Method that creates the bubble chart
     *
     * @return Returns the bubble chart with all it's values
     */
    private BubbleChart<Number, Number> createChart() throws IOException {
        // Setting up the Bubble Chart
        xAxis = new NumberAxis();
        xAxis.setLabel("Market Value ($billion)");
        yAxis = new NumberAxis();
        yAxis.setLabel("Profits ($billion)");
        final BubbleChart<Number, Number> bc = new BubbleChart<>(xAxis, yAxis);

        final String bubbleChartCss = getClass().getResource("ChartAppBubbleStyle.css").toExternalForm();
        bc.setTitle("Profits vs. Market Value BubbleChart");
        bc.getStylesheets().add(bubbleChartCss);


        // Loading each catagory into an array and plotting it's values
        ArrayList<Company> carsArray = CompanyList.searchByCategory(6, "Cars");
        XYChart.Series<Number, Number> Cars = new XYChart.Series<>();
        Cars.setName("Cars");
        for (int i = 0; i < carsArray.size(); i++) {
            Cars.getData().add(new XYChart.Data<Number, Number>(carsArray.get(i).getCompanyMarketValue(), carsArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> bankArray = CompanyList.searchByCategory(6, "Bank");
        XYChart.Series<Number, Number> Banks = new XYChart.Series<>();
        Banks.setName("Banks");
        for (int i = 0; i < bankArray.size(); i++) {
            Banks.getData().add(new XYChart.Data<Number, Number>(bankArray.get(i).getCompanyMarketValue(), bankArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> utilityArray = CompanyList.searchByCategory(6, "Utility");
        XYChart.Series<Number, Number> Utilitys = new XYChart.Series<>();
        Utilitys.setName("Utilities");
        for (int i = 0; i < utilityArray.size(); i++) {
            Utilitys.getData().add(new XYChart.Data<Number, Number>(utilityArray.get(i).getCompanyMarketValue(), utilityArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> conglomerateArray = CompanyList.searchByCategory(6, "Conglomerate");
        XYChart.Series<Number, Number> Conglomerates = new XYChart.Series<>();
        Conglomerates.setName("Conglomerate");
        for (int i = 0; i < conglomerateArray.size(); i++) {
            Conglomerates.getData().add(new XYChart.Data<Number, Number>(conglomerateArray.get(i).getCompanyMarketValue(), conglomerateArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> tradeArray = CompanyList.searchByCategory(6, "Trade");
        XYChart.Series<Number, Number> Trades = new XYChart.Series<>();
        Trades.setName("Trade");
        for (int i = 0; i < tradeArray.size(); i++) {
            Trades.getData().add(new XYChart.Data<Number, Number>(tradeArray.get(i).getCompanyMarketValue(), tradeArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> technologyArray = CompanyList.searchByCategory(6, "Technology");
        XYChart.Series<Number, Number> Technologies = new XYChart.Series<>();
        Technologies.setName("Technology");
        for (int i = 0; i < technologyArray.size(); i++) {
            Technologies.getData().add(new XYChart.Data<Number, Number>(technologyArray.get(i).getCompanyMarketValue(), technologyArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> foodAndDrinkArray = CompanyList.searchByCategory(6, "Food and drink");
        XYChart.Series<Number, Number> Foods = new XYChart.Series<>();
        Foods.setName("Food and drink");
        for (int i = 0; i < foodAndDrinkArray.size(); i++) {
            Foods.getData().add(new XYChart.Data<Number, Number>(foodAndDrinkArray.get(i).getCompanyMarketValue(), foodAndDrinkArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> transportArray = CompanyList.searchByCategory(6, "Transport");
        XYChart.Series<Number, Number> Transports = new XYChart.Series<>();
        Transports.setName("Transport");
        for (int i = 0; i < transportArray.size(); i++) {
            Transports.getData().add(new XYChart.Data<Number, Number>(transportArray.get(i).getCompanyMarketValue(), transportArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> retailArray = CompanyList.searchByCategory(6, "Retail");
        XYChart.Series<Number, Number> Retails = new XYChart.Series<>();
        Retails.setName("Retail");
        for (int i = 0; i < retailArray.size(); i++) {
            Retails.getData().add(new XYChart.Data<Number, Number>(retailArray.get(i).getCompanyMarketValue(), retailArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> pharmacyArray = CompanyList.searchByCategory(6, "Pharmacy");
        XYChart.Series<Number, Number> Pharmacies = new XYChart.Series<>();
        Pharmacies.setName("Pharmacy");
        for (int i = 0; i < pharmacyArray.size(); i++) {
            Pharmacies.getData().add(new XYChart.Data<Number, Number>(pharmacyArray.get(i).getCompanyMarketValue(), pharmacyArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> manufactureArray = CompanyList.searchByCategory(6, "Manufacture");
        XYChart.Series<Number, Number> Manufactures = new XYChart.Series<>();
        Manufactures.setName("Manufacture");
        for (int i = 0; i < manufactureArray.size(); i++) {
            Manufactures.getData().add(new XYChart.Data<Number, Number>(manufactureArray.get(i).getCompanyMarketValue(), manufactureArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> realEstatesArray = CompanyList.searchByCategory(6, "Real Estate");
        XYChart.Series<Number, Number> RealEstates = new XYChart.Series<>();
        RealEstates.setName("Real Estate");
        for (int i = 0; i < realEstatesArray.size(); i++) {
            RealEstates.getData().add(new XYChart.Data<Number, Number>(realEstatesArray.get(i).getCompanyMarketValue(), realEstatesArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> InsuranceArray = CompanyList.searchByCategory(6, "Insurance");
        XYChart.Series<Number, Number> Insurances = new XYChart.Series<>();
        Insurances.setName("Insurance");
        for (int i = 0; i < InsuranceArray.size(); i++) {
            Insurances.getData().add(new XYChart.Data<Number, Number>(InsuranceArray.get(i).getCompanyMarketValue(), InsuranceArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> entertainmentArray = CompanyList.searchByCategory(6, "Entertainment");
        XYChart.Series<Number, Number> Entertainments = new XYChart.Series<>();
        Entertainments.setName("Entertainment");
        for (int i = 0; i < entertainmentArray.size(); i++) {
            Entertainments.getData().add(new XYChart.Data<Number, Number>(entertainmentArray.get(i).getCompanyMarketValue(), entertainmentArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> constructionArray = CompanyList.searchByCategory(6, "Construction");
        XYChart.Series<Number, Number> Constructions = new XYChart.Series<>();
        Constructions.setName("Construction");
        for (int i = 0; i < constructionArray.size(); i++) {
            Constructions.getData().add(new XYChart.Data<Number, Number>(constructionArray.get(i).getCompanyMarketValue(), constructionArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> mediaArray = CompanyList.searchByCategory(6, "Media");
        XYChart.Series<Number, Number> Medias = new XYChart.Series<>();
        Medias.setName("Media");
        for (int i = 0; i < mediaArray.size(); i++) {
            Medias.getData().add(new XYChart.Data<Number, Number>(mediaArray.get(i).getCompanyMarketValue(), mediaArray.get(i).getCompanyProfit(), 1));
        }

        ArrayList<Company> convenienceArray = CompanyList.searchByCategory(6, "Convenience ");
        XYChart.Series<Number, Number> Conveniences = new XYChart.Series<>();
        Conveniences.setName("Convenience");
        for (int i = 0; i < convenienceArray.size(); i++) {
            Conveniences.getData().add(new XYChart.Data<Number, Number>(convenienceArray.get(i).getCompanyMarketValue(), convenienceArray.get(i).getCompanyProfit(), 1));
        }


        // Adding all the differnt catagory series into the bubble chart
        bc.getData().addAll(Cars, Banks, Utilitys, Conglomerates, Trades, Technologies, Foods, Transports, Retails, Pharmacies, Manufactures, RealEstates, Insurances, Entertainments, Constructions, Medias, Conveniences);
        return bc;
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