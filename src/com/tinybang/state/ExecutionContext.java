package com.tinybang.state;

import java.util.Map;

/**
 * @author conan.cao
 *
 */
public class ExecutionContext {
	
	private String signalName;
	
	private ExecutionId executionId;
	
	private Map<String, String> contextVariables;
	
	public ProcessDefinition getProcessDefinition() {
		return executionId.getProcessDefinition();
	}
	
	public Map<String, String> getVariables(){
		return contextVariables;
	}
	
	public void setVariables(Map<String,String> variables){
		this.contextVariables = variables;
	}
	
	public void setExecutionId(ExecutionId executionId){
		this.executionId = executionId;
	}
	
	public ExecutionId getExecutionId(){
		return executionId;
	}
	
	public void setSignalName(String signalName){
		this.signalName = signalName;
	}

	public String getSignalName(){
		return signalName;
	}
	
	public void setCurrentNode(State currentNode){
		executionId.setCurrentState(currentNode);
	}
	
	public State getCurrentNode(){
		return executionId.getCurrentNode();
	}
}
