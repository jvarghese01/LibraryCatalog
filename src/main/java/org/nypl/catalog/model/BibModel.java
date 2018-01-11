package org.nypl.catalog.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BibModel {

	private String title;
	private String isbn;
	private String description;
	private String publishDate;
	private String imageUrl;
	private String author;
	private String stars;
	private String formatType;	
	private String catalogURL;	
	private String circCount;	


	
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getFormatType() {
		return formatType;
	}
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}
	public String getCatalogURL() {
		return catalogURL;
	}
	public void setCatalogURL(String catalogURL) {
		this.catalogURL = catalogURL;
	}
	public String getCircCount() {
		return circCount;
	}
	public void setCircCount(String circCount) {
		this.circCount = circCount;
	}

}
