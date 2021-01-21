<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>
<h2>Update Department</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>
	<form action="DepartmentUpdateServlet" name = "departmentPage" id = "departmentPage">
	<input type="hidden" name="did" id="did" value="${department.deptId}">
		<table width=40%>
			<tr>
			  <div class="form-group">
         <td><label for="designationName">Department Name <font color=red>   *</font></label></td>
      	<td><input type="text" name="deptName" id="deptName" class="form-control" placeholder="Enter Department Name" required value="${department.deptName}">
						${deptName}
						</td>
					</div>
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
	</center>
</body>
</html>