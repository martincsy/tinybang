/**
 * @author conan.cao
 */
package com.tinybang.state;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author conan.cao
 *
 */
public class ExecutionId {

	private ProcessDefinition processDefinition;
	
	private State currentNode;
	
	private String id;	
	
	private static final Pattern SERIALIZED_PATTERN = Pattern.compile("ID:([a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12});PROCESSNAME:(\\w+);STATENAME:([\\w||\\s]+)"); 

	public static void main(String[] args){
		Matcher m = SERIALIZED_PATTERN.matcher("ID:eb4e033d-954d-49a7-82a2-80fdc3a9f17d;PROCESSNAME:EntityDistribution;STATENAME:FOR WHOM");
		System.out.println(m.matches());
		
		for(int i = 0 ; i <= m.groupCount(); i++){
			System.out.println(m.group(i));
		}
	}
	
	public ExecutionId(String processName, String stateName){
		this.processDefinition = ProcessDefinitionFactory.findProcessDefinition(processName);
		this.currentNode = getProcessDefinition().locateStateNodeByNodeName(stateName);
		id = UUID.randomUUID().toString();
	}
	
	public ExecutionId(String id, String processName, String stateName){
		this.processDefinition = ProcessDefinitionFactory.findProcessDefinition(processName);
		this.currentNode = getProcessDefinition().locateStateNodeByNodeName(stateName);
		this.id = id;
	}
	
	public static ExecutionId createNewExecutionId(String processName, String stateName){
		return new ExecutionId(processName, stateName);
	}
	
	public void setCurrentState(State stateNode){
		this.currentNode = stateNode;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public static ExecutionId fromString(String serializedStr){
		ExecutionId executionId = null;			
		
		if(serializedStr == null || serializedStr.length() <=0){
			Matcher m = SERIALIZED_PATTERN.matcher(serializedStr);
			if(m.matches()){
				executionId = new ExecutionId(m.group(1), m.group(2), m.group(3));
			}
		}
		return executionId;
	}
	
	public String toString(){
		String serializedStr = new StringBuilder("ID:").append(id).append(";PROCESSNAME:")
					.append(processDefinition.getName()).append(";STATENAME:").append(currentNode.getNodeName()).toString();
		return serializedStr;
	}
	
	public ProcessDefinition getProcessDefinition(){
		return processDefinition;
	}
	
	public State getCurrentNode(){
		return currentNode;
	}
}
