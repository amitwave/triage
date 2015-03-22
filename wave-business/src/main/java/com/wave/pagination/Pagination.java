package com.wave.pagination;

public class Pagination {


    private int totalRecords;
    private int totalNoOfPages;
    public static final int numberOfRecordsPerPage = 5;

    public static int calculatePageCount(int totalRecords) {
        int totalNoOfPages = totalRecords / Pagination.numberOfRecordsPerPage;
        if (totalRecords > totalNoOfPages * 5) {
            totalNoOfPages++;
        }
        return totalNoOfPages;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalNoOfPages() {
        return totalNoOfPages;
    }

    public void setTotalNoOfPages(int totalNoOfPages) {
        this.totalNoOfPages = totalNoOfPages;
    }

    public static int getNumberOfRecordsPerPage() {
        return numberOfRecordsPerPage;
    }
}
