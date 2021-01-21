<%@page import="com.dsynhub.HRIS.bean.StatusBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>



<body>

<h2>Update Status</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>

<%

	StatusBean b1=(StatusBean)request.getAttribute("b1");

	if(b1!=null)
	{
%>

<form action="StatusUpdateServlet">
<table width=40%>
	<tr>
	<td><input type="hidden" name="statusId" value="<%=b1.getStatusId()%>" ></td>
	</tr>
	 

		<tr>
		  <div class="form-group">
         <td><label for="statusName">Status Name <font color=red>   *</font></label></td>
   	<td><input type="text" name="status" value="<%=b1.getStatusName()%>" class="form-control" placeholder="Enter status Name" pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus ></td>
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
<%
	}
%>
</body>
</html>