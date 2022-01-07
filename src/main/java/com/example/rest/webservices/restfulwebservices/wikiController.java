package com.example.rest.webservices.restfulwebservices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservices.restfulwebservices.searches.Searches;
import com.example.rest.webservices.restfulwebservices.searches.SearchesList;
//@ComponentScan(basePackages= {"com.example.rest.webservices.restfulwebservices"})
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class wikiController {
	//public HashMap<String,String> getAllSearches(String searchString)
	//@Autowired
	//private SearchesHardcodedService searchesService;
	
	@Autowired
	private SearchesJpaRepository searchesJpaService;
	
	@GetMapping(path="")
	public List<Searches> getAllSearches(){
		return searchesJpaService.findAll();
		//return searchesService.findAll();
	}
	/*
	@GetMapping(path="/{title}")
	public Searches getSearches(@PathVariable("id") String title){
		return searchesJpaService.findByTitle(title);
	}
	*/
	/*@GetMapping(path="/{id}")
	public Searches getSearches(@PathVariable("id") String id){
		long pgId1= Long.valueOf(id);
		return searchesService.findById(pgId1);
	}*/
	
	//@RequestMapping("/delete/{id}")
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteSearches(@PathVariable("id") String id){
		long pgId= Long.valueOf(id);
		////System.out.println("id" + pgId);
		//Searches search2 = SearchesHardcodedService.deleteById(pgId);
		////System.out.println("id" + search2);
		
		//Searches searchRandom= SearchesJpaRepository.findById(pgId);
		//Searches search2=
				searchesJpaService.deleteById(pgId);
		
		//if(search2!=null) {
			return ResponseEntity.ok().build();
		//}
		//return ResponseEntity.notFound().build();
	}
	
	@PostMapping(path="")
	public ResponseEntity<Searches> saveSearch(@RequestBody SearchesList search){
		////System.out.println(search.toString());
		
		////System.out.println("size:" + search.getSearchList().size());
		
		////System.out.println("Inside Backend Save");
		for( Searches searches: search.getSearchList()) {
			//SearchesHardcodedService.save(searches);
			searchesJpaService.save(searches);
		}
		
		System.out.println("Success saved!!!!");
//		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("").buildAndExpand(search.getPageId()).toUri();
		
//		return ResponseEntity.created(uri).build();
		return ResponseEntity.ok().build();
		//return new ResponseEntity<Searches>(search, HttpStatus.OK) ;
		
	}
}
