<%@page import="com.dsynhub.HRIS.bean.StateBean"%>
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
	var f = document.stateListPage;
	f.sid.value = id;
	f.action = "StateDeleteServlet";
	f.submit();
}

</script>

</head>

<form action = "StateListServlet" name = "stateListPage">
<input type="hidden" name="sid" id="sid">
 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">State Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
              
<table id="example1" class="table table-bordered table-striped">
<thead>
<%
List<StateBean> listofStates= (ArrayList)request.getAttribute("listofStates");

if( listofStates!=null ){ %>
<tr>
<th>ID</th>
<th>State Name</th>
<th>Country Name</th>
<th>Update</th>
<th>Delete</th>

</tr>
</thead>

<tbody>
<% 
for(int i=0;i<listofStates.size();i++){
	StateBean state = listofStates.get(i);
%>
	
<tr>
<td><%=state.getStateId()  %></td>
<td><%=state.getStateName() %></td>
<td><%=state.getCountryName() %></td>

<td> 
<a href="StateEditServlet?sid=<%= state.getStateId()%>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td>
<a href="#" onclick ="del(<%= state.getStateName() %>)"><img src=image\Delete.png height="42" width="42"></a>
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