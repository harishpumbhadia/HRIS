<%@page import="com.dsynhub.HRIS.bean.EmployeeQualificationBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.bean.EmployeeBean"%>
<%@page import="com.dsynhub.HRIS.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>

<!-- form start --> 
<h2>Update Employee Qualification</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>

	<form action="EmployeeQualificationUpdateServlet">

		<table width=40%>

			<%
				EmployeeQualificationBean employeeQualificationBean = (EmployeeQualificationBean) request
						.getAttribute("employeeQualificationBean");
			%>
		<input type="hidden" name="employeeQualificationId" id="employeeQualificationId" value="${employeeQualificationBean.employeeQualificationId}">

			<tr>
				    <div class="form-group">
                 <td><label for="designationName">Qualification Name <font color=red>   *</font></label></td>
           
				<td><input type="text" name=qualificationName class="form-control" placeholder="Enter Qualification Name"   pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus
					value=<%=employeeQualificationBean.getQualificaionName()%>></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				    <div class="form-group">
                 <td><label for="designationName">Institute Name <font color=red>   *</font></label></td>
               
				<td><input type="text" name=institute class="form-control" placeholder="Enter Institue Name"   pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus
					value=<%=employeeQualificationBean.getInstitute()%>></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
					    <div class="form-group">
                 <td><label for="designationName">Date Of Completion <font color=red>   *</font></label></td>
              
				<td><input type="text" name=dateOfCompletion class="form-control" placeholder="Enter Date Of Completition"  required autofocus
					value=<%=employeeQualificationBean.getDateOfCompletion()%>></td>
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