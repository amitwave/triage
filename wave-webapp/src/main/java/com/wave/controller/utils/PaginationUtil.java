package com.wave.controller.utils;

import com.wave.command.PageLink;
import com.wave.command.PaginationCommand;

/**
 * Created by amit on 13/04/2015.
 */
public class PaginationUtil {
    public static PaginationCommand getPaginationCommand(Integer page, Long count, Integer pageSize) {
        PaginationCommand paginationCommand = new PaginationCommand();
        paginationCommand.setCurrentPage(page);

        Long pages = 0l;
        if(pageSize > count) {
            pages = 1l;
        }else if(count % pageSize == 0){
            pages = count / pageSize;
        }else if(count % pageSize > 0){
            pages = (count / pageSize) + 1;
        }

        for (Long i = 1l; i <= pages; i++) {
            PageLink pageLink = new PageLink();
            pageLink.setPage(i);
            paginationCommand.getPageLinks().add(pageLink);
        }

        return paginationCommand;
    }
}
