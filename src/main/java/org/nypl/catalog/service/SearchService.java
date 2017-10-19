package org.nypl.catalog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nypl.catalog.model.BibModel;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	public Map<String, List<BibModel>> search() {
		List<BibModel> results = new ArrayList<BibModel>();
	    
		BibModel bm = new BibModel();
	    	bm.setTitle("Java 8 - The Definitive Guide");
	    	bm.setDescription("Authoritative book on the Java 8 programming language");
	    	bm.setIsbn("543289983212321");
	    results.add(bm);
	    
		BibModel bm2 = new BibModel();
		bm2.setTitle("Rails 5 - The Definitive Guide");
		bm2.setDescription("Authoritative book on the Rails 5 framework");
		bm2.setIsbn("542284982214321");
		results.add(bm2); 
		
		Map<String,List<BibModel>> searchResults = new HashMap<String,List<BibModel>>();
		searchResults.put("results",results);		
	    	
		return searchResults;
	}	
}
