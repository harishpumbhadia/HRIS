<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>

<h2>Add Status</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>
	<form action="StatusInsertServlet">


	<table width=40%>
		<tr>
		  <div class="form-group">
         <td><label for="statusName">Status Name <font color=red>   *</font></label></td>
   			<td><input type="text" name="status" id="status" class="form-control" placeholder="Enter status Name" pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
				<td>${status}</td>
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