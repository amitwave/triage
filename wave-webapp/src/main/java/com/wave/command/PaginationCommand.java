package com.wave.command;


import java.util.ArrayList;
import java.util.List;

public class PaginationCommand {

    private List<PageLink> pageLinks;
    private Integer currentPage;
    private String url;


    public List<PageLink> getPageLinks() {
        if(this.pageLinks == null) {
            pageLinks = new ArrayList<PageLink>();
        }
        return pageLinks;
    }

    public void setPageLinks(List<PageLink> pageLinks) {
        this.pageLinks = pageLinks;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
