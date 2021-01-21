package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.DepartmentBean;
import com.dsynhub.HRIS.util.DBConnection;



public class DepartmentDAO {
	
	Connection conn = null ;
	PreparedStatement pstmt = null;
	boolean result = false ;
	ResultSet rs =  null ;
	
	
	public boolean insert(DepartmentBean departmentBean)
	{
		
		conn = DBConnection.getDBConnection();
		
		if(conn !=null)
		{
			String insertSQL = "INSERT INTO Department(departmentName) VALUES(?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, departmentBean.getDeptName());
				
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
	
	public List<DepartmentBean> list()
	{
		List<DepartmentBean> listofDepartments = new ArrayList<DepartmentBean>();
		
		conn= DBConnection.getDBConnection();
		
		if(conn!=null)
		{
			String selectSQL = "SELECT * FROM department";
			
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
					rs= pstmt.executeQuery();
			
					DepartmentBean department = null;
			
					while(rs.next())
					{
						department = new DepartmentBean();
						
						department.setDeptId(rs.getInt("departmentId"));
						department.setDeptName(rs.getString("departmentName"));
					
				
			listofDepartments.add(department);
			}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Size : "+listofDepartments.size());
		return listofDepartments ;
	}
	public boolean delete(int deptId) {
		
		conn = DBConnection.getDBConnection();
		
		if(conn!=null)
		{
			String deleteSQL = "DELETE FROM department WHERE departmentId= ?";
			
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setInt(1, deptId);
				
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
		
	
	public DepartmentBean getByPK(int deptId) {
		
		conn = DBConnection.getDBConnection();
		
		DepartmentBean department = new DepartmentBean();
		if(conn != null)
		{
			String selectSQL = "SELECT * FROM department WHERE departmentId = ? ";
			
			try {
				pstmt = conn.prepareStatement(selectSQL);
				
				pstmt.setInt(1, deptId);
				
				rs = pstmt.executeQuery();
				

				
				while(rs.next()){
					 
				
					department.setDeptId(deptId);
					department.setDeptName(rs.getString(2));
					System.out.println("deptId    " + deptId);
					
				}
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}
		
		return department ; 
	}
	public boolean update(DepartmentBean departmentBean) {
		
		
		conn = DBConnection.getDBConnection();
		
		
		
		 if(conn!=null){
			 String updateSQL = "UPDATE department set departmentName=? WHERE departmentId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,departmentBean.getDeptName());
				pstmt.setInt(2,departmentBean.getDeptId());
				
				
				 System.out.println(updateSQL);
				 System.out.println(departmentBean.getDeptId());
				 System.out.println(departmentBean.getDeptName());
				 
				 
					
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
