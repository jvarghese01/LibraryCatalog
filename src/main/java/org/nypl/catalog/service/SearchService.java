package org.nypl.catalog.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.nypl.catalog.model.BibModel;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	RestHighLevelClient client = new RestHighLevelClient(
	        RestClient.builder(
	                new HttpHost("localhost", 9200, "http")));
	
	public List<BibModel> search() throws IOException {
		List<BibModel> results = new ArrayList<BibModel>();
		BibModel bm;
		/*GetRequest getRequest = new GetRequest(
		        "bibs", 
		        "doc",  
		        "*"); 
		
		GetResponse getResponse = client.get(getRequest);
		Map map = getResponse.getSourceAsMap();*/
		SearchRequest searchRequest = new SearchRequest("bibs"); 
		searchRequest.types("doc");
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 
		searchSourceBuilder.sort(new FieldSortBuilder("count").order(SortOrder.DESC));  

		searchRequest.source(searchSourceBuilder);
		SearchResponse searchResponse = client.search(searchRequest);
		SearchHits hits = searchResponse.getHits();
		for (SearchHit hit:hits) {
			Map map = hit.getSourceAsMap();
			System.out.println(map);
			bm = new BibModel();
			
			String title = (String) ((Map)map.get("data")).get("title");
			String id = (String) ((Map)map.get("data")).get("id");
			String circCount = (String) map.get("count");


			Integer publishYear = (Integer) ((Map)map.get("data")).get("publishYear");
			String formatType = (String) ((Map)(((Map)map.get("data")).get("materialType"))).get("value");
			bm = new BibModel();
			bm.setTitle(title);
			bm.setFormatType(formatType);
			bm.setPublishDate(publishYear+"");
			bm.setImageUrl("https://www.nypl.org/books-music-dvds/recommendations/lists/src/client/images/book-place-holder.png");
			bm.setCatalogURL("http://browse.nypl.org/iii/encore/record/C__Rb"+id);
			bm.setCircCount(circCount);

			results.add(bm);
		}
		return results;
	}

	public List<BibModel> searchDummy() {
		List<BibModel> results = new ArrayList<BibModel>();
	    
		
		for(int a=0;a<10;a++) {
			BibModel bm = new BibModel();
			BibModel bm2 = new BibModel();
			BibModel bm3 = new BibModel();


		    	bm.setTitle("Java: A Beginner's Guide, Sixth Edition");
		    	bm.setAuthor("Herbert Schildt");
		    	bm.setStars("4");
		    	bm.setPublishDate("May 6, 2014");
		    	bm.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/41KJV7-HS0L._AC_US218_.jpg");	
		    	bm.setIsbn("543289983212321");
		    	bm.setFormatType("book");

		    
			bm2 = new BibModel();
			bm2.setTitle("Head First Java, 2nd Edition");
			bm2.setAuthor("Kathy Sierra and Bert Bates");
			bm2.setStars("4");
			bm2.setPublishDate("Feb 9, 2005");
			bm2.setIsbn("542284982214321");
			bm2.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/51Gsycdh-TL._AC_US218_.jpg");
			bm2.setFormatType("book");

			bm3 = new BibModel();
			bm3.setTitle("Java: The Complete Reference, Tenth Edition");
			bm3.setAuthor("Herbert Schildt");
			bm3.setStars("4");
			bm3.setPublishDate("Oct 11, 2017");
			bm3.setIsbn("542284982214321");
			bm3.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/51P0lRpq2TL._AC_US436_FMwebp_QL65_.jpg");
			bm3.setFormatType("book");

			
			results.add(bm);
			results.add(bm2);
			results.add(bm3);
		}
		
		
		
		
	    	
		return results;
	}	
}
