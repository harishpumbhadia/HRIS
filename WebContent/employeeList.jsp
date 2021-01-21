<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<script type="text/javascript">

function del(id) {
	//alert("ID : "+id);
	var f = document.employeeListPage;
	f.employeeId.value = id;
	f.action = "EmployeeDeleteServlet";
	f.submit();
}

</script>
</head>
<body>

<a href="LogoutServlet">Logout</a>

<form action="" name=employeeListPage id="employeeListPage">
<input type="hidden" name="employeeId" id="employeeId">
<div class="box">
                <div class="box-header">
                  <h3 class="box-title">Employee Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
<div class="table-responsive">          
<table id="example1" class="table table-bordered table-striped" >
<thead>
<tr>
<th>EmployeeId</th>
<th>Name</th>
<th>Date of Birth</th>
<th>Gender</th>
<th>Maratial Status </th>
<th>Address </th>
<th>City</th>
<th>State</th>
<th>Country</th>
<th>Mobile Number</th>
<th>Postal Code</th>
<th>E - Mail</th>
<th>Department</th>
<th>Designation</th>
<th>Status</th>
<th>Join Date</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>

<tbody>
<% 


List<EmployeeBean> listOfEmployee= (ArrayList)request.getAttribute("listofEmployee");

if(listOfEmployee!=null ){
for(int i=0;i<listOfEmployee.size();i++){
	EmployeeBean employeeBean = listOfEmployee.get(i);
	
%>	
<tr>
<td><%= employeeBean.getEmployeeId() %></td>
<td><%= employeeBean.getEmployeeFirstName() + " " + employeeBean.getEmployeeMiddleName()+ " " +employeeBean.getEmployeeLastName() %></td>
<td><%= employeeBean.getDateOfBirth() %></td>
<td><%= employeeBean.getGender() %></td>
<td><%= employeeBean.getMaratialStatus() %></td>
<td><%= employeeBean.getCurrentAddress() %></td>
<td><%= employeeBean.getCityName() %></td>
<td><%= employeeBean.getStateName() %></td>
<td><%= employeeBean.getCountryName() %></td>
<td><%= employeeBean.getMobileNumber() %></td>
<td><%= employeeBean.getPostalCode() %></td>
<td><%= employeeBean.getEmail() %></td>
<td><%= employeeBean.getDepartmentName() %></td>
<td><%= employeeBean.getDesignationName()%></td>
<td><%= employeeBean.getStatusName()%></td>
<td><%= employeeBean.getJoiningDate()%></td>

<td> 
<a href="EmployeeEditServlet?employeeId=<%= employeeBean.getEmployeeId() %>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td>
<a href="#" onclick="del(<%= employeeBean.getEmployeeId() %>)"><img src=image\Delete.png height="42" width="42"></a>
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