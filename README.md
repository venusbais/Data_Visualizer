
# Java Data Interaction and Visualization
This is a Java object-oriented project with a user interface and data visualization using JavaFX

## Description 
* CompnayList.java reads the CSV file and creates a Company object for each company and appends it to the compnayList ArrayList 
* Encapsulation is used by having each Company object's data be stored in private variables with getter methods to access that data
* JavaFX is used to create a bar graph, bubble graph, pie chart, and a searchable table. It is also used to create other UI pages such as the homepage, data summary, and individual record viewer
* Linear search is used for finding each instance of a certain type of company (e.g. bank) so that they can be grouped for the graphs and displayed for the search by category
* Linear string search is used for finding if a word or term searched is in a company's name. This is used for the company search
* Selection Sort is used to sort values ascendingly or descendingly for the company search by category


## Dataset
* The dataset I chose has information about 247 of the largest companies in Japan.
* The original categories included are global rank, company name, sales, profits, assets, and market value
* I added two extra categories to the dataset. Those being the type of company and the company description. The company types allow for better sorting and the company description provides a more enhanced individual company view
* [Here is a link to the original dataset](https://data.world/finance/japan-largest-companies)

##Running application 
![image](https://github.com/venusbais/Data_Visualizer/assets/78401777/8dce4600-9ec5-4fe6-8742-c3c4cb9190c5)

