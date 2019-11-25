package com.unox.entities;
import java.util.ArrayList;

public class Schedule {

	private Screen screen;
	private Show show;
	private Movie movie;
	
	private int id;
	private ArrayList<Booking> bookings;
	
	public Schedule()
	{
		bookings = new ArrayList<Booking>();
	}
	
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Booking> getBookings() {
		return bookings;
	}
	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}
	
	
	
	
}
