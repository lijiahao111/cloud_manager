package cn.elk.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author chenchao
 * @Data 2023/5/30 9:30
 **/
public class EsTest {
    public static void main(String[] args) throws IOException {

        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient client = new RestHighLevelClient(builder);


        client.close();
    }
}
