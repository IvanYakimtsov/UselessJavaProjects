import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 25.04.2017.
 */
public class SearchResultData implements PageSwapper {
    List<Student> searchResult = new ArrayList<Student>();

    public List<Student> getPage(int pageNumber, int amountOfRecords) {
        List<Student> page = new ArrayList<Student>();
        int firstRecordIndex = (pageNumber-1)*amountOfRecords;
        for (int index = firstRecordIndex; index < firstRecordIndex + amountOfRecords; index++){
            if(index>searchResult.size() - 1) break;
            page.add(searchResult.get(index));
        }

        return page;
    }


    public int getAmountOfRecords() {
        return searchResult.size();
    }

    public void setTableData(List<Student> searchResult){
        this.searchResult = searchResult;
    }
}
