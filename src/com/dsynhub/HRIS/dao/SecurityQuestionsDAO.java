package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.SecurityQuestionsBean;
import com.dsynhub.HRIS.util.DBConnection;

public class SecurityQuestionsDAO {
	
		private Connection conn=null;
		private PreparedStatement pstmt=null;
		public boolean add(SecurityQuestionsBean questionsBean)
		{
			boolean flag=false;
			conn=DBConnection.getDBConnection();
			if(conn!=null)
			{
				String insertSQL="INSERT INTO SECURITYQUESTIONS (SECURITYQUESTION) VALUES (?)";
				
				try {
					
					pstmt=conn.prepareStatement(insertSQL);
					pstmt.setString(1,questionsBean.getQuestion());
					int rowAffected=pstmt.executeUpdate();
					if(rowAffected>0)
					{
						flag=true;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			return flag;
		}
		public List<SecurityQuestionsBean> getSecurityQuestionsList() {
			List<SecurityQuestionsBean> questionList=new ArrayList<SecurityQuestionsBean>();
			conn=DBConnection.getDBConnection();
			if(conn!=null)
			{
					String selectSQL="SELECT * FROM SECURITYQUESTIONS";
					try {
						pstmt=conn.prepareStatement(selectSQL);
						ResultSet rs=pstmt.executeQuery();
						SecurityQuestionsBean questionsBean;
						while(rs.next())
						{
							questionsBean = new SecurityQuestionsBean();
							questionsBean.setQuestionId(rs.getInt("securityQuestionId"));
							questionsBean.setQuestion(rs.getString("securityQuestion"));
							questionList.add(questionsBean);
								
						}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				
					
			}
			return questionList;
			
		}
	
		public boolean delete(int securityQuestionId)
		{
			boolean result=false;
			conn=DBConnection.getDBConnection();
			if(conn!=null)
			{
					String deleteSQL="DELETE FROM SECURITYQUESTIONS WHERE SECURITYQUESTIONID=?";
					try {
						pstmt=conn.prepareStatement(deleteSQL);
						pstmt.setInt(1,securityQuestionId);
						int rowAffected=pstmt.executeUpdate();
						if(rowAffected>0)
						{
							result=true;
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
					
			}
			return result;
		}
		
		public SecurityQuestionsBean getBySecurityQuestionId(int securityQuestionId) {
			
			conn=DBConnection.getDBConnection();
			SecurityQuestionsBean questionBean=new SecurityQuestionsBean();
			if(conn!=null)
			{
				String selectSQL="SELECT * FROM SECURITYQUESTIONS WHERE SECURITYQUESTIONID=?";
				try {
					pstmt=conn.prepareStatement(selectSQL);
					pstmt.setInt(1,securityQuestionId);
					ResultSet rs=pstmt.executeQuery();
					while(rs.next())
					{
						questionBean.setQuestionId(rs.getInt("securityQuestionId"));
						questionBean.setQuestion(rs.getString("securityQuestion"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
				
			}
			return questionBean;
			
		}
		
		public boolean update(SecurityQuestionsBean questionsBean)
		{
			boolean flag=false;
			conn=DBConnection.getDBConnection();
			if(conn!=null)
			{
				String updateSQL="UPDATE SECURITYQUESTIONS SET SECURITYQUESTION=? WHERE SECURITYQUESTIONID=?";
				
				try {
					
					pstmt=conn.prepareStatement(updateSQL);
					pstmt.setString(1,questionsBean.getQuestion());
					pstmt.setInt(2,questionsBean.getQuestionId());
					int rowAffected=pstmt.executeUpdate();
					if(rowAffected>0)
					{
						flag=true;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			return flag;
		}
		
}
