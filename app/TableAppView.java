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

/**
 * A table showing all the data with buttons to filter and sort 
 * the data in different ways
 * @author: Kevin Basta
 */
public class TableAppView extends Application {
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
            setSelectedData(-1);
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
        tableView.getColumns().addAll(globalRank, companyName, companySales, companyProfits, companyAssets, companyMarketValue, companyType, companyDescription);


        // SETTING UP BUTTONS  
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().add(tableView);

        // RANK SORT
        Button btnRank = new Button("Rank");
        btnRank.setOnMouseClicked((event) -> {
            try {
                setSelectedData(0);
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spRankButton = new StackPane();
        spRankButton.getChildren().add(btnRank);

        // NAME SORT
        Button btnName = new Button("Name");
        btnName.setOnMouseClicked((event) -> {
            try {
                companyDataList = CompanyList.selectionSortString();
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spNameButton = new StackPane();
        spNameButton.getChildren().add(btnName);

        // SALES SORT
        Button btnSales = new Button("Sales");
        btnSales.setOnMouseClicked((event) -> {
            try {
                setSelectedData(2);
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spSalesButton = new StackPane();
        spSalesButton.getChildren().add(btnSales);

        // PROFITS SORT
        Button btnProfits = new Button("Profits");
        btnProfits.setOnMouseClicked((event) -> {
            try {
                setSelectedData(3);
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spProfitsButton = new StackPane();
        spProfitsButton.getChildren().add(btnProfits);

        // ASSETS SORT
        Button btnAssets = new Button("Assets");
        btnAssets.setOnMouseClicked((event) -> {
            try {
                setSelectedData(4);
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spAssetsButton = new StackPane();
        spAssetsButton.getChildren().add(btnAssets);

        // MARTKET VALUE SORT
        Button btnMarketValue = new Button("Market Value");
        btnMarketValue.setOnMouseClicked((event) -> {
            try {
                setSelectedData(5);
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spMarketValueButton = new StackPane();
        spMarketValueButton.getChildren().add(btnMarketValue);

        // MAIN MENUE
        Button button = new Button("<< Go Back");
        button.setOnMouseClicked((event)->{
            Main.setOwnStage(importedStage);
        });
        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);

        // CARS CATAGORY SORT
        Button btnCars = new Button("Cars");
        btnCars.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Cars");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spCarsButton = new StackPane();
        spCarsButton.getChildren().add(btnCars);

        // BANK CATAGORY SORT
        Button btnBank = new Button("Bank");
        btnBank.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Bank");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spBankButton = new StackPane();
        spBankButton.getChildren().add(btnBank);

        // UTILITY CATAGORY SORT
        Button btnUtility = new Button("Utility");
        btnUtility.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Utility");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spUtilityButton = new StackPane();
        spUtilityButton.getChildren().add(btnUtility);

        // Conglomerate CATAGORY SORT
        Button btnConglomerate = new Button("Conglomerate");
        btnConglomerate.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Conglomerate");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spConglomerateButton = new StackPane();
        spConglomerateButton.getChildren().add(btnConglomerate);

        // Trade CATAGORY SORT
        Button btnTrade = new Button("Trade");
        btnTrade.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Trade");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spTrade = new StackPane();
        spTrade.getChildren().add(btnTrade);

        // Technology CATAGORY SORT
        Button btnTechnology = new Button("Technology");
        btnTechnology.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Technology");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spTechnology = new StackPane();
        spTechnology.getChildren().add(btnTechnology);

        // Retail CATAGORY SORT
        Button btnRetail = new Button("Retail");
        btnRetail.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Retail");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spRetail = new StackPane();
        spRetail.getChildren().add(btnRetail);

        // Manufacture CATAGORY SORT
        Button btnManufacture = new Button("Manufacture");
        btnManufacture.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Manufacture");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spManufacture = new StackPane();
        spManufacture.getChildren().add(btnManufacture);

        // Pharmacy CATAGORY SORT
        Button btnPharmacy = new Button("Pharmacy");
        btnPharmacy.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Pharmacy");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spPharmacy = new StackPane();
        spPharmacy.getChildren().add(btnPharmacy);

        // Real Estate CATAGORY SORT
        Button btnRealEstate = new Button("Real Estate");
        btnRealEstate.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Real Estate");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spRealEstate = new StackPane();
        spRealEstate.getChildren().add(btnRealEstate);
        
        // Insurance CATAGORY SORT
        Button btnInsurance = new Button("Insurance");
        btnInsurance.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Insurance");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spInsurance = new StackPane();
        spInsurance.getChildren().add(btnInsurance);
        
        // Entertainment CATAGORY SORT
        Button btnEntertainment = new Button("Entertainment");
        btnEntertainment.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Entertainment");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spEntertainment = new StackPane();
        spEntertainment.getChildren().add(btnEntertainment);
        
        // Construction CATAGORY SORT
        Button btnConstruction = new Button("Construction");
        btnConstruction.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Construction");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spConstruction = new StackPane();
        spConstruction.getChildren().add(btnEntertainment);
        
        // Media CATAGORY SORT
        Button btnMedia = new Button("Media");
        btnMedia.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Media");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spMedia = new StackPane();
        spMedia.getChildren().add(btnMedia);
        
        // Convenience CATAGORY SORT
        Button btnConvenience = new Button("Convenience");
        btnConvenience.setOnMouseClicked((event) -> {
            try {
                setSelectedStringCatagory("Convenience ");
                Main.setOwnScene(importedStage, new Scene(createContent(), 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        StackPane spConvenience = new StackPane();
        spConvenience.getChildren().add(btnConvenience);
      

        // Vertical Wrapper
        VBox vbox = new VBox();
        VBox.setVgrow(spLineChart, Priority.ALWAYS);
        
        // Horizontal Wrapper #1
        Text sortSectionOne = new Text("Sort By Value: ");
        sortSectionOne.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox hbox = new HBox(8);
        hbox.getChildren().addAll(sortSectionOne, spRankButton, spNameButton, spSalesButton, spProfitsButton, spAssetsButton, spMarketValueButton);
        hbox.setPadding(new Insets(25, 190, 25, 25));
        hbox.setAlignment(Pos.BASELINE_CENTER);
        
        // Horizontal Wrapper #2
        Text sortSectionTwo = new Text("Filter By Catagory: ");
        sortSectionTwo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        HBox hbox2 = new HBox(8);
        hbox2.getChildren().addAll(sortSectionTwo, spCarsButton, spBankButton, spUtilityButton, spConglomerateButton, spTrade, spTechnology, spRetail);
        hbox2.setPadding(new Insets(0, 25, 5, 25));
        hbox2.setAlignment(Pos.BASELINE_CENTER);
        
        // Horizontal Wrapper #3
        HBox hbox3 = new HBox(8);
        hbox3.getChildren().addAll(spManufacture, spPharmacy ,spRealEstate, spInsurance, spEntertainment, spConstruction, spMedia, spConvenience);
        hbox3.setPadding(new Insets(0, 25, 25, 25));
        hbox3.setAlignment(Pos.BASELINE_CENTER);
        
        // Horizontal Wrapper #4
        HBox hbox4 = new HBox(8);
        hbox4.getChildren().addAll(spButton);
        hbox4.setMargin(spButton, new Insets(0, 30, 0, 75));
        hbox4.setPadding(new Insets(5, 5, 5, 5));
        hbox4.setAlignment(Pos.BASELINE_RIGHT);
        
        // Adding the table and the horizontal boxes to the vertical box
        vbox.getChildren().addAll(spLineChart, hbox, hbox2, hbox3, hbox4);
        return vbox;
    }

    
    /**
     * A method that gets the catagory and sets the companyDataList
     * to the array that was filtered in the CompanyList class
     * 
     * @param strCatagory  The catagory to search the data set for
     */
    private void setSelectedStringCatagory(String strCatagory) throws IOException {
        if (strCatagory == "Cars") {
            companyDataList = CompanyList.searchByCategory(6, "Cars");
        } else if (strCatagory == "Bank") {
            companyDataList = CompanyList.searchByCategory(6, "Bank");
        } else if (strCatagory == "Utility") {
            companyDataList = CompanyList.searchByCategory(6, "Utility");
        } else if (strCatagory == "Conglomerate") {
            companyDataList = CompanyList.searchByCategory(6, "Conglomerate");
        } else if (strCatagory == "Trade") {
            companyDataList = CompanyList.searchByCategory(6, "Trade");
        } else if (strCatagory == "Technology") {
            companyDataList = CompanyList.searchByCategory(6, "Technology");
        } else if (strCatagory == "Food and drink") {
            companyDataList = CompanyList.searchByCategory(6, "Food and drink");
        } else if (strCatagory == "Transport") {
            companyDataList = CompanyList.searchByCategory(6, "Transport");
        } else if (strCatagory == "Retail") {
            companyDataList = CompanyList.searchByCategory(6, "Retail");
        } else if (strCatagory == "Pharmacy") {
            companyDataList = CompanyList.searchByCategory(6, "Pharmacy");
        } else if (strCatagory == "Manufacture") {
            companyDataList = CompanyList.searchByCategory(6, "Manufacture");
        } else if (strCatagory == "Real Estate") {
            companyDataList = CompanyList.searchByCategory(6, "Real Estate");
        } else if (strCatagory == "Insurance") {
            companyDataList = CompanyList.searchByCategory(6, "Insurance");
        } else if (strCatagory == "Entertainment") {
            companyDataList = CompanyList.searchByCategory(6, "Entertainment");
        } else if (strCatagory == "Construction") {
            companyDataList = CompanyList.searchByCategory(6, "Construction");
        } else if (strCatagory == "Media") {
            companyDataList = CompanyList.searchByCategory(6, "Media");
        } else if (strCatagory == "Convenience ") {
            companyDataList = CompanyList.searchByCategory(6, "Convenience ");
        } else {
            companyDataList = CompanyList.getArrayList();
        }
    }


    /**
     * A method that calls a sort method in the CompanyList class
     * 
     * @param intIndex  The index number of which value to sort for
     */
    private void setSelectedData(int intIndex) throws IOException {
        if (intIndex == 0 || intIndex == 2 || intIndex == 3 || intIndex == 4 || intIndex == 5) {
            companyDataList = CompanyList.selectionSortDouble(intIndex);
        } else {
            companyDataList = CompanyList.getArrayList();
        }
    }
 

    /**
     * A method that sends the table view scene back to the main 
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