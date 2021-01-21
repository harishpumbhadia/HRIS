<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.EmployeeEmergencyContactBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>

<form action="" name=employeeQualificationListPage id="employeeQualificationListPage">
<input type="hidden" name="employeeQualificatioId" id="employeeQualificatioId">

 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Designation Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
              
<table id="example1" class="table table-bordered table-striped">
<thead>
		<tr>
			<th>EmergencyId</th>
			<th>Name</th>
			<th>Contact Name</th>
			<th>Relation</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Contact One</th>
			<th>Contact Two</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
</thead>

<tbody>
		<%
			List<EmployeeEmergencyContactBean> listOfEmployeeEmergencyContact = (ArrayList) request.getAttribute("listofEmployeeEmergencyContact");

			if (listOfEmployeeEmergencyContact != null) {
				for (int i = 0; i < listOfEmployeeEmergencyContact.size(); i++) {
					EmployeeEmergencyContactBean employeeEmergencyContactBean = listOfEmployeeEmergencyContact.get(i);
		%>
		<tr>
			<td><%=employeeEmergencyContactBean.getEmergencyId()%></td>
			<td><%=employeeEmergencyContactBean.getEmployeeFirstName() + " "
					+ employeeEmergencyContactBean.getEmployeeLastName()%></td>
			<td><%=employeeEmergencyContactBean.getContactName()%></td>
			<td><%=employeeEmergencyContactBean.getRelation()%></td>
			<td><%=employeeEmergencyContactBean.getDesignationName()%></td>
			<td><%=employeeEmergencyContactBean.getDepartmentName()%></td>
			<td><%=employeeEmergencyContactBean.getContactNumberOne()%></td>
			<td><%=employeeEmergencyContactBean.getContactNumberTwo()%></td>
			<td>
			<a href="EmployeeEmergencyContactEditServlet?emergencyId=<%=employeeEmergencyContactBean.getEmergencyId()%>"><img src=image\Update.png height="42" width="42"></a> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			</td>
			
			<td>
			<a href="EmployeeEmergencyContactDeleteServlet?emergencyId=<%=employeeEmergencyContactBean.getEmergencyId()%>"><img src=image\Delete.png height="42" width="42"></a> 
			</td>
		</tr>

		<%}
}else{
%>
		<h1>NO Records Found.......</h1>
		<% }
%>

</tbody>
	</table>

</form>


</body>
   <script type="text/javascript">
      $(function () {
        $("#example1").dataTable();
        $('#example2').dataTable({
          "bPaginate": true,
          "bLengthChange": false,
          "bFilter": false,
          "bSort": true,
          "bInfo": true,
          "bAutoWidth": false
        });
      });
    </script>
</html>