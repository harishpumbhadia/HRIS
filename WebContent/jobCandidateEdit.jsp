<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.bean.DepartmentBean"%>
<%@page import="com.dsynhub.HRIS.dao.DepartmentDAO"%>
<%@page import="com.dsynhub.HRIS.bean.DesignationBean"%>
<%@page import="com.dsynhub.HRIS.dao.DesignationDAO"%>
<%@page import="com.dsynhub.HRIS.bean.JobCandidateBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<!-- form start --> 
<h2>Update Candidate Application Form</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>
<body>

<form action="JobCandidateUpdateServlet" name="jobCandidatePage" id = "jobCandidatePage" role="form"> 

<input type="hidden" name="candidateId" id="candidateId" value="${jobCandidateBean.cadidateId}">
		
	
		<table width=40%>

		<% JobCandidateBean jobCandidateBean = (JobCandidateBean)request.getAttribute("jobCandidateBean");	 %>
		

			<tr>
				 <div class="form-group">
                 <td><label for="candidateFirstName">Candidate First Name <font color=red>   *</font></label></td>
              
				<td><input type="text" class="form-control" placeholder="Enter First Name"  name=candidateFirstName required value = <%= jobCandidateBean.getCandidateFirstName() %>></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>


			<tr>
					 <div class="form-group">
                 <td><label for="candidateMiddleName">Candidate Middle Name <font color=red>   *</font></label></td>
               	<td><input type="text" class="form-control" placeholder="Enter Middle Name" name=candidateMiddleName required value = <%= jobCandidateBean.getCandidateMiddleName() %> ></td>
			</tr>
			
<tr>
<td>&nbsp;</td>
</tr>

			
			<tr>
				 <div class="form-group">
                 <td><label for="candidateLastName">Candidate Last Name <font color=red>   *</font></label></td>
           		<td><input type="text" class="form-control" placeholder="Enter Last Name" name=candidateLastName required value = <%= jobCandidateBean.getCandidateLastName() %>></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			
			<tr>
				 <div class="form-group">
                 <td><label for="email">Candidate E-mail  <font color=red>   *</font></label></td>
      			<td><input type="text" class="form-control" placeholder="Enter Email" name=email required value = <%= jobCandidateBean.getEmail()%>></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			
			<tr>
				 <div class="form-group">
                 <td><label for="mobileNumber">Candidate Mobile Number  <font color=red>   *</font></label></td>
        		<td><input type="text" class="form-control" placeholder="Enter Mobile Number" name=mobileNumber required value = <%= jobCandidateBean.getMobileNumber()%>></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

		
			<tr>
					<div class="form-group">
                 <td><label for="candidateQualification">Candidate Qualification  <font color=red>   *</font></label></td>
        		<td><input type="text" class="form-control" placeholder="Enter Qualifiction" name=candidateQualification required value = <%= jobCandidateBean.getCandidateQualification()%>></td>
				</div>
			</tr>
<tr>
<td>&nbsp;</td>
</tr>

		
		
			<tr>
				<div class="form-group">
                 <td><label for="designtionName">Designation Name  <font color=red>   *</font></label></td>
        		</div>
        	
			<td>
				<select name="designationId" class="form-control" required="required">
						<option value="0">Select</option>
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
                 <td><label for="departmentName">Department Name  <font color=red>   *</font></label></td>
        
				<td><select name="departmentId" class="form-control" required="required">
								<option value="0">DEPARTMENT</option>
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
							</div>
							</select></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>


			<tr>
				<div class="form-group">
                 <td><label for="dateOfApplication">Date Of Application   <font color=red>   *</font></label></td>
        		<td><input type="text" class="form-control" placeholder="Enter Date Of Application" name=dateOfApplication required value = <%= jobCandidateBean.getDateOfApplication()%>></td>
				</div>
			</tr>
			
<tr>
<td>&nbsp;</td>
</tr>


			<tr>
				<div class="form-group">
                 <td><label for="isActive">Is Active   <font color=red>   *</font></label></td>
        
				<td><select name="isActive" class="form-control" required="required">
				<option value="">Select Status</option>
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