<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.bean.DepartmentBean"%>
<%@page import="com.dsynhub.HRIS.dao.DepartmentDAO"%>

<%@page import="com.dsynhub.HRIS.bean.EmployeeBean"%>
<%@page import="com.dsynhub.HRIS.dao.EmployeeDAO"%>

<%@page import="com.dsynhub.HRIS.bean.LeaveCategoriesBean"%>
<%@page import="com.dsynhub.HRIS.dao.LeaveCategoriesDAO"%>
<%@page import="com.dsynhub.HRIS.bean.DesignationBean"%>
<%@page import="com.dsynhub.HRIS.dao.DesignationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>

<!-- form start --> 
<h2>Leave Application Form</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>

<form action="LeaveApplicationInsertServlet" role="form">

		<table width=40%>

			<tr>
			         <div class="form-group">
                 <td><label for="designationName">Employee Name <font color=red>   *</font></label></td>
			<td><select name="employeeId" class="form-control" required="required">
						<option value="">Select Employee</option>
						<%
							EmployeeDAO employeeDAO = new EmployeeDAO();
							List<EmployeeBean> employeeList = employeeDAO.list();
							for (int i = 0; i < employeeList.size(); i++) {
								EmployeeBean employeeBean = employeeList.get(i);
						%>
						<option value="<%=employeeBean.getEmployeeId()%>"><%=employeeBean.getEmployeeFirstName() + " "
						+ employeeBean.getEmployeeLastName()%></option>

						<%
							}
						%>

				</select>
				</div>
				</td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>			
			<tr>
			         <div class="form-group">
                 <td><label for="leaveName">Leave Name <font color=red>   *</font></label></td>
			<td><select name="leaveId" class="form-control" required="required">
						<option value="">Select Leave</option>
						<%
						LeaveCategoriesDAO leaveCategoryDAO = new LeaveCategoriesDAO();
							List<LeaveCategoriesBean> leavelist = leaveCategoryDAO.list();
							for (int i = 0; i < leavelist.size(); i++) {
								LeaveCategoriesBean leaveCategoriesBean = leavelist.get(i);
						%>
						<option value="<%=leaveCategoriesBean.getLeaveId()%>"><%=leaveCategoriesBean.getCategory()%></option>

						<%
							}
						%>

				</select>
				</div>
				</td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
		
			<tr>
				 <div class="form-group">
                 <td><label for="candidateFirstName">Leave Start Date <font color=red>   *</font></label></td>
                 <td><input type="text" class="form-control" placeholder="Enter Leave Start Date" name=leaveStartDate required autofocus></td>
                 </div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				 <div class="form-group">
                 <td><label for="candidateMiddleName">Leave Days <font color=red>   *</font></label></td>
               <td><input type="text" class="form-control" placeholder="Enter Leave Days" name=leaveDays pattern="[0-9]+" title="Only Numbers Allowed " required autofocus></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				 <div class="form-group">
                 <td><label for="candidateLastName">Leave Description <font color=red>   *</font></label></td>
           	<td><input type="text" class="form-control" placeholder="Enter Leave Description" name=discription required autofocus></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			
			<tr>
			 <div class="form-group">
                 <td><label for="isActive">Leave Status  <font color=red>   *</font></label></td>
        
				<td><input type="text" class="form-control" placeholder="Enter Leave Status" name=isActive required autofocus></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			
			<tr>
			 <div class="form-group">
                 <td><label for="mobileNumber">Date Of Application  <font color=red>   *</font></label></td>
        
				<td><input type="text" class="form-control" placeholder="Enter Date Of Application" name=dateOfApplication  required autofocus ></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			
			<tr>
				<div class="form-group">
                 <td><label for="candidateQualification">Date Of Last Update <font color=red>   *</font></label></td>
        
				<td><input type="text" class="form-control" placeholder="Enter Date Of Last Update" name=dateOfLastUpdate required autofocus></td>
			</tr>
			
<tr>
<td>&nbsp;</td>
</tr>
	
			<tr>
				<div class="form-group">
                 <td><label for="designtionName">Designation Name  <font color=red>   *</font></label></td>
        
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
                 <td><label for="departmentName">Department Name  <font color=red>   *</font></label></td>
        
				<td><select name="departmentId" class="form-control" required="required">
								<option value="">Select Department</option>
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
        
				<td><input type="text" class="form-control" placeholder="Enter Date Of Application" name=dateOfApplication required></td>
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