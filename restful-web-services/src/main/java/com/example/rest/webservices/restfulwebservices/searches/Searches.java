package com.example.rest.webservices.restfulwebservices.searches;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.swing.text.String.String;

//import javassist.runtime.Inner;

//import javax.swing.text.String.String;
@Entity
public class Searches {
	private String title;
	@Id
	private Long pageId;//alt use Long//////@GeneratedValue
	//private String pageId;
	//private long size;
	private String size;
	//private long wordCount;
	private String wordCount;
	private String snippet;//check
	private String timestamp;
	
	
	protected Searches() {
		
	}
	
	public Searches(String title, long pageId, String size, String wordCount, String snippet1, String timestamp) {
		super();
		this.title= title;
		this.pageId=pageId;
		this.size=size;
		this.wordCount=wordCount;
		this.snippet=snippet1;
		this.timestamp=timestamp;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPageId() {
		return pageId;
	}
	public void setPageId(long pageId) {
		this.pageId = pageId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWordCount() {
		return wordCount;
	}
	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (pageId ^ (pageId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Searches other = (Searches) obj;
		if (pageId != other.pageId)
			return false;
		return true;
	}

	
	
	
	
}
