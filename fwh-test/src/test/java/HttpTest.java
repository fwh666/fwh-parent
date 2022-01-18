import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: fwh-parent
 * @description:
 * @author: fwh
 * @date: 2022-01-17 12:28
 **/
public class HttpTest {
    @Test
    public void doGet() {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
//        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        RequestConfig requestConfig = RequestConfig.custom()
                //返回数据的超时时间
                .setSocketTimeout(1000)
                //连接上服务器的超时时间
                .setConnectTimeout(1000)
                .build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
//            System.out.println(response.getStatusLine());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("内容长度：" + content.length());
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
