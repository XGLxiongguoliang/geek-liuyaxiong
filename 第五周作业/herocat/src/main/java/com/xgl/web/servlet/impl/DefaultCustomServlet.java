package com.xgl.web.servlet.impl;

import com.xgl.web.servlet.HeroRequest;
import com.xgl.web.servlet.HeroResponse;
import com.xgl.web.servlet.HeroServlet;

/**
 * @Description 定义Servlet规范实现
 * @Author XGL
 * @Date 2023/3/22 17:02
 */
public class DefaultCustomServlet extends HeroServlet {
    @Override
    public void doGet(HeroRequest request, HeroResponse response) throws Exception {
        String uri = request.getUri();
        response.write("404 - no this servlet : " + (uri.contains("?") ? uri.substring(0, uri.lastIndexOf("?")) : uri));
    }

    @Override
    public void doPost(HeroRequest request, HeroResponse response) throws Exception {
        doGet(request, response);
    }
}
