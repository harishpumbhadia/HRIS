<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.StatusBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>
<form action="" name="statusList" id="statusList">
<input type="hidden" name="statusId" id="statusId">
 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Department Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
<table id="example1" class="table table-bordered table-striped">
<thead>

<tr class="Large">
<th>Id</th>
<th>Status</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>

<tbody>
<%
List<StatusBean> listofStatus=(ArrayList)request.getAttribute("listofStatus");

if(listofStatus!=null){
for(int i=0;i<listofStatus.size();i++){
	StatusBean b1 = listofStatus.get(i);
%>	
<tr class="Large">
<td><%=b1.getStatusId()%></td>
<td><%=b1.getStatusName()%></td>
<td><a href="StatusEditServlet?statusId=<%=b1.getStatusId()%>"> <img src=image\Update.png height="42" width="42"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>


<td><a href="StatusDeleteServlet?statusId=<%=b1.getStatusId()%>"> <img src=image\Delete.png height="42" width="42"></a></td>

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