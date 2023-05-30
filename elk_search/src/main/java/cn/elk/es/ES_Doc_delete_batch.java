package cn.elk.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
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
public class ES_Doc_delete_batch {
    public static void main(String[] args) throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient esclient = new RestHighLevelClient(builder);
        /**
         * 批量插入文档
         */
        BulkRequest bulkRequest = new BulkRequest();
        DeleteRequest source1 = new DeleteRequest().index("user").id("201");
        DeleteRequest source2 = new DeleteRequest().index("user").id("202");
        bulkRequest.add(source1);
        bulkRequest.add(source2);
        BulkResponse bulk = esclient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("bulk.getTook() = " + bulk.getTook());
        System.out.println("bulk.getItems() = " + bulk.getItems());
        esclient.close();
    }
}
