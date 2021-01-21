<%@page import="com.dsynhub.HRIS.bean.LeaveCategoriesBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>

<!-- form start --> 
<h2>Add Leave Category</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>

<form action="LeaveCategoriesInsertServlet">
<% LeaveCategoriesBean leaveCategories= new LeaveCategoriesBean();  %>

	<table width=40%>
			<tr>          
                    <div class="form-group">
                 <td><label for="designationName">Category Name <font color=red>   *</font></label></td>
 			<td> <input type="text" class="form-control" name="category" id="category" placeholder="Enter Leave Name"  pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
 			</div>
		</tr>

<tr>
<td>&nbsp;</td>
</tr>
	
		<tr>
		<div class="form-group">
        <td><label for="designationName">Leave Per Year <font color=red>   *</font></label></td>
 		
		<td> <input type="text" name="leavesPerYear" id="leavesPerYear" class="form-control" placeholder="Enter Number Of Leaves"  maxlength=2 pattern="[0-9]+" title="Only Numbers Allowed " required autofocus></td>
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
</body>
</html>