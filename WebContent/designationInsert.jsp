<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.bean.DepartmentBean"%>
<%@page import="com.dsynhub.HRIS.dao.DepartmentDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>

<!-- form start --> 
<h2>Add Designation</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>

<form role="form" action="DesignationInsertServlet">
<table width=40%>
<tr>          
                    <div class="form-group">
                 <td><label for="designationName">Designation Name <font color=red>   *</font></label></td>
                  <td><input type="text" class="form-control" id="designationName" placeholder="Enter Designation Name" name="designationName" pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
                    </div>
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
                   <td> <button type="reset" class="btn btn-warning">Reset</button></td>
                 
              
                   <td> <button type="submit" class="btn btn-success">Submit</button></td>
                 
	</tr>
</table>
</form>
 
</body>
</html>