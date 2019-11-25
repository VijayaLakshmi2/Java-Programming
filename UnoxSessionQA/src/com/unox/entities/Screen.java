package com.unox.entities;
import java.util.ArrayList;

public class Screen {
	
	private int id;
	private String name;
	private ArrayList<ScreenClass> screenClass;
	private ArrayList<Show> shows;
	
	public Screen(){
		screenClass = new ArrayList<ScreenClass>();
		shows = new ArrayList<Show>();
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
	public ArrayList<ScreenClass> getScreenClass() {
		return screenClass;
	}
	public void addScreenClass(ScreenClass screenClass) {
		this.screenClass.add(screenClass);
	}
	
	public ArrayList<Show> getShows() {
		return shows;
	}
	public void addShows(Show show) {
		this.shows.add(show);
	}
	

}
