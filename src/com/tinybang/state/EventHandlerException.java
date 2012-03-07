package com.tinybang.state;

/**
 * 
 * @author conan.cao
 *
 */
public class EventHandlerException extends Exception{

	private static final long serialVersionUID = 6770895964887006215L;

	public EventHandlerException() {
    	super();
    }
    
    public EventHandlerException(String message) {
    	super(message);
    }

    public EventHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventHandlerException(Throwable cause) {
        super(cause);
    }	

}
