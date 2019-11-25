package com.unox.entities;
import java.util.ArrayList;

public class Movie {

	private int id;
	private String name;
	private String genre;
	private int rating;
	private String status;
	
	private ArrayList<Review> reviews;
	private ArrayList<Show> shows;
	private ArrayList<Screen> screens;
	private ArrayList<StarCast> starCast;
	
	public Movie(){
		reviews = new ArrayList<Review>();
		shows = new ArrayList<Show>();
		screens = new ArrayList<Screen>();
		starCast = new ArrayList<StarCast>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ArrayList<Screen> getScreens() {
		return screens;
	}
	public void addScreen(Screen screen) {
		this.screens.add(screen);
	}
	
	public ArrayList<Show> getShows() {
		return shows;
	}
	public void addShow(Show show) {
		this.shows.add(show);
	}
	
	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public ArrayList<StarCast> getStarCast() {
		return starCast;
	}

	public void addStarCast(StarCast starCast) {
		this.starCast.add(starCast);
	}

	
	
}
