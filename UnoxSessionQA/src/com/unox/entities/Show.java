package com.unox.entities;
import java.util.ArrayList;

public class Show {

	private int id;
	private String name;
	private ArrayList<Screen> screens;
	
	public Show(){
		screens = new ArrayList<Screen>();
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
	
	public ArrayList<Screen> getScreens() {
		return screens;
	}
	public void addScreen(Screen screen) {
		this.screens.add(screen);
	}
}
