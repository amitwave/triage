package com.wave.controller.utils;

import com.wave.user.dao.UserData;

import javax.servlet.http.Cookie;


public class CookieUtils {

    public static Long getUserIdFromCookie(String cookie) {
        String[] cookieKeyVal = cookie.split("=");
        Long userId = null;
        if("USER_ID".equals(cookieKeyVal[0])) {
            userId = Long.parseLong(cookieKeyVal[1]);
        }
        return userId;
    }

    public static Cookie getCookie(UserData userData) {
        return new Cookie("TRIAGE", "USER_ID="+userData.getUserId());
    }
}
