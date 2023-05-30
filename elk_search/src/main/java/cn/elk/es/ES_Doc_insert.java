package cn.elk.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;

import java.io.IOException;


/**
 * @author chenchao
 * @Data 2023/5/30 9:43
 **/
public class ES_Doc_insert {
    public static void main(String[] args) throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient esclient = new RestHighLevelClient(builder);
        /**
         * 插入文档
         */
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user").id("102");
        User user = new User();
        user.setUsername("lwq2");
        user.setAge(12);
        user.setSex("nan1");
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        indexRequest.source(userJson, XContentType.JSON);
        IndexResponse response = esclient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("response.getResult() = " + response.getResult());

        esclient.close();
    }
}
