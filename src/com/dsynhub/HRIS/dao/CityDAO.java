package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.CityBean;
import com.dsynhub.HRIS.util.DBConnection;

public class CityDAO {
	
	Connection conn = null ;
	PreparedStatement pstmt = null;
	boolean result = false ;
	ResultSet rs =  null ;
	
	
	public boolean insert(CityBean cityBean)
	{
		
		conn = DBConnection.getDBConnection();
		
		if(conn !=null)
		{
			String insertSQL = "INSERT INTO city(stateId,cityName) VALUES(?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setInt(1, cityBean.getStateId());
				pstmt.setString(2, cityBean.getCityName());
				
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
	
	public List<CityBean> list()
	{
		List<CityBean> listofCity = new ArrayList<CityBean>();
		
		conn= DBConnection.getDBConnection();
		
		if(conn!=null)
		{
			String selectSQL = "select c.cityId, c.cityName,s.stateid, s.stateName from city c, state s where c.stateid=s.stateid ";
			
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
					rs= pstmt.executeQuery();
			
					CityBean city = null;
			
					while(rs.next())
					{
						city = new CityBean();
						
						city.setCityId(rs.getInt("cityId"));
						city.setStateId(rs.getInt("stateid"));
						city.setCityName(rs.getString("cityName"));
						city.setStateName(rs.getString("stateName"));
				
			listofCity.add(city);
			}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Size : "+listofCity.size());
		return listofCity ;
	}
	public boolean delete(int cityId) {
		
		conn = DBConnection.getDBConnection();
		
		if(conn!=null)
		{
			String deleteSQL = "DELETE FROM city WHERE cityId= ?";
			
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setInt(1, cityId);
				
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
		
	
	public CityBean getByPK(int cityId) {
		
		conn = DBConnection.getDBConnection();
		
		CityBean city = new CityBean();
		if(conn != null)
		{
			String selectSQL = "SELECT * FROM city WHERE cityId = ? ";
			
			try {
				pstmt = conn.prepareStatement(selectSQL);
				
				pstmt.setInt(1, cityId);
				
				rs = pstmt.executeQuery();
				

				
				while(rs.next()){
					 
				
					city.setCityId(rs.getInt("cityId"));
					city.setStateId(rs.getInt("stateId"));
					city.setCityName(rs.getString("cityName"));
					System.out.println("cityId    " + cityId);
					
				}
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}
		
		return city ; 
	}
	public boolean update(CityBean cityBean) {
		
		
		conn = DBConnection.getDBConnection();
		
		
		
		 if(conn!=null){
			 String updateSQL = "UPDATE city set cityName=?,stateId=? WHERE cityId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,cityBean.getCityName());
				pstmt.setInt(2,cityBean.getStateId());
				pstmt.setInt(3,cityBean.getCityId());
				
				
				 System.out.println(updateSQL);
				 System.out.println(cityBean.getCityId());
				 System.out.println(cityBean.getStateId());
				 System.out.println(cityBean.getCityName());
				 
				 
					
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
