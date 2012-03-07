package com.tinybang.state;

/**
 * 
 * @author conan.cao
 *
 */
public class StateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5233582871905178548L;

    public StateException() {
    	super();
    }
    
    public StateException(String message) {
    	super(message);
    }

    public StateException(String message, Throwable cause) {
        super(message, cause);
    }

    public StateException(Throwable cause) {
        super(cause);
    }	
}
