package org.nypl.catalog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nypl.catalog.model.BibModel;
import org.nypl.catalog.model.SearchResult;
import org.nypl.catalog.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class SearchController {
	
	@Autowired
	public SearchService searchService;	
	
    @ResponseBody
	@RequestMapping(value = "/search", produces={"application/xml", "application/json"})
    public List<BibModel> search(@RequestParam(value="term") String name) {
    		return searchService.search();
    }
    
    @RequestMapping("/search")
    public String searchWithView(@RequestParam(value="term") String term, Model model){
        List<BibModel> result = searchService.search();
    		model.addAttribute("result", result);
        model.addAttribute("term", term);
        model.addAttribute("results", result.size());


        return "search";
    }
    
    @ResponseBody
    @RequestMapping(value = "/searchx", produces={"application/xml", "application/json"})
    public SearchResult search2(@RequestParam(value="term") String name) {
    		SearchResult sr = new SearchResult();
    		BibModel bm = new BibModel();
    		bm.setTitle("java");
    		bm.setIsbn("isbn");
    		bm.setDescription("desc");
    		sr.add(bm);
    		return sr;
    }    
    
    
}
