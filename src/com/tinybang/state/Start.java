package com.tinybang.state;


/**
 * 
 * @author conan.cao
 *
 */
public class Start extends State {

	private static final String START = "start";
	
	public Start() {
		super(START);
	}

	@Override
	public IState next(ExecutionContext context) throws StateException {
		if(getLeaveTransitions().size() <= 0){
			throw new StateException("The start node does not have any transitions to the next node.");
		}else if(getLeaveTransitions().size() > 1){ 
			throw new StateException("The start node should only have one transition to the next node.");
		}
		
		for(Transition transition : getLeaveTransitions()){
			State currentNode = transition.getTo();
			context.setCurrentNode(currentNode);
			return currentNode;
		}
		
		throw new StateException("The start node does not go to the next node.Please have a check.");
	}
}
