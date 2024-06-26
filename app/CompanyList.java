package app;

import java.io.*;
import java.util.ArrayList;

/**
 * A Company List class that initializes the Arraylist of compnay objects from
 * the csv file and has the search and sort methods
 * @author: Kevin Basta
 */
public class CompanyList {
    private static ArrayList<Company> companyList = new ArrayList<Company>();

    /**
     * Constructor method for populating the arraylist from the csv
     *
     * @param fileToRead The name of the csv file to read the information from
     */
    public CompanyList(String fileToRead) throws IOException {
        BufferedReader japanLargestCompanies = new BufferedReader(new FileReader("src/app/" + fileToRead));
        String strCSVLineReader = "";
        String[] dataReader;

        while ((strCSVLineReader = japanLargestCompanies.readLine()) != null) {
            // Using regex to make sure the descriptions doesn't get split
            dataReader = strCSVLineReader.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            if (!dataReader[0].equals("Global Rank")) {
                companyList.add(new Company(dataReader));
            }
        }

        japanLargestCompanies.close();
    }

    /**
     * A search method that searches by the category of the company
     *
     * @param indexValue  The index of where the value is in the array
     * @param categoryName  The name of the category to search for
     * @return An arraylist containing all the companies that are of that category
     */
    public static ArrayList<Company> searchByCategory(int indexValue, String categoryName) {
        ArrayList<Company> newCategoryCompanyList = new ArrayList<Company>();
        String strElement;

        for (int i = 0; i < companyList.size(); i++) {
            strElement = companyList.get(i).getCompanyType();
            if (strElement.equals(categoryName)) {
                newCategoryCompanyList.add(companyList.get(i));
            }
        }

        return newCategoryCompanyList;
    }

    /**
     * A search method that searches by the company name
     *
     * @param strCompanyName  The name or part of the name of the company to search for
     * @return An arraylist containing all the companies that have that name
     */
    public static ArrayList<Company> linearStringSearch(String strCompanyName) {
        ArrayList<Company> newCompnayListForSearch = new ArrayList<Company>();
        String strElement;

        for (int i = 0; i < companyList.size(); i++) {
            strElement = companyList.get(i).getCompanyName();
            String[] splitedString = strElement.split(" ");

            if (strElement.equalsIgnoreCase(strCompanyName)) {
                newCompnayListForSearch.add(companyList.get(i));
            } else {
                for (int j = 0; j < splitedString.length; j++) {
                    if (strCompanyName.equalsIgnoreCase(splitedString[j])) {
                        newCompnayListForSearch.add(companyList.get(i));
                    }
                }
            }
        }

        if (newCompnayListForSearch.isEmpty()) {
            String[] notFound = {"1", "not found", "2", "3", "4", "5", "not found", "not found"};
            newCompnayListForSearch.add(new Company(notFound));
            return newCompnayListForSearch;
        } else {
            return newCompnayListForSearch;
        }
    }
    
    /**
     * A sort method that sorts for all the double variable values
     *
     * @param intArrayIndexValue  The index value of the variable to sort for
     * @return An array list that has the sorted array
     */
    public static ArrayList<Company> selectionSortDouble(int intArrayIndexValue) throws IOException {
        ArrayList<Company> newSortedCompanyList = companyList;
        int currentMinIndex;

        for (int i = 0; i < newSortedCompanyList.size(); i++) {
            currentMinIndex = i;

            // If it's not global rank, sort from largest to smallest
            if (intArrayIndexValue != 0) {
                for (int j = i + 1; j < newSortedCompanyList.size(); j++) {
                    if (newSortedCompanyList.get(j).getCompanyDblParameter(intArrayIndexValue) > newSortedCompanyList.get(currentMinIndex).getCompanyDblParameter(intArrayIndexValue)) {
                        currentMinIndex = j;
                    }
                }
            } else {
                for (int j = i + 1; j < newSortedCompanyList.size(); j++) {
                    if (newSortedCompanyList.get(j).getCompanyDblParameter(intArrayIndexValue) < newSortedCompanyList.get(currentMinIndex).getCompanyDblParameter(intArrayIndexValue)) {
                        currentMinIndex = j;
                    }
                }
            }

            if (i != currentMinIndex) {
                Company tempCompany = newSortedCompanyList.get(currentMinIndex);
                newSortedCompanyList.set(currentMinIndex, newSortedCompanyList.get(i));
                newSortedCompanyList.set(i, tempCompany);
            }
        }

        return newSortedCompanyList;
    }

    /**
     * A sort method that sorts for all the double variable values in a given array
     *
     * @param intArrayIndexValue  The index value of the variable to sort for
     * @param newArraylist  An array list to sort
     * @return An array list that has the sorted array
     */
    public static ArrayList<Company> selectionSortDoubleNewArray(int intArrayIndexValue, ArrayList<Company> newArraylist) throws IOException {
        ArrayList<Company> newSortedCompanyList = newArraylist;
        int currentMinIndex;

        for (int i = 0; i < newSortedCompanyList.size(); i++) {
            currentMinIndex = i;

            // If it's not global rank, sort from largest to smallest
            if (intArrayIndexValue != 0) {
                for (int j = i + 1; j < newSortedCompanyList.size(); j++) {
                    if (newSortedCompanyList.get(j).getCompanyDblParameter(intArrayIndexValue) > newSortedCompanyList.get(currentMinIndex).getCompanyDblParameter(intArrayIndexValue)) {
                        currentMinIndex = j;
                    }
                }
            } else {
                for (int j = i + 1; j < newSortedCompanyList.size(); j++) {
                    if (newSortedCompanyList.get(j).getCompanyDblParameter(intArrayIndexValue) < newSortedCompanyList.get(currentMinIndex).getCompanyDblParameter(intArrayIndexValue)) {
                        currentMinIndex = j;
                    }
                }
            }

            if (i != currentMinIndex) {
                Company tempCompany = newSortedCompanyList.get(currentMinIndex);
                newSortedCompanyList.set(currentMinIndex, newSortedCompanyList.get(i));
                newSortedCompanyList.set(i, tempCompany);
            }
        }

        return newSortedCompanyList;
    }

    /**
     * A sort method that sorts for all the string name values
     *
     * @return An array list that has the sorted array
     */
    public static ArrayList<Company> selectionSortString() {
        ArrayList<Company> newSortedCompanyList = companyList;

        for (int j = 0; j < newSortedCompanyList.size() - 1; j++) {
            int min = j;
            for (int k = j + 1; k < newSortedCompanyList.size(); k++) {
                if (newSortedCompanyList.get(k).getCompanyName().compareTo(newSortedCompanyList.get(min).getCompanyName()) < 0) {
                    min = k;
                }  
            }
            
            // Swap the reference at j with the reference at min 
            Company temp = newSortedCompanyList.get(j);
            newSortedCompanyList.set(j, newSortedCompanyList.get(min));
            newSortedCompanyList.set(min, temp);
        }

        return newSortedCompanyList;
    }

    /**
     * A method that calculates statistics about the data set
     *
     * @return An array that has all the summary data
     */
    public static String[] getDataSummary() {
        String[] finalSummaryData = new String[6];
        Double dblAverageSales = 0.0;
        Double dblAverageProfit = 0.0;
        Double dblAverageAssets = 0.0;
        Double dblAverageMarketValue = 0.0;
        Double dblMaxProfit = 0.0;
        Double dblMinprofit = 0.0;

        for (int i = 0; i < companyList.size(); i++) {
            dblAverageSales += companyList.get(i).getCompanySales();
            dblAverageProfit += companyList.get(i).getCompanyProfit();
            dblAverageAssets += companyList.get(i).getCompanyAssets();
            dblAverageMarketValue += companyList.get(i).getCompanyMarketValue();

            if (companyList.get(i).getCompanyProfit() > dblMaxProfit) {
                dblMaxProfit = companyList.get(i).getCompanyProfit();
            }

            if (companyList.get(i).getCompanyProfit() < dblMinprofit) {
                dblMinprofit = companyList.get(i).getCompanyProfit();
            }
        }

        dblAverageSales = Math.round((dblAverageSales / companyList.size() + 1) * 100.0) / 100.0;
        dblAverageProfit = Math.round((dblAverageProfit / companyList.size() + 1) * 100.0) / 100.0;
        dblAverageAssets = Math.round((dblAverageAssets / companyList.size() + 1) * 100.0) / 100.0;
        dblAverageMarketValue = Math.round((dblAverageMarketValue / companyList.size() + 1) * 100.0) / 100.0;

        finalSummaryData[0] = String.valueOf(dblAverageSales);
        finalSummaryData[1] = String.valueOf(dblAverageProfit);
        finalSummaryData[2] = String.valueOf(dblAverageAssets);
        finalSummaryData[3] = String.valueOf(dblAverageMarketValue);
        finalSummaryData[4] = String.valueOf(dblMaxProfit);
        finalSummaryData[5] = String.valueOf(dblMinprofit);

        return finalSummaryData;
    }

    /**
     * A getter method that returns the initialized companyList array
     *
     * @return An array list that has all the companies from the csv file
     */
    public static ArrayList<Company> getArrayList() {
        return companyList;
    }

}
