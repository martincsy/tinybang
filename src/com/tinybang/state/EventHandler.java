package com.tinybang.state;


/**
 * 
 * @author conan.cao
 *
 */
public interface EventHandler {
	public void execute(ExecutionContext context) throws EventHandlerException;
}
