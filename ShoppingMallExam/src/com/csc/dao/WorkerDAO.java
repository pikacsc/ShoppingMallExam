package com.csc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utill.DBManager;

public class WorkerDAO {
	private WorkerDAO() {}
	
	private static WorkerDAO instance = new WorkerDAO();
	
	public static WorkerDAO getInstance() {
		return instance;
	}
	
	
	//사용자 인증을 위한 메소드 : -1 :아이디 존재 x
	//0:아이디 존재하지만 비밀번호 불일치
	//1:아이디와 비밀번호 모두 일치
	//login.jsp -> workerCheck.jsp
	
	//아이디를 검색 조건으로 주어서 비밀번호를 얻어온다
	
	
	public int workerCheck(String userid,String userpw) {
		int result = -1;
		String sql = "select pwd from worker where id=?";
		
		//DB와 연동
		Connection conn = null;
		
		//쿼리문(select)을 수행하기 위한 문장객체
		PreparedStatement pstmt = null;
		
		//결과값을 저장할 ResultSet
		ResultSet rs = null;
		try {
			//DB연결
			conn = DBManager.getConnection();
			
			//pstmt 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			//쿼리 실행후 rs 결과값 받음
			rs = pstmt.executeQuery();
			if(rs.next()) { //전달인자로 준 아이디와 일치하는 행이 존재
				result = 0; // 등록된 관리자
				String dbPwd = rs.getString(1); //DB 저장된 비밀번호
				
				//DB 비밀번호와 입력한 비밀번호 일치여부
				if(dbPwd.equals(userpw)) {
					result = 1; //비밀번호 마저도 일치
					//로그인승인
				}
				
				//비밀번호가 안맞습니다
			} 
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
}
