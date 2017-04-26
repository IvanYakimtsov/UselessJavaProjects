import java.util.List;

/**
 * Created by Ivan on 11.04.2017.
 */
public class WorkingAreaManager implements WorkingAreaListener {
    private PageSwapper pageSwapper;
    public WorkingAreaManager(PageSwapper pageSwapper){
        this.pageSwapper = pageSwapper;
    }
    public void validateWorkingArea(WorkingArea workingArea) {
        List<Student> page;
        page = pageSwapper.getPage(workingArea.getCurrentPage(),workingArea.getAmmountOfRecords());
        workingArea.setAmmountOfPages(pageSwapper.getAmountOfRecords());
        workingArea.getWorkingAreaPanel().drawPage(page);
        workingArea.getWorkingAreaPanel().requestFocus();
    }
}
