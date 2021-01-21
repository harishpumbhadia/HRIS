<%@page import="java.util.List"%>
<%@page import="com.dsynhub.HRIS.bean.DepartmentBean"%>
<%@page import="com.dsynhub.HRIS.dao.DepartmentDAO"%>
<%@page import="com.dsynhub.HRIS.bean.DesignationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>
<h2>Update Designation</h2>
<hr>
<form action="DesignationUpdateServlet" method="post" name="designationPage" id="designationPage">
		<input type="hidden" name="designationId" id="designationId" value="${designationBean.designationId}">
	<table width=50%>
		<% DesignationBean designationBean = (DesignationBean)request.getAttribute("designationBean");	 %>
			<tr>
			      <div class="form-group">
                 <td><label for="designationName">Designation Name </label></td>
             <td><input type="text" class="form-control" id="designationName" value = <%= designationBean.getDesignationName() %> name="designationName"  required autofocus>${designationName} </td>
         			</div>
			</tr>
			
<tr>
<td>&nbsp;</td>
</tr>

<tr>
				 <div class="form-group">
				 <td><label for="designationName">Department Name <font color=red>   *</font></label></td>
                	<td><select name="departmentId" class="form-control" required="required">
								<option value="">Select DEPARTMENT</option>
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