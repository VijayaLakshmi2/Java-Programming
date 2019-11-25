package com.unox.entities;
import java.util.ArrayList;

public class Multiplex {

	private int id;
	private String name;
	private ArrayList<Screen> screens;
	
	public Multiplex(){
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
		screens.add(screen);
	}

}
