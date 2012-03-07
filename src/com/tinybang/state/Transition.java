package com.tinybang.state;

import java.util.UUID;

/**
 * 
 * @author conan.cao
 *
 */
public class Transition {
	
	private UUID id;

	private final State from;
	
	private final State to;
	
	private String name;

	public Transition(State from, State to, String name){
		this.from = from;
		this.to = to;
		this.name = name;
		id = UUID.randomUUID();
	}
	
	public State getFrom() {
		return from;
	}


	public State getTo() {
		return to;
	}


	public String getName() {
		return name;
	}
	
	public UUID getId(){
		return id;
	}
}
