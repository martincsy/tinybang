package com.tinybang.state;

/**
 * 
 * @author conan.cao
 *
 */
public interface IState {

	public void onEnter(ExecutionContext context) throws StateException;
	
	public void onExist(ExecutionContext context) throws StateException;
	
	public IState next(ExecutionContext context) throws StateException;
}
