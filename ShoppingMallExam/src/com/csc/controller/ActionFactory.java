package com.csc.controller;

import com.csc.contoller.action.Action;
import com.csc.contoller.action.ContractAction;
import com.csc.contoller.action.FindZipZumAction;
import com.csc.contoller.action.IdCheckFormAction;
import com.csc.contoller.action.IndexAction;
import com.csc.contoller.action.JoinAction;
import com.csc.contoller.action.JoinFormAction;
import com.csc.contoller.action.LoginAction;
import com.csc.contoller.action.LoginFormAction;
import com.csc.contoller.action.LogoutAction;
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
		} else if(command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		} else if(command.equals("find_zip_num")) {
			action = new FindZipZumAction();
		} else if(command.equals("join")) {
			action = new JoinAction();
		} else if(command.equals("login_form")) {
			action = new LoginFormAction();
		} else if(command.equals("login")) {
			action = new LoginAction();
		} else if(command.equals("logout")) {
			action = new LogoutAction();
		}
		
		return action;
	}
	
}
