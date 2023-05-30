package cn.elk.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;


/**
 * @author chenchao
 * @Data 2023/5/30 9:43
 **/
public class ES_Doc_delete {
    public static void main(String[] args) throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient esclient = new RestHighLevelClient(builder);

        DeleteRequest request = new DeleteRequest();

        request.index("user").id("101");
        DeleteResponse delete = esclient.delete(request, RequestOptions.DEFAULT);
        System.out.println("delete = " + delete);

        esclient.close();
    }
}
