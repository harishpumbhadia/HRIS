<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.DesignationBean"%>
<%@page import="com.dsynhub.HRIS.bean.LeaveApplicationBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<script type="text/javascript">

function del(id) {
	//alert("ID : "+id);
	var f = document.leaveApplicationListPage;
	f.leaveApplicationId.value = id;
	f.action = "LeaveApplicationDeleteServlet";
	f.submit();
}

</script>
</head>

<body>



<form action="" name=leaveApplicationListPage id="leaveApplicationListPage">
<input type="hidden" name="leaveApplicationId" id="leaveApplicationId">

 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Leave Application Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
              
<table id="example1" class="table table-bordered table-striped">
<thead>

<tr>
<th>Leave Application Id</th>
<th>Employee Name</th>
<th>Leave Category</th>
<th>Leave Days</th>
<th>Discription</th>
<th>Status</th>
<th>date Of Application</th>
<th>date Of Last Update</th>
</tr>
</thead>

<tbody>
<% 


List<LeaveApplicationBean> listofleaveApplication= (ArrayList)request.getAttribute("listOfDesignation");

if(listofleaveApplication!=null ){
for(int i=0;i<listofleaveApplication.size();i++){
	LeaveApplicationBean leaveApplicationBean= listofleaveApplication.get(i);
	
%>	
<tr>
<td><%= leaveApplicationBean.getemployeeId() %></td>
<td><%= leaveApplicationBean.getleaveId()%></td>
<td><%= leaveApplicationBean.getDepartmentName() %></td>

<%-- <td> 
<a href="DesignationEditServlet?designationId=<%= leaveApplicationBean.getDesignationId() %>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td>
<a href="#" onclick="del(<%= designationBean.getDesignationId() %>)"><img src=image\Delete.png height="50" width="50"></a>
</td>
</tr> --%>
</tbody>
<%}
}else{
%>	
	<h1>NO Records Found.......</h1>
<% }
%>
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
</body>
</html>