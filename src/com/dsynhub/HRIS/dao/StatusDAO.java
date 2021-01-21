package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.StatusBean;
import com.dsynhub.HRIS.util.DBConnection;

public class StatusDAO {
	
	
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(StatusBean b1){
		 conn=DBConnection.getDBConnection();
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO status(status) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, b1.getStatusName());
				
				
				
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
				//Close Connection
			}
			 
		 }
		
		return result;
	}
	
	


	   public  List<StatusBean> list(){
		
		List<StatusBean> listofStatus = new ArrayList<StatusBean>();
		 conn=DBConnection.getDBConnection();
			
		 if(conn!=null){
			 String selectSQL = "Select * from status";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				StatusBean b1=null;
				
				while(rs.next()){
					b1=new StatusBean();
				
					b1.setStatusId(rs.getInt("statusId"));
					b1.setStatusName(rs.getString("status"));
					
					
					
					
					listofStatus.add(b1);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listofStatus.size());
		return listofStatus;
	}




	   public boolean delete(int statusId){
		   
		  
			 conn=DBConnection.getDBConnection();
				
			 if(conn!=null){
				 String deleteSQL = "DELETE FROM status WHERE statusId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setInt(1,statusId);
					
					System.out.println(deleteSQL);
					int rowsAffected = pstmt.executeUpdate();
					
					if (rowsAffected > 0) {
						result=true;

					} else {
						//System.out.println(rowsAffected + " Row(s) Inserted......");

					}
				 } catch (SQLException e) {
					e.printStackTrace();
				}finally{
					
					//Close Connection
				}
				 
			 }
			
			return result;
		}

	
	   public StatusBean getByPK(int statusId) {
			
			conn=DBConnection.getDBConnection();
			StatusBean b1=new StatusBean();
			if(conn!=null)
			{
				String selectSQL="SELECT * FROM status WHERE statusId=?";
				try {
					pstmt=conn.prepareStatement(selectSQL);
					
					pstmt.setInt(1,statusId);
					rs=pstmt.executeQuery();
					while (rs.next()) {


						b1.setStatusId(rs.getInt("statusId"));
						b1.setStatusName(rs.getString("status"));
						
						
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
			return b1;
		}
		


	   public boolean update(StatusBean b1) {
			boolean result=false;
			conn=DBConnection.getDBConnection();
			if(conn!=null)
			{
				try {
					String updateSQL="UPDATE status SET status=? WHERE statusId=?";
				
					pstmt=conn.prepareStatement(updateSQL);
					
					pstmt.setString(1,b1.getStatusName());
					pstmt.setInt(2, b1.getStatusId());
					
					
					int rowAffected=pstmt.executeUpdate();
					
					System.out.println("Row Affected=="+b1.getStatusId());
					System.out.println(updateSQL);
					if(rowAffected>0)
					{
						result=true;
						System.out.println(rowAffected+"Row(s) Updated");
					}
					else
					{

						System.out.println(rowAffected+"Row(s) Updated");
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return result;
			

		}



}
