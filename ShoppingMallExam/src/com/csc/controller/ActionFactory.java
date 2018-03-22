package com.csc.controller;

import com.csc.contoller.action.Action;
import com.csc.contoller.action.ContractAction;
import com.csc.contoller.action.IdCheckFormAction;
import com.csc.contoller.action.IndexAction;
import com.csc.contoller.action.JoinFormAction;
import com.csc.contoller.action.ProductDetailAction;
import com.csc.contoller.action.ProductKindAction;

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
		} else if(command.equals("product_detail")){
			action = new ProductDetailAction();
		} else if(command.equals("catagory")) {
			action = new ProductKindAction();
		} else if(command.equals("contract")) {
			action = new ContractAction();
		} else if(command.equals("join_form")) {
			action = new JoinFormAction();
		}else if(command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		}
		
		return action;
	}
	
}
