package com.xgl.web.servlet.impl;

import com.xgl.web.servlet.HeroResponse;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

/**
 * @Description Servlet规范之响应规范实现
 * @Author XGL
 * @Date 2023/3/22 17:02
 */
public class HttpCustomResponse implements HeroResponse {

    private HttpRequest request;
    private ChannelHandlerContext context;

    public HttpCustomResponse(HttpRequest request, ChannelHandlerContext context) {
        this.request = request;
        this.context = context;
    }

    @Override
    public void write(String content) throws Exception {
        //处理context为空
        if (content == null) {
            return;
        }

        //创建响应对象
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(content.getBytes("UTF-8")));

        //获取响应头
        HttpHeaders headers = response.headers();
        //设置响应体类型
        headers.set(HttpHeaderNames.CONTENT_TYPE, "text/json");
        //设置响应体长度
        headers.set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        //设置缓存过期时间
        headers.set(HttpHeaderNames.EXPIRES, 0);
        //如果HTTP请求是长连接，则响应也使用长连接
        if (HttpUtil.isKeepAlive(request)) {
            headers.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        }
        //将数据写到channel - 访问地址能返回值
        context.writeAndFlush(response);

        //将数据写到channel - 访问地址不能返回值
        context.write(response);
    }
}
