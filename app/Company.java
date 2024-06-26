package app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A Company class that defines paramiters for Company objects.
 * @author: Kevin Basta
 */
public class Company {
    
    private String strCompanyName;
    private String strTypeOfCompany;
    private String strCompanyDescription;

    private int intGlobalRank;
    private Double dblCompanySales;
    private Double dblCompanyProfits;
    private Double dblCompanyAssets; 
    private Double dblCompanyMarketValue;

    /**
     * Constructor method for the Compnay class.
     *
     * @param newCompanyData  An array containing all the values from the csv file.
     */
    public Company(String[] newCompanyData) {
        this.intGlobalRank = Integer.parseInt(newCompanyData[0]);
        this.strCompanyName = newCompanyData[1];
        this.dblCompanySales = Double.parseDouble(newCompanyData[2]);
        this.dblCompanyProfits = Double.parseDouble(newCompanyData[3]);
        this.dblCompanyAssets = Double.parseDouble(newCompanyData[4]);
        this.dblCompanyMarketValue = Double.parseDouble(newCompanyData[5]);
        this.strTypeOfCompany = newCompanyData[6];
        this.strCompanyDescription = newCompanyData[7];
    }


    /**
     * Getter method for the object's company name
     *
     * @return This object's company name
     */
    public String getCompanyName() {
        return this.strCompanyName;
    }

    /**
     * Getter method for the object's company type
     *
     * @return This object's company type
     */
    public String getCompanyType() { 
        return this.strTypeOfCompany;
    }

    /**
     * Getter method for the object's company Description
     *
     * @return This object's company Description
     */
    public String getCompanyDescription() {
        return this.strCompanyDescription;
    }

    /**
     * Getter method for the object's company rank
     *
     * @return This object's company rank
     */
    public int getCompanyRank() {
        return this.intGlobalRank;
    }

    /**
     * Getter method for the object's company sales
     *
     * @return This object's company sales
     */
    public double getCompanySales() {
        return this.dblCompanySales;
    }

    /**
     * Getter method for the object's company profit
     *
     * @return This object's company profit
     */
    public double getCompanyProfit() {
        return this.dblCompanyProfits;
    }

    /**
     * Getter method for the object's company assets
     *
     * @return This object's company assets
     */
    public double getCompanyAssets() {
        return this.dblCompanyAssets;
    }

    /**
     * Getter method for the object's company market value
     *
     * @return This object's company market value
     */
    public double getCompanyMarketValue() {
        return this.dblCompanyMarketValue;
    }




    /**
     * Getter method for the object's company name for cell view
     *
     * @return This object's company name as a simple string
     */
    public StringProperty getCompanyNameProperty() {
        return new SimpleStringProperty(this.strCompanyName);
    }

    /**
     * Getter method for the object's company type for cell view
     *
     * @return This object's company type as a simple string
     */
    public StringProperty getCompanyTypeProperty() { 
        return new SimpleStringProperty(this.strTypeOfCompany);
    }

    /**
     * Getter method for the object's company description for cell view
     *
     * @return This object's company description as a simple string
     */
    public StringProperty getCompanyDescriptionProperty() {
        return new SimpleStringProperty(this.strCompanyDescription);
    }

    /**
     * Getter method for the object's company rank for cell view
     *
     * @return This object's company rank as a simple string
     */
    public StringProperty getCompanyRankProperty() {
        return new SimpleStringProperty(String.valueOf(this.intGlobalRank));
    }

    /**
     * Getter method for the object's company sales for cell view
     *
     * @return This object's company sales as a simple string
     */
    public StringProperty getCompanySalesProperty() {
        return new SimpleStringProperty(String.valueOf(this.dblCompanySales));
    }

    /**
     * Getter method for the object's company profit for cell view
     *
     * @return This object's company profit as a simple string
     */
    public StringProperty getCompanyProfitProperty() {
        return new SimpleStringProperty(String.valueOf(this.dblCompanyProfits));
    }

    /**
     * Getter method for the object's company assets for cell view
     *
     * @return This object's company assets as a simple string
     */
    public StringProperty getCompanyAssetsProperty() {
        return new SimpleStringProperty(String.valueOf(this.dblCompanyAssets));
    }

    /**
     * Getter method for the object's company market value for cell view
     *
     * @return This object's company market value as a simple string
     */
    public StringProperty getCompanyMarketValueProperty() {
        return new SimpleStringProperty(String.valueOf(this.dblCompanyMarketValue));
    }




    /**
     * Getter method for the DOUBLE Search and Sort index Value
     *
     * @param intIndex  the index value specifying which value to return
     * @return the value spesified by the index parameter
     */
    public Double getCompanyDblParameter(int intIndex) {
        if (intIndex == 0) {
            return Double.parseDouble(String.valueOf(this.intGlobalRank));
        } else if (intIndex == 2) {
            return this.dblCompanySales;
        } else if (intIndex == 3) {
            return this.dblCompanyProfits;
        } else if (intIndex == 4) {
            return this.dblCompanyAssets;
        } else if (intIndex == 5) {
            return this.dblCompanyMarketValue;
        } else {
            return null;
        }
    }

    /**
     * Getter method for the STRING Search and Sort index Value
     *
     * @param intIndex  the index value specifying which value to return
     * @return the value spesified by the index parameter
     */
    public String getCompanyStrParameter(int intIndex) {
        if (intIndex == 1) {
            return this.strCompanyName;
        } else if (intIndex == 6) {
            return this.strTypeOfCompany;
        } else if (intIndex == 7) {
            return this.strCompanyDescription;
        } else {
            return null;
        }
    }

}
