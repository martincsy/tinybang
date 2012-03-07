package com.tinybang.state;


/**
 * @author conan.cao
 *
 */
public class End extends State {

	private static final String END = "end";
	
	public End() {
		super(END);
	}

	@Override
	public IState next(ExecutionContext context) throws StateException {
		throw new StateException("End node does not have next node.");
	}
}
