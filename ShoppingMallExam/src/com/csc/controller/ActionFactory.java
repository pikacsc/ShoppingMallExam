package com.csc.controller;

import com.csc.admin.AdminIndexAction;
import com.csc.admin.AdminLoginAction;
import com.csc.admin.AdminLogoutAction;
import com.csc.admin.AdminMemberListAction;
import com.csc.admin.AdminOrderListAction;
import com.csc.admin.AdminOrderSaveAction;
import com.csc.admin.AdminProductDeleteAction;
import com.csc.admin.AdminProductDetailAction;
import com.csc.admin.AdminProductListAction;
import com.csc.admin.AdminProductUpdateAction;
import com.csc.admin.AdminProductUpdateFormAction;
import com.csc.admin.AdminProductWriteAction;
import com.csc.admin.AdminProductWriteFormAction;
import com.csc.admin.AdminQnaDetailAction;
import com.csc.admin.AdminQnaListAction;
import com.csc.admin.AdminQnaResaveAction;
import com.csc.contoller.action.Action;
import com.csc.contoller.action.CartDeleteAction;
import com.csc.contoller.action.CartInsertAction;
import com.csc.contoller.action.CartListAction;
import com.csc.contoller.action.ContractAction;
import com.csc.contoller.action.FindZipZumAction;
import com.csc.contoller.action.IdCheckFormAction;
import com.csc.contoller.action.IndexAction;
import com.csc.contoller.action.JoinAction;
import com.csc.contoller.action.JoinFormAction;
import com.csc.contoller.action.LoginAction;
import com.csc.contoller.action.LoginFormAction;
import com.csc.contoller.action.LogoutAction;
import com.csc.contoller.action.MyPageAction;
import com.csc.contoller.action.OrderAllAction;
import com.csc.contoller.action.OrderDetailAction;
import com.csc.contoller.action.OrderInsertAction;
import com.csc.contoller.action.OrderListAction;
import com.csc.contoller.action.ProductDetailAction;
import com.csc.contoller.action.ProductKindAction;
import com.csc.contoller.action.QnaListAction;
import com.csc.contoller.action.QnaViewAction;
import com.csc.contoller.action.QnaWriteAction;
import com.csc.contoller.action.QnaWriteFormAction;

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
		} else if(command.equals("cart_insert")) {
			action = new CartInsertAction();
		} else if(command.equals("cart_list")) {
			action = new CartListAction();
		} else if(command.equals("cart_delete")) {
			action = new CartDeleteAction();
		} else if(command.equals("order_insert")) {
			action = new OrderInsertAction();
		} else if(command.equals("order_list")) {
			action = new OrderListAction();
		} else if(command.equals("mypage")) {
			action = new MyPageAction();
		} else if(command.equals("order_datail")) {
			action = new OrderDetailAction();
		} else if(command.equals("order_all")) {
			action = new OrderAllAction();
		} else if(command.equals("qna_list")) {
			action = new QnaListAction();
		} else if(command.equals("qna_write_form")) {
			action = new QnaWriteFormAction();
		} else if(command.equals("qna_write")) {
			action = new QnaWriteAction();
		} else if(command.equals("qna_view")) {
			action = new QnaViewAction();
		} 
		
		if(command.equals("admin_login_form")) {
			action = new AdminIndexAction();
		} else if(command.equals("admin_login")) {
			action = new AdminLoginAction();
		} else if(command.equals("admin_logout")) {
			action = new AdminLogoutAction();
		} else if(command.equals("admin_product_list")) {
			action = new AdminProductListAction();
		} else if(command.equals("admin_product_detail")) {
			action = new AdminProductDetailAction();
		} else if(command.equals("admin_product_write_form")) {
			action = new AdminProductWriteFormAction();
		} else if(command.equals("admin_product_write")) {
			action = new AdminProductWriteAction();
		} else if(command.equals("admin_product_update_form")) {
			action = new AdminProductUpdateFormAction();
		} else if(command.equals("admin_product_update")) {
			action = new AdminProductUpdateAction();
		} else if(command.equals("admin_delete_product")) {
			action = new AdminProductDeleteAction();
		} else if(command.equals("admin_order_list")) {
			System.out.println("admin_order_list 받음");
			action = new AdminOrderListAction();
		} else if(command.equals("admin_order_save")) {
			action = new AdminOrderSaveAction();
		} else if(command.equals("admin_member_list")) { 
			action = new AdminMemberListAction();
		} else if(command.equals("admin_qna_list")) {
			action = new AdminQnaListAction();
		} else if(command.equals("admin_qna_detail")) {
			action = new AdminQnaDetailAction();
		} else if(command.equals("admin_qna_repsave")) {
			action = new AdminQnaResaveAction();
		}
		
		
		return action;
	}
	
}
