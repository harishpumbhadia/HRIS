<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.EmployeeQualificationBean"%>
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
                  <h3 class="box-title">Employee Qualification Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
              
<table id="example1" class="table table-bordered table-striped">
<thead>

		<tr>
			<th>EmployeeQualificatioId</th>
			<th>Name</th>
			<th>Qualification</th>
			<th>Institute</th>
			<th>Date Of Completion</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
</thead>

<tbody>
		<%
			List<EmployeeQualificationBean> listOfEmployeeQualification = (ArrayList) request.getAttribute("listOfEmployeeQualification");

			if (listOfEmployeeQualification != null) {
				for (int i = 0; i < listOfEmployeeQualification.size(); i++) {
					EmployeeQualificationBean employeeQualificationBean = listOfEmployeeQualification.get(i);
		%>
		<tr>
			<td><%=employeeQualificationBean.getEmployeeQualificationId()%></td>
			<td><%=employeeQualificationBean.getEmployeeFirstName() + " "
					+ employeeQualificationBean.getEmployeeLastName()%></td>
			<td><%=employeeQualificationBean.getQualificaionName()%></td>
			<td><%=employeeQualificationBean.getInstitute()%></td>
			<td><%=employeeQualificationBean.getDateOfCompletion()%></td>
			<td><%=employeeQualificationBean.getDesignationName()%></td>
			<td><%=employeeQualificationBean.getDepartmentName()%></td>
			<td>
			<a href="EmployeeQualificationEditServlet?employeeQualificationId=<%=employeeQualificationBean.getEmployeeQualificationId()%>"><img src=image\Update.png height="42" width="42"></a> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			</td>
			
			<td>
			<a href="EmployeeQualificationDeleteServlet?employeeQualificationId=<%=employeeQualificationBean.getEmployeeQualificationId()%>"><img src=image\Delete.png height="42" width="42"></a> 
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

</body>
</html>