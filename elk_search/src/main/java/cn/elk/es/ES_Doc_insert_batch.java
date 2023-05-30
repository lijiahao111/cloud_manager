package cn.elk.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
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
public class ES_Doc_insert_batch {
    public static void main(String[] args) throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient esclient = new RestHighLevelClient(builder);
        /**
         * 批量插入文档
         */
        BulkRequest bulkRequest = new BulkRequest();
        IndexRequest source1 = new IndexRequest().index("user").id("201").source(XContentType.JSON, "username", "zhangsan1","age",20,"sex","nan");
        IndexRequest source2 = new IndexRequest().index("user").id("202").source(XContentType.JSON, "username", "zhangsan2","age",21,"sex","nan1");
        IndexRequest source3 = new IndexRequest().index("user").id("203").source(XContentType.JSON, "username", "zhangsan3","age",22,"sex","nan2");
        IndexRequest source4 = new IndexRequest().index("user").id("204").source(XContentType.JSON, "username", "zhangsan4","age",23,"sex","nan3");
        IndexRequest source5 = new IndexRequest().index("user").id("205").source(XContentType.JSON, "username", "zhangsan4","age",24,"sex","nan4");
        IndexRequest source6 = new IndexRequest().index("user").id("206").source(XContentType.JSON, "username", "zhangsan4","age",25,"sex","nan5");
        bulkRequest.add(source1);
        bulkRequest.add(source2);
        bulkRequest.add(source3);
        bulkRequest.add(source4);
        bulkRequest.add(source5);
        bulkRequest.add(source6);
        BulkResponse bulk = esclient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("bulk.getTook() = " + bulk.getTook());
        System.out.println("bulk.getItems() = " + bulk.getItems());

        esclient.close();
    }
}
