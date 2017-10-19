package org.nypl.catalog.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BibModel {

	private String title;
	private String isbn;
	private String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
