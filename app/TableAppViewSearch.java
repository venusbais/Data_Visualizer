package app;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

/**
 * A table for seaching the data set and selecting which 
 * record from the search to view
 * @author: Kevin Basta
 */
public class TableAppViewSearch extends Application {
    private Stage importedStage;
    private ArrayList<Company> companyDataList = new ArrayList<Company>();

    /**
     * Method that creates the javafx for the table view and buttons layout
     *
     * @return Returns the container that the scene is made of
     */
    public Parent createContent() throws IOException {
        final ObservableList<Company> data = FXCollections.observableArrayList();

        if (companyDataList.isEmpty()) {
            String[] newComapnyData = {"1", "Example Company", "1", "2", "3", "4", "Example Type", "Description Of Company"};
            companyDataList.add(new Company(newComapnyData));
        }

        // Making the table view
        for (int i = 0; i < companyDataList.size(); i++) {
            String[] singleCompanyDataValue = { String.valueOf(companyDataList.get(i).getCompanyRank()),
                    companyDataList.get(i).getCompanyName(), String.valueOf(companyDataList.get(i).getCompanySales()),
                    String.valueOf(companyDataList.get(i).getCompanyProfit()),
                    String.valueOf(companyDataList.get(i).getCompanyAssets()),
                    String.valueOf(companyDataList.get(i).getCompanyMarketValue()),
                    companyDataList.get(i).getCompanyType(), companyDataList.get(i).getCompanyDescription() };

            data.add(new Company(singleCompanyDataValue));
        }

        TableColumn numberCol = new TableColumn("#");
        numberCol.setMinWidth(20);
        numberCol.setCellValueFactory(new Callback<CellDataFeatures<Company, Company>, ObservableValue<Company>>() {
            @Override public ObservableValue<Company> call(CellDataFeatures<Company, Company> p) {
                return new ReadOnlyObjectWrapper(p.getValue());
            }
        });

        numberCol.setCellFactory(new Callback<TableColumn<Company, Company>, TableCell<Company, Company>>() {
            @Override public TableCell<Company, Company> call(TableColumn<Company, Company> param) {
                return new TableCell<Company, Company>() {
                    @Override protected void updateItem(Company item, boolean empty) {
                        super.updateItem(item, empty);

                        if (this.getTableRow() != null && item != null) {
                            setText(this.getTableRow().getIndex()+"");
                        } else {
                            setText("");
                        }
                    }
                };
            }
        });
        numberCol.setSortable(false);

        TableColumn globalRank = new TableColumn();
        globalRank.setText("Global Rank");
        globalRank.setCellValueFactory(new PropertyValueFactory("getCompanyRank"));
        globalRank.setSortable(false);

        TableColumn companyName = new TableColumn();
        companyName.setText("Company");
        companyName.setCellValueFactory(new PropertyValueFactory("getCompanyName"));
        companyName.setSortable(false);

        TableColumn companySales = new TableColumn();
        companySales.setText("Sales");
        companySales.setCellValueFactory(new PropertyValueFactory("getCompanySales"));
        companySales.setSortable(false);

        TableColumn companyProfits = new TableColumn();
        companyProfits.setText("Profits");
        companyProfits.setCellValueFactory(new PropertyValueFactory("getCompanyProfit"));
        companyProfits.setSortable(false);
        
        TableColumn companyAssets = new TableColumn();
        companyAssets.setText("Assets");
        companyAssets.setCellValueFactory(new PropertyValueFactory("getCompanyAssets"));
        companyAssets.setSortable(false);

        TableColumn companyMarketValue = new TableColumn();
        companyMarketValue.setText("Market Value");
        companyMarketValue.setCellValueFactory(new PropertyValueFactory("getCompanyMarketValue"));
        companyMarketValue.setSortable(false);
        
        TableColumn companyType = new TableColumn();
        companyType.setText("Type");
        companyType.setCellValueFactory(new PropertyValueFactory("getCompanyType"));
        companyType.setSortable(false);

        TableColumn companyDescription = new TableColumn();
        companyDescription.setText("Description");
        companyDescription.setMinWidth(3000);
        companyDescription.setCellValueFactory(new PropertyValueFactory("getCompanyDescription"));
        companyDescription.setSortable(false);

        final TableView tableView = new TableView();
        tableView.setItems(data);
        tableView.getColumns().addAll(numberCol, globalRank, companyName, companySales, companyProfits, companyAssets, companyMarketValue, companyType, companyDescription);

        
        // SETTING UP BUTTONS  
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().add(tableView);

        // Text Input filed
        TextField textField = new TextField();
        textField.setPromptText("Company Name...");

        ChoiceBox<String> choiceBox = new ChoiceBox();

        // Search button
        Button btnSearch = new Button("Search!");
        btnSearch.setOnMouseClicked((event) -> {
            try {
                companyDataList = CompanyList.linearStringSearch(textField.getText());
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spSearchButton = new StackPane();
        spSearchButton.getChildren().add(btnSearch);


        // Giving values to the number choice box
        if (companyDataList.isEmpty()) {
            choiceBox.getItems().addAll("0");
        } else {
            for (int j = 0; j < companyDataList.size(); j++) {
                choiceBox.getItems().addAll(String.valueOf(j));
            }
        }
        choiceBox.setValue("0");


        // View Individual Record Button
        Button btnInfo = new Button("View Info!");
        btnInfo.setOnMouseClicked((event) -> {
            IndividualRecordView individualRecord = new IndividualRecordView();
            Scene individualrecordScene;
            try {
                individualrecordScene = individualRecord.getScene(importedStage, companyDataList.get(Integer.parseInt(choiceBox.getValue())));
                importedStage.setScene(individualrecordScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spInfoButton = new StackPane();
        spInfoButton.getChildren().add(btnInfo);


        // Making the Go Back Button
        Button button = new Button("<< Go Back");
        button.setOnMouseClicked((event)->{
            Main.setOwnStage(importedStage);
        });
        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);


        // Vertical Wrapper
        VBox vbox = new VBox();
        VBox.setVgrow(spLineChart, Priority.ALWAYS);

        // Horizontal Wrapper #1
        Text sortSectionOne = new Text("Search Company Name: ");
        sortSectionOne.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        HBox hbox = new HBox(8);
        hbox.getChildren().addAll(sortSectionOne, textField, spSearchButton);
        hbox.setPadding(new Insets(25, 25, 25, 25));
        hbox.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #2
        Text sortSectionTwo = new Text("View Company Individual Record: ");
        sortSectionTwo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        HBox hbox2 = new HBox(8);
        hbox2.getChildren().addAll(sortSectionTwo, choiceBox, spInfoButton);
        hbox2.setPadding(new Insets(0, 25, 5, 25));
        hbox2.setAlignment(Pos.BASELINE_CENTER);

        // Horizontal Wrapper #3
        HBox hbox3 = new HBox(8);
        hbox3.getChildren().addAll(spButton);
        hbox3.setMargin(spButton, new Insets(0, 30, 0, 75));
        hbox3.setPadding(new Insets(5, 5, 5, 5));
        hbox3.setAlignment(Pos.BASELINE_RIGHT);
        
        // Adding the table and the horizontal boxes to the vertical box
        vbox.getChildren().addAll(spLineChart, hbox, hbox2, hbox3);
        return vbox;
    }
 

    /**
     * A method that sends the table search view scene back to the main 
     * stage in the Main.java
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
