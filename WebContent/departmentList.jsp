<%@page import="com.dsynhub.HRIS.bean.DepartmentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<script type="text/javascript">

function del(id) {
	alert("ID : "+id);
	var f = document.departmentListPage;
	f.did.value = id;
	f.action = "DepartmentDeleteServlet";
	f.submit();
}

</script>

</head>

<form action = "DepartmentListServlet" name = "departmentListPage">
<input type="hidden" name="did" id="did">

 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Department Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
<table id="example1" class="table table-bordered table-striped">
<thead>
<%
List<DepartmentBean> listofDepartments= (ArrayList)request.getAttribute("listofDepartments");

if(listofDepartments!=null){ %>
<tr>
<th>ID</th>
<th>NAME</th>
<th>Update</th>
<th>Delete</th>
</tr>

<tbody>
<% 
for(int i=0;i<listofDepartments.size();i++){
	DepartmentBean department = listofDepartments.get(i);
%>

	
<tr>
<td><%=department.getDeptId()  %></td>
<td><%=department.getDeptName() %></td>

<td> 
<a href="DepartmentEditServlet?did=<%= department.getDeptId()%>"><img src=image\Update.png height="42" width="42"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td>
<a href="#" onclick ="del(<%= department.getDeptId() %>)"><img src=image\Delete.png height="42" width="42"></a></a>
</td>
</tr>

<%}
}else{
%>	
	<h1> NO Records Found....... </h1>
<% }
%>
</tbody>
</div>
</div>
</table>
</center>
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
</html>