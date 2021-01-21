<%@page import="com.dsynhub.HRIS.bean.CityBean"%>
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
	var f = document.cityListPage;
	f.cid.value = id;
	f.action = "CityDeleteServlet";
	f.submit();
}

</script>

</head>

<form action = "CityListServlet" name = "cityListPage">
<input type="hidden" name="cid" id="cid">
<div class="box">
                <div class="box-header">
                  <h3 class="box-title">State Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
              
<table id="example1" class="table table-bordered table-striped">
<thead>
<%
List<CityBean> listofCity= (ArrayList)request.getAttribute("listofCity");

if(listofCity!=null){ %>
<tr>
<th>ID</th>
<th>City NAME</th>
<th>State NAME</th>
<th>Update</th>
<th>Delete</th>

</tr>
</thead>

<tbody>
<% 
for(int i=0;i<listofCity.size();i++){
	CityBean city = listofCity.get(i);
%>
	
<tr>
<td><%=city.getCityId()  %></td>
<td><%=city.getCityName() %></td>
<td><%=city.getStateName() %></td>

<td> 
<a href="CityEditServlet?cid=<%= city.getCityId()%>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td>
<a href="#" onclick ="del(<%= city.getCityName() %>)"><img src=image\Delete.png height="42" width="42"></a>
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
</center>
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