package cn.elk.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;


/**
 * @author chenchao
 * @Data 2023/5/30 9:43
 **/
public class ES_Doc_Query {
    public static void main(String[] args) throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestHighLevelClient esclient = new RestHighLevelClient(builder);
        /**
         * 查询数据
         */
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        //构建查询对象
        //查询所有
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        searchRequest.source(query);
        SearchResponse search = esclient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        System.out.println("hits.getTotalHits() = " + hits.getTotalHits());
        System.out.println("search.getTook() = " + search.getTook());

        for (SearchHit hit : hits) {

            System.out.println("hit.getSourceAsString() = " + hit.getSourceAsString());
        }

        esclient.close();
    }
}
