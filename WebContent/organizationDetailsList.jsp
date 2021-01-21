<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.OrganizationDetailsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<script type="text/javascript">

function del(id) {
	//alert("ID : "+id);
	var f = document.organizationDetailsListPage;
	f.organizationId.value = id;
	f.action = "OrganizationDetailsDeleteServlet";
	f.submit();
}

</script>
</head>
<body>


<form action="" name=organizationDetailsListPage id="organizationDetailsListPage">
<input type="hidden" name="organizationId" id="organizationId">
<div class="box">
                <div class="box-header">
                  <h3 class="box-title">Organization Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
              
<table id="example1" class="table table-bordered table-striped">
<thead>
<tr>
<th>Organization Id</th>
<th>Organization Name</th>
<th>Organization Address </th>
<th>City</th>
<th>State</th>
<th>Country</th>
<th>Contact Number</th>
<th>E - Mail</th>
<th>Website</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>

<tbody>
<% 


List<OrganizationDetailsBean> listOfOrganizationDetails= (ArrayList)request.getAttribute("listofOrganizationDetails");

if(listOfOrganizationDetails!=null ){
for(int i=0;i<listOfOrganizationDetails.size();i++){
	OrganizationDetailsBean organizationDetails = listOfOrganizationDetails.get(i);
	
%>	
<tr>
<td><%= organizationDetails.getOrganizationId() %></td>
<td><%= organizationDetails.getOrganizationName() %></td>
<td><%= organizationDetails.getOrganizationAddress() %></td>
<td><%= organizationDetails.getCityName() %></td>
<td><%= organizationDetails.getStateName() %></td>
<td><%= organizationDetails.getCountryName() %></td>
<td><%= organizationDetails.getContactNo() %></td>
<td><%= organizationDetails.getEmailId() %></td>
<td><%= organizationDetails.getWebsite()%></td>

<td> 
<a href="OrganizationDetailsEditServlet?organizationId=<%= organizationDetails.getOrganizationId() %>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td>
<a href="#" onclick="del(<%= organizationDetails.getOrganizationId() %>)"><img src=image\Delete.png height="42" width="42"></a> 
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
</html>