package app;

import java.io.*;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

/**
 * A javafx scene for displaying the individual record for a given company
 * @author: Kevin Basta
 */
public class IndividualRecordView extends Application {
    private Stage importedStage;
    private ArrayList<Company> companyDataList = new ArrayList<Company>();

    /**
     * Method that creates all the javafx for the page and buttons
     *
     * @return Returns the container that the scene is made of
     */
    public Parent createContent() throws IOException { 
         // Making the go back to main menue button
        Button button = new Button("<< Go Back To Main Menue");
        button.setOnMouseClicked((event)->{
            Main.setOwnStage(importedStage);
        });
        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);

         // Making the go back to search button
        Button buttonSearch = new Button("<< Go Back To Search");
        buttonSearch.setOnMouseClicked((event)->{
            TableAppViewSearch tableAppSearch = new TableAppViewSearch();
            Scene tableAppSearchScene;

            try {
                tableAppSearchScene = tableAppSearch.getScene(importedStage);
                importedStage.setScene(tableAppSearchScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spButtonSearch = new StackPane();
        spButtonSearch.getChildren().add(buttonSearch);

        // Vertical Wrapper
        VBox vbox = new VBox();

        // Horizontal Wrapper #1
        Text companyName = new Text(companyDataList.get(0).getCompanyName());
        companyName.setFont(Font.font("Tahoma", FontWeight.BLACK, 50));
        HBox hbox = new HBox(30);
        hbox.getChildren().addAll(companyName);
        hbox.setPadding(new Insets(15, 25, 25, 25));
        hbox.setAlignment(Pos.BASELINE_LEFT);

        // Horizontal Wrapper #2 SMALL TITLES
        Text type = new Text("TYPE");
        type.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text sales = new Text("SALES (billion)");
        sales.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text profits = new Text("PROFIT (billion)");
        profits.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));

        HBox hbox2 = new HBox(8);
        hbox2.getChildren().addAll(type, sales, profits);
        hbox2.setMargin(type, new Insets(0, 100, 5, 0));
        hbox2.setMargin(sales, new Insets(0, 100, 5, 0));
        hbox2.setMargin(profits, new Insets(0, 0, 5, 0));
        hbox2.setPadding(new Insets(0, 100, 5, 100));
        hbox2.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #3 VALUES
        Text typeValue = new Text(companyDataList.get(0).getCompanyType());
        typeValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text salesValue = new Text("$" + String.valueOf(companyDataList.get(0).getCompanySales()));
        salesValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text profitsValue = new Text("$" + String.valueOf(companyDataList.get(0).getCompanyProfit()));
        profitsValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

        HBox hbox3 = new HBox(8);
        hbox3.getChildren().addAll(typeValue, salesValue, profitsValue);
        if (companyDataList.get(0).getCompanyType().length() > 7) {
            hbox3.setMargin(typeValue, new Insets(5, 40, 5, -50));
        } else {
            hbox3.setMargin(typeValue, new Insets(5, 85, 5, 0));
        }
        hbox3.setMargin(salesValue, new Insets(5, 75, 5, 0));
        hbox3.setMargin(profitsValue, new Insets(5, 0, 5, 0));
        hbox3.setPadding(new Insets(0, 100, 50, 100));
        hbox3.setAlignment(Pos.BASELINE_CENTER);


        // Horizontal Wrapper #5 SMALL TITLES
        Text globalRank = new Text("GLOBAL RANK");
        globalRank.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text assets = new Text("ASSETS (billion)");
        assets.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text marketValue = new Text("MARKET VALUE (billion)");
        marketValue.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));

        HBox hbox5 = new HBox(8);
        hbox5.getChildren().addAll(globalRank, assets, marketValue);
        hbox5.setMargin(globalRank, new Insets(0, 100, 5, 5));
        hbox5.setMargin(assets, new Insets(0, 100, 5, 0));
        hbox5.setMargin(marketValue, new Insets(0, 0, 5, 0));
        hbox5.setPadding(new Insets(0, 100, 5, 100));
        hbox5.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #6 VALUES
        Text globalRankValue = new Text("#" + String.valueOf(companyDataList.get(0).getCompanyRank()));
        globalRankValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text assetsValue = new Text("$" + String.valueOf(companyDataList.get(0).getCompanyAssets()));
        assetsValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text marketValueValue = new Text("$" + String.valueOf(companyDataList.get(0).getCompanyMarketValue()));
        marketValueValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

        HBox hbox6 = new HBox(8);
        hbox6.getChildren().addAll(globalRankValue, assetsValue, marketValueValue);
        hbox6.setMargin(globalRankValue, new Insets(5, 100, 5, 0));
        hbox6.setMargin(assetsValue, new Insets(5, 100, 5, 0));
        hbox6.setMargin(marketValueValue, new Insets(5, 0, 5, 0));
        hbox6.setPadding(new Insets(0, 100, 5, 100));
        hbox6.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #7 DESCRIPTION
        String description = companyDataList.get(0).getCompanyDescription();
        
        Label label = new Label(description);
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        label.setMaxWidth(700);
        label.setMaxHeight(600);

        HBox hbox7 = new HBox(8);
        hbox7.getChildren().addAll(label);
        hbox7.setMargin(label, new Insets(5, 0, 5, 0));
        hbox7.setPadding(new Insets(15, 20, 10, 20));
        hbox7.setAlignment(Pos.BASELINE_CENTER);

       // Horizontal Wrapper #4 RETURN BUTTONS
       HBox hbox4 = new HBox(8);
       hbox4.getChildren().addAll(buttonSearch, spButton);
       hbox4.setMargin(spButton, new Insets(0, 30, 0, 75));
       hbox4.setPadding(new Insets(5, 5, 5, 5));
       hbox4.setAlignment(Pos.BASELINE_RIGHT);

       // Adding all the horizontal boxes to the vertical box
        vbox.getChildren().addAll(hbox, hbox2, hbox3, hbox5, hbox6, hbox7, hbox4);
        return vbox;
    } 

    /**
     * A method that sends the scene back to the main stage in the Main.java
     * 
     * @param theStage This parameter gets the main.java stage so that it's able to
     * set the main stage to a different scene later
     * @param companyObject This passes the company object to display information about
     * @return A scene from the createContent method
     */
    public Scene getScene(Stage theStage, Company companyObject) throws IOException {
        companyDataList.clear();
        companyDataList.add(companyObject);
        importedStage = theStage;
        return new Scene(createContent(), 800, 500);
    }

    /**
     * A method required by the javafx library for independant running
     * 
     * @param primaryStage A stage created by this java file
     */
    @Override public void start(Stage primaryStage) throws Exception {}
}
