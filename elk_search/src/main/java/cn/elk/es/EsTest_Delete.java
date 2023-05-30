package cn.elk.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author chenchao
 * @Data 2023/5/30 9:35
 **/
public class EsTest_Delete {

    public static void main(String[] args) throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient esclient = new RestHighLevelClient(builder);

        DeleteIndexRequest request = new DeleteIndexRequest("lwq");
        AcknowledgedResponse delete = esclient.indices().delete(request, RequestOptions.DEFAULT);
        boolean ackStatus = delete.isAcknowledged();
        System.out.println("索引操作"+ackStatus);

        esclient.close();
    }
}
