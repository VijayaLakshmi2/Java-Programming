package com.unox.entities;

public class Review {

	private int id;
	private String title;
	private String content;
	private Movie movie;
	private String reviewerName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public String getreviewerName() {
		return reviewerName;
	}
	public void setreviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	
}
