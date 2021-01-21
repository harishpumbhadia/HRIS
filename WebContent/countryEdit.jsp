<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<!-- form start --> 
<h2>Update Country</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>
<body>
	
	<form action="CountryUpdateServlet" name = "countryPage" id = "countryPage">
	<input type="hidden" name="cid" id="cid" value="${country.countryId}">
	<table width=40%>
		<tr>          
             <div class="form-group">
               <td><label for="countryName">Country Name <font color=red>   *</font></label></td>
    			<td><input type="text" name="countryName" class="form-control" placeholder="Enter Country Name" id="countryName" pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus value="${country.countryName}">
						${countryName}
				</div>
						</td>
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