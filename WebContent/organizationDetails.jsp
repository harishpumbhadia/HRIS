<%@page import="com.dsynhub.HRIS.bean.StatusBean"%>
<%@page import="com.dsynhub.HRIS.dao.StatusDAO"%>
<%@page import="com.dsynhub.HRIS.bean.CountryBean"%>
<%@page import="com.dsynhub.HRIS.dao.CountryDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.bean.StateBean"%>
<%@page import="com.dsynhub.HRIS.dao.StateDAO"%>
<%@page import="com.dsynhub.HRIS.bean.CityBean"%>
<%@page import="com.dsynhub.HRIS.dao.CityDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>

<!-- form start --> 
<h2>Add Organization Details</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>

<form action="OrganizationDetailsInsertServlet">

	<table width=40%>
			<tr>          
                    <div class="form-group">
                 <td><label for="designationName">Organization Name <font color=red>   *</font></label></td>
  			<td><input type="text" name=organizationName class="form-control" placeholder="Enter Organization Name"  pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
			</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				         <div class="form-group">
                 <td><label for="designationName">Organization Address <font color=red>   *</font></label></td>
  		
				<td><input type="text" name=organizationAddress class="form-control" placeholder="Enter Organization Address"  required autofocus></td>
				</div>
			</tr>
			
<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
			         <div class="form-group">
                 <td><label for="designationName">City Name<font color=red>   *</font></label></td>
  		
			
			<td>
			<select name="cityId" class="form-control" required="required">
								<option value="">Select City</option>
								<%
									CityDAO cityDAO = new CityDAO();
										List<CityBean> cityList = cityDAO.list();
										for (int i = 0; i < cityList.size(); i++) {
											CityBean city = cityList.get(i);
								%>
								<option value="<%=city.getCityId()%>"><%=city.getCityName()%></option>

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
                 <td><label for="designationName">State Name <font color=red>   *</font></label></td>
  		
			
			<td>
			<select name="stateId" class="form-control" required="required">
								<option value="">Select State</option>
								<%
									StateDAO stateDAO = new StateDAO();
										List<StateBean> stateList = stateDAO.list();
										for (int i = 0; i < stateList.size(); i++) {
											StateBean state = stateList.get(i);
								%>
								<option value="<%=state.getStateId()%>"><%=state.getStateName()%></option>

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
                 <td><label for="designationName">Country Name <font color=red>   *</font></label></td>
  		
			
			<td>
			<select name="countryId" class="form-control" required="required">
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


							</select>
			</div>
			</td>
			</tr>
<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				         <div class="form-group">
                 <td><label for="designationName">Contact Number <font color=red>   *</font></label></td>
  		
			
				<td><input type="text" name=contactNo class="form-control" placeholder="Enter Contact Number"  pattern="[0-9]+" title="Only Numbers Allowed " required autofocus></td>
			</div>
			</tr>
<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				         <div class="form-group">
                 <td><label for="designationName">Email Address <font color=red>   *</font></label></td>
  		
			
				<td><input type="email" name=emailId class="form-control" placeholder="Enter Organization Email"  required autofocus></td>
			</div>
			</tr>
<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				         <div class="form-group">
                 <td><label for="designationName">Organization Web-Site <font color=red>   *</font></label></td>
  		
			
				<td><input type="text" name=website class="form-control" placeholder="Enter Organization Web-Site" required autofocus></td>
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