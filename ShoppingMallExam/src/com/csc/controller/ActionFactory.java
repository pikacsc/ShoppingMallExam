package com.csc.controller;

import com.csc.contoller.action.Action;
import com.csc.contoller.action.IndexAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	public ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : "+command);
		
		if(command.equals("index")) {
			action = new IndexAction();
		}
		
		return action;
	}
	
}
