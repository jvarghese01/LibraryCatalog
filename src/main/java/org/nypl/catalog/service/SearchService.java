package org.nypl.catalog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nypl.catalog.model.BibModel;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	public List<BibModel> search() {
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
		    
			bm2 = new BibModel();
			bm2.setTitle("Head First Java, 2nd Edition");
			bm2.setAuthor("Kathy Sierra and Bert Bates");
			bm2.setStars("4");
			bm2.setPublishDate("Feb 9, 2005");
			bm2.setIsbn("542284982214321");
			bm2.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/51Gsycdh-TL._AC_US218_.jpg");

			bm3 = new BibModel();
			bm3.setTitle("Java: The Complete Reference, Tenth Edition");
			bm3.setAuthor("Herbert Schildt");
			bm3.setStars("4");
			bm3.setPublishDate("Oct 11, 2017");
			bm3.setIsbn("542284982214321");
			bm3.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/51P0lRpq2TL._AC_US436_FMwebp_QL65_.jpg");
			
			
			results.add(bm);
			results.add(bm2);
			results.add(bm3);
		}
		
		
		
		
	    	
		return results;
	}	
}
