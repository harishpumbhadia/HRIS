package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.EmployeeBean;
import com.dsynhub.HRIS.util.DBConnection;

public class EmployeeDAO {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	boolean result = false;

	public boolean insert(EmployeeBean employeeBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO EMPLOYEE(employeeFirstName , employeeMiddleName , employeeLastName, dateOfBirth , Gender , maratialStatus ,currentAddress ,cityId , stateId , countryId ,  mobileNumber , postalCode , email  , departmentId , designationId , employmentStatusID , joiningDate , securityQuestionId , securityAnswer,password ) VALUES(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,md5(?))";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, employeeBean.getEmployeeFirstName());
				pstmt.setString(2, employeeBean.getEmployeeMiddleName());
				pstmt.setString(3, employeeBean.getEmployeeLastName());
				pstmt.setString(4, employeeBean.getDateOfBirth());
				pstmt.setString(5, employeeBean.getGender());
				pstmt.setString(6, employeeBean.getMaratialStatus());
				pstmt.setString(7, employeeBean.getCurrentAddress());
				pstmt.setInt(8, employeeBean.getCityId());
				pstmt.setInt(9, employeeBean.getStateId());
				pstmt.setInt(10, employeeBean.getCountryId());
				pstmt.setString(11, employeeBean.getMobileNumber());
				pstmt.setString(12, employeeBean.getPostalCode());
				pstmt.setString(13, employeeBean.getEmail());
				pstmt.setInt(14, employeeBean.getDepartmentId());
				pstmt.setInt(15, employeeBean.getDesignationId());
				pstmt.setInt(16, employeeBean.getEmploymentStatusId());
				pstmt.setString(17, employeeBean.getJoiningDate());
				pstmt.setInt(18, employeeBean.getSecurityQuestionId());
				pstmt.setString(19, employeeBean.getSecurityAnswer());
				pstmt.setString(20, employeeBean.getPassword());

				
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 0) {

					System.out.println("Not Inserted");
				}

				else {
					result = true;
					System.out.println("Inserted");
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			System.out.println("Check Connection");
		}

		return result;

	}

	public List<EmployeeBean> list() {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "select e.employeeID ,  e.employeeFirstName , e.employeeMiddleName , e.employeeLastName , e.dateOfBirth , e.gender , e.maratialStatus , e.currentAddress , e.cityId , e.stateId , e . countryId , e.mobileNumber , e.postalCode ,   e.email ,  e.departmentId , e.designationId , e.employmentStatusId , e.joiningDate , e.securityQuestionId , e.securityAnswer , ci.cityName , sta.stateName , co.countryName , dept.departmentName , desig.designationName , st.status , sc.securityQuestion from employee e ,city ci , state sta , country co ,  Department dept , designation desig , status st , securityQuestions sc  where  e.departmentId = dept.departmentId and e.designationId = desig.designationId and e.cityId = ci.cityId and sta.stateId = e.stateId and e.countryId = co.countryId And st.statusId = e.employmentStatusId and e.securityQuestionId = sc.securityQuestionId  ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				EmployeeBean employeeBean = null;

				while (rs.next()) {
					employeeBean = new EmployeeBean();

					employeeBean.setEmployeeId(rs.getInt("employeeId"));
					employeeBean.setEmployeeFirstName(rs.getString("employeeFirstName"));
					employeeBean.setEmployeeMiddleName(rs.getString("employeeMiddleName"));
					employeeBean.setEmployeeLastName(rs.getString("employeeLastName"));
					employeeBean.setDateOfBirth(rs.getString("dateOfBirth"));
					employeeBean.setGender(rs.getString("gender"));
					employeeBean.setMaratialStatus(rs.getString("maratialStatus"));
					employeeBean.setCurrentAddress(rs.getString("currentAddress"));
					employeeBean.setCityId(rs.getInt("cityId"));
					employeeBean.setCityName(rs.getString("cityName"));
					employeeBean.setStateId(rs.getInt("stateId"));
					employeeBean.setStateName(rs.getString("stateName"));
					employeeBean.setCountryId(rs.getInt("CountryId"));
					employeeBean.setCountryName(rs.getString("countryName"));
					employeeBean.setMobileNumber(rs.getString("mobileNumber"));
					employeeBean.setPostalCode(rs.getString("postalCode"));
					employeeBean.setEmail(rs.getString("email"));
					employeeBean.setDepartmentId(rs.getInt("departmentId"));
					employeeBean.setDepartmentName(rs.getString("departmentName"));
					employeeBean.setDesignationId(rs.getInt("designationId"));
					employeeBean.setDesignationName(rs.getString("designationName"));
					employeeBean.setEmploymentStatusId(rs.getInt("employmentStatusId"));
					employeeBean.setStatusName(rs.getString("status"));
					employeeBean.setJoiningDate(rs.getString("joiningdate"));
					employeeBean.setSecurityQuestionId(rs.getInt("securityQuestionId"));
					employeeBean.setSecurityQuestion(rs.getString("securityQuestion"));
					employeeBean.setSecurityAnswer(rs.getString("securityAnswer"));
			
					listofEmployee.add(employeeBean);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return listofEmployee;
	}

	public boolean delete(int employeeID) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM EMPLOYEE WHERE employeeId= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, employeeID);

				int rowAffected = pstmt.executeUpdate();

				if (rowAffected > 0)
					result = true;

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			System.out.println("Network Error");
		}
		return result;
	}

	public EmployeeBean getByPK(int employeeId) {

		conn = DBConnection.getDBConnection();

		EmployeeBean employeeBean = new EmployeeBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM Employee WHERE employeeID = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, employeeId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					employeeBean.setEmployeeId(rs.getInt("employeeId"));
					employeeBean.setEmployeeFirstName(rs.getString("employeeFirstName"));
					employeeBean.setEmployeeMiddleName(rs.getString("employeeMiddleName"));
					employeeBean.setEmployeeLastName(rs.getString("employeeLastName"));
					employeeBean.setDateOfBirth(rs.getString("dateOfBirth"));
					employeeBean.setGender(rs.getString("gender"));
					employeeBean.setMaratialStatus(rs.getString("maratialStatus"));
					employeeBean.setCurrentAddress(rs.getString("currentAddress"));
					employeeBean.setCityId(rs.getInt("cityId"));
					employeeBean.setStateId(rs.getInt("stateId"));
					employeeBean.setCountryId(rs.getInt("CountryId"));
					employeeBean.setMobileNumber(rs.getString("mobileNumber"));
					employeeBean.setPostalCode(rs.getString("postalCode"));
					employeeBean.setEmail(rs.getString("email"));
					employeeBean.setDepartmentId(rs.getInt("departmentId"));
					employeeBean.setDesignationId(rs.getInt("designationId"));
					employeeBean.setEmploymentStatusId(rs.getInt("employmentStatusId"));
					employeeBean.setJoiningDate(rs.getString("joiningdate"));
					employeeBean.setSecurityQuestionId(rs.getInt("securityQuestionId"));
					employeeBean.setSecurityAnswer(rs.getString("securityAnswer"));
			

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return employeeBean;
	}

	public boolean update(EmployeeBean employeeBean) {

		conn = DBConnection.getDBConnection();

		// DesignationBean designationBean = new DesignationBean();

		if (conn != null) {
			String updateSQL = "UPDATE Employee set employeeFirstName=?,employeeMiddleName=? ,employeeLastName=? ,dateOfBirth = ? , Gender = ? , maratialStatus = ? ,currentAddress = ? , cityId = ? ,stateId = ? ,countryId = ? , mobileNumber = ? ,postalCode = ? , email = ? , departmentId = ? , designationId = ? , employmentStatusId = ? , joiningDate = ?  WHERE employeeId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, employeeBean.getEmployeeFirstName());
				pstmt.setString(2, employeeBean.getEmployeeMiddleName());
				pstmt.setString(3, employeeBean.getEmployeeLastName());
				pstmt.setString(4, employeeBean.getDateOfBirth());
				pstmt.setString(5, employeeBean.getGender());
				pstmt.setString(6, employeeBean.getMaratialStatus());
				pstmt.setString(7, employeeBean.getCurrentAddress());
				pstmt.setInt(8, employeeBean.getCityId());
				pstmt.setInt(9, employeeBean.getStateId());
				pstmt.setInt(10, employeeBean.getCountryId());
				pstmt.setString(11, employeeBean.getMobileNumber());
				pstmt.setString(12, employeeBean.getPostalCode());
				pstmt.setString(13, employeeBean.getEmail());
				pstmt.setInt(14, employeeBean.getDepartmentId());
				pstmt.setInt(15, employeeBean.getDesignationId());
				pstmt.setInt(16, employeeBean.getEmploymentStatusId());
				pstmt.setString(17, employeeBean.getJoiningDate());
				pstmt.setInt(18, employeeBean.getEmployeeId());
		
				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {

					System.out.println(rowsAffected + " Row(s) Updated......");
					result = true;
				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");
					result = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	public static boolean login(String email, String password, int departmentId) {
		
		boolean result = false ;
		
		conn = DBConnection.getDBConnection();
		
		EmployeeBean employeeBean = new EmployeeBean();
		
		if (conn != null) {
			String selectSQL = "Select * from employee WHERE email =? AND md5(password)=? And departmentId = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, email);
				pstmt.setString(2, password);
				pstmt.setInt(3,departmentId);

				System.out.println("E mail " + email);
				System.out.println("Password" + password);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					employeeBean.setEmployeeId(rs.getInt("employeeId"));
					employeeBean.setEmployeeFirstName(rs.getString("employeeFirstName"));
					employeeBean.setEmployeeMiddleName(rs.getString("employeeMiddleName"));
					employeeBean.setEmployeeLastName(rs.getString("employeeLastName"));
					employeeBean.setDateOfBirth(rs.getString("dateOfBirth"));
					employeeBean.setGender(rs.getString("gender"));
					employeeBean.setMaratialStatus(rs.getString("maratialStatus"));
					employeeBean.setCurrentAddress(rs.getString("currentAddress"));
					employeeBean.setCityId(rs.getInt("cityId"));
					employeeBean.setStateId(rs.getInt("stateId"));
					employeeBean.setCountryId(rs.getInt("CountryId"));
					employeeBean.setMobileNumber(rs.getString("mobileNumber"));
					employeeBean.setPostalCode(rs.getString("postalCode"));
					employeeBean.setEmail(rs.getString("email"));
					employeeBean.setDepartmentId(rs.getInt("departmentId"));
					employeeBean.setDesignationId(rs.getInt("designationId"));
					employeeBean.setEmploymentStatusId(rs.getInt("employmentStatusId"));
					employeeBean.setJoiningDate(rs.getString("joiningdate"));
					employeeBean.setSecurityQuestionId(rs.getInt("securityQuestionId"));
					employeeBean.setSecurityAnswer(rs.getString("securityAnswer"));
					
					result = true ;

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
		
		return result;
	}

}
