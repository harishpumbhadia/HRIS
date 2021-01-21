<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.JobVacancyBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>
<script type="text/javascript">

function del(id) {
	//alert("ID : "+id);
	var f = document.jobVacancyListPage;
	f.jobVacancyId.value = id;
	f.action = "JobVacancyDeleteServlet";
	f.submit();
}

</script>
</head>
<body>

<form action="" name=jobVacancyListPage id="jobVacancyListPage">
<input type="hidden" name="jobVacancyId" id="jobVacancyId">
<center>
 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Job Vacancy Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
<table id="example1" class="table table-bordered table-striped">
<thead>
<tr>
<th>JobVacancyId</th>
<th>Name</th>
<th>Description</th>
<th>CandidateQualifiaction</th>
<th>Department</th>
<th>Designation</th>
<th>IsActive</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>

<tbody>
<% 


List<JobVacancyBean> listOfJobVacancy= (ArrayList)request.getAttribute("listOfJobVacancy");

if(listOfJobVacancy!=null ){
for(int i=0;i<listOfJobVacancy.size();i++){
	JobVacancyBean jobVacancyBean= listOfJobVacancy.get(i);
	
%>	
<tr>
<td><%= jobVacancyBean.getVacancyId() %></td>
<td><%= jobVacancyBean.getVacancyName()%></td>
<td><%= jobVacancyBean.getDescription() %></td>
<td><%= jobVacancyBean.getCandidateQualificationName() %></td>
<td><%= jobVacancyBean.getDepartmentName() %></td>
<td><%= jobVacancyBean.getDesignationName()%></td>
<td><% if (jobVacancyBean.getIsActive() == 1) { %><%= "Yes" %><% } else {  %><%= "No" %><% }  %></td>


<td> 

<a href="JobVacancyEditServlet?jobVacancyId=<%= jobVacancyBean.getVacancyId() %>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td>
<a href="#" onclick="del(<%= jobVacancyBean.getVacancyId() %>)"><img src=image\Delete.png height="42" width="42"></a></a>
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