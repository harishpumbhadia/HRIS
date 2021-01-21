package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.StateBean;
import com.dsynhub.HRIS.util.DBConnection;

public class StateDAO {
	
	Connection conn = null ;
	PreparedStatement pstmt = null;
	boolean result = false ;
	ResultSet rs =  null ;
	
	
	public boolean insert(StateBean stateBean)
	{
		
		conn = DBConnection.getDBConnection();
		
		if(conn !=null)
		{
			String insertSQL = "INSERT INTO state(countryId,stateName) VALUES(?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setInt(1, stateBean.getCountryId());
				pstmt.setString(2, stateBean.getStateName());
				
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected == 0)
				{
					
					System.out.println("Not Inserted");
				}
				
				else
				{
					result=true;
					System.out.println("Inserted");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		else
		{
			System.out.println("Check Connection");
		}
		
		return result;
		
	}
	
	public List<StateBean> list()
	{
		List<StateBean> listofStates = new ArrayList<StateBean>();
		
		conn= DBConnection.getDBConnection();
		
		if(conn!=null)
		{
			String selectSQL = "select s.stateId, s.stateName,c.countryId,c.countryName from state s, country c where s.countryId=c.countryId ";
			//String selectSQL="select * from state";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
					rs= pstmt.executeQuery();
			
					StateBean state = null;
			
					while(rs.next())
					{
						state = new StateBean();
						
						state.setStateId(rs.getInt("stateId"));
						state.setCountryId(rs.getInt("countryId"));
						state.setStateName(rs.getString("stateName"));
						state.setCountryName(rs.getString("countryName"));
				
			listofStates.add(state);
			}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Size : "+listofStates.size());
		return listofStates ;
	}
	public boolean delete(int stateId) {
		
		conn = DBConnection.getDBConnection();
		
		if(conn!=null)
		{
			String deleteSQL = "DELETE FROM state WHERE stateId= ?";
			
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setInt(1, stateId);
				
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected > 0 )
					result = true ;
				
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else
		{
			System.out.println("Network Error");
		}
		return result;
	}
		
	
	public StateBean getByPK(int stateId) {
		
		conn = DBConnection.getDBConnection();
		
		StateBean state = new StateBean();
		if(conn != null)
		{
			String selectSQL = "SELECT * FROM state WHERE stateId = ? ";
			
			try {
				pstmt = conn.prepareStatement(selectSQL);
				
				pstmt.setInt(1, stateId);
				
				rs = pstmt.executeQuery();
				

				
				while(rs.next()){
					 
				
					state.setStateId(rs.getInt("stateId"));
					state.setCountryId(rs.getInt("countryId"));
					state.setStateName(rs.getString("stateName"));
					System.out.println("stateId    " + stateId);
					
				}
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}
		
		return state ; 
	}
	public boolean update(StateBean stateBean) {
		
		
		conn = DBConnection.getDBConnection();
		
		
		
		 if(conn!=null){
			 String updateSQL = "UPDATE state set stateName=?,countryId=? WHERE stateId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,stateBean.getStateName());
				pstmt.setInt(2,stateBean.getCountryId());
				pstmt.setInt(3,stateBean.getStateId());
				
				
				 System.out.println(updateSQL);
				 System.out.println(stateBean.getStateId());
				 System.out.println(stateBean.getCountryId());
				 System.out.println(stateBean.getStateName());
				 
				 
					
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					
					System.out.println(rowsAffected + " Row(s) Updated......");
					result=true;
				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");
					result = false ;
				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;

	}


}
