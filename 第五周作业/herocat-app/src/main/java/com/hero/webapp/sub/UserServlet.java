package com.hero.webapp.sub;

import com.xgl.web.servlet.HeroRequest;
import com.xgl.web.servlet.HeroResponse;
import com.xgl.web.servlet.HeroServlet;

/**
 * 业务Servlet-Demo
 */
public class UserServlet extends HeroServlet {
    @Override
    public void doGet(HeroRequest request, HeroResponse response) throws Exception {
        String uri = request.getUri();
        String path = request.getPath();
        String method = request.getMethod();
        String name = request.getParameter("name");

        String content = "uri = " + uri + "\n" +
                         "path = " + path + "\n" +
                         "method = " + method + "\n" +
                         "param = " + name;
        response.write(content);
    }

    @Override
    public void doPost(HeroRequest request, HeroResponse response) throws Exception {
        doGet(request, response);
    }
}
