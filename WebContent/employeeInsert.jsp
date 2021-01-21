<%@page import="com.dsynhub.HRIS.bean.DepartmentBean"%>
<%@page import="com.dsynhub.HRIS.dao.DepartmentDAO"%>
<%@page import="com.dsynhub.HRIS.dao.SecurityQuestionsDAO"%>
<%@page import="com.dsynhub.HRIS.bean.SecurityQuestionsBean"%>
<%@page import="com.dsynhub.HRIS.bean.StatusBean"%>
<%@page import="com.dsynhub.HRIS.dao.StatusDAO"%>
<%@page import="com.dsynhub.HRIS.bean.DesignationBean"%>
<%@page import="com.dsynhub.HRIS.dao.DesignationDAO"%>
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

<h2>Add Employee</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>



<form action="EmployeeInsertServlet">

		<table width=40%>
		<tr>
		  <div class="form-group">
        		 <td><label for="designationName">Employee First Name <font color=red>   *</font></label></td>
     			<td><input type="text" name=employeeFirstName class="form-control" placeholder="Enter First Name"  pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
			</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Employee Middle Name <font color=red>   *</font></label></td>
     	
				<td><input type="text" name=employeeMiddleName class="form-control" placeholder="Enter Middle Name"  pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Employee Last Name <font color=red>   *</font></label></td>
     	
				<td><input type="text" name=employeeLastName class="form-control" placeholder="Enter Last Name"  pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Employee Birth - Date <font color=red>   *</font></label></td>
     	
				<td><input type="text" name=dateOfBirth class="form-control" placeholder="Enter Birth-Date"   required autofocus></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Employee Gender  <font color=red>   *</font></label></td>
     	
				<td><input type="radio" id="inputgender" name="gender" value="Male"
								checked>MALE <input type="radio" id="inputgender"
								name="gender" value="Female">FEMALE</td>
								</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Employee Maratial Status <font color=red>   *</font></label></td>
     	
				<td><input type="radio" id="inputgender" name="maratialStatus" value="Married"
								checked>Married <input type="radio" id="inputgender"
								name="maratialStatus" value="UnMarried">UnMarraied</td>
								</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Employee Address <font color=red>   *</font></label></td>
     	
				<td><input type="text" name=currentAddress class="form-control" placeholder="Enter Address"  pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
				</div>
			</tr>
			
<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
			  <div class="form-group">
        		 <td><label for="designationName">City Name <font color=red>   *</font></label></td>
     	
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
        		 <td><label for="designationName">Mobile Number <font color=red>   *</font></label></td>
     	
				<td><input type="text" name=mobileNumber class="form-control" placeholder="Enter Mobile Number"  pattern="[0-9]+" title="Only Alphabates Allowed " required autofocus></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Postal Code <font color=red>   *</font></label></td>
     	
				<td><input type="text" name=postalCode class="form-control" placeholder="Enter Postal Code"  pattern="[0-9]+" title="Only Alphabates Allowed " required autofocus></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
		
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">E-Mail Address <font color=red>   *</font></label></td>
     	
				<td><input type="email" name=email class="form-control" placeholder="Enter Email Address" required autofocus></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Password <font color=red>   *</font></label></td>
     	
				<td><input type="password" name=password maxlength = 28 minlength = 8 class="form-control" placeholder="Enter Password "  required></td>
			</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
		
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Department Name <font color=red>   *</font></label></td>
     	
				<td><select name="departmentId" class="form-control" required="required">
								<option value="">Select Department</option>
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

							</select>
				</div>			
				</td>
			</tr>
	
<tr>
<td>&nbsp;</td>
</tr>
		
		
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Designation Name <font color=red>   *</font></label></td>
     	
	
			<td>
				<select name="designationId" class="form-control" required="required">
						<option value="">Select</option>
								<% DesignationDAO designationDAO = new DesignationDAO();
							List<DesignationBean> deignationList = designationDAO.list();
							for(int i=0;i<deignationList.size();i++){
								DesignationBean designationBean = deignationList.get(i);
							%>
						<option value="<%=designationBean.getDesignationId()%>"><%=designationBean.getDesignationName()%></option>
				
				<%} %>
					
					</select>
					</div>
				</td>
				
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Employee Status <font color=red>   *</font></label></td>
     	
	
			<td>
				<select name="employmentStatusId" class="form-control" required="required">
						<option value="0">Select</option>
								<% StatusDAO statusDAO = new StatusDAO();
							List<StatusBean> statusList = statusDAO.list();
							for(int i=0;i<statusList.size();i++){
								StatusBean statusBean =statusList.get(i);
							%>
						<option value="<%=statusBean.getStatusId()%>"><%=statusBean.getStatusName()%></option>
				
				<%} %>
					
					</select>
					</div>
				</td>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				  <div class="form-group">
        		 <td><label for="designationName">Join Date <font color=red>   *</font></label></td>
     	
				<td><input type="text" name=joiningDate class="form-control" placeholder="Enter Join Date "  required></td>
				</div>
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
			  <div class="form-group">
        		 <td><label for="designationName">Security Question <font color=red>   *</font></label></td>
     	
				<%
					List<SecurityQuestionsBean> securityQuestionsList = new SecurityQuestionsDAO()
								.getSecurityQuestionsList();
				%>
					<td><select name="securityQuestionId" class="form-control" required="required">
							<option value="">Select Security Question</option>
							<%
								if (securityQuestionsList != null) {
										for (int i = 0; i < securityQuestionsList.size(); i++) {
											SecurityQuestionsBean securityQuestionsBean = securityQuestionsList
													.get(i);
							%>

							<option value="<%=securityQuestionsBean.getQuestionId()%>">
								<%=securityQuestionsBean.getQuestion()%>
							</option>
							<%
								}
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
        		 <td><label for="designationName">Security Answer <font color=red>   *</font></label></td>
     	
				<td><input type="text" name=securityAnswer class="form-control" placeholder="Enter Security Answer "  required></td>
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