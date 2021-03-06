package com.ivan.tableEditor.tableEditorView.workingArea;

import com.ivan.tableEditor.tableEditorModel.Student;
        import com.ivan.tableEditor.tableEditorModel.TableModel;

        import java.util.List;

/**
 * Created by Ivan on 11.04.2017.
 */
public class WorkingAreaManager implements WorkingAreaListener {
    private TableModel tableModel;
    public WorkingAreaManager(TableModel tableModel){
        this.tableModel = tableModel;
    }
    @Override
    public void validateWorkingArea(WorkingArea workingArea) {
        List<Student> page;
        page = tableModel.getPage(workingArea.getCurrentPage(),workingArea.getAmmountOfRecords());
        if(tableModel.getTableData() != null) workingArea.setAmmountOfPages(tableModel.getTableData().size());
        workingArea.getWorkingAreaPanel().drawPage(page);
        workingArea.getWorkingAreaPanel().requestFocus();
    }
}
