package com.example.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.rest.webservices.restfulwebservices.searches.Searches;


@Service
public class SearchesHardcodedService {
	private static List<Searches> allSearches= new ArrayList<Searches>();
	private static long pageIdCounter=3434;
	
	static {
		allSearches.add(new Searches("Wow",++pageIdCounter,"34495","4283","<span class=\"searchmatch\">Space</span> is the boundless three-dimensional extent in which objects and events have relative position and direction. Physical <span class=\"searchmatch\">space</span>","2020-04-27T19:31:02Z"));
		allSearches.add(new Searches("Hiiii",++pageIdCounter,"10903","1093","<span class=\"searchmatch\">Space</span> is the boundless three-dimensional extent in which objects and events have relative position and direction. <span class=\"searchmatch\">Space</span>, <span class=\"searchmatch\">SPACE</span>, spacing, or The <span class=\"searchmatch\">Space</span>","2020-03-13T10:10:20Z"));
		allSearches.add(new Searches("No Way",++pageIdCounter,"12345","9023","The International <span class=\"searchmatch\">Space</span> Station (ISS) is a modular <span class=\"searchmatch\">space</span> station (habitable artificial satellite) in low Earth orbit. The ISS programme is a multi-national","2020-05-14T15:31:28Z"));

	}
	
	public List<Searches> findAll(){
		return allSearches;
	}
	
	public static  Searches deleteById(long Id) {
		Searches searches1=findById(Id);
		System.out.println("" + searches1);
		if (searches1==null) {
			return null;
		}
		else if(allSearches.remove(searches1)) {
			System.out.println("remove");
			return searches1;
		}
		else {
			return null;
		}
		
	}
	
	public static Searches save(Searches searches) {
		if(searches.getPageId()==-1 || searches.getPageId()==0) {
			if(searches.getPageId()==0) {
				searches.setPageId(++pageIdCounter);
			}
			allSearches.add(searches);
		}
		else {
			deleteById(searches.getPageId());
			allSearches.add(searches);
		}
		
		return searches;
	}

	public static Searches findById(long Id) {
		for(Searches allSearch1:allSearches ) {
			if (allSearch1.getPageId()==Id) {
				return allSearch1;
			}
			
		}
		return null;
	}
}
