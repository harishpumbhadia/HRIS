<%@page import="com.dsynhub.HRIS.bean.LeaveCategoriesBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<script type="text/javascript">

function del(id) {
	//alert("ID : "+id);
	var f = document.leaveCategoriesListPage;
	f.lid.value = id;
	f.action = "LeaveCategoriesDeleteServlet";
	f.submit();
}

</script>

</head>

<form action = "LeaveCategoriesListServlet" name = "leaveCategoriesListPage">
<input type="hidden" name="lid" id="lid">
 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Leave Category Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
              
<table id="example1" class="table table-bordered table-striped">
<thead>
<%
List<LeaveCategoriesBean> listofleaveCategories= (ArrayList)request.getAttribute("listofleaveCategories");

if(listofleaveCategories!=null){ %>
<tr>
<th>ID</th>
<th>Category</th>
<th>Leaves Per Year</th>
<th>Update</th>
<th>Delete</th>

</tr>
</thead>

<tbody>
<% 
for(int i=0;i<listofleaveCategories.size();i++){
	LeaveCategoriesBean leaveCategories = listofleaveCategories.get(i);
%>
	
<tr>
<td><%=leaveCategories.getLeaveId()  %></td>
<td><%=leaveCategories.getCategory()  %></td>
<td><%=leaveCategories.getLeavesPerYear() %></td>

<td> 
<a href="LeaveCategoriesEditServlet?lid=<%= leaveCategories.getLeaveId() %>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td>
<a href="#" onclick ="del(<%= leaveCategories.getLeaveId() %>)"><img src=image\Delete.png height="42" width="42"></a> 
</td>
</tr>

<%}
}else{
%>	
	<h1> NO Records Found....... </h1>
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