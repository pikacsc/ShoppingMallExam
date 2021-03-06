package com.csc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.csc.dto.QnaVO;

import utill.DBManager;

public class QnaDAO {
	private QnaDAO() {}
	
	private static QnaDAO instance = new QnaDAO();
	
	public static QnaDAO getInstance() {
		return instance;
	}
	
	public ArrayList<QnaVO> listQna(String id){
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		String sql = "select * from qna where id = ? order by qseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qnaVO = new QnaVO();
				qnaVO.setQseq(rs.getInt("qseq"));
				qnaVO.setSubject(rs.getString("subject"));
				qnaVO.setContent(rs.getString("content"));
				qnaVO.setReply(rs.getString("reply"));
				qnaVO.setId(rs.getString("id"));
				qnaVO.setRep(rs.getString("rep"));
				qnaVO.setIndate(rs.getTimestamp("indate"));
				qnaList.add(qnaVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qnaList;
	}
	
	
	public QnaVO getQna(int seq) {
		String sql = "select * from qna where qseq = ?";		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		QnaVO qnaVO = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qnaVO = new QnaVO();
				qnaVO.setQseq(rs.getInt("qseq"));
				qnaVO.setSubject(rs.getString("subject"));
				qnaVO.setContent(rs.getString("content"));
				qnaVO.setReply(rs.getString("reply"));
				qnaVO.setId(rs.getString("id"));
				qnaVO.setRep(rs.getString("rep"));
				qnaVO.setIndate(rs.getTimestamp("indate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qnaVO;
	}
	
	
	public int insertQna(QnaVO qnaVO, String session_id) {
		int result = 0;
		String sql = "insert into qna(qseq, subject, content, "
				+ " id) values(qna_seq.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qnaVO.getSubject());
			pstmt.setString(2, qnaVO.getContent());
			pstmt.setString(3, session_id);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	/**
	 * 
	 * 관리자모드에서 필요한 메소드
	 */
	
	public ArrayList<QnaVO> listAllQna(){
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		String sql = "select * from qna order by indate desc";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qnaVO = new QnaVO();
				qnaVO.setQseq(rs.getInt("qseq"));
				qnaVO.setSubject(rs.getString("subject"));
				qnaVO.setContent(rs.getString("content"));
				qnaVO.setId(rs.getString("id"));
				qnaVO.setIndate(rs.getTimestamp("indate"));
				qnaVO.setReply(rs.getString("reply"));
				qnaVO.setRep(rs.getString("rep"));
				qnaList.add(qnaVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qnaList;
	}
	
	
	public void updateQna(QnaVO qnaVO) {
		String sql = "update qna set reply = ?, rep='2' where qseq=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qnaVO.getReply());
			pstmt.setInt(2, qnaVO.getQseq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
}
