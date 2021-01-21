<%@page import="com.dsynhub.HRIS.bean.EmployeeEmergencyContactBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>

<!-- form start --> 
<h2>Update Employee Emergency Contact</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>



	<form action="EmployeeEmergencyContactUpdateServlet" name="" id="">

		<input type="hidden" name="emergencyId" id="emergencyId"
			value="${employeeEmergencyContactBean.emergencyId}">

		
			<%
				EmployeeEmergencyContactBean employeeEmergencyContactBean = (EmployeeEmergencyContactBean) request
						.getAttribute("employeeEmergencyContactBean");
			%>

			<table width=40%>
			<tr>          
                    <div class="form-group">
                 <td><label for="designationName">Contact Name <font color=red>   *</font></label></td>
	
				<td><input type="text" name=contactName placeholder="Name"
					value=<%=employeeEmergencyContactBean.getContactName()%> class="form-control" placeholder="Contact Name " pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
			</tr>
<tr>
<td>&nbsp;</td>
</tr>

				<tr>
				  <div class="form-group">
                 <td><label for="designationName">Relation  <font color=red>   *</font></label></td>
         
		
				<td><input type="text" name=relation class="form-control" placeholder="Relation " pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus
					value=<%=employeeEmergencyContactBean.getRelation()%>></td>
			</tr>
<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				           <div class="form-group">
                 <td><label for="designationName">Contact Number 1 <font color=red>   *</font></label></td>
         
				<td><input type="text" name=contactNumberOne class="form-control" placeholder="Contact Number 1" pattern="[0-9]+" title="Only Numbers Allowed " required autofocus
					value=<%=employeeEmergencyContactBean.getContactNumberOne()%>></td>
			</tr>
<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				           <div class="form-group">
                 <td><label for="designationName">Contact Number 2 <font color=red>   *</font></label></td>
         
				<td><input type="text" name=contactNumberTwo class="form-control" placeholder="Contact Number 2" pattern="[0-9]+" title="Only Numbers Allowed " required autofocus
					value=<%=employeeEmergencyContactBean.getContactNumberTwo()%>></td>
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