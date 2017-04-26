import java.util.List;

/**
 * Created by Ivan on 25.04.2017.
 */
public interface PageSwapper {
    public List<Student> getPage(int currentPage, int ammountOfRecords);
    public int getAmountOfRecords();
}
