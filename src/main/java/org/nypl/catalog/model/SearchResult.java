package org.nypl.catalog.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SearchResult {
	List<BibModel> results = new ArrayList<BibModel>();

	public List<BibModel> getBibModel() {
		return results;
	}

	public void setBibModel(List<BibModel> results) {
		this.results = results;
	}
	
	public void add(BibModel bm) {
		if(results==null)
			results = new ArrayList<BibModel>();
		results.add(bm);
	}
	
	
}
