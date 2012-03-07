package com.tinybang.state;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @author conan.cao
 *
 */
public class State implements IState{

	private UUID id;
	
	private String nodeName;
	
	private List<Transition> leaveTransitions;
	
	private List<EventHandler> beforeActionHanders = new ArrayList<EventHandler>();
	
	private List<EventHandler> afterActionHanders = new ArrayList<EventHandler>();
	
	public List<Transition> getLeaveTransitions(){
		if(leaveTransitions == null){
			leaveTransitions = new ArrayList<Transition>();
		}
		
		return leaveTransitions;
	}
	
	public State(String nodeName){
		this.nodeName = nodeName;
		id = UUID.randomUUID();
	}
	
	public String getNodeName(){
		return nodeName;
	}
	
	public void addStateNodeEnterEvent(EventHandler actionHandler){
		if(actionHandler != null)beforeActionHanders.add(actionHandler);
	}
	
	public void addStateNodeExitEvent(EventHandler actionHandler){
		if(actionHandler != null)afterActionHanders.add(actionHandler);
	}	

	protected void fireStateEnterEvent(ExecutionContext context) throws EventHandlerException{
		try{
			for(EventHandler handler : beforeActionHanders){
					handler.execute(context);	
			}
		}catch(Exception e){
			throw new EventHandlerException(e);
		}
	}
	
	@Override
	public IState next(ExecutionContext context) throws StateException{		
		String signalName = context.getSignalName();
		
		for(Transition transition : getLeaveTransitions()){
			if(transition != null && transition.getName().equalsIgnoreCase(signalName)){
				State destinationNode = transition.getTo();
				context.setCurrentNode(destinationNode);
				return destinationNode;
			}
		}
		
		throw new StateException(
				MessageFormat.format("Current node {0} can not move to next node with transition {1}",
						this.nodeName, String.valueOf(signalName)));
	}

	protected void fireStateExitEvent(ExecutionContext context) throws EventHandlerException{
		try{
			for(EventHandler handler : afterActionHanders){
					handler.execute(context);	
			}
		}catch(Exception e){
			throw new EventHandlerException(e);
		}
	}

	@Override
	public void onEnter(ExecutionContext context) throws StateException {
		try{
		    fireStateEnterEvent(context);
		}catch(EventHandlerException e){
			throw new StateException(MessageFormat.format("Enter {0} node meets exception",
					this.nodeName), e);
		}
	}

	@Override
	public void onExist(ExecutionContext context) throws StateException {
		try{
			fireStateExitEvent(context);
		}catch(EventHandlerException e){
			throw new StateException(MessageFormat.format("Exist {0} node meets exception",
					this.nodeName), e);
		}
	}
	
	public UUID getId(){
		return id;
	}
}
