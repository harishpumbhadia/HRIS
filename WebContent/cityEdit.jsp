<%@page import="com.dsynhub.HRIS.bean.StateBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.dao.StateDAO"%>
<%@page import="com.dsynhub.HRIS.bean.CityBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>
    
<body>

<!-- form start --> 
<h2>Update City</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>
<form action="CityUpdateServlet" method="post" name="cityPage" id="cityPage">
		<input type="hidden" name="cityId" id="cityId" value="${cityBean.cityId}">
		<table width=40%>
		<tr>          
             <div class="form-group">
               <td><label for="cityName">City Name <font color=red>   *</font></label></td>
   			<td> <input type="text" name="cityName" id="cityName" class="form-control" placeholder="Enter City Name" id="stateName" pattern="[A-Za-z]+" title="Only Alphabates Allowed " required autofocus value = "${city.getCityName()}" >${cityName}</td> 
			</tr>

<tr>
<td>&nbsp;</td>
</tr>

			<tr>
				 <div class="form-group">
				 <td><label for="designationName">State Name <font color=red>   *</font></label></td>
          
				<td><select name="stateId" class="form-control" required="required">
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