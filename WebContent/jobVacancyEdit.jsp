<%@page import="com.dsynhub.HRIS.bean.JobVacancyBean"%>
<%@page import="com.dsynhub.HRIS.bean.DesignationBean"%>
<%@page import="com.dsynhub.HRIS.dao.DesignationDAO"%>
<%@page import="com.dsynhub.HRIS.bean.DepartmentBean"%>
<%@page import="com.dsynhub.HRIS.dao.DepartmentDAO"%>
<%@page import="com.dsynhub.HRIS.bean.CandidateQualificationBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.dao.CandidateQualificationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>

<form action="JobVacancyUpdateServlet" method="post" name="jobVacancyPage" id="jobVacancyPage">
		<input type="hidden" name="jobVacancyId" id="jobVacancyId" value="${jobVacancyBean.vacancyId}">
		<table width=40%>

			

		<% JobVacancyBean jobVacancyBean = (JobVacancyBean)request.getAttribute("jobVacancyBean");	 %>
			<tr>
			<div class="form-group">
				<td><label for="vacancyName">Vacancy Name <font color=red>   *</font></label></td>
				<td><input type="text" class="form-control" placeholder="Enter Vacancy Name" name=vacancyName required value = "<%= jobVacancyBean.getVacancyName() %>"></td>
			</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
			<div class="form-group">
				<td><label for="description">Description <font color=red>   *</font></label></td>
				<td><textarea class="form-control" placeholder="Write Description Here...In 100 Words" name=description id="description" maxlength="100" rows="5"  value = <%= jobVacancyBean.getDescription() %> required autofocus  >${description}</textarea></td>
			</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
			<div class="form-group">
				<td><label for="noOfPositions">Number Of Position <font color=red>   *</font></label></td>
				<td><input type="text" class="form-control" placeholder="Enter Number Of Position" name=noOfPositions required value = <%= jobVacancyBean.getNoOfPositions() %>></td>
			</div>
			</tr>
			
<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
			<div class="form-group">
				<td><label for="candidateQualification">Candidate Qualification<font color=red>   *</font></label></td>
				<td>
				<select name="candidateQualificationId" class="form-control" required="required">
						<option value="0">Select Qualification</option>
								<% CandidateQualificationDAO candidateQualificationDAO = new CandidateQualificationDAO();
							List<CandidateQualificationBean> candidateQualificationList = candidateQualificationDAO.list();
							for(int i=0;i<candidateQualificationList.size();i++){
								CandidateQualificationBean candidateQualificationBean = candidateQualificationList.get(i);
							
							%>
						<option value="<%=candidateQualificationBean.getCandidateQualificationId()%>" selected="selected"><%=candidateQualificationBean.getCandidateQualificationName()%></option>
				
				<%} %>
					</div>
					</select>
				</td>
			</tr>
			
<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
			<div class="form-group">
				<td><label for="designationName">Designation Name<font color=red>   *</font></label></td>
			
			<td>
				<select name="designationId" class="form-control" required="required">
						<option value="">Select Designation</option>
								<% DesignationDAO designationDAO = new DesignationDAO();
							List<DesignationBean> deignationList = designationDAO.list();
							for(int i=0;i<deignationList.size();i++){
								DesignationBean designationBean = deignationList.get(i);
							%>
						<option value="<%=designationBean.getDesignationId()%>"><%=designationBean.getDesignationName()%></option>
				
				<%} %>
					</div>
					</select>
				</td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				 <div class="form-group">
				 <td><label for="designationName">Department Name <font color=red>   *</font></label></td>
                	<td><select name="departmentId" class="form-control" required="required">
								<option value="">Select DEPARTMENT</option>
								<%
									DepartmentDAO departmentDAO = new DepartmentDAO();
										List<DepartmentBean> departmentList = departmentDAO.list();
										for (int i = 0; i < departmentList.size(); i++) {
											DepartmentBean department = departmentList.get(i);
								%>
								<option value="<%=department.getDeptId()%>"><%=department.getDeptName()%></option>

								<%
									}
								%>

							</select></td>
</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
			<div class="form-group">
			
				<td><label for="departmentName">Select IsActive<font color=red>   *</font> </label></td>
				<td><select name="isActive" class="form-control" required="required">
						<option value=1>Yes</option>
						<option value=0>No</option>
			</div>
				</select></td>
			</tr>


<tr>
<td>&nbsp;</td>
</tr>			
			
			<tr>			
                   <td> <button type="reset" class="btn btn-warning">Reset</button></td>
                 
              
                   <td> <button type="submit" class="btn btn-success">Submit</button></td>
                 
		</tr>
		
		</table>
	</form>


</body>
</html>