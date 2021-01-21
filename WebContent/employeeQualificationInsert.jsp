<%@page import="com.dsynhub.HRIS.bean.EmployeeBean"%>
<%@page import="com.dsynhub.HRIS.bean.DesignationBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>

<!-- form start --> 
<h2>Add Employee Qualification</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>

<form action="EmployeeQualificationInsertServlet">

	<table width=40%>
<tr>          
                    <div class="form-group" class="form-control" required="required">
                 <td><label for="designationName">Select Employee <font color=red>   *</font></label></td>
 
				<td>
				<select name="employeeId" class="form-control" required="required">
						<option value="">Select Employee</option>
								<% EmployeeDAO employeeDAO = new EmployeeDAO();
							List<EmployeeBean> employeeList = employeeDAO.list();
							for(int i=0;i<employeeList.size();i++){
								EmployeeBean employeeBean = employeeList.get(i);
							%>
						<option value="<%=employeeBean.getEmployeeId()%>"><%=employeeBean.getEmployeeFirstName() + " " + employeeBean.getEmployeeLastName()%></option>
				
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
                 <td><label for="designationName">Qualification Name <font color=red>   *</font></label></td>
                
				<td><input type="text" name=qualificationName class="form-control" placeholder="Enter Qualification Name"   pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
				</div>	
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				    <div class="form-group">
                 <td><label for="designationName">Institute Name <font color=red>   *</font></label></td>
                
				<td><input type="text" name=institute class="form-control" placeholder="Enter Institute Name"  pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus></td>
				</div>	
			</tr>

<tr>
<td>&nbsp;</td>
</tr>
			
			<tr>
				    <div class="form-group">
                 <td><label for="designationName">Date Of Completion <font color=red>   *</font></label></td>
                
				<td><input type="text" name=dateOfCompletion class="form-control" placeholder="Enter Date Of Completition"  required autofocus></td>
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