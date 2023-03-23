package com.xgl.web.servlet.impl;

import com.xgl.web.servlet.HeroRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

/**
 * @Description Servlet规范之请求规范实现
 * @Author XGL
 * @Date 2023/3/22 17:01
 */
public class HttpCustomRequest implements HeroRequest {
    private HttpRequest request;

    public HttpCustomRequest(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String getUri() {
        return request.uri();
    }

    @Override
    public String getPath() {
        return new QueryStringDecoder(request.uri()).path();
    }

    @Override
    public String getMethod() {
        return request.method().name();
    }

    @Override
    public Map<String, List<String>> getParameters() {
        return new QueryStringDecoder(request.uri()).parameters();
    }

    @Override
    public List<String> getParameters(String name) {
        return getParameters().get(name);
    }

    @Override
    public String getParameter(String name) {
        List<String> parameters = getParameters(name);
        if (parameters == null || parameters.size() == 0) {
            return null;
        }

        return parameters.get(0);
    }
}
