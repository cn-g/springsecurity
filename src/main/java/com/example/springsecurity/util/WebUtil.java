package com.example.springsecurity.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 客户端相关操作
 * 
 * @author xu
 */
public class WebUtil {

    /**
     * 将字符串渲染到客户端
     * 
     * @param response
     * @param str
     * @return
     */
    public static void renderString(HttpServletResponse response, String str) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
