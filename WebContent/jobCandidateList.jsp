<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.JobCandidateBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<script type="text/javascript">

function del(id) {
	//alert("ID : "+id);
	var f = document.jobCandidateListPage;
	f.jobCandidateId.value = id;
	f.action = "JobCandidateDeleteServlet";
	f.submit();
}

</script>
</head>
<body>

<form action="" name=jobCandidateListPage id="jobCandidateListPage">
<input type="hidden" name="jobCandidateId" id="jobCandidateId">
<center>
 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Candidate Application Details</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
<table id="example1" class="table table-bordered table-striped">
<thead>
<tr>
<th>JobCandidateId</th>
<th>Name</th>
<th>E-Mail</th>
<th>Mobile</th>
<th>Department</th>
<th>Designation</th>
<th>Date OF Application</th>
<th>IsActive</th>
<th>Update</th>
<th>Delete</th>
</tr>

<tbody>
<% 


List<JobCandidateBean> listOfCandidates= (ArrayList)request.getAttribute("listofCandidates");

if(listOfCandidates!=null ){
for(int i=0;i<listOfCandidates.size();i++){
	JobCandidateBean jobCandidateBean= listOfCandidates.get(i);
	
%>	
<tr>
<td><%= jobCandidateBean.getCadidateId() %></td>
<td><%= jobCandidateBean.getCandidateFirstName() + " " + jobCandidateBean.getCandidateMiddleName()+ " " + jobCandidateBean.getCandidateLastName() %></td>
<td><%= jobCandidateBean.getEmail() %></td>
<td><%= jobCandidateBean.getMobileNumber() %></td>
<td><%= jobCandidateBean.getDepartentName() %></td>
<td><%= jobCandidateBean.getDesignationName()%></td>
<td><%= jobCandidateBean.getDateOfApplication()%></td>
<td><% if (jobCandidateBean.getIsActive() == 1) { %><%= "Yes" %><% } else {  %><%= "No" %><% }  %></td>


<td> 
<a href="JobCandidateEditServlet?jobCandidateId=<%= jobCandidateBean.getCadidateId() %>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td>
<a href="#" onclick="del(<%= jobCandidateBean.getCadidateId() %>)"><img src=image\Delete.png height="42" width="42"></a>
</td>
</tr>

<%}
}else{
%>	
	<h1>NO Records Found.......</h1>
<% }
%>

</div>
</div>
</tbody>
</table>

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