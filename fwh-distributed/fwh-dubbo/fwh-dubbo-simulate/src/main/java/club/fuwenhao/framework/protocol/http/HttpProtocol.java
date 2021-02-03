package club.fuwenhao.framework.protocol.http;

import club.fuwenhao.framework.Invocation;
import club.fuwenhao.framework.Protocol;
import club.fuwenhao.framework.URL;

public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(),invocation);
    }
}
