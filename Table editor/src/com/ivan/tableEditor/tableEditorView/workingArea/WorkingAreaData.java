package com.ivan.tableEditor.tableEditorView.workingArea;


import java.util.List;

/**
 * Created by Ivan on 11.04.2017.
 */
public class WorkingAreaData {
    private int currentPage;
    private int ammountOfPages;
    private int ammountOfRecords;
    private int examsAmmount;

    WorkingAreaData() {
        examsAmmount = 5;
        ammountOfPages = 1;
        ammountOfRecords = 5;
        currentPage = 1;
    }


    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setAmmountOfPages(int ammountOfPages) {
        this.ammountOfPages = ammountOfPages;
    }

    public void setAmmountOfRecords(int ammountOfRecords) {
        this.ammountOfRecords = ammountOfRecords;
        if (ammountOfRecords <= 0) this.ammountOfRecords = 1;
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public int getAmmountOfPages() {
        return ammountOfPages;
    }

    public int getAmmountOfRecords() {
        return ammountOfRecords;
    }


    public int getExamsAmmount() {
        return examsAmmount;
    }
}
