<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.bean.CountryBean"%>
<%@page import="com.dsynhub.HRIS.dao.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>

<!-- form start --> 
<h2>Add State</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>

	<form action="StateInsertServlet">

	<table width=40%>
		<tr>          
             <div class="form-group">
               <td><label for="stateName">State Name <font color=red>   *</font></label></td>
     		<td><input type="text" name="stateName" class="form-control" placeholder="Enter State Name" id="stateName" pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				 <div class="form-group">
				 <td><label for="designationName">Country Name <font color=red>   *</font></label></td>
               
				<td><select name="countryId" class="form-control" required="required">
								<option value="">Select Country</option>
								<%
								CountryDAO countryDAO = new CountryDAO();
										List<CountryBean> countryList = countryDAO.list();
										for (int i = 0; i < countryList.size(); i++) {
											CountryBean country = countryList.get(i);
								%>
								<option value="<%=country.getCountryId()%>"><%=country.getCountryName()%></option>

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
                   <td> <button type="reset" class="btn btn-warning">Reset</button></td>
                 
              
                   <td> <button type="submit" class="btn btn-success">Submit</button></td>
                 
	</tr>

		</table>
	</form>
</body>
</html>