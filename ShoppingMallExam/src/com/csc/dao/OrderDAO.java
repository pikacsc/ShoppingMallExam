package com.csc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.csc.dto.CartVO;
import com.csc.dto.OrderVO;

import utill.DBManager;

public class OrderDAO {
	private OrderDAO () {};
	
	private static OrderDAO instance = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return instance;
	}
	
	//사용자가 주문
	
	public int insertOrder(ArrayList<CartVO> cartList,String id) {
	
		String selectMaxOseq = "select max(oseq) from orders"; //가장 최신 주문 찾기
		
		String insertOrder = "insert into orders(oseq, id) values("
				+"orders_seq.nextval, ?)";
	
		
		int maxOseq=0;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			
			//주문테이블 oseq 주문번호
			//id 주문자 아이디
			//indate 주문일
			//홍길동 1.주문번호 one   2.주문번호
			pstmt = conn.prepareStatement(selectMaxOseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxOseq=rs.getInt(1);
			}
			pstmt.close();
			
			
			//order_detail
			//주문 상세 번호
			//주문 번호
			//상품 번호
			//주문 수량
			//처리 여부
			
			pstmt=conn.prepareStatement(insertOrder);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			for(CartVO cartVO : cartList) {
				insertOrderDetail(cartVO,maxOseq);
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return maxOseq;
	}
	
	
	
	public void insertOrderDetail(CartVO cartVO,int maxOseq) {
		String insertOrderDetail = "insert into order_detail(obseq, oseq, "
				+ "pseq, quantity) values(order_detail_seq.nextval, ?, ?, ?)";
		
		String updateCartResult = "update cart set result=2 where cseq?";	
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insertOrderDetail);
			pstmt.setInt(1, maxOseq);
			pstmt.setInt(2, cartVO.getPseq());
			pstmt.setInt(3, cartVO.getQuantity());
			pstmt.executeUpdate();
			pstmt.close();
			
			//카트테이블에 result 결과처리여부 1.미처리 2.처리
			pstmt = conn.prepareStatement(updateCartResult);
			pstmt.setInt(1, cartVO.getCseq());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	public ArrayList<OrderVO> listOrderById(String id, String result, int oseq){
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		String sql = "select * from order_view where id = ? "
				+ "and result like '%'||?||'%' and oseq = ?";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2,result);
			pstmt.setInt(3, oseq);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderVO orderVO = new OrderVO();
				orderVO.setObseq(rs.getInt("OBSEQ"));
				orderVO.setOseq(rs.getInt("OSEQ"));
				orderVO.setId(rs.getString("ID"));
				orderVO.setIndate(rs.getTimestamp("INDATE"));
				orderVO.setMname(rs.getString("MNAME"));
				orderVO.setZipNum(rs.getString("ZIP_NUM"));
				orderVO.setAddress(rs.getString("ADDRESS"));
				orderVO.setPhone(rs.getString("PHONE"));
				orderVO.setPseq(rs.getInt("PSEQ"));
				orderVO.setQuantity(rs.getInt("QUANTITY"));
				orderVO.setPname(rs.getString("PNAME"));
				orderVO.setPrice2(rs.getInt("PRICE2"));
				orderVO.setResult(rs.getString("RESULT"));
				orderList.add(orderVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return orderList;
	}
	
	
	
	//현재 진행중인 주문 내역만 조회
	public ArrayList<Integer> selectSeqOrderIng(String id){
		ArrayList<Integer> oseqList = new ArrayList<Integer>();
		String sql = "select distinct oseq from order_view "
				+ "where id=? and result='1' order by oseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				oseqList.add(rs.getInt(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return oseqList;
	}
	
	
	/*
	 * 관리자 모드에서 사용되는 메소드 * *
	 */
	
	
	
	
}
