package com.example.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.webservices.restfulwebservices.searches.Searches;
import com.example.rest.webservices.restfulwebservices.searches.SearchesList;
@Repository
public interface SearchesJpaRepository extends JpaRepository<Searches ,Long>{
	
	
	
	
	//List<Searches> findByTitle(String title);
}
