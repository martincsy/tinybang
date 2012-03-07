package com.tinybang.state;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author conan.cao
 *
 */
public class ProcessDefinition {
	
	priv
	
	private String name;
	
	private Start startNode;
	
	private Map<String, State> nodesMap = new HashMap<String, State>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Start getStartNode() {
		return startNode;
	}

	public void setStartNode(Start startNode) {
		this.startNode = startNode;
	}

	public void addNode(State node) {
		if(node != null){
			nodesMap.put(node.getNodeName(), node);	
		}
	}
	
	public Collection<State> getAllNodes(){
		return nodesMap.values();
	}
	
	public State locateStateNodeByNodeName(String nodeName){
		if(nodeName == null){
			return null;
		}else{
			return nodesMap.get(nodeName);
		}
	}
}
