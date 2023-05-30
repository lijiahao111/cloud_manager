package cn.elk.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
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
public class ES_Doc_Update {
    public static void main(String[] args) throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient esclient = new RestHighLevelClient(builder);

        /**
         * 修改文档
         */
        UpdateRequest indexRequest = new UpdateRequest();
        indexRequest.index("user").id("101");
        indexRequest.doc(XContentType.JSON,"sex","女");
        UpdateResponse update = esclient.update(indexRequest, RequestOptions.DEFAULT);
        System.out.println("response.getResult() = " + update.getResult());

        esclient.close();
    }
}
