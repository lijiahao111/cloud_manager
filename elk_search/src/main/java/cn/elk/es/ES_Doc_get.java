package cn.elk.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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
public class ES_Doc_get {
    public static void main(String[] args) throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient esclient = new RestHighLevelClient(builder);

        GetRequest request = new GetRequest();
        request.index("user").id("101");
        GetResponse documentFields = esclient.get(request, RequestOptions.DEFAULT);
        String sourceAsString = documentFields.getSourceAsString();
        System.out.println("sourceAsString = " + sourceAsString);

        esclient.close();
    }
}
