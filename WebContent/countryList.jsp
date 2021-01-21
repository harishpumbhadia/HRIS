<%@page import="com.dsynhub.HRIS.bean.CountryBean"%>
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
	var f = document.countryListPage;
	f.cid.value = id;
	f.action = "CountryDeleteServlet";
	f.submit();
}

</script>

</head>

<form action = "CountryListServlet" name = "countryListPage">
<input type="hidden" name="cid" id="cid">
<div class="box">
                <div class="box-header">
                  <h3 class="box-title">Country Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
<table id="example1" class="table table-bordered table-striped">
<thead>
<%
List<CountryBean> listofCountry= (ArrayList)request.getAttribute("listofCountry");

if(listofCountry!=null){ %>
<tr>
<th>ID</th>
<th>NAME</th>
<th>Update</th>
<th>Delete</th>

</tr>

<tbody>
<% 
for(int i=0;i<listofCountry.size();i++){
	CountryBean country = listofCountry.get(i);
%>
	
<tr>
<td><%=country.getCountryId()  %></td>
<td><%=country.getCountryName() %></td>

<td> 
<a href="CountryEditServlet?cid=<%= country.getCountryId()%>"><img src=image\Update.png height="42" width="42"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td>
<a href="#" onclick ="del(<%= country.getCountryName() %>)"><img src=image\Delete.png height="42" width="42"></a>
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