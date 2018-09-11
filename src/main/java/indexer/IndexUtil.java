package indexer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

public class IndexUtil {

	public static void main(String[] args) throws IOException {
		NYPLAPIClient nyplR = new NYPLAPIClient("https://isso.nypl.org/oauth/token","jasonvarghese","d88480879f67a5238c059dbed5c704a52a62bc98","client_credentials");
		OAuth2RestTemplate oauth = nyplR.getOAuth2RestTemplate();
		
		String response="";
		try {
			response = oauth.getForObject("https://platform.nypl.org/api/v0.1/bibs?nyplSource=sierra-nypl", String.class);
			System.out.println(response);

			JSONArray ja = (JSONArray)(new JSONObject(response)).get("data");
			
			for(Object j:ja) {
				if (((JSONObject)j).get("deleted").equals(false)){

				
					System.out.println("ID:"+((JSONObject)j).get("id"));
					System.out.println("TITLE:"+((JSONObject)j).get("title"));
						
					
	
					JSONArray code = (JSONArray) (((JSONObject)j).get("locations"));
					System.out.println(code);
					
					for(Object c:code) {
						System.out.println("CODE:"+((JSONObject)c).get("code"));
					}

				}
			}

		}
		catch(Exception e) {
			System.out.println(e.toString());
		}		
		
		//System.out.println(response);
		
		/*
		RestHighLevelClient client = new RestHighLevelClient(
		        RestClient.builder(
		                new HttpHost("localhost", 9200, "http")));
		
		
		
		BufferedReader br = new BufferedReader(new FileReader("/Users/digital/Documents/topBibsWithCount.csv"));
		String line = "";
		String bibID="";
		while((line = br.readLine())!=null) {
			
			bibID = (line.split(","))[0];			
			


			Map<String, Object> jsonMap = new HashMap<>();
			
			jsonMap.put("count", (line.split(","))[1]);
			UpdateRequest request = new UpdateRequest("bibs", "doc", bibID)
			        .doc(jsonMap); 
			
			try {
			UpdateResponse updateResponse = client.update(request);
			String id = updateResponse.getId();
			
			System.out.println(id);
			}
			catch (Exception e) {
				System.out.println("Update Error at"+bibID);

			}
			*/
			
			/*bibID = (line.split(","))[0];			
			String response="";
			try {
				response = oauth.getForObject("https://platform.nypl.org/api/v0.1/bibs/sierra-nypl/"+bibID, String.class);
			}
			catch(Exception e) {
				System.out.println("API Error at"+bibID);
			}
			
			IndexRequest request = new IndexRequest(
			        "bibs", 
			        "doc",  
			        bibID);
			
			request.source(response, XContentType.JSON); 
			
			try{
				IndexResponse indexResponse = client.index(request);
			}
			catch (Exception e) {
				System.out.println("ES Error at"+bibID);
			}*/
		
		}

		//client.close();

		
	//}
	

}
