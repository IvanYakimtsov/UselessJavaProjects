package view;

import connectionController.ConnectionManager;
import dataModel.Student;

import java.util.List;

/**
 * Created by Ivan on 25.04.2017.
 */
public class SearchResultData implements PageSwapper {
    ConnectionManager connectionManager;
    String typeOfSearch;
   SearchResultData(ConnectionManager connectionManager,String typeOfSearch){
       this.connectionManager = connectionManager;
       this.typeOfSearch = typeOfSearch;
   }

    public List<Student> getPage(int pageNumber, int amountOfRecords) {
       return connectionManager.getSearchResultPage(pageNumber,amountOfRecords,typeOfSearch);
    }


    public int getAmountOfRecords() {
        int amount = connectionManager.getSearchSize(typeOfSearch);
        return amount;
    }


}
