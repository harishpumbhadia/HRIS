package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.JobVacancyBean;
import com.dsynhub.HRIS.util.DBConnection;

public class JobVacancyDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public boolean insert(JobVacancyBean jobVacancyBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO JobVacancy(vacancyName , description , noOfPositions , candidateQualificationId , departmentId , designationId , isActive) VALUES(?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, jobVacancyBean.getVacancyName());
				pstmt.setString(2, jobVacancyBean.getDescription());
				pstmt.setInt(3, jobVacancyBean.getNoOfPositions());
				pstmt.setInt(4, jobVacancyBean.getCandidateQualificationId());
				pstmt.setInt(5, jobVacancyBean.getDepartmentId());
				pstmt.setInt(6, jobVacancyBean.getDesignationId());
				pstmt.setInt(7, jobVacancyBean.getIsActive());

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

	public List<JobVacancyBean> list() {
		List<JobVacancyBean> listofJobVacancy = new ArrayList<JobVacancyBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "select v.vacancyId , v.vacancyName , v.description , v.noOfPOsitions , c.candidateQualificationId ,c.candidateQualificationName , dept.departmentId ,dept.departmentName, desig.designationId ,desig.designationName, v.isActive from JobVacancy v , Department dept , CandidateQualification c , designation desig where v.candidateQualificationID = c.candidateQualificationId and v.departmentId = dept.departmentId and v.designationId = desig.designationId ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				JobVacancyBean jobVacancyBean = null;

				while (rs.next()) {
					jobVacancyBean = new JobVacancyBean();

					jobVacancyBean.setVacancyId(rs.getInt("vacancyId"));
					jobVacancyBean.setVacancyName(rs.getString("vacancyName"));
					jobVacancyBean.setDescription(rs.getString("Description"));
					jobVacancyBean.setNoOfPositions(rs.getInt("noOfPositions"));
					jobVacancyBean.setCandidateQualificationId(rs.getInt("candidateQualificationId"));
					jobVacancyBean.setCandidateQualificationName(rs.getString("candidateQualificationName"));
					jobVacancyBean.setDesignationId(rs.getInt("designationId"));
					jobVacancyBean.setDepartmentId(rs.getInt("departmentid"));
					jobVacancyBean.setDesignationName(rs.getString("designationName"));
					jobVacancyBean.setDepartmentName(rs.getString("departmentName"));
					jobVacancyBean.setIsActive(rs.getInt("isActive"));

					listofJobVacancy.add(jobVacancyBean);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return listofJobVacancy;
	}

	public boolean delete(int jobVacancyId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM JobVacancy WHERE vacancyId= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, jobVacancyId);

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

	public JobVacancyBean getByPK(int jobVacancyId) {

		conn = DBConnection.getDBConnection();

		JobVacancyBean jobVacancyBean = new JobVacancyBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM JobVacancy WHERE VacancyId = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, jobVacancyId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					jobVacancyBean.setVacancyId(rs.getInt("vacancyId"));
					jobVacancyBean.setVacancyName(rs.getString("vacancyName"));
					jobVacancyBean.setDescription(rs.getString("Description"));
					jobVacancyBean.setNoOfPositions(rs.getInt("noOfPositions"));
					jobVacancyBean.setCandidateQualificationId(rs.getInt("candidateQualificationId"));
					jobVacancyBean.setDesignationId(rs.getInt("designationId"));
					jobVacancyBean.setDepartmentId(rs.getInt("departmentid"));
					jobVacancyBean.setIsActive(rs.getInt("isActive"));
					

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return jobVacancyBean;
	}

	public boolean update(JobVacancyBean jobVacancyBean) {

		conn = DBConnection.getDBConnection();

		// DesignationBean designationBean = new DesignationBean();

		if (conn != null) {
			String updateSQL = "UPDATE JobVacancy set vacancyName=?,description=? , noOfPositions = ? , candidateQualificationId = ? , departmentId = ? , designationId = ? , isActive = ?  WHERE VacancyId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, jobVacancyBean.getVacancyName());
				pstmt.setString(2, jobVacancyBean.getDescription());
				pstmt.setInt(3, jobVacancyBean.getNoOfPositions());
				pstmt.setInt(4, jobVacancyBean.getCandidateQualificationId());
				pstmt.setInt(5, jobVacancyBean.getDepartmentId());
				pstmt.setInt(6, jobVacancyBean.getDesignationId());
				pstmt.setInt(7, jobVacancyBean.getIsActive());
				pstmt.setInt(8, jobVacancyBean.getVacancyId());
				

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

}
