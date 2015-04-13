package com.wave.controller.utils;

import com.wave.command.PageLink;
import com.wave.command.PaginationCommand;

/**
 * Created by amit on 13/04/2015.
 */
public class PaginationUtil {
    public static PaginationCommand getPaginationCommand(Integer page, Long allReferralsCountByStatus) {
        PaginationCommand paginationCommand = new PaginationCommand();
        paginationCommand.setCurrentPage(page);

        for (Long i = 1l; i <= allReferralsCountByStatus; i++) {
            PageLink pageLink = new PageLink();
            pageLink.setPage(i);
            paginationCommand.getPageLinks().add(pageLink);
        }

        return paginationCommand;
    }
}
